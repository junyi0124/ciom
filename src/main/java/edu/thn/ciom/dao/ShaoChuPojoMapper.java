package edu.thn.ciom.dao;

import edu.thn.ciom.pojo.ShaoChuPojo;
import edu.thn.ciom.pojo.ShaoChuPojoExample;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

public interface ShaoChuPojoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sjshaochu
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    long countByExample(ShaoChuPojoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sjshaochu
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    int deleteByExample(ShaoChuPojoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sjshaochu
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    @Delete({
            "delete from t_sjshaochu",
            "where sjshaochuId = #{sjshaochuid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer sjshaochuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sjshaochu
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    @Insert({
            "insert into t_sjshaochu (sjshaochuName, sjshaochuMark, ",
            "sjshaochuMark1, sjshaochuMark2, ",
            "sjshaochuMark3, sjshaochuDate, ",
            "sjshaochuDate1, sjshaochuZong, ",
            "sjshaochuZong1, sjshaochuZong2, ",
            "sjshaochuDouble, sjshaochuDouble1, ",
            "sjshaochuDouble2, sjshaochuType, ",
            "sjshaochuType1, sjshaochuType2, ",
            "sjqitaId, sjqitaName, ",
            "sjlaiyuanId, sjlaiyuanName, ",
            "sjshaochuImg, sjshaochuImgName, ",
            "shujuId, shujuName, ",
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
            "values (#{sjshaochuname,jdbcType=VARCHAR}, #{sjshaochumark,jdbcType=VARCHAR}, ",
            "#{sjshaochumark1,jdbcType=VARCHAR}, #{sjshaochumark2,jdbcType=VARCHAR}, ",
            "#{sjshaochumark3,jdbcType=VARCHAR}, #{sjshaochudate,jdbcType=TIMESTAMP}, ",
            "#{sjshaochudate1,jdbcType=TIMESTAMP}, #{sjshaochuzong,jdbcType=INTEGER}, ",
            "#{sjshaochuzong1,jdbcType=INTEGER}, #{sjshaochuzong2,jdbcType=INTEGER}, ",
            "#{sjshaochudouble,jdbcType=DOUBLE}, #{sjshaochudouble1,jdbcType=DOUBLE}, ",
            "#{sjshaochudouble2,jdbcType=DOUBLE}, #{sjshaochutype,jdbcType=INTEGER}, ",
            "#{sjshaochutype1,jdbcType=INTEGER}, #{sjshaochutype2,jdbcType=INTEGER}, ",
            "#{sjqitaid,jdbcType=INTEGER}, #{sjqitaname,jdbcType=VARCHAR}, ",
            "#{sjlaiyuanid,jdbcType=INTEGER}, #{sjlaiyuanname,jdbcType=VARCHAR}, ",
            "#{sjshaochuimg,jdbcType=VARCHAR}, #{sjshaochuimgname,jdbcType=VARCHAR}, ",
            "#{shujuid,jdbcType=INTEGER}, #{shujuname,jdbcType=VARCHAR}, ",
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
    @SelectKey(statement = "CALL IDENTITY()", keyProperty = "sjshaochuid", before = false, resultType = Integer.class)
    int insert(ShaoChuPojo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sjshaochu
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    int insertSelective(ShaoChuPojo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sjshaochu
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    List<ShaoChuPojo> selectByExampleWithRowbounds(ShaoChuPojoExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sjshaochu
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    List<ShaoChuPojo> selectByExample(ShaoChuPojoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sjshaochu
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    @Select({
            "select",
            "sjshaochuId, sjshaochuName, sjshaochuMark, sjshaochuMark1, sjshaochuMark2, sjshaochuMark3, ",
            "sjshaochuDate, sjshaochuDate1, sjshaochuZong, sjshaochuZong1, sjshaochuZong2, ",
            "sjshaochuDouble, sjshaochuDouble1, sjshaochuDouble2, sjshaochuType, sjshaochuType1, ",
            "sjshaochuType2, sjqitaId, sjqitaName, sjlaiyuanId, sjlaiyuanName, sjshaochuImg, ",
            "sjshaochuImgName, shujuId, shujuName, sjleixingId, sjleixingName, sjxingtaiId, ",
            "sjxingtaiName, userId, userName, bumenId, bumenName, buyuanId, buyuanName, yonghuId, ",
            "yonghuName, byumenId, byumenName, byuyuanId, byuyuanName, buzhiId, buzhiName, ",
            "roleId, roleName, byuzhiId, byuzhiName, yhroleId, yhroleName",
            "from t_sjshaochu",
            "where sjshaochuId = #{sjshaochuid,jdbcType=INTEGER}"
    })
    @ResultMap("edu.thn.ciom.dao.ShaoChuPojoMapper.BaseResultMap")
    ShaoChuPojo selectByPrimaryKey(Integer sjshaochuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sjshaochu
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    int updateByExampleSelective(@Param("record") ShaoChuPojo record, @Param("example") ShaoChuPojoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sjshaochu
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    int updateByExample(@Param("record") ShaoChuPojo record, @Param("example") ShaoChuPojoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sjshaochu
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    int updateByPrimaryKeySelective(ShaoChuPojo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sjshaochu
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    @Update({
            "update t_sjshaochu",
            "set sjshaochuName = #{sjshaochuname,jdbcType=VARCHAR},",
            "sjshaochuMark = #{sjshaochumark,jdbcType=VARCHAR},",
            "sjshaochuMark1 = #{sjshaochumark1,jdbcType=VARCHAR},",
            "sjshaochuMark2 = #{sjshaochumark2,jdbcType=VARCHAR},",
            "sjshaochuMark3 = #{sjshaochumark3,jdbcType=VARCHAR},",
            "sjshaochuDate = #{sjshaochudate,jdbcType=TIMESTAMP},",
            "sjshaochuDate1 = #{sjshaochudate1,jdbcType=TIMESTAMP},",
            "sjshaochuZong = #{sjshaochuzong,jdbcType=INTEGER},",
            "sjshaochuZong1 = #{sjshaochuzong1,jdbcType=INTEGER},",
            "sjshaochuZong2 = #{sjshaochuzong2,jdbcType=INTEGER},",
            "sjshaochuDouble = #{sjshaochudouble,jdbcType=DOUBLE},",
            "sjshaochuDouble1 = #{sjshaochudouble1,jdbcType=DOUBLE},",
            "sjshaochuDouble2 = #{sjshaochudouble2,jdbcType=DOUBLE},",
            "sjshaochuType = #{sjshaochutype,jdbcType=INTEGER},",
            "sjshaochuType1 = #{sjshaochutype1,jdbcType=INTEGER},",
            "sjshaochuType2 = #{sjshaochutype2,jdbcType=INTEGER},",
            "sjqitaId = #{sjqitaid,jdbcType=INTEGER},",
            "sjqitaName = #{sjqitaname,jdbcType=VARCHAR},",
            "sjlaiyuanId = #{sjlaiyuanid,jdbcType=INTEGER},",
            "sjlaiyuanName = #{sjlaiyuanname,jdbcType=VARCHAR},",
            "sjshaochuImg = #{sjshaochuimg,jdbcType=VARCHAR},",
            "sjshaochuImgName = #{sjshaochuimgname,jdbcType=VARCHAR},",
            "shujuId = #{shujuid,jdbcType=INTEGER},",
            "shujuName = #{shujuname,jdbcType=VARCHAR},",
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
            "where sjshaochuId = #{sjshaochuid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ShaoChuPojo record);
}