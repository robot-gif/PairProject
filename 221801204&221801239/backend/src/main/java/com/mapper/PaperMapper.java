package com.mapper;

import com.pojo.Keyword;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PaperMapper
{
    List<Keyword> getTopWords();
}
