package edu.thn.ciom.service;

import edu.thn.ciom.dao.JianChuPojoMapper;
import edu.thn.ciom.pojo.JianChuPojo;
import edu.thn.ciom.pojo.JianChuPojoExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JianchuService {
    @Autowired
    private JianChuPojoMapper jianChuPojoMapper;

    public List<JianChuPojo> querySjjianchus(JianChuPojo record, int page, int rows) {
        JianChuPojoExample example = new JianChuPojoExample();
        JianChuPojoExample.Criteria criteria = example.createCriteria();
        if (record != null) {
            if(record.getShujuid()!=null) criteria.andShujuidEqualTo(record.getShujuid());
            if(record.getShujuname()!=null) criteria.andShujunameLike(record.getShujuname());
        }

        if (rows == 0) return jianChuPojoMapper.selectByExample(example);
        return jianChuPojoMapper.selectByExampleWithRowbounds(example, new RowBounds((page - 1) * rows, rows));
    }

    public JianChuPojo getSjjianchu(int parseInt) {
        return jianChuPojoMapper.selectByPrimaryKey(parseInt);
    }

    public void modifySjjianchu(JianChuPojo sjjianchu) {
        jianChuPojoMapper.updateByPrimaryKeySelective(sjjianchu);
    }

    public void deleteSjjianchu(Integer id) {
        jianChuPojoMapper.deleteByPrimaryKey(id);
    }

    public void save(JianChuPojo sjjianchu) {
        jianChuPojoMapper.insertSelective(sjjianchu);
    }
}
