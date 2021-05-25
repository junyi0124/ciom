package edu.thn.ciom.service;

import edu.thn.ciom.dao.PeizhiPojoMapper;
import edu.thn.ciom.pojo.PeizhiPojo;
import edu.thn.ciom.pojo.PeizhiPojoExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class JcpeizhiService {
    @Autowired
    private PeizhiPojoMapper peizhiPojoMapper;

    public List queryJcpeizhis(PeizhiPojo record, int page, int rows) {
        // TODO Auto-generated method stub
        PeizhiPojoExample example = new PeizhiPojoExample();
        PeizhiPojoExample.Criteria criteria = example.createCriteria();
        if (StringUtils.hasText(record.getBuzhiBieming()))
            criteria.andBumenbiemingLike(record.getBuzhiBieming());
//        if (StringUtils.hasText(record.getAdminpassword()))
//            criteria.andAdminpasswordLike(record.getAdminpassword());
        RowBounds rb = new RowBounds(page * rows, rows);
        return peizhiPojoMapper.selectByExampleWithRowbounds(example, rb);
    }

    public PeizhiPojo getJcpeizhi(int parseInt) {
        // TODO Auto-generated method stub
        return peizhiPojoMapper.selectByPrimaryKey(parseInt);
    }

    public void modifyJcpeizhi(PeizhiPojo jcpeizhi) {
        // TODO Auto-generated method stub
        peizhiPojoMapper.updateByPrimaryKey(jcpeizhi);
    }

    public void deleteJcpeizhi(Integer id) {
        // TODO Auto-generated method stub
        peizhiPojoMapper.deleteByPrimaryKey(id);

    }

    public void save(PeizhiPojo jcpeizhi) {
        // TODO Auto-generated method stub
        peizhiPojoMapper.insert(jcpeizhi);

    }
}
