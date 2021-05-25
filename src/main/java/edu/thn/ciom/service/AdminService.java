package edu.thn.ciom.service;

import edu.thn.ciom.dao.AdminPojoMapper;
import edu.thn.ciom.pojo.AdminPojo;
import edu.thn.ciom.pojo.AdminPojoExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminPojoMapper adminPojoMapper;

    public List queryAdmins(AdminPojo record, int page, int rows) {
        // TODO Auto-generated method stub
        AdminPojoExample example = new AdminPojoExample();
        AdminPojoExample.Criteria criteria = example.createCriteria();
        if(StringUtils.hasText(record.getAdminname()))
            criteria.andAdminnameLike(record.getAdminname());
        if(StringUtils.hasText(record.getAdminpassword()))
            criteria.andAdminpasswordLike(record.getAdminpassword());
        RowBounds rb = new RowBounds(page * rows, rows);

        return adminPojoMapper.selectByExampleWithRowbounds(example, rb);
    }

    public AdminPojo getAdmin(int parseInt) {
        // TODO Auto-generated method stub
        return adminPojoMapper.selectByPrimaryKey(parseInt);
    }

    public void modifyAdmin(AdminPojo admin) {
        // TODO Auto-generated method stub
        adminPojoMapper.updateByPrimaryKey(admin);
    }

    public void deleteAdmin(Integer id) {
        // TODO Auto-generated method stub
        adminPojoMapper.deleteByPrimaryKey(id);

    }

    public void save(AdminPojo admin) {
        // TODO Auto-generated method stub
        adminPojoMapper.insert(admin);
    }
}
