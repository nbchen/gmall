package com.nbchen.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.nbchen.gmall.bean.PmsBaseAttrInfo;
import com.nbchen.gmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author nbchen
 * @date 2019/09/01
 */
@CrossOrigin // 跨域访问
@Controller
public class AttrController {

    @Reference
    AttrService attrService;

    /**
     * 根据三级类目id查询平台属性列表
     * Request URL: http://127.0.0.1:8083/attrInfoList?catalog3Id=61
     * Request Method: GET
     * @param catalog3Id
     * @return
     */
    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        return attrService.attrInfoList(catalog3Id);
    }

    // todo  saveAttrInfo增 , 删除, 修改

}
