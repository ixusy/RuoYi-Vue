package com.xby.testAll.mapper;

import com.xby.testAll.domain.Book;
import com.xby.testAll.domain.Ip;

import java.util.List;

/**
 * 书籍Mapper接口
 *
 * @author xby
 * @date 2025-05-13
 */
public interface BookMapper
{
    /**
     * 查询书籍列表
     *
     * @param id 书籍主键
     * @return 书籍
     */
    public Book selectBookById(Long id);

    /**
     * 查询书籍列表
     *
     * @param book 书籍
     * @return 书籍集合
     */
    public List<Book> selectBookList(Book book);

    /**
     * 新增书籍
     *
     * @param book 书籍
     * @return 结果
     */
    public int insertBook(Book book);

    /**
     * 修改书籍
     *
     * @param book 书籍
     * @return 结果
     */
    public int updateBook(Book book);

    /**
     * 删除书籍
     *
     * @param id 书籍主键
     * @return 结果
     */
    public int deleteBookById(Long id);

    /**
     * 批量删除书籍
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBookByIds(Long[] ids);
}
