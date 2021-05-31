package edu.thn.ciom.service;

import edu.thn.ciom.dao.LeiXingPojoMapper;
import edu.thn.ciom.pojo.LeiXingPojo;
import edu.thn.ciom.pojo.LeiXingPojoExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class TypeService {

    @Autowired
    private LeiXingPojoMapper leiXingPojoMapper;

    public List querySjleixings(LeiXingPojo record, int page, int rows) {
        LeiXingPojoExample example = new LeiXingPojoExample();
        LeiXingPojoExample.Criteria criteria = example.createCriteria();

        if (record == null) {
            if (StringUtils.hasText(record.getSjleixingname()))
                criteria.andSjleixingnameLike(record.getSjleixingname());
            if (StringUtils.hasText(record.getSjleixingmark()))
                criteria.andSjleixingmark1Like(record.getSjleixingmark());
        }

        if (rows == 0) return leiXingPojoMapper.selectByExample(example);
        RowBounds rb = new RowBounds((page - 1) * rows, rows);
        return leiXingPojoMapper.selectByExampleWithRowbounds(example, rb);
    }

    public LeiXingPojo getSjleixing(int parseInt) {
        return leiXingPojoMapper.selectByPrimaryKey(parseInt);
    }

    public void modifySjleixing(LeiXingPojo sjleixing) {
        leiXingPojoMapper.updateByPrimaryKeySelective(sjleixing);
    }

    public void deleteSjleixing(Integer id) {
        leiXingPojoMapper.deleteByPrimaryKey(id);

    }

    public void save(LeiXingPojo sjleixing) {
        leiXingPojoMapper.insertSelective(sjleixing);
    }
}
