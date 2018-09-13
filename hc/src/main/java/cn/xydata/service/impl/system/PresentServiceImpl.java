package cn.xydata.service.impl.system;

import cn.xydata.entity.system.Present;
import cn.xydata.mapper.system.PresentMapper;
import cn.xydata.service.system.PresentService;
import oracle.jdbc.proxy.annotation.Pre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresentServiceImpl implements PresentService {
    @Autowired
    private PresentMapper presentMapper;

    @Override
    public List<Present> findAllPresent() {
        List<Present> list=presentMapper.findAllPresent();
        return list;
    }

    @Override
    public void deletePresent(int times) {
        presentMapper.deletePresent(times);
    }

    @Override
    public void addPresent(Present present) {
        presentMapper.addPresent(present);
    }

    @Override
    public int  updatePresent(int get,String presentName) {
        int count = presentMapper.updatePresent(get,presentName);
        return count;
    }

    @Override
    public Present findPresent(String presentName) {
        Present present=presentMapper.findPresent(presentName);
        return present;
    }

}
