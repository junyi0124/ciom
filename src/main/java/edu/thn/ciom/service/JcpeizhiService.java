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

    public List<PeizhiPojo> queryJcpeizhis(PeizhiPojo record, int page, int rows) {
        PeizhiPojoExample example = new PeizhiPojoExample();
        PeizhiPojoExample.Criteria criteria = example.createCriteria();
        if (record != null) {
            if (StringUtils.hasText(record.getBuzhiBieming()))
                criteria.andBumenbiemingLike(record.getBuzhiBieming());
            if (record.getJcpeizhiid() != 0)
                criteria.andJcpeizhiidEqualTo(record.getJcpeizhiid());
        }

        if (rows == 0) return peizhiPojoMapper.selectByExample(example);
        RowBounds rb = new RowBounds(page * rows, rows);
        return peizhiPojoMapper.selectByExampleWithRowbounds(example, rb);
    }

    public PeizhiPojo getJcpeizhi(int parseInt) {
        return peizhiPojoMapper.selectByPrimaryKey(parseInt);
    }

    public void modifyJcpeizhi(PeizhiPojo jcpeizhi) {
        peizhiPojoMapper.updateByPrimaryKey(jcpeizhi);
    }

    public void deleteJcpeizhi(Integer id) {
        peizhiPojoMapper.deleteByPrimaryKey(id);

    }

    public void save(PeizhiPojo jcpeizhi) {
        peizhiPojoMapper.insert(jcpeizhi);
    }
}
