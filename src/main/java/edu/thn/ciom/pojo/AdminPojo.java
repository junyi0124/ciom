package edu.thn.ciom.pojo;

import java.io.Serializable;

public class AdminPojo implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin.adminId
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    private Integer adminid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin.adminName
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    private String adminname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin.adminPassword
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    private String adminpassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_admin
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin.adminId
     *
     * @return the value of t_admin.adminId
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    public Integer getAdminid() {
        return adminid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    public AdminPojo withAdminid(Integer adminid) {
        this.setAdminid(adminid);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin.adminId
     *
     * @param adminid the value for t_admin.adminId
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin.adminName
     *
     * @return the value of t_admin.adminName
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    public String getAdminname() {
        return adminname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    public AdminPojo withAdminname(String adminname) {
        this.setAdminname(adminname);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin.adminName
     *
     * @param adminname the value for t_admin.adminName
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    public void setAdminname(String adminname) {
        this.adminname = adminname == null ? null : adminname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin.adminPassword
     *
     * @return the value of t_admin.adminPassword
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    public String getAdminpassword() {
        return adminpassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    public AdminPojo withAdminpassword(String adminpassword) {
        this.setAdminpassword(adminpassword);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin.adminPassword
     *
     * @param adminpassword the value for t_admin.adminPassword
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword == null ? null : adminpassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminid=").append(adminid);
        sb.append(", adminname=").append(adminname);
        sb.append(", adminpassword=").append(adminpassword);
        sb.append("]");
        return sb.toString();
    }
}