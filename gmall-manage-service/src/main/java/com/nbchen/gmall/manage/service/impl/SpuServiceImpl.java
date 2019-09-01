package com.nbchen.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.nbchen.gmall.bean.PmsProductInfo;
import com.nbchen.gmall.bean.PmsProductSaleAttrValue;
import com.nbchen.gmall.common.util.BeanHelper;
import com.nbchen.gmall.dto.PmsProductInfoDTO;
import com.nbchen.gmall.dto.PmsProductSaleAttrDTO;
import com.nbchen.gmall.manage.mapper.PmsProductInfoMapper;
import com.nbchen.gmall.service.SpuService;
import com.nbchen.gmall.vo.PmsProductInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nbchen
 * @date 2019/09/01
 */
@Service
@Transactional
public class SpuServiceImpl implements SpuService {

    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;

    /**
     * 根据3级类目id查询SPU集合
     * @param catalog3Id
     * @return
     */
    @Override
    public List<PmsProductInfoVo> spuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        List<PmsProductInfo> pmsProductInfoList = pmsProductInfoMapper.select(pmsProductInfo);

        List<PmsProductInfoVo> pmsProductInfoVoList = new ArrayList<>();
        pmsProductInfoList.forEach(productInfo -> {
            PmsProductInfoVo build = PmsProductInfoVo.builder()
                    .id(productInfo.getId())
                    .spuName(productInfo.getProductName())
                    .description(productInfo.getDescription())
                    .catalog3Id(productInfo.getCatalog3Id())
                    .build();
            pmsProductInfoVoList.add(build);
        });

        return pmsProductInfoVoList;
    }

    /**
     * 添加商品SPU
     * @param productInfo
     */
    @Override
    public void saveSpuInfo(PmsProductInfoDTO productInfo) {



        List<PmsProductSaleAttrDTO> spuSaleAttrList = productInfo.getSpuSaleAttrList();
        spuSaleAttrList.forEach(pmsProductSaleAttrDTO -> {
            List<PmsProductSaleAttrValue> spuSaleAttrValueList = pmsProductSaleAttrDTO.getSpuSaleAttrValueList();
        });
    }
}
