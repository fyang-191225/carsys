package com.qfedu.car.api;

import com.qfedu.car.common.vo.R;
import com.qfedu.car.oss.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author FYY
 * @date 2019/12/12 0012 下午 21:04
 */

@Api(value = "资源管理",tags = "资源管理")
@RestController
public class OssController {

    @Autowired
    private OssService ossService;

    @ApiOperation(value = "实现资源上传至云服务器Oss，及信息添加到数据库", notes = "实现资源上传至云服务器，及信息添加到数据库")
    @PostMapping("/api/oss/upload.do")
    public R upload(@RequestBody MultipartFile file) {
        return ossService.upload(file);
    }


    @ApiOperation(value = "查询数据库记录的信息", notes = "查询数据库记录的信息")
    @GetMapping("/api/oss/selectSql.do")
    public R selectSql() {
        return ossService.queryAll();
    }


    @ApiOperation(value = "查询Oss记录的信息", notes = "查询Oss记录的信息")
    @GetMapping("/api/oss/selectOss.do")
    public R selectOss() {
        return ossService.queryOssAll();
    }

    @ApiOperation(value = "删除Oss上上传的信息以及数据库的信息", notes = "删除Oss上上传的信息以及数据库的信息")
    @DeleteMapping("/api/oss/del.do")
    public R del(String objname) {
        return ossService.delete(objname);
    }

}
