package cn.xydata.service.system;

import cn.xydata.entity.system.Users;

import java.util.List;

public interface UsersService {

    Users login(String userName,String password);

    int addUser(Users users);

    List<Users> findUser();
}
