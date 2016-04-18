package com.ranngo.pullingnews.nbcnews;

import com.ranngo.pullingnews.newyorktimes.WebUrl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Marija on 4/18/2016.
 */
public class NbcNews {

    public static void callForNews(){
        Document doc = null;
        try {
            doc = Jsoup.connect("http://www.nbcnews.com/news").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements newsUrls = doc.select(" .story-link .img-container  a[href]");;
        parseLinks(newsUrls);
    }

    public static void  parseLinks(Elements elements){

        String link="";
        ArrayList<String> urls=new ArrayList<String>();
        for(int i=0;i<elements.size();++i){
            //System.out.println(  elements.get(i).toString());
           // System.out.println();
            //String urli= elements.get(i).toString();
            //String [] parts=urli.split("\n")[0].split(" ");
            //String url=parts[1].replace("\">","").replace("href=\"","");
          //  System.out.println(elements.get(i).toString().split("\n")[0].split(" ")[1].replace("\">","").replace("href=\"","http://www.nbcnews.com"));
            String url=elements.get(i).toString().split("\n")[0].split(" ")[1].replace("\">","").replace("href=\"","http://www.nbcnews.com");
            urls.add(url);

        }
        writeToFile(getDates().split(" ")[1],urls);

    }
    public static String getDates(){

        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYYMMdd");

        String todaysDate=simpleDateFormat.format(calendar.getTime());

        calendar.add(Calendar.DATE,-1);
        String yesterdaysDate=simpleDateFormat.format(calendar.getTime());

        return yesterdaysDate +" "+todaysDate;
    }


    public static void writeToFile(String date,ArrayList<String> urls){
        try {
            File file=new File("./res/NbcNews/"+date+".txt");
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

}
