package com.slwer.reader.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.slwer.reader.entity.Category;
import com.slwer.reader.mapper.CategoryMapper;
import com.slwer.reader.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> selectAll() {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("category_id");
        return categoryMapper.selectList(wrapper);
    }
}
