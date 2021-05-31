package edu.thn.ciom.service;

import edu.thn.ciom.dao.ShujuPojoMapper;
import edu.thn.ciom.pojo.ShujuPojo;
import edu.thn.ciom.pojo.ShujuPojoExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.basic.BasicArrowButton;
import java.util.List;

@Service
public class ShujuService {
    @Autowired
    private ShujuPojoMapper shujuPojoMapper;

    public List queryShujus(ShujuPojo record, int page, int rows, String sdate, String edate, String sdate1, String edate1) {
        ShujuPojoExample example =new ShujuPojoExample();
        ShujuPojoExample.Criteria criteria = example.createCriteria();

        RowBounds rb = new RowBounds((page-1)*rows, rows);
        return shujuPojoMapper.selectByExampleWithRowbounds(example, rb);
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