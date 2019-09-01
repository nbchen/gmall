因为fastdfs-client-java-1.27-SNAPSHOT.jar这个依赖包在maven中央仓库是没有的。

需要自己编译源码成jar本地安装到maven 的本地仓库，安装完以后就能正常引用了（注意：本地必须安装了Maven，并配置好Maven环境变量）

1）：下载开发包工具  或者  Github下载    或者   点我下载
2）：需要把 fastdfs-client-java 开发工具包打包到本地的Maven仓库
2.1）：解压 fastdfs-client-java-master
2.2）：进入 fastdfs-client-java 目录，在此处打开命令窗口 cmd
2.3）：输入 mvn clean install
3）：构建一小会，如出现以下。则成功把 fastdfs-client-java 打包到本地的 Maven 仓库
至此，更新项目Maven，pom.xml文件就不会出现找不到fastdfs-client-java依赖了。（成功导入fastdfs-client-java依赖

<dependency>
      <groupId>org.csource</groupId>
      <artifactId>fastdfs-client-java</artifactId>
      <version>1.27-SNAPSHOT</version>
</dependency>



一 : 添加配置文件
当完成以上操作之后可以添加链接FastDFS服务器的配置文件 fastdfs-client.properties

fastdfs.connect_timeout_in_seconds = 5
fastdfs.network_timeout_in_seconds = 30
fastdfs.charset = UTF-8
fastdfs.http_anti_steal_token = false
fastdfs.http_secret_key = FastDFS1234567890
fastdfs.http_tracker_http_port = 80
fastdfs.tracker_servers = 192.168.1.7:22122
因为项目中只使用properties 格式文件，如果需要更多的配置信息，可以查看官方的[配置信息](https://github.com/happyfish100/fastdfs-client-java#conf-%E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6%E6%89%80%E5%9C%A8%E7%9B%AE%E5%BD%95%E5%8A%A0%E8%BD%BD%E4%BC%98%E5%85%88%E9%A1%BA%E5%BA%8F)

注: 1. 其他的配置项为可选，fastdfs.tracker_servers 为必须选项
     2. 多个tracker_servers可以使用逗号“ , ”分隔



二 : 加载配置文件
1. 测试加载配置文件
@Test
public void initConifg() throws Exception {
    // 加载配置文件   
    ClientGlobal.initByProperties("config/fastdfs-client.properties");                          
    System.out.println("ClientGlobal.configInfo():" + ClientGlobal.configInfo());
}
2. 输出结果
ClientGlobal.configInfo():{
    g_connect_timeout(ms) = 5000
    g_network_timeout(ms) = 30000
    g_charset = UTF-8
    g_anti_steal_token = false
    g_secret_key = FastDFS1234567890
    g_tracker_http_port = 80
    trackerServers = 192.168.1.7:22122
}
当出现上面和配置文件一致的输出结果时候，说明加载配置文件已经成功。


三:功能实现
由于是使用Junit做测试，为了方便在开始执行之前，初始化配置文件和获取连接，同时没有捕获异常全部抛出

1.初始化连接信息
//成员变量
TrackerServer trackerServer = null;
StorageServer storageServer = null;
StorageClient storageClient = null;
/**
 * 初始化连接信息
 * @author: wrh45
 * @date: 2017年8月5日下午8:08:57
 */
@Before
public void init() throws Exception {
      // 加载配置文件
      ClientGlobal.initByProperties("config/fastdfs-client.properties");
      // 获取连接
      TrackerClient trackerClient = new TrackerClient();
      trackerServer = trackerClient.getConnection();
      storageClient = new StorageClient(trackerServer, storageServer);
}
注:    如果出现连接超时异常：java.net.SocketTimeoutException: connect timed out
     1 .查看服务器地址和端口是否正确
​     2 .请查看服务器TrackerServer和StorageServer服务端口是否开启。默认为22122和23000



2.上传文件
/**
 * 上传图片
 * @throws Exception
 * @author: wrh45
 * @date: 2017年8月5日下午7:09:23
 */
@Test
public void uploadFileOfByte() throws Exception {
    // 获取文件字节信息
    file = new File("src/test/resources/pic/Ace.jpg");
    FileInputStream inputStream = new FileInputStream(file);
    byte[] file_buff = new byte[(int) file.length()];
    inputStream.read(file_buff);
  
    // 获取文件扩展名
    String fileName = file.getName();
    String extName = null;
    if (fileName.contains(".")) {
        extName = fileName.substring(fileName.lastIndexOf(".") + 1);
    } else {
        return;
    }

    // 图片元数据,如果设置为空，那么服务器上不会生成-m的原数据文件
    NameValuePair[] meta_list = new NameValuePair[2];
    meta_list[0] = new NameValuePair("fileName", "测试专用");
    meta_list[1] = new NameValuePair("length", "测试专用");
    // 文件上传，返回组名和访问地址
    String[] upload_file = storageClient.upload_file(file_buff, extName, meta_list);
    System.out.println(Arrays.asList(upload_file));
}
OK，在浏览器输入地址后，成功返回了图片信息

3.下载文件
这里通过storageClient下载文件，然后将数据存储到本地。如果通过浏览器下载，同理将数据写入文件即可

/**
 * 下载图片
 * @throws Exception
 * @author: wrh45
 * @date: 2017年8月5日下午8:09:10
 */
@Test
public void downLoadFile() throws Exception {
    // 下载文件，返回字节数组
    byte[] file_buff = storageClient.download_file("group1", "M00/00/00/wKgBB1l-EwyAGvxuAAWkdYkPHEE854.jpg");
    // 将数据写文件中
    File file = new File("src/test/resources/pic/Ace2.jpg");
    FileOutputStream outStream = new FileOutputStream(file);
    outStream.write(file_buff);
    outStream.flush();
    outStream.close();
}


4.获取元数据信息
/**
 * 元数据信息
 * @throws Exception
 * @author: wrh45
 * @date: 2017年8月5日下午8:09:38
 */
@Test
public void metaData() throws Exception {
    // 上传图片的时候，元数据若为空将无法生存-m的原数据文件。获取时候此处将抛出NullPointerException
    NameValuePair[] get_metadata = storageClient.get_metadata("group1",
        "M00/00/00/wKgBB1l-EwyAGvxuAAWkdYkPHEE854.jpg");
    for (NameValuePair nameValuePair: get_metadata) {
        System.out.println("name: " + nameValuePair.getName() + "  value: " + nameValuePair.getValue());
    }
}
以下是执行结果，获取到的数据和上传的数据一样

name: fileName  value: 测试专用
name: length  value: 测试专用


5.获取文件信息
/**
 * 获取文件信息
 * @author: wrh45
 * @date: 2017年8月7日下午9:02:47
 */
@Test
public void getFileInfo() throws Exception {
    FileInfo fileInfo = storageClient.get_file_info("group1", "M00/00/00/wKgBB1l-EwyAGvxuAAWkdYkPHEE854.jpg");

    System.out.println("CRC32签名：" + fileInfo.getCrc32());
    System.out.println("文件大小：" + fileInfo.getFileSize());
    System.out.println("服务器地址：" + fileInfo.getSourceIpAddr());
    System.out.println("创建时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(fileInfo.getCreateTimestamp()));
}
输出结果

CRC32签名：-1995498431
文件大小：369781
服务器地址：192.168.1.7
创建时间：2017-08-07 20-24-56


6.删除文件
当数据测试完整之后，试试能否删除吧

/**
 * 删除文件
 * @throws Exception
 * @author: wrh45
 * @date: 2017年8月7日下午9:10:04
 */
@Test
public void deleteFile() throws Exception {
    // 返回0成功，否则返回错误吗
    int code = storageClient.delete_file("group1", "M00/00/00/wKgBB1l-EwyAGvxuAAWkdYkPHEE854.jpg");
    System.out.println(code);
}
删除之后输出结果为0，如果出现非0结果，那么返回的是错误代码

以上是Java实现上传下载等功能的代码，如果需要可以封装成工具类使用。

以下是个人封装好的工具类
/**
 * 上传文件工具类
 * @ClassName: FileUploadUtils
 * @author wrh45
 * @date 2017年8月8日下午4:14:31
 */
public class FileUploadUtils {
    private static TrackerClient trackerClient = null;
    private static TrackerServer trackerServer = null;
    private static StorageServer storageServer = null;
    private static StorageClient storageClient = null;
    private static final String groupName = "group1";

    static {
        // 加载配置文件
        try {
            ClientGlobal.initByProperties("config/fastdfs-client.properties");
            // System.out.println("ClientGlobal.configInfo():" +
            // ClientGlobal.configInfo());
        } catch (IOException | MyException e) {
            e.printStackTrace();
            System.out.println("load config file fail");
        }
    }

    /*
     * 初始化连接数据
     */
    private static void init() {
        try {
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            storageClient = new StorageClient(trackerServer, storageServer);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("init fail");
        }
    }

    /**
     * 上传文件
     * @param filePath 文件路径
     * @param fileName 文件名称
     * @return 文件存储信息
     * @author: wrh45
     * @date: 2017年8月5日下午11:10:38
     */
    public static String[] uploadFile(String filePath, String fileName) {
        return uploadFile(null, filePath, fileName);
    }

    /**
     * 上传文件
     * @param fileBuff 文件字节数组
     * @param fileName 文件名称
     * @return 文件存储信息
     * @author: wrh45
     * @date: 2017年8月5日下午11:10:38
     */
    public static String[] uploadFile(byte[] fileBuff, String fileName) {
        return uploadFile(fileBuff, null, fileName);
    }

    /**
     * 上传文件
     * @param file_buff 文件字节数组
     * @param filePath 文件路径
     * @param fileName 文件名称
     * @return 文件存储信息
     * @author: wrh45
     * @date: 2017年8月5日下午10:58:19
     */
    private static String[] uploadFile(byte[] fileBuff, String filePath, String fileName) {
        try {
            if (fileBuff == null && filePath == null) {
                return new String[0];
            }
            // 初始化数据
            if (storageClient == null) {
                init();
            }

            // 获取文件扩展名称
            String fileExtName = "";
            if (fileName != null && !"".equals(fileName) && fileName.contains(".")) {
                fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1);
            } else {
                return new String[0];
            }

            // 设置图片元数据
            NameValuePair[] metaList = new NameValuePair[3];
            metaList[0] = new NameValuePair("fileName", fileName);
            metaList[1] = new NameValuePair("fileExtName", fileExtName);
            metaList[2] = new NameValuePair("fileSize", String.valueOf(fileBuff.length));
            // 上传文件
            String[] uploadFile = null;
            if (fileBuff != null && filePath == null) {
                if (fileBuff.length == 0) {
                    return new String[0];
                }
                uploadFile = storageClient.upload_file(fileBuff, fileExtName, metaList);
            } else {
                //路径匹配Windown和Linux
                if ("".equals(filePath) || !(filePath.matches("^[a-zA-Z]:{1}([\u4e00-\u9fa5\\w/_\\\\-]+)$") || filePath.matches("^(/[\u4e00-\u9fa5\\w_-]+)+$"))) {
                    return new String[0];
                }
                uploadFile = storageClient.upload_file(filePath, fileExtName, metaList);
            }
            return uploadFile == null ? new String[0] : uploadFile;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (trackerServer != null) {
                    trackerServer.close();
                    trackerServer = null;
                }
                if (storageServer != null) {
                    storageServer.close();
                    storageServer = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new String[0];
    }

    /**
     * 删除服务器文件
     * @param remoteFileName  文件在服务器中名称
     * @author: wrh45
     * @date: 2017年8月6日上午12:15:22
     */
    public static int deleteFile(String remoteFileName) {
        try {
            if (remoteFileName == null || "".equals(remoteFileName) || !remoteFileName.contains(groupName)) {
                return -1;
            }
            if (storageClient == null) {
                init();
            }
            String fileURL = remoteFileName.substring(remoteFileName.indexOf(groupName));
            String group = fileURL.substring(0, remoteFileName.indexOf("/") + 1);
            String fileName = fileURL.substring(remoteFileName.indexOf("/") + 2);
            int code = storageClient.delete_file(group, fileName);
            return code;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("The File Delete Fail");
        }
        return -1;
    }

    /**
     * 获取文件信息
     * @param groupName  组名
     * @param remoteFilename  远程文件名
     * @return
     * @author: wrh45
     * @date: 2017年8月8日上午12:25:26
     */
    public static FileInfo getFileInfo(String groupName, String remoteFilename) {
        try {
            if (storageClient == null) {
                init();
            }
            FileInfo fileInfo = storageClient.get_file_info(groupName, remoteFilename);
            return fileInfo;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Get File Info Fail");
        }
        return null;
    }
}
整篇博文到此为止，不足之处请多多指正。
