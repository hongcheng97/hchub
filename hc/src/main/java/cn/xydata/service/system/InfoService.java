package cn.xydata.service.system;

import cn.xydata.entity.system.Info;

import java.sql.Array;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface InfoService {

    List<Info> findAllInfo(Integer pageStart);

    List<Info> findOne(String userName);

    int addInfo(String userName, String presentName, String phone, Date date);

    int count();

    int deleteInfo(String userName);
}
