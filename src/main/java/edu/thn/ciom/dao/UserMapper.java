package edu.thn.ciom.dao;

import edu.thn.ciom.pojo.UserPojo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO `srm`.`t_user` " +
            "(`userName`, `userPassword`, `userXingming`, `userSex`, `userAge`, " +
            "`userMinzu`, `userPhone`, `userMark1`, 'userDate', `buzhiId`, `buzhiName`) " +
            "VALUES (#{userName}, #{userPassword}, '#{userXingming}, #{userSex}, #{userAge}, " +
            "#{userMinzu}, '#{userPhone}, #{userMark1}, #{userDate}, #{buzhiId}, #{buzhiName})")
    @Options(useGeneratedKeys = true)
    int add(UserPojo user);


    @Select("SELECT `userId`, `userName`, `userPassword`, `userXingming`, `userSex`, `userAge`, " +
            "`userMinzu`, `userPhone`, `userMark1`, 'userDate', `buzhiId`, `buzhiName` FROM `srm`.`t_user` WHERE `userId`=2;")
    @Results({
            @Result(id = true, column = "userId", property = "userId"),
            //@Result(column = "userDate", property = "userDate", jdbcType = JdbcType.DATE),
            // map-underscore-to-camel-case = true 可以实现一样的效果
            // @Result(column = "update_time", property = "updateTime"),
    })
    UserPojo findById(@Param("userId") Integer id);
}
