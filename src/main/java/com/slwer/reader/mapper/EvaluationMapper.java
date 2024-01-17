package com.slwer.reader.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.slwer.reader.entity.Evaluation;

import java.util.List;
import java.util.Map;

public interface EvaluationMapper extends BaseMapper<Evaluation> {
    List<Map<String, Object>> selectByBookId(Long bookId);
}
