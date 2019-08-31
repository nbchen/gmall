package com.nbchen.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.nbchen.gmall.bean.PmsBaseAttrInfo;
import com.nbchen.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.nbchen.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.nbchen.gmall.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author nbchen
 * @date 2019/09/01
 */
@Service
@Transactional
public class AttrServiceImpl implements AttrService {

    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;
    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    /**
     * 根据三级类目id查询平台属性列表
     * @param catalog3Id
     * @return
     */
    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        return pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);
    }
}
