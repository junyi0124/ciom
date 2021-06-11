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


    public List<DaohangPojo> queryJcdaohangs(DaohangPojo record, int page, int rows) {
        DaohangPojoExample example = new DaohangPojoExample();
        DaohangPojoExample.Criteria criteria = example.createCriteria();
        if (record != null) {
            criteria.andJcbiaotiidEqualTo(record.getJcbiaotiid());
            criteria.andJcdaohangtype1EqualTo(record.getJcdaohangtype1());
        }

        if (rows == 0) return daohangPojoMapper.selectByExample(example);
        RowBounds rb = new RowBounds((page - 1) * rows, rows);
        return daohangPojoMapper.selectByExampleWithRowbounds(example, rb);
    }

    public DaohangPojo getJcdaohang(int parseInt) {
        return daohangPojoMapper.selectByPrimaryKey(parseInt);
    }

    public void modifyJcdaohang(DaohangPojo jcdaohang) {
        daohangPojoMapper.updateByPrimaryKeySelective(jcdaohang);
    }

    public void deleteJcdaohang(Integer id) {
        daohangPojoMapper.deleteByPrimaryKey(id);

    }

    public void save(DaohangPojo jcdaohang) {
        daohangPojoMapper.insertSelective(jcdaohang);

    }
}
