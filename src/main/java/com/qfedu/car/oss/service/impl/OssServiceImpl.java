package com.qfedu.car.oss.service.impl;

import com.qfedu.car.common.vo.R;
import com.qfedu.car.oss.dao.OssUrlDao;
import com.qfedu.car.oss.entity.OssUrl;
import com.qfedu.car.oss.service.OssService;
import com.qfedu.car.util.AliOssUtil;
import com.qfedu.car.util.DateUtil;
import com.qfedu.car.util.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;

/**
 * @author FYY
 * @date 2019/12/12 0012 下午 19:58
 */

@Service
public class OssServiceImpl implements OssService {

    @Autowired
    private OssUrlDao ossUrlDao;



    @Override
    public R upload(MultipartFile file) {
        // 1. 检验文件是否为空
        if (!file.isEmpty()) {
            // 2. 获取文件的名字
            String fn = file.getOriginalFilename();
            // 3. 重命名
            fn = rename(fn);
            try {
                // 4. 上传oss服务器, 并设置时间
                Date date = DateUtil.addYear(3);
                String upload = AliOssUtil.upload(fn, file.getBytes(), date);

                // 5. 保存到本地数据库
                OssUrl ossUrl = new OssUrl();
                // 路径
                ossUrl.setUrl(upload);
                // 路径过期的日期
                ossUrl.setEndtime(date);
                // 图片的名字
                ossUrl.setObjname(fn);

                ossUrlDao.insert(ossUrl);
                return R.OK(ossUrl);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return R.fail();
    }

    @Override
    public R queryAll() {

        return R.OK(ossUrlDao.selectAll());
    }

    @Override
    public R queryOssAll() {

        return R.OK(AliOssUtil.list());
    }

    @Override
    public R delete(String objname) {
        if (AliOssUtil.del(objname)) {
            ossUrlDao.delete(objname);
            return R.OK();
        } else {
            return R.fail();
        }

    }

    //对文件名 1、截取 2、重命名
    private String rename(String fn) {
        if (fn.length() > 40) {
            fn = fn.substring(fn.length() - 40);
        }
        return UUID.randomUUID().toString()+"_"+fn;
    }
}
