package cn.xydata.mapper.system;


import cn.xydata.entity.system.Info;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface InfoMapper {

    @Select("select * from t_info limit #{pageStart},5")
    List<Info> findAllInfo(Integer pageStart);

    @Select("select USERNAME,PRESENTNAME,PHONE,DATE from t_info where userName=#{userName}")
    List<Info> findOne(String userName);

    @Insert("insert into t_info(userName,presentName,phone,date,ISDELETED) values(#{userName},#{presentName},#{phone},#{date},0)")
    int addInfo(@Param("userName") String userName, @Param("presentName") String presentName, @Param("phone") String  phone, @Param("date") Date date);

    @Select("select count(1) from t_info")
    int count();

    @Delete("delete from t_info where userName=#{userName}")
    int deleteInfo(String userName);
}
