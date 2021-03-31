package com.pojo;

import org.apache.ibatis.type.Alias;

@Alias("meetinginfo")
public class MeetingInfo
{
    private int publish_year;
    private String magazine;
    private int number;

    public MeetingInfo(int publish_year, String magazine, int number)
    {
        this.publish_year = publish_year;
        this.magazine = magazine;
        this.number = number;
    }

    @Override
    public String toString() {
        return "MeetingInfo{" +
                "publish_year=" + publish_year +
                ", magazine='" + magazine + '\'' +
                ", number=" + number +
                '}';
    }

    public int getPublish_year() {
        return publish_year;
    }

    public void setPublish_year(int publish_year) {
        this.publish_year = publish_year;
    }

    public String getMagazine() {
        return magazine;
    }

    public void setMagazine(String magazine) {
        this.magazine = magazine;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
