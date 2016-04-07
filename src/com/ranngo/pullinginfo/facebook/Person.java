package com.ranngo.pullinginfo.facebook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Marija on 4/7/2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

        private String id;
        private String about;
        private String bio;
        private String birthday;
        private String category;
        private String link;
        private String website;

        public Person(){

        }

    public Person(String id, String about, String bio, String birthday, String category, String link, String website) {
        this.id = id;
        this.about = about;
        this.bio = bio;
        this.birthday = birthday;
        this.category = category;
        this.link = link;
        this.website = website;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return id+ " "+about;
    }
}
