package edu.thn.ciom.dao;

import edu.thn.ciom.pojo.ShujuPojo;
import edu.thn.ciom.pojo.ShujuPojoExample;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

public interface ShujuPojoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shuju
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    long countByExample(ShujuPojoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shuju
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    int deleteByExample(ShujuPojoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shuju
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    @Delete({
            "delete from t_shuju",
            "where shujuId = #{shujuid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer shujuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shuju
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    @Insert({
            "insert into t_shuju (shujuName, shujuMark, ",
            "shujuMark1, shujuMark2, ",
            "shujuMark3, shujuDate, ",
            "shujuDate1, shujuZong, ",
            "shujuZong1, shujuZong2, ",
            "shujuDouble, shujuDouble1, ",
            "shujuDouble2, shujuDouble3, ",
            "shujuDouble4, shujuType, ",
            "shujuType1, shujuType2, ",
            "shujuImg, shujuImgName, ",
            "sjleixingId, sjleixingName, ",
            "sjxingtaiId, sjxingtaiName, ",
            "userId, userName, ",
            "bumenId, bumenName, ",
            "buyuanId, buyuanName, ",
            "yonghuId, yonghuName, ",
            "byumenId, byumenName, ",
            "byuyuanId, byuyuanName, ",
            "buzhiId, buzhiName, ",
            "roleId, roleName, ",
            "byuzhiId, byuzhiName, ",
            "yhroleId, yhroleName)",
            "values (#{shujuname,jdbcType=VARCHAR}, #{shujumark,jdbcType=VARCHAR}, ",
            "#{shujumark1,jdbcType=VARCHAR}, #{shujumark2,jdbcType=VARCHAR}, ",
            "#{shujumark3,jdbcType=VARCHAR}, #{shujudate,jdbcType=TIMESTAMP}, ",
            "#{shujudate1,jdbcType=TIMESTAMP}, #{shujuzong,jdbcType=INTEGER}, ",
            "#{shujuzong1,jdbcType=INTEGER}, #{shujuzong2,jdbcType=INTEGER}, ",
            "#{shujudouble,jdbcType=DOUBLE}, #{shujudouble1,jdbcType=DOUBLE}, ",
            "#{shujudouble2,jdbcType=DOUBLE}, #{shujudouble3,jdbcType=DOUBLE}, ",
            "#{shujudouble4,jdbcType=DOUBLE}, #{shujutype,jdbcType=INTEGER}, ",
            "#{shujutype1,jdbcType=INTEGER}, #{shujutype2,jdbcType=INTEGER}, ",
            "#{shujuimg,jdbcType=VARCHAR}, #{shujuimgname,jdbcType=VARCHAR}, ",
            "#{sjleixingid,jdbcType=INTEGER}, #{sjleixingname,jdbcType=VARCHAR}, ",
            "#{sjxingtaiid,jdbcType=INTEGER}, #{sjxingtainame,jdbcType=VARCHAR}, ",
            "#{userid,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
            "#{bumenid,jdbcType=INTEGER}, #{bumenname,jdbcType=VARCHAR}, ",
            "#{buyuanid,jdbcType=INTEGER}, #{buyuanname,jdbcType=VARCHAR}, ",
            "#{yonghuid,jdbcType=INTEGER}, #{yonghuname,jdbcType=VARCHAR}, ",
            "#{byumenid,jdbcType=INTEGER}, #{byumenname,jdbcType=VARCHAR}, ",
            "#{byuyuanid,jdbcType=INTEGER}, #{byuyuanname,jdbcType=VARCHAR}, ",
            "#{buzhiid,jdbcType=INTEGER}, #{buzhiname,jdbcType=VARCHAR}, ",
            "#{roleid,jdbcType=INTEGER}, #{rolename,jdbcType=VARCHAR}, ",
            "#{byuzhiid,jdbcType=INTEGER}, #{byuzhiname,jdbcType=VARCHAR}, ",
            "#{yhroleid,jdbcType=INTEGER}, #{yhrolename,jdbcType=VARCHAR})"
    })
    @SelectKey(statement = "CALL IDENTITY()", keyProperty = "shujuid", before = false, resultType = Integer.class)
    int insert(ShujuPojo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shuju
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    int insertSelective(ShujuPojo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shuju
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    List<ShujuPojo> selectByExampleWithRowbounds(ShujuPojoExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shuju
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    List<ShujuPojo> selectByExample(ShujuPojoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shuju
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    @Select({
            "select",
            "shujuId, shujuName, shujuMark, shujuMark1, shujuMark2, shujuMark3, shujuDate, ",
            "shujuDate1, shujuZong, shujuZong1, shujuZong2, shujuDouble, shujuDouble1, shujuDouble2, ",
            "shujuDouble3, shujuDouble4, shujuType, shujuType1, shujuType2, shujuImg, shujuImgName, ",
            "sjleixingId, sjleixingName, sjxingtaiId, sjxingtaiName, userId, userName, bumenId, ",
            "bumenName, buyuanId, buyuanName, yonghuId, yonghuName, byumenId, byumenName, ",
            "byuyuanId, byuyuanName, buzhiId, buzhiName, roleId, roleName, byuzhiId, byuzhiName, ",
            "yhroleId, yhroleName",
            "from t_shuju",
            "where shujuId = #{shujuid,jdbcType=INTEGER}"
    })
    @ResultMap("edu.thn.ciom.dao.ShujuPojoMapper.BaseResultMap")
    ShujuPojo selectByPrimaryKey(Integer shujuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shuju
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    int updateByExampleSelective(@Param("record") ShujuPojo record, @Param("example") ShujuPojoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shuju
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    int updateByExample(@Param("record") ShujuPojo record, @Param("example") ShujuPojoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shuju
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    int updateByPrimaryKeySelective(ShujuPojo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shuju
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    @Update({
            "update t_shuju",
            "set shujuName = #{shujuname,jdbcType=VARCHAR},",
            "shujuMark = #{shujumark,jdbcType=VARCHAR},",
            "shujuMark1 = #{shujumark1,jdbcType=VARCHAR},",
            "shujuMark2 = #{shujumark2,jdbcType=VARCHAR},",
            "shujuMark3 = #{shujumark3,jdbcType=VARCHAR},",
            "shujuDate = #{shujudate,jdbcType=TIMESTAMP},",
            "shujuDate1 = #{shujudate1,jdbcType=TIMESTAMP},",
            "shujuZong = #{shujuzong,jdbcType=INTEGER},",
            "shujuZong1 = #{shujuzong1,jdbcType=INTEGER},",
            "shujuZong2 = #{shujuzong2,jdbcType=INTEGER},",
            "shujuDouble = #{shujudouble,jdbcType=DOUBLE},",
            "shujuDouble1 = #{shujudouble1,jdbcType=DOUBLE},",
            "shujuDouble2 = #{shujudouble2,jdbcType=DOUBLE},",
            "shujuDouble3 = #{shujudouble3,jdbcType=DOUBLE},",
            "shujuDouble4 = #{shujudouble4,jdbcType=DOUBLE},",
            "shujuType = #{shujutype,jdbcType=INTEGER},",
            "shujuType1 = #{shujutype1,jdbcType=INTEGER},",
            "shujuType2 = #{shujutype2,jdbcType=INTEGER},",
            "shujuImg = #{shujuimg,jdbcType=VARCHAR},",
            "shujuImgName = #{shujuimgname,jdbcType=VARCHAR},",
            "sjleixingId = #{sjleixingid,jdbcType=INTEGER},",
            "sjleixingName = #{sjleixingname,jdbcType=VARCHAR},",
            "sjxingtaiId = #{sjxingtaiid,jdbcType=INTEGER},",
            "sjxingtaiName = #{sjxingtainame,jdbcType=VARCHAR},",
            "userId = #{userid,jdbcType=INTEGER},",
            "userName = #{username,jdbcType=VARCHAR},",
            "bumenId = #{bumenid,jdbcType=INTEGER},",
            "bumenName = #{bumenname,jdbcType=VARCHAR},",
            "buyuanId = #{buyuanid,jdbcType=INTEGER},",
            "buyuanName = #{buyuanname,jdbcType=VARCHAR},",
            "yonghuId = #{yonghuid,jdbcType=INTEGER},",
            "yonghuName = #{yonghuname,jdbcType=VARCHAR},",
            "byumenId = #{byumenid,jdbcType=INTEGER},",
            "byumenName = #{byumenname,jdbcType=VARCHAR},",
            "byuyuanId = #{byuyuanid,jdbcType=INTEGER},",
            "byuyuanName = #{byuyuanname,jdbcType=VARCHAR},",
            "buzhiId = #{buzhiid,jdbcType=INTEGER},",
            "buzhiName = #{buzhiname,jdbcType=VARCHAR},",
            "roleId = #{roleid,jdbcType=INTEGER},",
            "roleName = #{rolename,jdbcType=VARCHAR},",
            "byuzhiId = #{byuzhiid,jdbcType=INTEGER},",
            "byuzhiName = #{byuzhiname,jdbcType=VARCHAR},",
            "yhroleId = #{yhroleid,jdbcType=INTEGER},",
            "yhroleName = #{yhrolename,jdbcType=VARCHAR}",
            "where shujuId = #{shujuid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ShujuPojo record);
}