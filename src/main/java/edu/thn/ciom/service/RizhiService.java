package edu.thn.ciom.service;
import edu.thn.ciom.dao.RizhiPojoMapper;
import edu.thn.ciom.pojo.RizhiPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RizhiService {

    @Autowired
    private RizhiPojoMapper rizhiPojoMapper;

    public void save(RizhiPojo rizhi) {
        // TODO Auto-generated method stub
        rizhiPojoMapper.insertSelective(rizhi);
    }
}
