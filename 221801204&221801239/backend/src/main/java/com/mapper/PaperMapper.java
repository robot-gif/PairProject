package com.mapper;

import com.pojo.Keyword;
import com.pojo.KeywordForPapers;
import com.pojo.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PaperMapper
{
    List<Keyword> getTopWords();
    Paper getPapers(int paper_id);
    List<KeywordForPapers> getKeyWords(int paper_id);
}
