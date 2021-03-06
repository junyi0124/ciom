package edu.thn.ciom.dao;

import edu.thn.ciom.pojo.AdminPojo;
import edu.thn.ciom.pojo.AdminPojoExample;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

public interface AdminPojoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    long countByExample(AdminPojoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    int deleteByExample(AdminPojoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    @Delete({
            "delete from t_admin",
            "where adminId = #{adminid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer adminid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    @Insert({
            "insert into t_admin (adminName, adminPassword)",
            "values (#{adminname,jdbcType=VARCHAR}, #{adminpassword,jdbcType=VARCHAR})"
    })
    @SelectKey(statement = "CALL IDENTITY()", keyProperty = "adminid", before = false, resultType = Integer.class)
    int insert(AdminPojo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    int insertSelective(AdminPojo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    List<AdminPojo> selectByExampleWithRowbounds(AdminPojoExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    List<AdminPojo> selectByExample(AdminPojoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    @Select({
            "select",
            "adminId, adminName, adminPassword",
            "from t_admin",
            "where adminId = #{adminid,jdbcType=INTEGER}"
    })
    @ResultMap("edu.thn.ciom.dao.AdminPojoMapper.BaseResultMap")
    AdminPojo selectByPrimaryKey(Integer adminid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    int updateByExampleSelective(@Param("record") AdminPojo record, @Param("example") AdminPojoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    int updateByExample(@Param("record") AdminPojo record, @Param("example") AdminPojoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    int updateByPrimaryKeySelective(AdminPojo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    @Update({
            "update t_admin",
            "set adminName = #{adminname,jdbcType=VARCHAR},",
            "adminPassword = #{adminpassword,jdbcType=VARCHAR}",
            "where adminId = #{adminid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AdminPojo record);
}