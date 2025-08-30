package com.xby.testAll.controller;

import com.xby.common.annotation.Log;
import com.xby.common.core.controller.BaseController;
import com.xby.common.core.domain.AjaxResult;
import com.xby.common.core.page.TableDataInfo;
import com.xby.common.enums.BusinessType;
import com.xby.common.utils.poi.ExcelUtil;
import com.xby.testAll.domain.Book;
import com.xby.testAll.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * BookController
 *
 * @author xby
 * @date 2025-05-13
 */
@RestController
@RequestMapping("/testAll/Book")
public class BookController extends BaseController
{
    @Autowired
    private IBookService bookService;

    /**
     * 查询书籍列表
     */
    @PreAuthorize("@ss.hasPermi('testAll:book:list')")
    @GetMapping("/list")
    public TableDataInfo list(Book book)
    {
        startPage();
        List<Book> list = bookService.selectBookList(book);
        return getDataTable(list);
    }

    /**
     * 导出书籍列表
     */
    @PreAuthorize("@ss.hasPermi('testAll:book:export')")
    @Log(title = "书籍", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Book book)
    {
        List<Book> list = bookService.selectBookList(book);
        ExcelUtil<Book> util = new ExcelUtil<Book>(Book.class);
        util.exportExcel(response, list, "书籍数据");
    }

    /**
     * 获取书籍详细信息
     */
    @PreAuthorize("@ss.hasPermi('testAll:book:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bookService.selectBookById(id));
    }

    /**
     * 新增书籍
     */
    @PreAuthorize("@ss.hasPermi('testAll:book:add')")
    @Log(title = "书籍", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Book book)
    {
        book.setUserId(getUserId());    // 设置当前用户ID
        return toAjax(bookService.insertBook(book));
    }

    /**
     * 修改书籍
     */
    @PreAuthorize("@ss.hasPermi('testAll:book:edit')")
    @Log(title = "书籍", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Book book)
    {
        return toAjax(bookService.updateBook(book));
    }

    /**
     * 删除书籍
     */
    @PreAuthorize("@ss.hasPermi('testAll:book:remove')")
    @Log(title = "书籍", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bookService.deleteBookByIds(ids));
    }
}
