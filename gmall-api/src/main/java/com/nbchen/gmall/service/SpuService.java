package com.nbchen.gmall.service;

import com.nbchen.gmall.bean.PmsProductInfo;
import com.nbchen.gmall.dto.PmsProductInfoDTO;
import com.nbchen.gmall.vo.PmsProductInfoVo;

import java.util.List;

/**
 * @author nbchen
 * @date 2019/09/01
 */
public interface SpuService {
    /**
     * 根据3级类目id查询SPU集合
     * @param catalog3Id
     * @return
     */
    List<PmsProductInfoVo> spuList(String catalog3Id);

    /**
     * 添加商品SPU
     * @param productInfo
     */
    void saveSpuInfo(PmsProductInfoDTO productInfo);
}
