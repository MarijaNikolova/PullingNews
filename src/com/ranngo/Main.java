package com.ranngo;

import com.ranngo.pullinginfo.facebook.FacebookUtillities;
import com.ranngo.pullingnews.newyorktimes.NewYorkTimes;
import com.ranngo.pullingnews.theguardian.TheGuardian;

/**
 * Created by Marija on 4/5/2016.
 */
public class Main {

    public static void main(String[] args) {

       // TheGuardian.callForNews();
        NewYorkTimes.callForNews();
        //FacebookUtillities.pullInfoForPerson("Beyonce");
    }
}
