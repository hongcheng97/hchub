package cn.xydata.service.impl.system;

import cn.xydata.entity.system.Info;
import cn.xydata.mapper.system.InfoMapper;
import cn.xydata.service.system.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    private InfoMapper infoMapper;

    @Override
    public List<Info> findAllInfo(Integer pageStart) {
        if(pageStart==null){
            pageStart=0;
        }
        List<Info> list=infoMapper.findAllInfo(pageStart);

        return list;
    }
    @Override
    public List<Info> findOne(String userName) {
        List<Info> list = infoMapper.findOne(userName);
        return list;
    }

    @Override
    public int addInfo(String userName, String presentName, String phone, Date date) {
        int count = infoMapper.addInfo(userName,presentName,phone,date);
        return count;
    }

    @Override
    public int count() {
        int num = infoMapper.count();
        return num;
    }

    @Override
    public int deleteInfo(String userName) {
       int count =  infoMapper.deleteInfo(userName);
       return count;
    }
}
