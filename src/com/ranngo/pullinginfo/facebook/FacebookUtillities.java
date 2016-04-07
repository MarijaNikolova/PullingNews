package com.ranngo.pullinginfo.facebook;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Marija on 4/7/2016.
 */
public class FacebookUtillities {

    public static String FACEBOOK_ACCESS_TOKEN="CAACEdEose0cBAJo8fAkTuD1YfFkUK1twEscz3jhwJrh6wv29SkfaZAs83X68Kq0kzy0HTzaOrBHQjSuYbvHTILEuI8UwZCZB8irhInO8O8zqHX3QGmanHYfXZCToh7sNnHDJbLUmXcpZBh1HULEZCx0nZBI8wVZBwu8p9Dad9CBqXmgUf9ZCZBho8kNOrbBHpWZBeR5ZC1y6sj0YBx7Wu2pZCUaPn";
    public static String FACEBOOK_API_URL="https://graph.facebook.com/";

    public static Person pullInfoForPerson(String query){

        String urlForPages=FACEBOOK_API_URL+"search/?type=page&q="+query+"&access_token="+FACEBOOK_ACCESS_TOKEN;
        Person person = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            Data data = restTemplate.getForObject(urlForPages, Data.class);
            System.out.println(data.toString());

            Page page = null;
            if (data.getPages().size() > 0)
                page = data.getPages().get(0);

            if (page != null) {
                String urlForPerson = FACEBOOK_API_URL + page.getId() + "/?fields=id,about,bio,birthday,category,link,website&access_token=" + FACEBOOK_ACCESS_TOKEN;
                person=restTemplate.getForObject(urlForPerson, Person.class);
                System.out.println(person.toString());

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            return person;
        }

    }

}
