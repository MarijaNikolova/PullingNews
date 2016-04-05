import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Marija on 3/30/2016.
 */
public class NewYorkTimes {


    public static String ARTICLE_SEARCH_API_KEY="fa53efbcdb2ba704efbc57e1f52c75ae:8:74849920";
    public static String ARTICLE_SEARCH_API_URL="http://api.nytimes.com/svc/search/v2/articlesearch.json?";


    public static Response pullArticles(String beginDate, String endDate, String page){

        String URL=ARTICLE_SEARCH_API_URL+"begin_date="+beginDate+"&end_date="+endDate+"&api-key="+ARTICLE_SEARCH_API_KEY+"&fl=web_url";
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
            File file=new File("./res/NewYorkTimes/"+date+".txt");
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
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYYMMdd");

        String todaysDate=simpleDateFormat.format(calendar.getTime());

        calendar.add(Calendar.DATE,-1);
        String yesterdaysDate=simpleDateFormat.format(calendar.getTime());

        return yesterdaysDate +" "+todaysDate;
    }


    public static void callForNews(){
        String [] dates=getDates().split(" ");
        System.out.println(dates[0]+ " " +dates[1]);
        Response response=pullArticles(dates[0],dates[0],null);
        saveTopStories(dates[0],response.getDocs());
        loopAllPages(response.getMeta(),dates[0],dates[0]);
    }

    public static void loopAllPages(Meta meta, String beginDate, String endDate){
            int pages=meta.getHits()/10;
            if((meta.getHits()%10)>0){
                pages+=1;
            }

            for(int i=1;i<pages;++i){
                if(i==100)
                    break;
                Response response=pullArticles(beginDate,endDate,Integer.toString(i));
                saveTopStories(beginDate,response.getDocs());

            }

    }


    public static void main(String[] args) {
        System.out.println("Hello");

        callForNews();


    }
}
