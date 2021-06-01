package edu.thn.ciom.service;

import edu.thn.ciom.dao.ShaoChuPojoMapper;
import edu.thn.ciom.pojo.ShaoChuPojo;
import edu.thn.ciom.pojo.ShaoChuPojoExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShaochuService {

    @Autowired
    private ShaoChuPojoMapper shaoChuPojoMapper;


    public List<ShaoChuPojo> querySjshaochus(ShaoChuPojo record, int page, int rows) {
        ShaoChuPojoExample example = new ShaoChuPojoExample();
        ShaoChuPojoExample.Criteria criteria = example.createCriteria();

        if (record != null) {
            if (record.getShujuid() != null) criteria.andShujuidEqualTo(record.getShujuid());
            if (record.getSjshaochuid() != null) criteria.andSjshaochuidEqualTo(record.getSjshaochuid());
        }

        if (rows == 0) return shaoChuPojoMapper.selectByExample(example);
        return shaoChuPojoMapper.selectByExampleWithRowbounds(example, new RowBounds((page - 1) * rows, rows));
    }

    public ShaoChuPojo getSjshaochu(int parseInt) {
        // TODO Auto-generated method stub
        return shaoChuPojoMapper.selectByPrimaryKey(parseInt);
    }

    public void modifySjshaochu(ShaoChuPojo sjshaochu) {
        // TODO Auto-generated method stub
        shaoChuPojoMapper.updateByPrimaryKey(sjshaochu);
    }

    public void deleteSjshaochu(Integer id) {
        // TODO Auto-generated method stub
        shaoChuPojoMapper.deleteByPrimaryKey(id);

    }

    public void save(ShaoChuPojo sjshaochu) {
        // TODO Auto-generated method stub
        shaoChuPojoMapper.insertSelective(sjshaochu);

    }
}
