package edu.thn.ciom.controller;

import edu.thn.ciom.pojo.UserPojo;
import edu.thn.ciom.service.UserService;
import edu.thn.ciom.util.DateUtil;
import edu.thn.ciom.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUsers")
    public void getUsers(HttpServletRequest request,
                         HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String page = (String) request.getParameter("page");
        String rows = (String) request.getParameter("rows");
        String userName = (String) request.getParameter("userName");
        String userXingming = (String) request.getParameter("userXingming");
        String userId = (String) request.getParameter("userId");
        String userMinzu = (String) request.getParameter("userMinzu");
        String userType = (String) request.getParameter("userType");
        String userType1 = (String) request.getParameter("userType1");
        String userType2 = (String) request.getParameter("userType2");
        String roleId = (String) request.getParameter("roleId");
        String bumenId = (String) request.getParameter("bumenId");
        String buyuanId = (String) request.getParameter("buyuanId");
        String buzhiId = (String) request.getParameter("buzhiId");
        String userSex = (String) request.getParameter("userSex");
        String sdate = (String) request.getParameter("sdate");
        String edate = (String) request.getParameter("edate");
        String sdate1 = (String) request.getParameter("sdate1");
        String edate1 = (String) request.getParameter("edate1");
        UserPojo user = new UserPojo();
        PageBean pageBean = null;
        if ((StringUtils.hasText(page))&&(!page.equals("null"))) {
            pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        }else{
            pageBean = new PageBean(0,0);
        }
        try {

            if (StringUtils.hasText(userXingming)) {
                user.setUserxingming(userXingming);
            }
            if (StringUtils.hasText(userName)) {
                user.setUsername(userName);
            }
            if (StringUtils.hasText(userId)) {
                user.setUserid(Integer.parseInt(userId));
            }
            if (StringUtils.hasText(buyuanId)) {
                user.setBuyuanid(Integer.parseInt(buyuanId));
            }
            if (StringUtils.hasText(buzhiId)) {
                user.setBuzhiid(Integer.parseInt(buzhiId));
            }
            if (StringUtils.hasText(userMinzu)) {
                user.setUserminzu(userMinzu);
            }
            if (StringUtils.hasText(userType)) {
                user.setUsertype(Integer.parseInt(userType));
            }
            if (StringUtils.hasText(userType1)) {
                user.setUsertype1(Integer.parseInt(userType1));
            }
            if (StringUtils.hasText(userType2)) {
                user.setUsertype2(Integer.parseInt(userType2));
            }
            if (StringUtils.hasText(roleId)) {
                user.setRoleid(Integer.parseInt(roleId));
            }
            if (StringUtils.hasText(bumenId)) {
                user.setBumenid(Integer.parseInt(bumenId));
            }
            if (StringUtils.hasText(userSex)) {
                user.setUsersex(Integer.parseInt(userSex));
            }
            if (StringUtils.hasText(sdate1)) {
                Date date = new Date();
                sdate1 = DateUtil.formatDate(date, "yyyy-MM-dd HH:mm:ss");
            }
            if (StringUtils.hasText(edate1)) {
                Date date = new Date();
                edate1 = DateUtil.formatDate(date, "yyyy-MM-dd HH:mm:ss");
            }
            JSONArray jsonArray = JSONArray.fromObject(userService.queryUsers(
                    user,null, pageBean.getStart(), pageBean.getRows(), sdate, edate, sdate1, edate1));
            JSONObject result = new JSONObject();
            int total = userService.queryUsers(user,null, 0,0, sdate, edate, sdate1, edate1).size();
            result.put("rows", jsonArray);
            result.put("total", total);
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
