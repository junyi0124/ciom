package edu.thn.ciom.controller;

import edu.thn.ciom.pojo.*;
import edu.thn.ciom.service.*;
import edu.thn.ciom.util.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
// import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BuzhiService buzhiService;

    @RequestMapping("/getUsers")
    public void getUsers(HttpServletRequest request,
                         HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        String userName = request.getParameter("userName");
        String userXingming = request.getParameter("userXingming");
        String userId = request.getParameter("userId");
        String userMinzu = request.getParameter("userMinzu");
        String userType = request.getParameter("userType");
        String userType1 = request.getParameter("userType1");
        String userType2 = request.getParameter("userType2");
        String roleId = request.getParameter("roleId");
        String bumenId = request.getParameter("bumenId");
        String buyuanId = request.getParameter("buyuanId");
        String buzhiId = request.getParameter("buzhiId");
        String userSex = request.getParameter("userSex");
        String sdate = request.getParameter("sdate");
        String edate = request.getParameter("edate");
        String sdate1 = request.getParameter("sdate1");
        String edate1 = request.getParameter("edate1");
        UserPojo user = new UserPojo();
        PageBean pageBean = null;
        if ((StringUtils.hasText(page)) && (!page.equals("null"))) {
            pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        } else {
            pageBean = new PageBean(0, 0);
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
                    user, null, pageBean.getStart(), pageBean.getRows(), sdate, edate, sdate1, edate1));
            JSONObject result = new JSONObject();
            int total = userService.queryUsers(user, null, 0, 0, sdate, edate, sdate1, edate1).size();
            result.put("rows", jsonArray);
            result.put("total", total);
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/addUser")
    public void addUser(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            JSONObject result = new JSONObject();

            String userName = request.getParameter("userName");
            if(!StringUtils.hasText(userName)) userName = request.getParameter("username");
            String userPassword = request.getParameter("userPassword");
            if(!StringUtils.hasText(userPassword)) userPassword = request.getParameter("userpassword");
            String userAge = request.getParameter("userAge");
            if(!StringUtils.hasText(userAge)) userAge = request.getParameter("userage");
            String userXingming = request.getParameter("userXingming");
            if(!StringUtils.hasText(userXingming)) userXingming = request.getParameter("userxingming");
            String userSex = request.getParameter("userSex");
            if(!StringUtils.hasText(userSex)) userSex = request.getParameter("usersex");
            String userMinzu = request.getParameter("userMinzu");
            if(!StringUtils.hasText(userMinzu)) userMinzu = request.getParameter("userminzu");
            String userPhone = request.getParameter("userPhone");
            if(!StringUtils.hasText(userPhone)) userPhone = request.getParameter("userphone");
            String userMark1 = request.getParameter("userMark1");
            if(!StringUtils.hasText(userMark1)) userMark1 = request.getParameter("usermark1");
            String buzhiId = request.getParameter("buzhiId");
            if(!StringUtils.hasText(buzhiId)) buzhiId = request.getParameter("buzhiid");

            String userId = request.getParameter("userId");
            if(!StringUtils.hasText(userId)) userId = request.getParameter("userid");
//            String userMark = request.getParameter("userMark");
//            String userMark2 = request.getParameter("userMark2");
//            String userMark3 = request.getParameter("userMark3");
//            String userMark4 = request.getParameter("userMark4");
//            String userDate = request.getParameter("userDate");
//            String userDate1 = request.getParameter("userDate1");
//            String userDate2 = request.getParameter("userDate2");
//            String userType = request.getParameter("userType");
//            String userType1 = request.getParameter("userType1");
//            String userType2 = request.getParameter("userType2");
//            String userZong = request.getParameter("userZong");
//            String userZong1 = request.getParameter("userZong1");
//            String userZong2 = request.getParameter("userZong2");
//            String userDouble = request.getParameter("userDouble");
//            String userDouble1 = request.getParameter("userDouble1");
//            String userDouble2 = request.getParameter("userDouble2");
//            String roleId = request.getParameter("roleId");
//            String bumenId = request.getParameter("bumenId");
//            String buyuanId = request.getParameter("buyuanId");

            UserPojo user = new UserPojo();

            if (StringUtils.hasText(userId)) {
                user = userService.getUser(Integer.parseInt(userId));
            }
            if (StringUtils.hasText(userName)) {
                user.setUsername(userName);
            }
            if (StringUtils.hasText(userPassword)) {
                user.setUserpassword(userPassword);
            }
            if (StringUtils.hasText(userAge)) {
                user.setUserage(Integer.parseInt(userAge));
            }
            if (StringUtils.hasText(userXingming)) {
                user.setUserxingming(userXingming);
            }
            if (StringUtils.hasText(userSex)) {
                user.setUsersex(Integer.parseInt(userSex));
            }
            if (StringUtils.hasText(userMinzu)) {
                user.setUserminzu(userMinzu);
            }
            if (StringUtils.hasText(userPhone)) {
                user.setUserphone(userPhone);
            }
//            if (StringUtils.hasText(userMark)) {
//                user.setUserMark(userMark);
//            }
            if (StringUtils.hasText(userMark1)) {
                user.setUsermark1(userMark1);
            }
//            if (StringUtils.hasText(userMark2)) {
//                user.setUserMark2(userMark2);
//            }
//            if (StringUtils.hasText(userMark3)) {
//                user.setUserMark3(userMark3);
//            }
//            if (StringUtils.hasText(userMark4)) {
//                user.setUserMark4(userMark4);
//            }
//            if (StringUtils.hasText(userDate)) {
//                user.setUserDate(DateUtil.formatString(userDate,
//                        "yyyy-MM-dd hh:mm:ss"));
//            }
//            if (StringUtils.hasText(userDate1)) {
//                user.setUserDate1(DateUtil.formatString(userDate1,
//                        "yyyy-MM-dd hh:mm:ss"));
//            }
//            if (StringUtils.hasText(userDate2)) {
//                user.setUserDate2(DateUtil.formatString(userDate2,
//                        "yyyy-MM-dd hh:mm:ss"));
//            }
//            if (StringUtils.hasText(userType)) {
//                user.setUserType(Integer.parseInt(userType));
//            }
//            if (StringUtils.hasText(userType1)) {
//                user.setUserType1(Integer.parseInt(userType1));
//            }
//            if (StringUtils.hasText(userType2)) {
//                user.setUserType2(Integer.parseInt(userType2));
//            }
//            if (StringUtils.hasText(userZong)) {
//                user.setUserZong(Integer.parseInt(userZong));
//            }
//            if (StringUtils.hasText(userZong1)) {
//                user.setUserZong1(Integer.parseInt(userZong1));
//            }
//            if (StringUtils.hasText(userZong2)) {
//                user.setUserZong2(Integer.parseInt(userZong2));
//            }
//            if (StringUtils.hasText(userDouble)) {
//                user.setUserDouble(Double.parseDouble(userDouble));
//            }
//            if (StringUtils.hasText(userDouble1)) {
//                user.setUserDouble1(Double.parseDouble(userDouble1));
//            }
//            if (StringUtils.hasText(userDouble2)) {
//                user.setUserDouble2(Double.parseDouble(userDouble2));
//            }
//            if (StringUtils.hasText(roleId)) {
//                user.setRoleId(Integer.parseInt(roleId));
//                Role role = new Role();
//                role = roleService.getRole(Integer.parseInt(roleId));
//                user.setRoleName(role.getRoleName());
//            }
            if (StringUtils.hasText(buzhiId)) {
                BuzhiPojo buzhi = buzhiService.getBuzhi(Integer.parseInt(buzhiId));
                user.setBuzhiid(buzhi.getBuzhiid());
                user.setBuzhiname(buzhi.getBuzhiname());
//                user.setBumenId(buzhi.getBumenId());
//                user.setBumenName(buzhi.getBumenName());
//                user.setBuyuanId(buzhi.getBuyuanId());
//                user.setBuyuanName(buzhi.getBuyuanName());
            }
//            if (StringUtils.hasText(bumenId)) {
//                user.setBumenId(Integer.parseInt(bumenId));
//                Bumen bumen = new Bumen();
//                bumen = bumenService.getBumen(Integer.parseInt(bumenId));
//                user.setBumenName(bumen.getBumenName());
//                user.setBuyuanId(bumen.getBuyuanId());
//                user.setBuyuanName(bumen.getBuyuanName());
//            }
//            if (StringUtils.hasText(buyuanId)) {
//                user.setBuyuanId(Integer.parseInt(buyuanId));
//                Buyuan buyuan = new Buyuan();
//                buyuan = buyuanService.getBuyuan(Integer.parseInt(buyuanId));
//                user.setBuyuanName(buyuan.getBuyuanName());
//            }
            if (StringUtils.hasText(userId)) {
                userService.modifyUser(user);
                result.put("success", "true");
                ResponseUtil.write(response, result);
            } else {
                int total = userService.queryUsers(null, userName, 0, 0, null, null, null, null).size();
                if (total == 0) {
                    Date date = new Date();
                    user.setUserdate(date);
                    user.setUsertype(0);
                    userService.save(user);
                    result.put("success", "true");
                    ResponseUtil.write(response, result);
                } else {
                    result.put("success", "true");
                    result.put("errorMsg", "用户名重复！");
                    ResponseUtil.write(response, result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/mimaUser")
    public void mimaUser(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String userId = request.getParameter("userId");
        String userPassword = request.getParameter("userPassword");
        String userPassword1 = request.getParameter("userPassword1");
        UserPojo user = new UserPojo();
        try {
            user = userService.getUser(Integer.parseInt(userId));
            if (!user.getUserpassword().equals(userPassword)) {
                request.setAttribute("error", "原密码错误，请重新输入！");
                request.getRequestDispatcher("user/usermima.jsp").forward(request,
                        response);
            } else {
                user.setUserpassword(userPassword1);
                userService.modifyUser(user);
                request.setAttribute("error", "密码修改成功！");
                request.getRequestDispatcher("user/usermima.jsp").forward(request,
                        response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/zhaohuiUser")
    public void zhaohuiUser(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            String userName = request.getParameter("userName");
            String userPhone = request.getParameter("userPhone");
            UserPojo user = new UserPojo();

            if (StringUtils.hasText(userName)) {
                user.setUsername(userName);
            }
            List<UserPojo> users = userService.queryUsers(user, null, 0, 0, null, null, null, null);
            if (users.size() == 0) {
                request.setAttribute("error", "无此用户名请重新找回！");
                request.getRequestDispatcher("user/zhaohuiuser").forward(request, response);
            } else {
                user = users.get(0);
                if (user.getUserphone().equals(userPhone)) {
                    String userPassword = user.getUserpassword();
                    request.setAttribute("error", "密码是：" + userPassword);
                    request.getRequestDispatcher("user/zhaohuiuser").forward(request, response);
                } else {
                    request.setAttribute("error", "用户名和电话不匹配，请重新找回！");
                    request.getRequestDispatcher("user/zhaohuiuser").forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "系统错误联系管理员！");
            request.getRequestDispatcher("user/zhaohuiuser").forward(request, response);
        }
    }

//    userName: 111111
//    userPassword: 111111
//    userPassword1: 111111
//    userXingming: 111111
//    userAge: 11
//    userSex: 0
//    userPhone: 13111111111
//    userMark1: 11111
//    buzhiId: 1
    @RequestMapping("/zhuceUser")
    public void zhuceUser(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {

            String userName = request.getParameter("userName");
            String userPassword = request.getParameter("userPassword");
            String userXingming = request.getParameter("userXingming");
            String userAge = request.getParameter("userAge");
            String userSex = request.getParameter("userSex");
            String userPhone = request.getParameter("userPhone");
//            String userMinzu = request.getParameter("userMinzu");
//            String userMark = request.getParameter("userMark");
            String userMark1 = request.getParameter("userMark1");
//            String userMark2 = request.getParameter("userMark2");
//            String userMark3 = request.getParameter("userMark3");
//            String userMark4 = request.getParameter("userMark4");
//            String userDate = request.getParameter("userDate");
//            String userDate1 = request.getParameter("userDate1");
//            String userDate2 = request.getParameter("userDate2");
//            String userType = request.getParameter("userType");
//            String userType1 = request.getParameter("userType1");
//            String userType2 = request.getParameter("userType2");
//            String userZong = request.getParameter("userZong");
//            String userZong1 = request.getParameter("userZong1");
//            String userZong2 = request.getParameter("userZong2");
//            String userDouble = request.getParameter("userDouble");
//            String userDouble1 = request.getParameter("userDouble1");
//            String userDouble2 = request.getParameter("userDouble2");
//            String roleId = request.getParameter("roleId");
//            String bumenId = request.getParameter("bumenId");
//            String buyuanId = request.getParameter("buyuanId");
            String buzhiId = request.getParameter("buzhiId");
//            String userId = request.getParameter("userId");
            UserPojo user = new UserPojo();

//            if (StringUtils.hasText(userId)) {
//                user = userService.getUser(Integer.parseInt(userId));
//            }
            if (StringUtils.hasText(userName)) {
                user.setUsername(userName);
            }
            if (StringUtils.hasText(userPassword)) {
                user.setUserpassword(userPassword);
            }
            if (StringUtils.hasText(userAge)) {
                user.setUserage(Integer.parseInt(userAge));
            }
//            if (StringUtils.hasText(userMinzu)) {
//                user.setUserMinzu(userMinzu);
//            }
            if (StringUtils.hasText(userXingming)) {
                user.setUserxingming(userXingming);
            }
            if (StringUtils.hasText(userSex)) {
                user.setUsersex(Integer.parseInt(userSex));
            }
            if (StringUtils.hasText(userPhone)) {
                user.setUserphone(userPhone);
            }
//            if (StringUtils.hasText(userMark)) {
//                user.setUserMark(userMark);
//            }
            if (StringUtils.hasText(userMark1)) {
                user.setUsermark1(userMark1);
            }
//            if (StringUtils.hasText(userMark2)) {
//                user.setUserMark2(userMark2);
//            }
//            if (StringUtils.hasText(userMark3)) {
//                user.setUserMark3(userMark3);
//            }
//            if (StringUtils.hasText(userMark4)) {
//                user.setUserMark4(userMark4);
//            }
//            if (StringUtils.hasText(userDate)) {
//                user.setUserDate(DateUtil.formatString(userDate,
//                        "yyyy-MM-dd hh:mm:ss"));
//            }
//            if (StringUtils.hasText(userDate1)) {
//                user.setUserDate1(DateUtil.formatString(userDate1,
//                        "yyyy-MM-dd hh:mm:ss"));
//            }
//            if (StringUtils.hasText(userDate2)) {
//                user.setUserDate2(DateUtil.formatString(userDate2,
//                        "yyyy-MM-dd hh:mm:ss"));
//            }
//            if (StringUtils.hasText(userType)) {
//                user.setUserType(Integer.parseInt(userType));
//            }
//            if (StringUtils.hasText(userType1)) {
//                user.setUserType1(Integer.parseInt(userType1));
//            }
//            if (StringUtils.hasText(userType2)) {
//                user.setUserType2(Integer.parseInt(userType2));
//            }
//            if (StringUtils.hasText(userZong)) {
//                user.setUserZong(Integer.parseInt(userZong));
//            }
//            if (StringUtils.hasText(userZong1)) {
//                user.setUserZong1(Integer.parseInt(userZong1));
//            }
//            if (StringUtils.hasText(userZong2)) {
//                user.setUserZong2(Integer.parseInt(userZong2));
//            }
//            if (StringUtils.hasText(userDouble)) {
//                user.setUserDouble(Double.parseDouble(userDouble));
//            }
//            if (StringUtils.hasText(userDouble1)) {
//                user.setUserDouble1(Double.parseDouble(userDouble1));
//            }
//            if (StringUtils.hasText(userDouble2)) {
//                user.setUserDouble2(Double.parseDouble(userDouble2));
//            }
//            if (StringUtils.hasText(roleId)) {
//                user.setRoleId(Integer.parseInt(roleId));
//                Role role = new Role();
//                role = roleService.getRole(Integer.parseInt(roleId));
//                user.setRoleName(role.getRoleName());
//            }
            if (StringUtils.hasText(buzhiId)) {
                user.setBuzhiid(Integer.parseInt(buzhiId));
                BuzhiPojo buzhi = buzhiService.getBuzhi(Integer.parseInt(buzhiId));
                user.setBuzhiname(buzhi.getBuzhiname());
//                user.setBumenId(buzhi.getBumenId());
//                user.setBumenName(buzhi.getBumenName());
//                user.setBuyuanId(buzhi.getBuyuanId());
//                user.setBuyuanName(buzhi.getBuyuanName());
            }
//            if (StringUtils.hasText(bumenId)) {
//                user.setBumenId(Integer.parseInt(bumenId));
//                Bumen bumen = new Bumen();
//                bumen = bumenService.getBumen(Integer.parseInt(bumenId));
//                user.setBumenName(bumen.getBumenName());
//                user.setBuyuanId(bumen.getBuyuanId());
//                user.setBuyuanName(bumen.getBuyuanName());
//            }
//            if (StringUtils.hasText(buyuanId)) {
//                user.setBuyuanId(Integer.parseInt(buyuanId));
//                Buyuan buyuan = new Buyuan();
//                buyuan = buyuanService.getBuyuan(Integer.parseInt(buyuanId));
//                user.setBuyuanName(buyuan.getBuyuanName());
//            }
            int total = userService.queryUsers(null, userName, 0, 0, null, null, null, null).size();
            HttpSession session = request.getSession();

            if (total == 0) {
                Date date = new Date();
                user.setUserdate(date);
                user.setUsertype(0);
                userService.save(user);
                session.setAttribute("error", "注册成功，请登录！");
                response.sendRedirect("/shouye/index");
            } else {
                session.setAttribute("error", "用户名重复，请重新输入！");
                response.sendRedirect("/user/zhuceuser");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/deleteUser")
    public void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        JSONObject result = new JSONObject();
        String delIds = request.getParameter("delIds");
        try {
            String str[] = delIds.split(",");
            for (int i = 0; i < str.length; i++) {
                userService.deleteUser(Integer.parseInt(str[i]));
            }
            result.put("success", "true");
            result.put("delNums", str.length);
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/userComboList")
    public void userComboList(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String userXingming = request.getParameter("userXingming");
        String userId = request.getParameter("userId");
//        String userMinzu = request.getParameter("userMinzu");
//        String userType = request.getParameter("userType");
//        String userType1 = request.getParameter("userType1");
//        String userType2 = request.getParameter("userType2");
//        String roleId = request.getParameter("roleId");
//        String bumenId = request.getParameter("bumenId");
//        String buyuanId = request.getParameter("buyuanId");
//        String buzhiId = request.getParameter("buzhiId");
//        String userSex = request.getParameter("userSex");
        UserPojo user = new UserPojo();
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
//            if (StringUtils.hasText(buyuanId)) {
//                user.setBuyuanId(Integer.parseInt(buyuanId));
//            }
//            if (StringUtils.hasText(buzhiId)) {
//                user.setBuzhiId(Integer.parseInt(buzhiId));
//            }
//            if (StringUtils.hasText(userMinzu)) {
//                user.setUserMinzu(userMinzu);
//            }
//            if (StringUtils.hasText(userType)) {
//                user.setUserType(Integer.parseInt(userType));
//            }
//            if (StringUtils.hasText(userType1)) {
//                user.setUserType1(Integer.parseInt(userType1));
//            }
//            if (StringUtils.hasText(userType2)) {
//                user.setUserType2(Integer.parseInt(userType2));
//            }
//            if (StringUtils.hasText(roleId)) {
//                user.setRoleId(Integer.parseInt(roleId));
//            }
//            if (StringUtils.hasText(bumenId)) {
//                user.setBumenId(Integer.parseInt(bumenId));
//            }
//            if (StringUtils.hasText(userSex)) {
//                user.setUserSex(Integer.parseInt(userSex));
//            }
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", "");
            jsonObject.put("value", "请选择...");
            jsonArray.add(jsonObject);
            jsonArray.addAll(JSONArray.fromObject(userService.queryUsers(
                    user, userName, 0, 0, null, null, null, null)
            .stream().map(d->new SelectListItem(d.getUserid(), d.getUsername()))
                    .collect(Collectors.toList())));
            ResponseUtil.write(response, jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @RequestMapping("/userTongji")
//    public void userTongji(HttpServletRequest request, HttpServletResponse response)
//            throws Exception {
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        String sdate = request.getParameter("sdate");
//        String edate = request.getParameter("edate");
//        String tijiaoUrl = "userTongji";
//        List<Integer> bumenIds = new ArrayList<Integer>();
//        List<String> tongjiNames = new ArrayList<String>();
//        List<Double> tongjiZongshus = new ArrayList<Double>();
////        List<Bumen> bumens = new ArrayList<Bumen>();
//        List<UserPojo> users = new ArrayList<UserPojo>();
//        Double zongshu = 0.0;
//        try {
//            bumens = bumenService.queryBumens(null, 0, 0);
//            for (int i = 0; i < bumens.size(); i++) {
//                bumenIds.add(bumens.get(i).getBumenId());
//                tongjiNames.add(bumens.get(i).getBumenName());
//            }
//            for (int i = 0; i < bumenIds.size(); i++) {
//                Double userZongshu = 0.0;
//                UserPojo user = new User();
//                user.setBumenId(bumenIds.get(i));
//                users = userService.queryUsers(user, null, 0, 0, sdate, edate, null, null);
//                for (int j = 0; j < users.size(); j++) {
//                    userZongshu = userZongshu + users.size();
//                }
//                zongshu = zongshu + userZongshu;
//                tongjiZongshus.add(userZongshu);
//            }
//
//            HttpSession session = request.getSession();
//            session.setAttribute("tijiaoUrl", tijiaoUrl);
//            session.setAttribute("tongjiNames", tongjiNames);
//            session.setAttribute("tongjiZongshus", tongjiZongshus);
//            session.setAttribute("zongshu", zongshu);
//            response.sendRedirect("tongjitu/bingzhuangtu.jsp");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @RequestMapping("/shangchuanUser")
//    public void shangchuanUser(HttpServletRequest request, HttpServletResponse response, MultipartFile uploadFile)
//            throws Exception {
//        try {
//            String userId = request.getParameter("userId");
//            String directory = "/file";
//            String targetDirectory = request.getSession().getServletContext().getRealPath(directory);
//            String fileName = uploadFile.getOriginalFilename();
//            File dir = new File(targetDirectory, fileName);
//            if (!dir.exists()) {
//                dir.mkdirs();
//            }
//            //MultipartFile自带的解析方法
//            uploadFile.transferTo(dir);
//
//            String shangchuandizhi = "/file" + "/" + fileName;
//            String shangchuanname = fileName;
//            UserPojo user = userService.getUser(Integer.parseInt(userId));
//            user.setUserImg(shangchuandizhi);
//            user.setUserImgName(shangchuanname);
//            userService.modifyUser(user);
//            JSONObject result = new JSONObject();
//            result.put("success", "true");
//            ResponseUtil.write(response, result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @RequestMapping("/daoruUser")
//    public void daoruUser(HttpServletRequest request, HttpServletResponse response, MultipartFile uploadFile)
//            throws Exception {
//        try {
//            String directory = "/file";
//            String targetDirectory = request.getSession().getServletContext().getRealPath(directory);
//            String fileName = uploadFile.getOriginalFilename();
//            File dir = new File(targetDirectory, fileName);
//            if (!dir.exists()) {
//                dir.mkdirs();
//            }
//            //MultipartFile自带的解析方法
//            uploadFile.transferTo(dir);
//            excelFile = new FileInputStream(dir);
//            List<List<String>> list = new ArrayList<List<String>>();
//            list = ExcelUtil.jiexiExcel(excelFile);
//            for (int i = 1; i < list.size(); i++) {
//                List<String> row = list.get(i);
//                String userName = row.get(0);
//                String userPassword = row.get(1);
//                String userXingming = row.get(2);
//                String userSex = row.get(3);
//                String userAge = row.get(4);
//                String userMinzu = row.get(5);
//                String userPhone = row.get(6);
//                String buzhiId = row.get(7);
//                UserPojo user = new User();
//
//                if (StringUtils.hasText(userName)) {
//                    user.setUserName(userName);
//                }
//                if (StringUtils.hasText(userPassword)) {
//                    user.setUserPassword(userPassword);
//                }
//                if (StringUtils.hasText(userAge)) {
//                    user.setUserAge(Integer.parseInt(userAge));
//                }
//                if (StringUtils.hasText(userXingming)) {
//                    user.setUserXingming(userXingming);
//                }
//                if (StringUtils.hasText(userSex)) {
//                    if (userSex.equals("男")) {
//                        user.setUserSex(0);
//                    } else if (userSex.equals("女")) {
//                        user.setUserSex(1);
//                    } else {
//                        user.setUserSex(0);
//                    }
//                }
//                if (StringUtils.hasText(userMinzu)) {
//                    user.setUserMinzu(userMinzu);
//                }
//                if (StringUtils.hasText(userPhone)) {
//                    user.setUserPhone(userPhone);
//                }
//                if (StringUtils.hasText(buzhiId)) {
//                    user.setBuzhiId(Integer.parseInt(buzhiId));
//                    Buzhi buzhi = new Buzhi();
//                    buzhi = buzhiService.getBuzhi(Integer.parseInt(buzhiId));
//                    user.setBuzhiName(buzhi.getBuzhiName());
//                    user.setBumenId(buzhi.getBumenId());
//                    user.setBumenName(buzhi.getBumenName());
//                    user.setBuyuanId(buzhi.getBuyuanId());
//                    user.setBuyuanName(buzhi.getBuyuanName());
//                }
//                Date date = new Date();
//                user.setUserDate(date);
//                userService.save(user);
//            }
//            JSONObject result = new JSONObject();
//            result.put("success", "true");
//            ResponseUtil.write(response, result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @RequestMapping("/daochuUser")
//    public void daochuUser(HttpServletRequest request, HttpServletResponse response)
//            throws Exception {
//        try {
//            Date date = new Date();
//            String strdate = DateUtil.formatDate(date, "yyyyMMddhhmmss");
//            String excelName = strdate + ".xls";
//            String mubanLujing = "";
//            String daochuLujing = "" + excelName;
//            String delIds = request.getParameter("delIds");
//            JSONObject result = new JSONObject();
//            String str[] = delIds.split(",");
//            List<List<String>> list = new ArrayList<List<String>>();
//            UserPojo user = new UserPojo();
//            for (int i = 0; i < str.length; i++) {
//                List<String> row = new ArrayList<String>();
//                user = userService.getUser(Integer.parseInt(str[i]));
//                row.add(TypeUtil.toString(i + 1));
//                row.add(user.getUserXingming());
//                row.add(user.getBuzhiName());
//                row.add(user.getUserPhone());
//                row.add(user.getUserAge().toString());
//                if (user.getUserSex() == 0) {
//                    row.add("男");
//                } else {
//                    row.add("女");
//                }
//                list.add(row);
//            }
//            if (ExcelUtil.daochuExcle(list, mubanLujing, daochuLujing)) {
//                result.put("success", "true");
//                ResponseUtil.write(response, result);
//            } else {
//                result.put("success", "true");
//                result.put("errorMsg", "导出Excel出错！");
//                ResponseUtil.write(response, result);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
