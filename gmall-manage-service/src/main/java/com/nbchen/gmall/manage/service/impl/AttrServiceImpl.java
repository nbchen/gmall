package com.nbchen.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.nbchen.gmall.bean.PmsBaseAttrInfo;
import com.nbchen.gmall.bean.PmsBaseAttrValue;
import com.nbchen.gmall.bean.PmsBaseSaleAttr;
import com.nbchen.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.nbchen.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.nbchen.gmall.manage.mapper.PmsBaseSaleAttrMapper;
import com.nbchen.gmall.service.AttrService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Autowired
    PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;

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

    /**
     * 新增/修改平台属性和属性值
     * @param pmsBaseAttrInfo
     */
    @Override
    public void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        String pmsBaseAttrInfoId = pmsBaseAttrInfo.getId();
        if (StringUtils.isBlank(pmsBaseAttrInfoId)) {
            // id为空,增加
            // 保存属性
            // insert:null值也插入数据库;insertSelective:null值不插入数据库
            pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);

            // 保存属性值
            List<PmsBaseAttrValue> valueList = pmsBaseAttrInfo.getAttrValueList();
            // 循环!,不好-->批量插入
            valueList.forEach(pmsBaseAttrValue -> {
                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
            });
        } else {
            // id不为空,修改
            // 修改属性
            pmsBaseAttrInfoMapper.updateByPrimaryKeySelective(pmsBaseAttrInfo);
            // 按照属性id删除属性值
            PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
            pmsBaseAttrValue.setAttrId(pmsBaseAttrInfoId);
            pmsBaseAttrValueMapper.delete(pmsBaseAttrValue);
            // 保存修改的属性值
            pmsBaseAttrInfo.getAttrValueList().forEach(pmsBaseAttrValue1 -> {
                pmsBaseAttrValue1.setAttrId(pmsBaseAttrInfoId);
                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue1);
            });
        }

    }

    /**
     * 根据平台属性id查询平台属性值集合
     * @param attrId
     * @return
     */
    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        return this.pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
    }

    /**
     * 根据属性id删除属性和该属性下的属性值
     * @param attrId
     */
    @Override
    public void deleteAttrInfoById(String attrId) {
        // 删除属性
        pmsBaseAttrInfoMapper.deleteByPrimaryKey(attrId);
        // 删除属性值
        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        pmsBaseAttrValueMapper.delete(pmsBaseAttrValue);
    }

    /**
     * 查询销售属性集合
     * @return
     */
    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return pmsBaseSaleAttrMapper.selectAll();
    }

}
