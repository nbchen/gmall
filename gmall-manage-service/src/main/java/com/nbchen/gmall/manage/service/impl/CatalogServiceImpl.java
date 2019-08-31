package com.nbchen.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.nbchen.gmall.bean.PmsBaseCatalog1;
import com.nbchen.gmall.bean.PmsBaseCatalog2;
import com.nbchen.gmall.bean.PmsBaseCatalog3;
import com.nbchen.gmall.manage.mapper.PmsBaseCatalog1Mapper;
import com.nbchen.gmall.manage.mapper.PmsBaseCatalog2Mapper;
import com.nbchen.gmall.manage.mapper.PmsBaseCatalog3Mapper;
import com.nbchen.gmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author nbchen
 * @date 2019/08/31
 */
@Service
@Transactional
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;
    @Autowired
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;
    @Autowired
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    /**
     * 查询一级类目
     * @return
     */
    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return pmsBaseCatalog1Mapper.selectAll();
    }

    /**
     * 根据一级类目id查询二级类目
     * @param catalog1Id 一级类目id
     * @return
     */
    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);
        return pmsBaseCatalog2Mapper.select(pmsBaseCatalog2);
    }

    /**
     * 根据二级类目id查询三级类目
     * @param catalog2Id 二级类目id
     * @return
     */
    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        return pmsBaseCatalog3Mapper.select(pmsBaseCatalog3);
    }
}
