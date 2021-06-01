package edu.thn.ciom.service;

import edu.thn.ciom.dao.RizhiPojoMapper;
import edu.thn.ciom.pojo.RizhiPojo;
import edu.thn.ciom.pojo.RizhiPojoExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.basic.BasicArrowButton;
import java.util.List;

@Service
public class RizhiService {

    @Autowired
    private RizhiPojoMapper rizhiPojoMapper;

    public List queryRizhis(RizhiPojo record, int page, int rows) {
        RizhiPojoExample ex = new RizhiPojoExample();
        RizhiPojoExample.Criteria criteria = ex.createCriteria();
        ex.setOrderByClause("date desc");

        if (record != null) {

        }
        if (rows == 0) return rizhiPojoMapper.selectByExample(ex);
        RowBounds rb = new RowBounds((page - 1) * rows, rows);
        return rizhiPojoMapper.selectByExampleWithRowbounds(ex, rb);
    }

    public RizhiPojo getRizhi(int parseInt) {
        // TODO Auto-generated method stub
        return rizhiPojoMapper.selectByPrimaryKey(parseInt);
    }

    public void modifyRizhi(RizhiPojo rizhi) {
        // TODO Auto-generated method stub
        rizhiPojoMapper.updateByPrimaryKeySelective(rizhi);
    }

    public void deleteRizhi(Integer id) {
        // TODO Auto-generated method stub
        rizhiPojoMapper.deleteByPrimaryKey(id);

    }

    public void save(RizhiPojo rizhi) {
        // TODO Auto-generated method stub
        rizhiPojoMapper.insert(rizhi);
    }
}
