package edu.thn.ciom.dao;

import edu.thn.ciom.pojo.BuzhiPojo;
import edu.thn.ciom.pojo.BuzhiPojoExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

public interface BuzhiPojoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_buzhi
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    long countByExample(BuzhiPojoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_buzhi
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    int deleteByExample(BuzhiPojoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_buzhi
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    @Delete({
        "delete from t_buzhi",
        "where buzhiId = #{buzhiid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer buzhiid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_buzhi
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    @Insert({
        "insert into t_buzhi (buzhiName, buzhiMark, ",
        "buzhiMark1, buzhiMark2, ",
        "buzhiType, buzhiType1, ",
        "buzhiType2, buzhiDouble, ",
        "buzhiDouble1, buzhiDouble2, ",
        "buyuanId, buyuanName, ",
        "bumenId, bumenName)",
        "values (#{buzhiname,jdbcType=VARCHAR}, #{buzhimark,jdbcType=VARCHAR}, ",
        "#{buzhimark1,jdbcType=VARCHAR}, #{buzhimark2,jdbcType=VARCHAR}, ",
        "#{buzhitype,jdbcType=INTEGER}, #{buzhitype1,jdbcType=INTEGER}, ",
        "#{buzhitype2,jdbcType=INTEGER}, #{buzhidouble,jdbcType=DOUBLE}, ",
        "#{buzhidouble1,jdbcType=DOUBLE}, #{buzhidouble2,jdbcType=DOUBLE}, ",
        "#{buyuanid,jdbcType=INTEGER}, #{buyuanname,jdbcType=VARCHAR}, ",
        "#{bumenid,jdbcType=INTEGER}, #{bumenname,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="CALL IDENTITY()", keyProperty="buzhiid", before=false, resultType=Integer.class)
    int insert(BuzhiPojo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_buzhi
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    int insertSelective(BuzhiPojo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_buzhi
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    List<BuzhiPojo> selectByExampleWithRowbounds(BuzhiPojoExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_buzhi
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    List<BuzhiPojo> selectByExample(BuzhiPojoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_buzhi
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    @Select({
        "select",
        "buzhiId, buzhiName, buzhiMark, buzhiMark1, buzhiMark2, buzhiType, buzhiType1, ",
        "buzhiType2, buzhiDouble, buzhiDouble1, buzhiDouble2, buyuanId, buyuanName, bumenId, ",
        "bumenName",
        "from t_buzhi",
        "where buzhiId = #{buzhiid,jdbcType=INTEGER}"
    })
    @ResultMap("edu.thn.ciom.dao.BuzhiPojoMapper.BaseResultMap")
    BuzhiPojo selectByPrimaryKey(Integer buzhiid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_buzhi
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    int updateByExampleSelective(@Param("record") BuzhiPojo record, @Param("example") BuzhiPojoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_buzhi
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    int updateByExample(@Param("record") BuzhiPojo record, @Param("example") BuzhiPojoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_buzhi
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    int updateByPrimaryKeySelective(BuzhiPojo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_buzhi
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    @Update({
        "update t_buzhi",
        "set buzhiName = #{buzhiname,jdbcType=VARCHAR},",
          "buzhiMark = #{buzhimark,jdbcType=VARCHAR},",
          "buzhiMark1 = #{buzhimark1,jdbcType=VARCHAR},",
          "buzhiMark2 = #{buzhimark2,jdbcType=VARCHAR},",
          "buzhiType = #{buzhitype,jdbcType=INTEGER},",
          "buzhiType1 = #{buzhitype1,jdbcType=INTEGER},",
          "buzhiType2 = #{buzhitype2,jdbcType=INTEGER},",
          "buzhiDouble = #{buzhidouble,jdbcType=DOUBLE},",
          "buzhiDouble1 = #{buzhidouble1,jdbcType=DOUBLE},",
          "buzhiDouble2 = #{buzhidouble2,jdbcType=DOUBLE},",
          "buyuanId = #{buyuanid,jdbcType=INTEGER},",
          "buyuanName = #{buyuanname,jdbcType=VARCHAR},",
          "bumenId = #{bumenid,jdbcType=INTEGER},",
          "bumenName = #{bumenname,jdbcType=VARCHAR}",
        "where buzhiId = #{buzhiid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BuzhiPojo record);
}