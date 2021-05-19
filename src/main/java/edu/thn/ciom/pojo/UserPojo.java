package edu.thn.ciom.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPojo {

    //`userName`, `userPassword`, `userXingming`, `userSex`, `userAge`, " +
    //            "`userMinzu`, `userPhone`, `userMark1`, 'userDate', `buzhiId`, `buzhiName`
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userXingming;
    private Integer userSex;
    private Integer userAge;
    private String userMinzu;
    private String userPhone;
    private String userMark1;
    private Date userDate;
    private Integer buzhiId;
    private String buzhiName;
}
