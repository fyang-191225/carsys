package com.qfedu.car.oss.service;

import com.qfedu.car.common.vo.R;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author FYY
 * @date 2019/12/12 0012 下午 19:58
 */

public interface OssService {

    R upload(MultipartFile file);

    R queryAll();

    R queryOssAll();

    R delete(String objname);
}
