package com.slwer.reader.service;

import com.slwer.reader.entity.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CategoryServiceTestor {

    @Resource
    private CategoryService categoryService;

    @Test
    public void selectAll() {
        List<Category> categories = categoryService.selectAll();
        for (Category c : categories) {
            System.out.println(c);
        }
    }
}