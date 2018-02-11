package org.renthouse.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * <dl>
 * <dt>FileService</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2017/10/12</dd>
 * </dl>
 *
 * @author 梁浩斌
 */
public interface FileService {
    String upload(MultipartFile file, String path);
}
