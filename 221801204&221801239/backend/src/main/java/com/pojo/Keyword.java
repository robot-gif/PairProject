package com.pojo;

import org.apache.ibatis.type.Alias;

@Alias("Keyword")
public class Keyword
{
    private String keyword;
    private int count;

    public Keyword(String keyword, int count) {
        this.keyword = keyword;
        this.count = count;
    }

    public Keyword() {
    }

    @Override
    public String toString() {
        return "Keyword{" +
                "keyword='" + keyword + '\'' +
                ", count=" + count +
                '}';
    }
}
