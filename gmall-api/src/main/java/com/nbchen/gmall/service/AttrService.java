package com.nbchen.gmall.service;

import com.nbchen.gmall.bean.PmsBaseAttrInfo;
import com.nbchen.gmall.bean.PmsBaseAttrValue;
import com.nbchen.gmall.bean.PmsBaseSaleAttr;

import java.util.List;

/**
 * @author nbchen
 * @date 2019/09/01
 */
public interface AttrService {

    /**
     * 根据三级类目id查询平台属性列表
     * @param catalog3Id
     * @return
     */
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    /***
     * 新增平台属性和属性值
     * @param pmsBaseAttrInfo
     */
    void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    /**
     * 根据平台属性id查询平台属性值集合
     * @param attrId
     * @return
     */
    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    /**
     * 根据属性id删除属性和该属性下的属性值
     * @param attrId
     */
    void deleteAttrInfoById(String attrId);

    /**
     * 查询销售属性集合
     * @return
     */
    List<PmsBaseSaleAttr> baseSaleAttrList();
}
