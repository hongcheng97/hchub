package cn.xydata.service.system;

import cn.xydata.entity.system.Present;

import java.util.List;

public interface PresentService {

    List<Present> findAllPresent();

    void deletePresent(int times);

    void addPresent(Present present);

    int updatePresent(int get,String presentName);

    Present findPresent(String presentName);

}
