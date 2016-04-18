package com.ranngo;

import com.ranngo.pullinginfo.facebook.FacebookUtillities;
import com.ranngo.pullingnews.nbcnews.NbcNews;
import com.ranngo.pullingnews.newyorktimes.NewYorkTimes;
import com.ranngo.pullingnews.theguardian.TheGuardian;

/**
 * Created by Marija on 4/5/2016.
 */
public class Main {

    public static void main(String[] args) {
        TheGuardian.callForNews("2016-04-18");
       NewYorkTimes.callForNews("20160418");
      //  FacebookUtillities.pullInfoForPerson("David Guetta");
       // NbcNews.callForNews();
    }
}
