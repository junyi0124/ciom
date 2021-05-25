package edu.thn.ciom.service;

import edu.thn.ciom.dao.UserPojoMapper;
import edu.thn.ciom.pojo.UserPojo;
import edu.thn.ciom.pojo.UserPojoExample;
import edu.thn.ciom.util.DateUtil;
import org.apache.ibatis.session.RowBounds;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserPojoMapper userPojoMapper;
    private final String dateFormat = "yyyy-MM-dd hh:mm:ss";
    public List queryUsers(UserPojo record, String userName, int page, int rows,
                           String sdate, String edate, String sdate1, String edate1) {
        // TODO Auto-generated method stub

        UserPojoExample example = new UserPojoExample();
        UserPojoExample.Criteria criteria = example.createCriteria();
        if (StringUtils.hasText(userName))
            criteria.andUsernameLike(userName);

        Pair<Boolean, Date> sd = new Pair<>(false, null);
        Pair<Boolean, Date> ed = new Pair<>(false, null);
        if (StringUtils.hasText(sdate)) {
            sd = DateUtil.tryParse(sdate, dateFormat);
        }
        if (StringUtils.hasText(edate)) {
            ed = DateUtil.tryParse(edate, dateFormat);
        }
        if(sd.getValue0() && ed.getValue0()) criteria.andUserdateBetween(sd.getValue1(), ed.getValue1());
        if(sd.getValue0() && !ed.getValue0()) criteria.andUserdateGreaterThanOrEqualTo(sd.getValue1());
        if(!sd.getValue0() && ed.getValue0()) criteria.andUserdateLessThanOrEqualTo(ed.getValue1());

        if (rows == 0) return userPojoMapper.selectByExample(example);
        RowBounds rb = new RowBounds(page * rows, rows);
        return userPojoMapper.selectByExampleWithRowbounds(example, rb);
    }

    public UserPojo getUser(int parseInt) {
        // TODO Auto-generated method stub
        return userPojoMapper.selectByPrimaryKey(parseInt);
    }

    public void modifyUser(UserPojo user) {
        // TODO Auto-generated method stub
        userPojoMapper.updateByPrimaryKeySelective(user);
    }

    public void deleteUser(Integer id) {
        // TODO Auto-generated method stub
        userPojoMapper.deleteByPrimaryKey(id);

    }

    public void save(UserPojo user) {
        // TODO Auto-generated method stub
        userPojoMapper.insertSelective(user);

    }
}
