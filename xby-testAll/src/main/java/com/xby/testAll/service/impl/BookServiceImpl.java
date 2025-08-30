package com.xby.testAll.service.impl;

import com.xby.common.annotation.DataScope;
import com.xby.testAll.domain.Book;
import com.xby.testAll.mapper.BookMapper;
import com.xby.testAll.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 书籍Service业务层处理
 *
 * @author xby
 * @date 2025-05-13
 */
@Service
public class BookServiceImpl implements IBookService
{
    @Autowired
    private BookMapper bookMapper;

    /**
     * 查询书籍
     *
     * @param id 书籍主键
     * @return 书籍
     */
    @Override
    public Book selectBookById(Long id)
    {
        return bookMapper.selectBookById(id);
    }

    /**
     * 查询书籍列表
     *
     * @param book 书籍
     * @return 书籍
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<Book> selectBookList(Book book)
    {
        return bookMapper.selectBookList(book);
    }

    /**
     * 新增书籍
     *
     * @param book 书籍
     * @return 结果
     */
    @Override
    public int insertBook(Book book)
    {
        return bookMapper.insertBook(book);
    }

    /**
     * 修改书籍
     *
     * @param book 书籍
     * @return 结果
     */
    @Override
    public int updateBook(Book book)
    {
        return bookMapper.updateBook(book);
    }

    /**
     * 批量删除书籍
     *
     * @param ids 需要删除的书籍主键
     * @return 结果
     */
    @Override
    public int deleteBookByIds(Long[] ids)
    {
        return bookMapper.deleteBookByIds(ids);
    }

    /**
     * 删除Book地址信息
     *
     * @param id 书籍主键
     * @return 结果
     */
    @Override
    public int deleteBookById(Long id)
    {
        return bookMapper.deleteBookById(id);
    }
}
