package edu.thn.ciom.service;

import edu.thn.ciom.dao.BiaotiPojoMapper;
import edu.thn.ciom.pojo.AdminPojoExample;
import edu.thn.ciom.pojo.BiaotiPojo;
import edu.thn.ciom.pojo.BiaotiPojoExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class JcbiaotiService {
    @Autowired
    private BiaotiPojoMapper biaotiPojoMapper;

    public List queryJcbiaotis(BiaotiPojo record, int page, int rows) {
        // TODO Auto-generated method stub
        BiaotiPojoExample example = new BiaotiPojoExample();
        BiaotiPojoExample.Criteria criteria = example.createCriteria();

        if (record != null) {
            criteria.andJcbiaotitypeEqualTo(record.getJcbiaotitype());
            criteria.andJcbiaotitype1EqualTo(record.getJcbiaotitype1());
        }

        if (rows == 0) return biaotiPojoMapper.selectByExample(example);
        RowBounds rb = new RowBounds((page - 1) * rows, rows);
        return biaotiPojoMapper.selectByExampleWithRowbounds(example, rb);
    }

    public BiaotiPojo getJcbiaoti(int parseInt) {
        // TODO Auto-generated method stub
        return biaotiPojoMapper.selectByPrimaryKey(parseInt);
    }

    public void modifyJcbiaoti(BiaotiPojo jcbiaoti) {
        // TODO Auto-generated method stub
        biaotiPojoMapper.updateByPrimaryKey(jcbiaoti);
    }

    public void deleteJcbiaoti(Integer id) {
        // TODO Auto-generated method stub
        biaotiPojoMapper.deleteByPrimaryKey(id);

    }

    public void save(BiaotiPojo jcbiaoti) {
        // TODO Auto-generated method stub
        biaotiPojoMapper.insertSelective(jcbiaoti);

    }

}
