package com.nbchen.gmall.namage;

import com.nbchen.gmall.manage.GmallManageWebApplication;
import lombok.extern.slf4j.Slf4j;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author nbchen
 * @date 2019/09/02
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GmallManageWebApplication.class)
@Slf4j
public class GmallManageWebApplicationTests {

    @Test
    public void contextLoads() throws Exception {
        // 加载配置文件
        String tracker = GmallManageWebApplicationTests.class.getResource("/tracker.conf").getPath();
        ClientGlobal.init(tracker);
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        String orginalFilename = "G:\\个人材料\\20_图库\\09_二次元图片\\4.jpg";
        String[] upload_file = storageClient.upload_file(orginalFilename, "jpg", null);
        for (int i = 0; i < upload_file.length; i++) {
            String s = upload_file[i];
            log.info("s = {}", s);
        }
        /**
         *  s = group1
         *  s = M00/00/00/wKgRkl1sbQKARpNaAACGUK6Qu8w048.jpg
         */
    }
}
