package edu.thn.ciom.service;

import edu.thn.ciom.dao.DaohangPojoMapper;
import edu.thn.ciom.pojo.DaohangPojo;
import edu.thn.ciom.pojo.DaohangPojoExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JcdaohangService {

    @Autowired
    private DaohangPojoMapper daohangPojoMapper;


    public List queryJcdaohangs(DaohangPojo record, int page, int rows) {
        // TODO Auto-generated method stub
        DaohangPojoExample example = new DaohangPojoExample();

        if (rows == 0) return daohangPojoMapper.selectByExample(example);
        RowBounds rb = new RowBounds(page * rows, rows);
        return daohangPojoMapper.selectByExampleWithRowbounds(example, rb);
    }

    public DaohangPojo getJcdaohang(int parseInt) {
        // TODO Auto-generated method stub
        return daohangPojoMapper.selectByPrimaryKey(parseInt);
    }

    public void modifyJcdaohang(DaohangPojo jcdaohang) {
        // TODO Auto-generated method stub
        daohangPojoMapper.updateByPrimaryKeySelective(jcdaohang);
    }

    public void deleteJcdaohang(Integer id) {
        // TODO Auto-generated method stub
        daohangPojoMapper.deleteByPrimaryKey(id);

    }

    public void save(DaohangPojo jcdaohang) {
        // TODO Auto-generated method stub
        daohangPojoMapper.insertSelective(jcdaohang);

    }
}
