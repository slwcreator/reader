package com.slwer.reader.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EvaluationMapperTest {

    @Resource
    private EvaluationMapper evaluationMapper;

    @Test
    public void selectByBookId() {
        List<Map<String, Object>> maps = evaluationMapper.selectByBookId(1L);
        System.out.println(maps);
    }
}