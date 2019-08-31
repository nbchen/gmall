package com.nbchen.gmall.service;

import com.nbchen.gmall.bean.PmsBaseAttrInfo;

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
}
