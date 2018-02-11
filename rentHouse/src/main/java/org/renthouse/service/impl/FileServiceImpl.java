package org.renthouse.service.impl;

import com.google.common.collect.Lists;
import org.renthouse.service.FileService;
import org.renthouse.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * <dl>
 * <dt>FileServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2017/10/12</dd>
 * </dl>
 *
 * @author 梁浩斌
 */
@Service("fileService")
public class FileServiceImpl implements FileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public String upload(MultipartFile file, String path) {
        String fileName = file.getOriginalFilename();
        String fileExtensionName =fileName.substring(fileName.lastIndexOf(".")+1);
        String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
        logger.info("开始上传文件，上传文件的文件名：{}，上传的路径：{}，新文件的名字：{}",
                fileName,path,uploadFileName);

        File file1 = new File(path);
        if(!file1.exists()){
            file1.setWritable(true);
            file1.mkdirs();
        }
        File targetFile = new File(path,uploadFileName);

        try{
            file.transferTo(targetFile);
            //文件已经上传成功了
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //已经上传到ftp服务器上
            //targetFile.delete();
        }catch (Exception e){
            logger.error("上传文件失败",e);

        }
        return targetFile.getName();
    }


}
