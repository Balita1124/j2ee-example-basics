package com.main.dao;

import com.main.beans.Author;
import java.util.List;

import com.main.dao.DAO;
import com.main.dao.DAOImpl;
import com.main.beans.Book;
import com.main.beans.Category;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookServiceImpl implements BookService {

    @Override
    public List<Book> findAll() {
        List<HashMap> result = new ArrayList<HashMap>();
        List<Book> bookList = new ArrayList<Book>();
        List<Author> authorList = new ArrayList<Author>();
        DAO bookDao = new DAOImpl();

        result = bookDao.findAll("book");
        for (HashMap element : result) {
            Book book = new Book();
            Author author = new Author();
            book.setId((Long) element.get("id"));
            book.setBookTitle((String) element.get("book_title"));
            
            bookList.add(book);
        }
        return bookList;
    }

}
