package edu.thn.ciom.service;

import edu.thn.ciom.dao.YongHuPojoMapper;
import edu.thn.ciom.pojo.DaohangPojoExample;
import edu.thn.ciom.pojo.YongHuPojo;
import edu.thn.ciom.pojo.YongHuPojoExample;
import edu.thn.ciom.util.DateUtil;
import org.apache.ibatis.session.RowBounds;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class YonghuService {

    @Autowired
    private YongHuPojoMapper yongHuPojoMapper;

    private final String dateFormat = "yyyy-MM-dd hh:mm:ss";

    public List<YongHuPojo> queryYonghus(YongHuPojo record, String yonghuName, int page, int rows,
                                         String sdate, String edate,
                                         String sdate1, String edate1) {

        YongHuPojoExample example = new YongHuPojoExample();
        YongHuPojoExample.Criteria criteria = example.createCriteria();
        if (StringUtils.hasText(yonghuName))
            criteria.andYonghunameEqualTo(yonghuName);

        Pair<Boolean, Date> sd = new Pair<>(false, null);
        Pair<Boolean, Date> ed = new Pair<>(false, null);
        if (StringUtils.hasText(sdate)) {
            sd = DateUtil.tryParse(sdate, dateFormat);
        }
        if (StringUtils.hasText(edate)) {
            ed = DateUtil.tryParse(edate, dateFormat);
        }
        if (sd.getValue0() && ed.getValue0()) criteria.andYonghudateBetween(sd.getValue1(), ed.getValue1());
        if (sd.getValue0() && !ed.getValue0()) criteria.andYonghudateGreaterThanOrEqualTo(sd.getValue1());
        if (!sd.getValue0() && ed.getValue0()) criteria.andYonghudateLessThanOrEqualTo(ed.getValue1());

        if (rows == 0) return yongHuPojoMapper.selectByExample(example);
        RowBounds rb = new RowBounds(page * rows, rows);
        return yongHuPojoMapper.selectByExampleWithRowbounds(example, rb);
    }

    public YongHuPojo getYonghu(int parseInt) {
        // TODO Auto-generated method stub
        return yongHuPojoMapper.selectByPrimaryKey(parseInt);
    }

    public void modifyYonghu(YongHuPojo yonghu) {
        // TODO Auto-generated method stub
        yongHuPojoMapper.updateByPrimaryKey(yonghu);
    }

    public void deleteYonghu(Integer id) {
        // TODO Auto-generated method stub
        yongHuPojoMapper.deleteByPrimaryKey(id);

    }

    public void save(YongHuPojo yonghu) {
        // TODO Auto-generated method stub
        yongHuPojoMapper.insertSelective(yonghu);

    }
}
