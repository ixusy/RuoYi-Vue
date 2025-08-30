package com.ruoyi.testAll.controller;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.testAll.domain.Ip;
import com.ruoyi.testAll.service.IIpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Random;

/**
 * ip地址Controller
 *
 * @author ruoyi
 * @date 2025-05-13
 */
@RestController
@RequestMapping("/testAll/test")
public class TestController
{

//    private Logger logger = LoggerFactory.getLogger(TestController.class);
//    Random rand = new Random();



    @Anonymous
    @GetMapping(path = "/test1")
    public AjaxResult Test() {
//        redisUtils.put("test9", "6666666666abc123ppppppppp");
//        redisUtils.expire("test9", 24*3600);


        return AjaxResult.success();
    }








}
