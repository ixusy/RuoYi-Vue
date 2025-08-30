package com.xby.testAll.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.xby.common.annotation.Anonymous;
import com.xby.common.annotation.Log;
import com.xby.common.core.domain.AjaxResult;
import com.xby.common.enums.BusinessType;
import com.xby.testAll.domain.Ip;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * ip地址Controller
 *
 * @author xby
 * @date 2025-05-13
 */
@RestController
@RequestMapping("/testAll/test")
public class TestAllController
{

//    private Logger logger = LoggerFactory.getLogger(TestController.class);
//    Random rand = new Random();

//    @Autowired
//    private SysConfigMapper configMapper;


    @Anonymous
//    @Log(title = "测试", businessType = BusinessType.OTHER)
    @GetMapping(path = "/test1")
    public AjaxResult Test() {
//        redisUtils.put("test9", "6666666666abc123ppppppppp");
//        redisUtils.expire("test9", 24*3600);



        JSONObject json = new JSONObject();
        json.put("token",  "Ow9CGhaMeEFngRd24ufHUzQc8niWAAGo@2geGM9uybGI2PfDZ6q5IeqXfTch5fgfw");

        JSONObject json_item = new JSONObject();
        json_item.put("logidUrl", "https://www.jdytp.com/?bd_vid=uANBIyIxUhNLgvw-I-tkPHRvrjc4g1cdg1DvrHfLPWfYn1TYPH6" );
        json_item.put("newType",  25);
        json_item.put("attributeSource",  0);
        json_item.put("interactionsType",  6);


        JSONArray json_list = new JSONArray();
        json_list.add(json_item);
        json.put("conversionTypes",json_list);

        String srcData = JSON.toJSON(json).toString();

//        logger.info(srcData);


        List<Ip> IpList = new ArrayList<>();
        IpList.add(new Ip());

//        return AjaxResult.success("ok",srcData);
        return AjaxResult.success("ok",json);
//        return AjaxResult.success("ok",IpList);
    }



}
