package edu.thn.ciom.service;

import edu.thn.ciom.dao.BuzhiPojoMapper;
import edu.thn.ciom.pojo.BuzhiPojo;
import edu.thn.ciom.pojo.BuzhiPojoExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BuzhiService {

    @Autowired
    private BuzhiPojoMapper buzhiPojoMapper;

    public List<BuzhiPojo> queryBuzhis(BuzhiPojo record, int page, int rows) {

        BuzhiPojoExample example = new BuzhiPojoExample();
        BuzhiPojoExample.Criteria criteria = example.createCriteria();

        if (StringUtils.hasText(record.getBuzhiname())) criteria.andBuzhinameEqualTo(record.getBuzhiname());
        if (record.getBuzhitype() != null) criteria.andBuzhiidEqualTo(record.getBuzhitype());
        //if (record.getBumenid() != 0) criteria.andBumenidEqualTo(record.getBumenid());
        //if (record.getBuzhitype() != 0) criteria.andBuzhinameEqualTo(record.getBuzhiname());

        if (rows == 0) return buzhiPojoMapper.selectByExample(example);
        RowBounds rb = new RowBounds((page - 1) * rows, rows);
        return buzhiPojoMapper.selectByExampleWithRowbounds(example, rb);
    }

    public BuzhiPojo getBuzhi(int parseInt) {
        return buzhiPojoMapper.selectByPrimaryKey(parseInt);
    }

    public void modifyBuzhi(BuzhiPojo buzhi) {
        buzhiPojoMapper.updateByPrimaryKeySelective(buzhi);
    }

    public void deleteBuzhi(Integer id) {
        buzhiPojoMapper.deleteByPrimaryKey(id);

    }

    public void save(BuzhiPojo buzhi) {
        buzhiPojoMapper.insertSelective(buzhi);

    }
}
