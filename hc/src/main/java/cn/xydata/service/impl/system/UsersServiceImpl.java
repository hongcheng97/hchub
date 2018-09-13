package cn.xydata.service.impl.system;

import cn.xydata.entity.system.Users;
import cn.xydata.mapper.system.UsersMapper;
import cn.xydata.service.system.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users login(String userName,String password) {
        Users users=usersMapper.login(userName,password);
        return users;
    }

    @Override
    public int addUser(Users users) {
        int count=usersMapper.addUser(users);
        return count;
    }

    @Override
    public List<Users> findUser() {
        List<Users> list =usersMapper.findUser();
        return  list;
    }
}
