package com.slwer.reader.service;

import com.slwer.reader.entity.Evaluation;

import java.util.List;
import java.util.Map;

public interface EvaluationService {
    List<Map<String, Object>> selectByBookId(Long bookId);

    Evaluation evaluate(Long memberId, Long bookId, Integer score, String content);

    Evaluation enjoy(Long evaluationId);
}
