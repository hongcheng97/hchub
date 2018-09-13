package cn.xydata.mapper.system;

import cn.xydata.entity.system.Present;
import org.apache.ibatis.annotations.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PresentMapper {
    @Select("select * from t_present where ISDELETED=0")
    List<Present> findAllPresent();

    @Update("update t_present set ISDELETED=1 where TIMES=#{times}")
    void deletePresent(int times);

    @Insert("insert into t_present(PRESENTNAME,PRESENTTYPE,TIMES,GET,NUMBER,ISDELETED) values(#{presentName},#{presentType},#{times},#{number}),0")
    void addPresent(Present present);

    @Update("update t_present set GET=#{get} where PRESENTNAME=#{presentName} ")
    int  updatePresent(@Param("get") int get, @Param("presentName") String presentName);

    @Select("select * from t_present where presentName=#{presentName}")
    Present findPresent(String presentName);

}
