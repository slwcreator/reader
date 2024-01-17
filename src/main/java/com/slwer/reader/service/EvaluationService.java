package com.slwer.reader.service;

import java.util.List;
import java.util.Map;

public interface EvaluationService {
    List<Map<String, Object>> selectByBookId(Long bookId);
}
