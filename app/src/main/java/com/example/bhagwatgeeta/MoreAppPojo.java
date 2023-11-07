package com.example.bhagwatgeeta;

public class MoreAppPojo {
    int pic;
    String text;
    String full_link;
    String only_id;
    float rating;

    public MoreAppPojo(int pic, String text, String full_link, String only_id, float rating) {
        this.pic = pic;
        this.text = text;
        this.full_link = full_link;
        this.only_id = only_id;
        this.rating = rating;
    }



    public String getFull_link() {
        return full_link;
    }

    public void setFull_link(String full_link) {
        this.full_link = full_link;
    }

    public String getOnly_id() {
        return only_id;
    }

    public void setOnly_id(String only_id) {
        this.only_id = only_id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }


    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "MoreAppPojo{" +
                "pic=" + pic +
                ", text='" + text + '\'' +
                ", full_link='" + full_link + '\'' +
                ", only_id='" + only_id + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
