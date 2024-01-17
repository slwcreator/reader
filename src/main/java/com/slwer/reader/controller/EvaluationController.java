package com.slwer.reader.controller;

import com.slwer.reader.service.EvaluationService;
import com.slwer.reader.utils.ResponseUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/evaluation")
public class EvaluationController {
    @Resource
    private EvaluationService evaluationService;

    @GetMapping("/list")
    public ResponseUtils list(Long bookId) {
        ResponseUtils resp;
        try {
            List<Map<String, Object>> maps = evaluationService.selectByBookId(bookId);
            resp = new ResponseUtils().put("list", maps);
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return resp;
    }
}
