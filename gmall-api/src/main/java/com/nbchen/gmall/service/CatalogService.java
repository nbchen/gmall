package com.nbchen.gmall.service;

import com.nbchen.gmall.bean.PmsBaseCatalog1;
import com.nbchen.gmall.bean.PmsBaseCatalog2;
import com.nbchen.gmall.bean.PmsBaseCatalog3;

import java.util.List;

/**
 * @author nbchen
 * @date 2019/08/31
 */
public interface CatalogService {
    /**
     * 查询一级类目
     * @return 一级类目集合
     */
    List<PmsBaseCatalog1> getCatalog1();

    /**
     * 根据一级类目id查询二级类目
     * @param catalog1Id 一级类目id
     * @return 该一级类目下的二级类目集合
     */
    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    /**
     * 根据二级类目id查询三级类目
     * @param catalog2Id 二级类目id
     * @return 该二级类目下的三级类目集合
     */
    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
