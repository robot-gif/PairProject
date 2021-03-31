package com.pojo;

import org.apache.ibatis.type.Alias;

import java.util.Arrays;
import java.util.List;

@Alias("Paper")
public class Paper
{
    private int paper_id;
    private String title;
    private String link;
    private int publication_year;
    private String abstracted;
    private transient List<KeywordForPapers> keywords;
    private String magazine;
    private String[] keywordString;

    public Paper() {
    }

    public Paper(int paper_id, String title, String link, int publication_year, String abstracted, String magazine) {
        this.paper_id = paper_id;
        this.title = title;
        this.link = link;
        this.publication_year = publication_year;
        this.abstracted = abstracted;
        this.magazine = magazine;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "paper_id=" + paper_id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", publication_year=" + publication_year +
                ", abstracted='" + abstracted + '\'' +
                ", magazine='" + magazine + '\'' +
                ", keywordString=" + Arrays.toString(keywordString) +
                '}';
    }

    public int getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(int paper_id) {
        this.paper_id = paper_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
    }

    public String getAbstracted() {
        return abstracted;
    }

    public void setAbstracted(String abstracted) {
        this.abstracted = abstracted;
    }

    public List<KeywordForPapers> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<KeywordForPapers> keywords) {
        this.keywords = keywords;
    }

    public String getMagazine() {
        return magazine;
    }

    public void setMagazine(String magazine) {
        this.magazine = magazine;
    }

    public void setKeywordString()
    {
        this.keywordString=new String[this.keywords.size()];
        for (int i=0;i<keywordString.length;i++)
        {
            keywordString[i]=keywords.get(i).getKeyword();
        }
    }
}
