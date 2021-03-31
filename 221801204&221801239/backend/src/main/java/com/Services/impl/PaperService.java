package com.Services.impl;

import com.Services.IPaperService;
import com.mapper.PaperMapper;
import com.pojo.KeywordForPapers;
import com.pojo.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaperService implements IPaperService
{
    @Autowired
    private PaperMapper mapper;

    @Override
    public List<Paper> getPapers()
    {
        List<Paper> paperList = new ArrayList<>();
        List<KeywordForPapers> paperKeywords;
        Paper paper;
        for (int i=15000;i<=15003;i++)
        {
            paperKeywords = mapper.getKeyWords(i);//获取该篇文章的关键词列表
            paper = mapper.getPapers(i);
            paper.setKeywords(paperKeywords);
            paper.setKeywordString();
            paperList.add(paper);
        }
        return paperList;
    }
}
