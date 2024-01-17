package com.slwer.reader.service.impl;

import com.slwer.reader.mapper.EvaluationMapper;
import com.slwer.reader.service.EvaluationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class EvaluationServiceImpl implements EvaluationService {
    @Resource
    private EvaluationMapper evaluationMapper;

    @Override
    public List<Map<String, Object>> selectByBookId(Long bookId) {
        return evaluationMapper.selectByBookId(bookId);
    }
}
