package com.example.bhagwatgeeta;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ChaptersPojo implements Serializable
{
    @SerializedName("a_n") private String chapterNo;
    private String chapterName; // kurukhetra
    private String noOfSlocks;
    private String fileName;

    @SerializedName("s_n") private String slockNo;
    @SerializedName("s") private String slockSanskrit;
    @SerializedName("t") private String slockHindi;

    public ChaptersPojo(String chapterNo, String chapterName, String noOfSlocks, String fileName)
    {
        this.chapterNo = chapterNo;
        this.chapterName = chapterName;
        this.noOfSlocks = noOfSlocks;
        this.fileName = fileName;
    }

    public String getSlockNo() {
        return "श्लोक"+slockNo;
    }

    public void setSlockNo(String slockNo) {
        this.slockNo = slockNo;
    }

    public String getSlockSanskrit() {
        return "संस्कृत :"+"\n"+slockSanskrit;
    }

    public void setSlockSanskrit(String slockSanskrit) {
        this.slockSanskrit = slockSanskrit;
    }

    public String getSlockHindi() {
        return "हिंदी :"+"\n"+slockHindi;
    }

    public void setSlockHindi(String slockHindi) {
        this.slockHindi = slockHindi;
    }

    public String getChapterNo() {
        return chapterNo;
    }

    public void setChapterNo(String chapterNo) {
        this.chapterNo = chapterNo;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getNoOfSlocks() {
        return noOfSlocks;
    }

    public void setNoOfSlocks(String noOfSlocks) {
        this.noOfSlocks = noOfSlocks;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "ChaptersPojo{" +
                "chapterNo='" + chapterNo + '\'' +
                ", chapterName='" + chapterName + '\'' +
                ", noOfSlocks='" + noOfSlocks + '\'' +
                ", fileName='" + fileName + '\'' +
                ", slockNo='" + slockNo + '\'' +
                ", slockSanskrit='" + slockSanskrit + '\'' +
                ", slockHindi='" + slockHindi + '\'' +
                '}';
    }
}
