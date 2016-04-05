package com.ranngo.pullingnews.theguardian;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by Marija on 4/5/2016.
 */
public class TheGuardian {

    public static String THE_GUARDIAN_API_KEY="c5b09c10-090a-4f9e-b87f-37df6fb7a079";
    public static String THE_GUARDIAN_API_URL="http://content.guardianapis.com/search?";

    public static Response pullArticles(String beginDate, String endDate, String page){

        String URL=THE_GUARDIAN_API_URL+"from-date="+beginDate+"&to-date="+endDate+"&api-key="+THE_GUARDIAN_API_KEY;
        if(page!=null)
            URL+="&page="+page;

        System.out.println(URL);

        RestTemplate restTemplate=new RestTemplate();
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        jsonConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "json", MappingJackson2HttpMessageConverter.DEFAULT_CHARSET)));
        restTemplate.getMessageConverters().add(jsonConverter);
        Result response=restTemplate.getForObject(URL,Result.class);

        if(response!=null){
            System.out.println("success");
        }

        return response.getResponse();
    }

    public static void saveTopStories(String date, ArrayList<WebUrl> urls){

        try {
            File file=new File("./res/TheGuardian/"+date+".txt");
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file,true));
            for(int i=0;i<urls.size();++i){
                bufferedWriter.write(urls.get(i).toString()+"\n");
            }
            bufferedWriter.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getDates(){

        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd");

        String todaysDate=simpleDateFormat.format(calendar.getTime());

        calendar.add(Calendar.DATE,-1);
        String yesterdaysDate=simpleDateFormat.format(calendar.getTime());

        return yesterdaysDate +" "+todaysDate;
    }

    public static void callForNews(){
        String [] dates=getDates().split(" ");
        System.out.println(dates[0]+ " " +dates[1]);
        Response response=pullArticles(dates[0],dates[0],null);
        saveTopStories(dates[0],response.getUrls());
        loopAllPages(response.getPages(),dates[0],dates[0]);
    }

    public static void loopAllPages(int pages, String beginDate, String endDate){

        for(int i=2;i<=pages;++i){
            Response response=pullArticles(beginDate,endDate,Integer.toString(i));
            saveTopStories(beginDate,response.getUrls());

        }

    }



}
