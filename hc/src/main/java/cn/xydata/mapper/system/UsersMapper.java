package cn.xydata.mapper.system;

import cn.xydata.entity.system.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {
    @Select("select * from t_users where USERNAME=#{userName} and PASSWORD=#{password}")
    Users login(@Param("userName") String userName,@Param("password") String password);

    @Insert("insert into t_users(USERNAME,PASSWORD,TYPE,PHONE,ISDELETED) values(#{userName},#{password},2,#{phone},0)")
    int addUser(Users users);

    @Select("select * from t_users ")
    List<Users> findUser();
}
