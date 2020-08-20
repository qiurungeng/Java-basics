package com.study.service;

import com.study.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookService {
    //@Autowired
    //@Qualifier("bookDao2")
    @Resource(name = "bookDao")
    private BookDao bookDao2;

    public void print(){
        System.out.println(bookDao2);
    }

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao2 +
                '}';
    }
}
