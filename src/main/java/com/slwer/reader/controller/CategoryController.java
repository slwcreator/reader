package com.slwer.reader.controller;

import com.slwer.reader.entity.Category;
import com.slwer.reader.service.CategoryService;
import com.slwer.reader.utils.ResponseUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResponseUtils list() {
        ResponseUtils resp;
        try {
            List<Category> categories = categoryService.selectAll();
            resp = new ResponseUtils().put("list", categories);
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return resp;
    }
}
