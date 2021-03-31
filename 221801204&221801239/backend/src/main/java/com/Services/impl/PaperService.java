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
    public Paper getPapers()
    {

        int paperid=4;
        List<KeywordForPapers> paperKeywords = mapper.getKeyWords(4);//获取该篇文章的关键词列表

        Paper paper = mapper.getPapers(4);
        paper.setKeywords(paperKeywords);
        return paper;
    }
}
