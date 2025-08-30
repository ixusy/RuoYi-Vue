package com.xby.common.utils;

import com.github.pagehelper.PageHelper;
import com.xby.common.core.page.PageDomain;
import com.xby.common.core.page.TableSupport;
import com.xby.common.utils.sql.SqlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 分页工具类
 *
 * @author xby
 */
public class PageUtils extends PageHelper
{
    private static final Logger log = LoggerFactory.getLogger(PageUtils.class);

    /**
     * 设置请求分页数据
     */
    public static void startPage()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
        log.info("99999-----pageNum: {}, pageSize: {}, orderBy: {}", pageNum, pageSize, orderBy);
        Boolean reasonable = pageDomain.getReasonable();
        PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
    }

    /**
     * 清理分页的线程变量
     */
    public static void clearPage()
    {
        PageHelper.clearPage();
    }
}
