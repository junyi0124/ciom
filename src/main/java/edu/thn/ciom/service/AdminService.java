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

    public List<AdminPojo> queryAdmins(AdminPojo record, int page, int rows) {
        AdminPojoExample example = new AdminPojoExample();
        AdminPojoExample.Criteria criteria = example.createCriteria();

        if (record != null) {
            if (StringUtils.hasText(record.getAdminname()))
                criteria.andAdminnameEqualTo(record.getAdminname());
            if (StringUtils.hasText(record.getAdminpassword()))
                criteria.andAdminpasswordEqualTo(record.getAdminpassword());
        }

        if (rows == 0) return adminPojoMapper.selectByExample(example);

        RowBounds rb = new RowBounds(page * rows, rows);
        return adminPojoMapper.selectByExampleWithRowbounds(example, rb);
    }

    public AdminPojo getAdmin(int parseInt) {
        return adminPojoMapper.selectByPrimaryKey(parseInt);
    }

    public void modifyAdmin(AdminPojo admin) {
        adminPojoMapper.updateByPrimaryKey(admin);
    }

    public void deleteAdmin(Integer id) {
        adminPojoMapper.deleteByPrimaryKey(id);
    }

    public void save(AdminPojo admin) {
        adminPojoMapper.insert(admin);
    }
}
