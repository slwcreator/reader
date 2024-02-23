package com.slwer.reader.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.slwer.reader.entity.Book;

import java.util.Map;

public interface BookMapper extends BaseMapper<Book> {
    void updateScore();

    IPage<Map<String, Object>> selectBookMap(IPage<Map<String, Object>> page);
}
