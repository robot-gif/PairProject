package com.pojo;

import org.apache.ibatis.type.Alias;

@Alias("PaperKeyword")
public class KeywordForPapers
{
    private String keyword;

    public KeywordForPapers(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
