package com.nbchen.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.nbchen.gmall.bean.PmsProductInfo;
import com.nbchen.gmall.dto.PmsProductInfoDTO;
import com.nbchen.gmall.service.SpuService;
import com.nbchen.gmall.vo.PmsProductInfoVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author nbchen
 * @date 2019/09/01
 */
//@CrossOrigin(origins = "http://127.0.0.1:8083")
@CrossOrigin
@Controller
public class SpuController {

    @Reference
    SpuService spuService;

    /**
     * 文件(图片)上传
     * @param multipartFile
     * @return
     */
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file")MultipartFile multipartFile) {

        // 将图片或者音视频上传到分布式的文件存储系统

        // 将图片的存储路径返回给页面
        String imgUrl = "https://m.360buyimg.com/babel/jfs/t5137/20/1794970752/352145/d56e4e94/591417dcN4fe5ef33.jpg";




        return imgUrl;
    }

    /**
     * 根据3级类目id查询SPU集合
     * 请求方式: GET
     * 请求URL: http://127.0.0.1:8083/spuList?catalog3Id=61
     * 请求参数: catalog3Id=61
     * 返回值: List<pmsProductInfo>
     */
    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfoVo> spuList(String catalog3Id) {
        return spuService.spuList(catalog3Id);
    }

    /**
     * 添加商品SPU
     * @param productInfo
     */
    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public void saveSpuInfo(@RequestBody PmsProductInfoDTO productInfo) {
        spuService.saveSpuInfo(productInfo);
    }

}
