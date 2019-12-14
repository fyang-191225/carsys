package com.qfedu.car.oss.dao;

import com.qfedu.car.oss.entity.OssUrl;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author FYY
 * @date 2019/12/12 0012 下午 19:57
 */


public interface OssUrlDao {
    /**
     * 新增一条上传的内容
     * @param ossUrl
     * @return
     */
    @Insert("insert into t_ossurl(objname ,url,ctime ,endtime)values (#{objname}, #{url}, #{ctime}, #{endtime})")
    int insert(OssUrl ossUrl);

    /**
     * 查询数据
     * @return
     */
    @Select("select id,objname ,url,ctime ,endtime from t_ossurl order by id desc ")
    @ResultType(OssUrl.class)
    List<OssUrl> selectAll();

    /**
     * 删除一条信息
     * @param name
     * @return
     */
    @Delete("delete from t_ossurl")
    int delete(String name);
}
