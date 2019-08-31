package com.nbchen.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.nbchen.gmall.bean.PmsBaseCatalog1;
import com.nbchen.gmall.bean.PmsBaseCatalog2;
import com.nbchen.gmall.bean.PmsBaseCatalog3;
import com.nbchen.gmall.service.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author nbchen
 * @date 2019/08/31
 */
@CrossOrigin // 跨域访问
@Controller
public class CatalogController {

    @Reference
    CatalogService catalogService;

    /**
     * 查询一级类目
     * @return
     */
    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1() {
        return catalogService.getCatalog1();
    }

    /**
     * 根据一级类目id查询二级类目
     * Request URL: http://127.0.0.1:8083/getCatalog2?catalog1Id=6
     * Request Method: POST
     *
     * @RequestParam("catalog1Id") 前端查询字符串,不是json;json用@requestBody接
     * @param catalog1Id
     * @return
     */
    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        return catalogService.getCatalog2(catalog1Id);
    }

    /**
     * 根据二级类目id查询三级类目
     * Request URL: http://127.0.0.1:8083/getCatalog3?catalog2Id=13
     * Request Method: POST
     * @param catalog2Id
     * @return
     */
    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        return catalogService.getCatalog3(catalog2Id);
    }



}
