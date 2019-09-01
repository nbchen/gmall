package com.nbchen.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.nbchen.gmall.bean.PmsBaseAttrInfo;
import com.nbchen.gmall.bean.PmsBaseAttrValue;
import com.nbchen.gmall.bean.PmsBaseSaleAttr;
import com.nbchen.gmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 新增平台属性和属性值
     * @param pmsBaseAttrInfo
     */
    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public void saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {
        attrService.saveAttrInfo(pmsBaseAttrInfo);
    }

    /**
     * 根据平台属性id查询平台属性值集合
     * Request URL: http://127.0.0.1:8083/getAttrValueList?attrId=43
     * Request Method: POST
     */
    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){
        return attrService.getAttrValueList(attrId);
    }

    /**
     * 根据属性id删除属性和该属性下的属性值
     * Request URL: http://127.0.0.1:8083/deleteAttrInfoById?attrId=43
     * Request Method: POST
     */
    @RequestMapping("deleteAttrInfoById")
    @ResponseBody
    public void deleteAttrInfoById(String attrId) {
        attrService.deleteAttrInfoById(attrId);
    }


    /**
     * 查询销售属性集合
     * 商家添加spu商品信息时,需要选择销售属性下拉表,添加销售属性值（自定义）
     * Request URL: http://127.0.0.1:8083/baseSaleAttrList
     * Request Method: POST
     */
    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return attrService.baseSaleAttrList();
    }

}
