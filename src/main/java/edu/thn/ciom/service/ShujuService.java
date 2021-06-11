package edu.thn.ciom.service;

import edu.thn.ciom.dao.ShujuPojoMapper;
import edu.thn.ciom.pojo.ShujuPojo;
import edu.thn.ciom.pojo.ShujuPojoExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

// import javax.swing.plaf.basic.BasicArrowButton;
import java.util.List;

@Service
public class ShujuService {
    @Autowired
    private ShujuPojoMapper shujuPojoMapper;

    public List<ShujuPojo> queryShujus(ShujuPojo record, int page, int rows) {
        ShujuPojoExample example = new ShujuPojoExample();
        ShujuPojoExample.Criteria criteria = example.createCriteria();

        if (record != null) {
            if (record.getShujuid() != null) criteria.andShujuidEqualTo(record.getShujuid());
            if (record.getBuzhiid() != null) criteria.andBuzhiidEqualTo(record.getBuzhiid());
            if (record.getSjleixingid() != null) criteria.andSjleixingidEqualTo(record.getSjleixingid());
            if (record.getUserid() != null) criteria.andUseridEqualTo(record.getUserid());
            if (record.getShujuname() != null && StringUtils.hasText(record.getShujuname()))
                criteria.andShujunameLike(record.getShujuname());
        }
        if (rows == 0) return shujuPojoMapper.selectByExample(example);
        return shujuPojoMapper.selectByExampleWithRowbounds(example, new RowBounds((page - 1) * rows, rows));
    }

    public ShujuPojo getShuju(int parseInt) {
        return shujuPojoMapper.selectByPrimaryKey(parseInt);
    }

    public void modifyShuju(ShujuPojo shuju) {
        shujuPojoMapper.updateByPrimaryKeySelective(shuju);
    }

    public void deleteShuju(Integer id) {
        shujuPojoMapper.deleteByPrimaryKey(id);

    }

    public void save(ShujuPojo shuju) {
        shujuPojoMapper.insertSelective(shuju);

    }
}