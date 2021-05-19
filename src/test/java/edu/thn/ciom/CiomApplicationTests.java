package edu.thn.ciom;

import edu.thn.ciom.dao.UserMapper;
import edu.thn.ciom.pojo.UserPojo;
import org.apache.catalina.filters.ExpiresFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CiomApplicationTests {

	private UserMapper _userMapper;

	@Autowired
	CiomApplicationTests(UserMapper userMapper) {
		this._userMapper = userMapper;
	}

	@Test
	void contextLoads() {
		UserPojo byId = _userMapper.findById(1);
		System.out.print(byId.getUserName());
	}




}
