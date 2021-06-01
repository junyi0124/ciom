package edu.thn.ciom.service;

import edu.thn.ciom.dao.DuochuPojoMapper;
import edu.thn.ciom.pojo.DuochuPojo;
import edu.thn.ciom.pojo.DuochuPojoExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    @Autowired
    private DuochuPojoMapper duochuPojoMapper;

    public List<DuochuPojo> querySjduochus(DuochuPojo record, int page, int rows) {
        DuochuPojoExample example = new DuochuPojoExample();
        DuochuPojoExample.Criteria criteria = example.createCriteria();

        if (record != null) {
            if (record.getShujuid() != null)
                criteria.andShujuidEqualTo(record.getShujuid());
        }

        if (rows == 0) return duochuPojoMapper.selectByExample(example);
        return duochuPojoMapper.selectByExampleWithRowbounds(example, new RowBounds((page - 1) * rows, rows));
    }

    public DuochuPojo getSjduochu(int parseInt) {
        return duochuPojoMapper.selectByPrimaryKey(parseInt);
    }

    public void modifySjduochu(DuochuPojo sjduochu) {
        duochuPojoMapper.updateByPrimaryKeySelective(sjduochu);
    }

    public void deleteSjduochu(Integer id) {
        duochuPojoMapper.deleteByPrimaryKey(id);
    }

    public void save(DuochuPojo sjduochu) {
        duochuPojoMapper.insertSelective(sjduochu);
    }
}
