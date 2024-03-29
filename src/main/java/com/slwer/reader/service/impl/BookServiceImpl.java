package com.slwer.reader.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.slwer.reader.entity.Book;
import com.slwer.reader.entity.Evaluation;
import com.slwer.reader.entity.MemberReadState;
import com.slwer.reader.mapper.BookMapper;
import com.slwer.reader.mapper.EvaluationMapper;
import com.slwer.reader.mapper.MemberReadStateMapper;
import com.slwer.reader.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper bookMapper;

    @Resource
    private EvaluationMapper evaluationMapper;

    @Resource
    private MemberReadStateMapper memberReadStateMapper;

    @Override
    public IPage<Book> selectPage(Long categoryId, String order, Integer page, Integer rows) {
        Page<Book> p = new Page<>(page, rows);
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        if (categoryId != null && categoryId != -1) {
            wrapper.eq("category_id", categoryId);
        }
        if (order != null) {
            if (order.equals("quantity")) {
                wrapper.orderByDesc("evaluation_quantity");
            } else if (order.equals("score")) {
                wrapper.orderByDesc("evaluation_score");
            }
        } else {
            wrapper.orderByDesc("evaluation_quantity");
        }

        p = bookMapper.selectPage(p, wrapper);
        return p;
    }

    @Override
    public Book selectById(Long bookId) {
        return bookMapper.selectById(bookId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateScore() {
        bookMapper.updateScore();
    }

    @Override
    public IPage<Map<String, Object>> selectBookMap(Integer page, Integer rows) {
        IPage<Map<String, Object>> p = new Page<>(page, rows);
        p = bookMapper.selectBookMap(p);
        return p;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Book createBook(Book book) {
        bookMapper.insert(book);
        return book;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Book updateBook(Book book) {
        bookMapper.updateById(book);
        return book;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBook(Long bookId) {
        bookMapper.deleteById(bookId);
        QueryWrapper<Evaluation> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("book_id", bookId);
        evaluationMapper.delete(wrapper1);
        QueryWrapper<MemberReadState> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("book_id", bookId);
        memberReadStateMapper.delete(wrapper2);
    }
}
