package edu.thn.ciom.controller;

import edu.thn.ciom.pojo.SelectListItem;
import edu.thn.ciom.pojo.YongHuPojo;
import edu.thn.ciom.service.YonghuService;
import edu.thn.ciom.util.DateUtil;
import edu.thn.ciom.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class YonghuController {

    @Autowired
    private YonghuService yonghuService;

    /***上传导入开始***/
    private InputStream excelFile;

    public InputStream getExcelFile() {
        return excelFile;
    }

    /***上传导入结束***/

    @RequestMapping("/getYonghus")
    public void getYonghus(HttpServletRequest request,
                           HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        String yonghuName = request.getParameter("yonghuName");
        String yonghuXingming = request.getParameter("yonghuXingming");
        String yonghuId = request.getParameter("yonghuId");
        String yonghuType = request.getParameter("yonghuType");
        String yonghuType1 = request.getParameter("yonghuType1");
        String yonghuType2 = request.getParameter("yonghuType2");
        String yhroleId = request.getParameter("yhroleId");
        String byumenId = request.getParameter("byumenId");
        String byuzhiId = request.getParameter("byuzhiId");
        String byuyuanId = request.getParameter("byuyuanId");
        String yonghuMinzu = request.getParameter("yonghuMinzu");
        String yonghuSex = request.getParameter("yonghuSex");
        String userId = request.getParameter("userId");
        String bumenId = request.getParameter("bumenId");
        String buyuanId = request.getParameter("buyuanId");
        String buzhiId = request.getParameter("buzhiId");
        String sdate = request.getParameter("sdate");
        String edate = request.getParameter("edate");
        String sdate1 = request.getParameter("sdate1");
        String edate1 = request.getParameter("edate1");
        YongHuPojo yonghu = new YongHuPojo();
        PageBean pageBean = null;
        if ((StringUtils.hasText(page)) && (!page.equals("null"))) {
            pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        } else {
            pageBean = new PageBean(0, 0);
        }
        try {

            if (StringUtils.hasText(yonghuXingming)) {
                yonghu.setYonghuxingming(yonghuXingming);
            }
            if (StringUtils.hasText(yonghuName)) {
                yonghu.setYonghuname(yonghuName);
            }
            if (StringUtils.hasText(yonghuMinzu)) {
                yonghu.setYonghuminzu(yonghuMinzu);
            }
            if (StringUtils.hasText(yonghuId)) {
                yonghu.setYonghuid(Integer.parseInt(yonghuId));
            }
            if (StringUtils.hasText(byuzhiId)) {
                yonghu.setByuzhiid(Integer.parseInt(byuzhiId));
            }
            if (StringUtils.hasText(byuyuanId)) {
                yonghu.setByuyuanid(Integer.parseInt(byuyuanId));
            }
            if (StringUtils.hasText(yonghuType)) {
                yonghu.setYonghutype(Integer.parseInt(yonghuType));
            }
            if (StringUtils.hasText(yonghuType1)) {
                yonghu.setYonghutype1(Integer.parseInt(yonghuType1));
            }
            if (StringUtils.hasText(yonghuType2)) {
                yonghu.setYonghutype2(Integer.parseInt(yonghuType2));
            }
            if (StringUtils.hasText(yhroleId)) {
                yonghu.setYhroleid(Integer.parseInt(yhroleId));
            }
            if (StringUtils.hasText(byumenId)) {
                yonghu.setByumenid(Integer.parseInt(byumenId));
            }
            if (StringUtils.hasText(yonghuSex)) {
                yonghu.setYonghusex(Integer.parseInt(yonghuSex));
            }
            if (StringUtils.hasText(userId)) {
                yonghu.setUserid(Integer.parseInt(userId));
            }
            if (StringUtils.hasText(buyuanId)) {
                yonghu.setBuyuanid(Integer.parseInt(buyuanId));
            }
            if (StringUtils.hasText(buzhiId)) {
                yonghu.setBuzhiid(Integer.parseInt(buzhiId));
            }
            if (StringUtils.hasText(bumenId)) {
                yonghu.setBumenid(Integer.parseInt(bumenId));
            }
            if (StringUtils.hasText(sdate1)) {
                Date date = new Date();
                sdate1 = DateUtil.formatDate(date, "yyyy-MM-dd HH:mm:ss");
            }
            if (StringUtils.hasText(edate1)) {
                Date date = new Date();
                edate1 = DateUtil.formatDate(date, "yyyy-MM-dd HH:mm:ss");
            }
            JSONArray jsonArray = JSONArray.fromObject(yonghuService.queryYonghus(
                    yonghu, null, pageBean.getStart(), pageBean.getRows(), sdate, edate, sdate1, edate1));
            JSONObject result = new JSONObject();
            int total = yonghuService.queryYonghus(yonghu, null, 0, 0, sdate, edate, sdate1, edate1).size();
            result.put("rows", jsonArray);
            result.put("total", total);
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/addYonghu")
    public void addYonghu(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            JSONObject result = new JSONObject();

            String yonghuName = request.getParameter("yonghuName");
            String yonghuPassword = request.getParameter("yonghuPassword");
            String yonghuAge = request.getParameter("yonghuAge");
            String yonghuXingming = request.getParameter("yonghuXingming");
            String yonghuSex = request.getParameter("yonghuSex");
            String yonghuPhone = request.getParameter("yonghuPhone");
            String yonghuMark = request.getParameter("yonghuMark");
            String yonghuMark1 = request.getParameter("yonghuMark1");
            String yonghuMark2 = request.getParameter("yonghuMark2");
            String yonghuMark3 = request.getParameter("yonghuMark3");
            String yonghuMark4 = request.getParameter("yonghuMark4");
            String yonghuDate = request.getParameter("yonghuDate");
            String yonghuDate1 = request.getParameter("yonghuDate1");
            String yonghuDate2 = request.getParameter("yonghuDate2");
            String yonghuType = request.getParameter("yonghuType");
            String yonghuType1 = request.getParameter("yonghuType1");
            String yonghuType2 = request.getParameter("yonghuType2");
            String yonghuZong = request.getParameter("yonghuZong");
            String yonghuZong1 = request.getParameter("yonghuZong1");
            String yonghuZong2 = request.getParameter("yonghuZong2");
            String yonghuDouble = request.getParameter("yonghuDouble");
            String yonghuDouble1 = request.getParameter("yonghuDouble1");
            String yonghuDouble2 = request.getParameter("yonghuDouble2");
            String yhroleId = request.getParameter("yhroleId");
            String byumenId = request.getParameter("byumenId");
            String byuyuanId = request.getParameter("byuyuanId");
            String byuzhiId = request.getParameter("byuzhiId");
            String userId = request.getParameter("userId");
            String bumenId = request.getParameter("bumenId");
            String buyuanId = request.getParameter("buyuanId");
            String buzhiId = request.getParameter("buzhiId");
            String yonghuId = request.getParameter("yonghuId");
            YongHuPojo yonghu = new YongHuPojo();

            if (StringUtils.hasText(yonghuId)) {
                yonghu = yonghuService.getYonghu(Integer.parseInt(yonghuId));
            }
            if (StringUtils.hasText(yonghuName)) {
                yonghu.setYonghuname(yonghuName);
            }
            if (StringUtils.hasText(yonghuPassword)) {
                yonghu.setYonghupassword(yonghuPassword);
            }
            if (StringUtils.hasText(yonghuAge)) {
                yonghu.setYonghuage(Integer.parseInt(yonghuAge));
            }
            if (StringUtils.hasText(yonghuXingming)) {
                yonghu.setYonghuxingming(yonghuXingming);
            }
            if (StringUtils.hasText(yonghuSex)) {
                yonghu.setYonghusex(Integer.parseInt(yonghuSex));
            }
            if (StringUtils.hasText(yonghuPhone)) {
                yonghu.setYonghuphone(yonghuPhone);
            }
            if (StringUtils.hasText(yonghuMark)) {
                yonghu.setYonghumark(yonghuMark);
            }
            if (StringUtils.hasText(yonghuMark1)) {
                yonghu.setYonghumark1(yonghuMark1);
            }
            if (StringUtils.hasText(yonghuMark2)) {
                yonghu.setYonghumark2(yonghuMark2);
            }
            if (StringUtils.hasText(yonghuMark3)) {
                yonghu.setYonghumark3(yonghuMark3);
            }
            if (StringUtils.hasText(yonghuMark4)) {
                yonghu.setYonghumark4(yonghuMark4);
            }
            if (StringUtils.hasText(yonghuDate)) {
                yonghu.setYonghudate(DateUtil.formatString(yonghuDate,
                        "yyyy-MM-dd hh:mm:ss"));
            }
            if (StringUtils.hasText(yonghuDate1)) {
                yonghu.setYonghudate1(DateUtil.formatString(yonghuDate1,
                        "yyyy-MM-dd hh:mm:ss"));
            }
            if (StringUtils.hasText(yonghuDate2)) {
                yonghu.setYonghudate2(DateUtil.formatString(yonghuDate2,
                        "yyyy-MM-dd hh:mm:ss"));
            }
            if (StringUtils.hasText(yonghuType)) {
                yonghu.setYonghutype(Integer.parseInt(yonghuType));
            }
            if (StringUtils.hasText(yonghuType1)) {
                yonghu.setYonghutype1(Integer.parseInt(yonghuType1));
            }
            if (StringUtils.hasText(yonghuType2)) {
                yonghu.setYonghutype2(Integer.parseInt(yonghuType2));
            }
            if (StringUtils.hasText(yonghuZong)) {
                yonghu.setYonghuzong(Integer.parseInt(yonghuZong));
            }
            if (StringUtils.hasText(yonghuZong1)) {
                yonghu.setYonghuzong1(Integer.parseInt(yonghuZong1));
            }
            if (StringUtils.hasText(yonghuZong2)) {
                yonghu.setYonghuzong2(Integer.parseInt(yonghuZong2));
            }
            if (StringUtils.hasText(yonghuDouble)) {
                yonghu.setYonghudouble(Double.parseDouble(yonghuDouble));
            }
            if (StringUtils.hasText(yonghuDouble1)) {
                yonghu.setYonghudouble1(Double.parseDouble(yonghuDouble1));
            }
            if (StringUtils.hasText(yonghuDouble2)) {
                yonghu.setYonghudouble2(Double.parseDouble(yonghuDouble2));
            }
            if (StringUtils.hasText(yhroleId)) {
                yonghu.setYhroleid(Integer.parseInt(yhroleId));
//                Yhrole yhrole = new Yhrole();
//                yhrole = yhroleService.getYhrole(Integer.parseInt(yhroleId));
//                yonghu.setYhroleName(yhrole.getYhroleName());
            }
            if (StringUtils.hasText(byuzhiId)) {
                yonghu.setByuzhiid(Integer.parseInt(byuzhiId));
//                Byuzhi byuzhi = new Byuzhi();
//                byuzhi = byuzhiService.getByuzhi(Integer.parseInt(byuzhiId));
//                yonghu.setByuzhiName(byuzhi.getByuzhiName());
//                yonghu.setByumenId(byuzhi.getByuzhiId());
//                yonghu.setByumenName(byuzhi.getByumenName());
//                yonghu.setByuyuanId(byuzhi.getByuyuanId());
//                yonghu.setByuyuanName(byuzhi.getByuyuanName());
            }
            if (StringUtils.hasText(byumenId)) {
                yonghu.setByumenid(Integer.parseInt(byumenId));
//                Byumen byumen = new Byumen();
//                byumen = byumenService.getByumen(Integer.parseInt(byumenId));
//                yonghu.setByumenName(byumen.getByumenName());
//                yonghu.setByuyuanId(byumen.getByuyuanId());
//                yonghu.setByuyuanName(byumen.getByuyuanName());
            }
            if (StringUtils.hasText(byuyuanId)) {
                yonghu.setByuyuanid(Integer.parseInt(byuyuanId));
//                Byuyuan byuyuan = new Byuyuan();
//                byuyuan = byuyuanService.getByuyuan(Integer.parseInt(byuyuanId));
//                yonghu.setByuyuanName(byuyuan.getByuyuanName());
            }
            if (StringUtils.hasText(userId)) {
                yonghu.setUserid(Integer.parseInt(userId));
//                User user = new User();
//                user = userService.getUser(Integer.parseInt(userId));
//                yonghu.setUserName(user.getUserName());
//                yonghu.setBumenId(user.getBumenId());
//                yonghu.setBumenName(user.getBumenName());
//                yonghu.setBuyuanId(user.getBuyuanId());
//                yonghu.setBuyuanName(user.getBuyuanName());
//                yonghu.setBuzhiId(user.getBuzhiId());
//                yonghu.setBuzhiName(user.getBuzhiName());
            }
            if (StringUtils.hasText(buzhiId)) {
                yonghu.setBuzhiid(Integer.parseInt(buzhiId));
//                Buzhi buzhi = new Buzhi();
//                buzhi = buzhiService.getBuzhi(Integer.parseInt(buzhiId));
//                yonghu.setBuzhiName(buzhi.getBuzhiName());
//                yonghu.setBumenId(buzhi.getBumenId());
//                yonghu.setBumenName(buzhi.getBumenName());
//                yonghu.setBuyuanId(buzhi.getBuyuanId());
//                yonghu.setBuyuanName(buzhi.getBuyuanName());
            }
            if (StringUtils.hasText(bumenId)) {
                yonghu.setBumenid(Integer.parseInt(bumenId));
//                Bumen bumen = new Bumen();
//                bumen = bumenService.getBumen(Integer.parseInt(bumenId));
//                yonghu.setBumenName(bumen.getBumenName());
//                yonghu.setBuyuanId(bumen.getBuyuanId());
//                yonghu.setBuyuanName(bumen.getBuyuanName());
            }
            if (StringUtils.hasText(buyuanId)) {
                yonghu.setBuyuanid(Integer.parseInt(buyuanId));
//                Buyuan buyuan = new Buyuan();
//                buyuan = buyuanService.getBuyuan(Integer.parseInt(buyuanId));
//                yonghu.setBuyuanName(buyuan.getBuyuanName());
            }
            if (StringUtils.hasText(yonghuId)) {
                yonghuService.modifyYonghu(yonghu);
                result.put("success", "true");
                ResponseUtil.write(response, result);
            } else {
                int total = yonghuService.queryYonghus(null, yonghuName, 0, 0, null, null, null, null).size();
                if (total == 0) {
                    Date date = new Date();
                    yonghu.setYonghudate(date);
                    yonghu.setYonghutype(0);
                    yonghuService.save(yonghu);
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

    @RequestMapping("/mimaYonghu")
    public void mimaYonghu(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String yonghuId = request.getParameter("yonghuId");
        String yonghuPassword = request.getParameter("yonghuPassword");
        String yonghuPassword1 = request.getParameter("yonghuPassword1");
        YongHuPojo yonghu = new YongHuPojo();
        try {
            yonghu = yonghuService.getYonghu(Integer.parseInt(yonghuId));
            if (!yonghu.getYonghupassword().equals(yonghuPassword)) {
                request.setAttribute("error", "原密码错误，请重新输入！");
                request.getRequestDispatcher("yonghu/yonghumima.jsp").forward(request,
                        response);
            } else {
                yonghu.setYonghupassword(yonghuPassword1);
                yonghuService.modifyYonghu(yonghu);
                request.setAttribute("error", "密码修改成功！");
                request.getRequestDispatcher("yonghu/yonghumima.jsp").forward(request,
                        response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/zhaohuiYonghu")
    public void zhaohuiYonghu(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            String yonghuName = request.getParameter("yonghuName");
            String yonghuPhone = request.getParameter("yonghuPhone");
            YongHuPojo yonghu = new YongHuPojo();

            if (StringUtils.hasText(yonghuName)) {
                yonghu.setYonghuname(yonghuName);
            }
            List<YongHuPojo> yonghus = yonghuService.queryYonghus(yonghu, null, 0, 0, null, null, null, null);
            if (yonghus.size() == 0) {
                request.setAttribute("error", "无此用户名请重新找回！");
                request.getRequestDispatcher("yonghu/zhaohuiyonghu.jsp").forward(request, response);
            } else {
                yonghu = yonghus.get(0);
                if (yonghu.getYonghuphone().equals(yonghuPhone)) {
                    String yonghuPassword = yonghu.getYonghupassword();
                    request.setAttribute("error", "密码是：" + yonghuPassword);
                    request.getRequestDispatcher("yonghu/zhaohuiyonghu.jsp").forward(request, response);
                } else {
                    request.setAttribute("error", "用户名和电话不匹配，请重新找回！");
                    request.getRequestDispatcher("yonghu/zhaohuiyonghu.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "系统错误联系管理员！");
            request.getRequestDispatcher("yonghu/zhaohuiyonghu.jsp").forward(request, response);
        }
    }

    @RequestMapping("/zhuceYonghu")
    public void zhuceYonghu(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            String yonghuName = request.getParameter("yonghuName");
            String yonghuPassword = request.getParameter("yonghuPassword");
            String yonghuAge = request.getParameter("yonghuAge");
            String yonghuXingming = request.getParameter("yonghuXingming");
            String yonghuSex = request.getParameter("yonghuSex");
            String yonghuPhone = request.getParameter("yonghuPhone");
            String yonghuMark = request.getParameter("yonghuMark");
            String yonghuMark1 = request.getParameter("yonghuMark1");
            String yonghuMark2 = request.getParameter("yonghuMark2");
            String yonghuMark3 = request.getParameter("yonghuMark3");
            String yonghuMark4 = request.getParameter("yonghuMark4");
            String yonghuDate = request.getParameter("yonghuDate");
            String yonghuDate1 = request.getParameter("yonghuDate1");
            String yonghuDate2 = request.getParameter("yonghuDate2");
            String yonghuType = request.getParameter("yonghuType");
            String yonghuType1 = request.getParameter("yonghuType1");
            String yonghuType2 = request.getParameter("yonghuType2");
            String yonghuZong = request.getParameter("yonghuZong");
            String yonghuZong1 = request.getParameter("yonghuZong1");
            String yonghuZong2 = request.getParameter("yonghuZong2");
            String yonghuDouble = request.getParameter("yonghuDouble");
            String yonghuDouble1 = request.getParameter("yonghuDouble1");
            String yonghuDouble2 = request.getParameter("yonghuDouble2");
            String yhroleId = request.getParameter("yhroleId");
            String byumenId = request.getParameter("byumenId");
            String byuyuanId = request.getParameter("byuyuanId");
            String byuzhiId = request.getParameter("byuzhiId");
            String userId = request.getParameter("userId");
            String bumenId = request.getParameter("bumenId");
            String buyuanId = request.getParameter("buyuanId");
            String buzhiId = request.getParameter("buzhiId");
            String yonghuId = request.getParameter("yonghuId");
            YongHuPojo yonghu = new YongHuPojo();

            // if (StringUtils.hasText(yonghuId)) {
            //    yonghu = yonghuService.getYonghu(Integer.parseInt(yonghuId));
            // }
            if (StringUtils.hasText(yonghuName)) {
                yonghu.setYonghuname(yonghuName);
            }
            if (StringUtils.hasText(yonghuPassword)) {
                yonghu.setYonghupassword(yonghuPassword);
            }
            if (StringUtils.hasText(yonghuAge)) {
                yonghu.setYonghuage(Integer.parseInt(yonghuAge));
            }
            if (StringUtils.hasText(yonghuXingming)) {
                yonghu.setYonghuxingming(yonghuXingming);
            }
            if (StringUtils.hasText(yonghuSex)) {
                yonghu.setYonghusex(Integer.parseInt(yonghuSex));
            }
            if (StringUtils.hasText(yonghuPhone)) {
                yonghu.setYonghuphone(yonghuPhone);
            }
            if (StringUtils.hasText(yonghuMark)) {
                yonghu.setYonghumark(yonghuMark);
            }
            if (StringUtils.hasText(yonghuMark1)) {
                yonghu.setYonghumark1(yonghuMark1);
            }
            if (StringUtils.hasText(yonghuMark2)) {
                yonghu.setYonghumark2(yonghuMark2);
            }
            if (StringUtils.hasText(yonghuMark3)) {
                yonghu.setYonghumark3(yonghuMark3);
            }
            if (StringUtils.hasText(yonghuMark4)) {
                yonghu.setYonghumark4(yonghuMark4);
            }
            if (StringUtils.hasText(yonghuDate)) {
                yonghu.setYonghudate(DateUtil.formatString(yonghuDate,
                        "yyyy-MM-dd hh:mm:ss"));
            }
            if (StringUtils.hasText(yonghuDate1)) {
                yonghu.setYonghudate1(DateUtil.formatString(yonghuDate1,
                        "yyyy-MM-dd hh:mm:ss"));
            }
            if (StringUtils.hasText(yonghuDate2)) {
                yonghu.setYonghudate2(DateUtil.formatString(yonghuDate2,
                        "yyyy-MM-dd hh:mm:ss"));
            }
            if (StringUtils.hasText(yonghuType)) {
                yonghu.setYonghutype(Integer.parseInt(yonghuType));
            }
            if (StringUtils.hasText(yonghuType1)) {
                yonghu.setYonghutype1(Integer.parseInt(yonghuType1));
            }
            if (StringUtils.hasText(yonghuType2)) {
                yonghu.setYonghutype2(Integer.parseInt(yonghuType2));
            }
            if (StringUtils.hasText(yonghuZong)) {
                yonghu.setYonghuzong(Integer.parseInt(yonghuZong));
            }
            if (StringUtils.hasText(yonghuZong1)) {
                yonghu.setYonghuzong1(Integer.parseInt(yonghuZong1));
            }
            if (StringUtils.hasText(yonghuZong2)) {
                yonghu.setYonghuzong2(Integer.parseInt(yonghuZong2));
            }
            if (StringUtils.hasText(yonghuDouble)) {
                yonghu.setYonghudouble(Double.parseDouble(yonghuDouble));
            }
            if (StringUtils.hasText(yonghuDouble1)) {
                yonghu.setYonghudouble1(Double.parseDouble(yonghuDouble1));
            }
            if (StringUtils.hasText(yonghuDouble2)) {
                yonghu.setYonghudouble2(Double.parseDouble(yonghuDouble2));
            }
            if (StringUtils.hasText(yhroleId)) {
                yonghu.setYhroleid(Integer.parseInt(yhroleId));
//                Yhrole yhrole = new Yhrole();
//                yhrole = yhroleService.getYhrole(Integer.parseInt(yhroleId));
//                yonghu.setYhroleName(yhrole.getYhroleName());
            }
            if (StringUtils.hasText(byuzhiId)) {
                yonghu.setByuzhiid(Integer.parseInt(byuzhiId));
//                Byuzhi byuzhi = new Byuzhi();
//                byuzhi = byuzhiService.getByuzhi(Integer.parseInt(byuzhiId));
//                yonghu.setByuzhiName(byuzhi.getByuzhiName());
//                yonghu.setByumenId(byuzhi.getByuzhiId());
//                yonghu.setByumenName(byuzhi.getByumenName());
//                yonghu.setByuyuanId(byuzhi.getByuyuanId());
//                yonghu.setByuyuanName(byuzhi.getByuyuanName());
            }
            if (StringUtils.hasText(byumenId)) {
                yonghu.setByumenid(Integer.parseInt(byumenId));
//                Byumen byumen = new Byumen();
//                byumen = byumenService.getByumen(Integer.parseInt(byumenId));
//                yonghu.setByumenName(byumen.getByumenName());
//                yonghu.setByuyuanId(byumen.getByuyuanId());
//                yonghu.setByuyuanName(byumen.getByuyuanName());
            }
            if (StringUtils.hasText(byuyuanId)) {
                yonghu.setByuyuanid(Integer.parseInt(byuyuanId));
//                Byuyuan byuyuan = new Byuyuan();
//                byuyuan = byuyuanService.getByuyuan(Integer.parseInt(byuyuanId));
//                yonghu.setByuyuanname(byuyuan.getByuyuanName());
            }
            if (StringUtils.hasText(userId)) {
                yonghu.setUserid(Integer.parseInt(userId));
//                User user = new User();
//                user = userService.getUser(Integer.parseInt(userId));
//                yonghu.setUserName(user.getUserName());
//                yonghu.setBumenId(user.getBumenId());
//                yonghu.setBumenName(user.getBumenName());
//                yonghu.setBuyuanId(user.getBuyuanId());
//                yonghu.setBuyuanName(user.getBuyuanName());
//                yonghu.setBuzhiId(user.getBuzhiId());
//                yonghu.setBuzhiName(user.getBuzhiName());
            }
            if (StringUtils.hasText(buzhiId)) {
                yonghu.setBuzhiid(Integer.parseInt(buzhiId));
//                Buzhi buzhi = new Buzhi();
//                buzhi = buzhiService.getBuzhi(Integer.parseInt(buzhiId));
//                yonghu.setBuzhiName(buzhi.getBuzhiName());
//                yonghu.setBumenId(buzhi.getBumenId());
//                yonghu.setBumenName(buzhi.getBumenName());
//                yonghu.setBuyuanId(buzhi.getBuyuanId());
//                yonghu.setBuyuanName(buzhi.getBuyuanName());
            }
            if (StringUtils.hasText(bumenId)) {
                yonghu.setBumenid(Integer.parseInt(bumenId));
//                Bumen bumen = new Bumen();
//                bumen = bumenService.getBumen(Integer.parseInt(bumenId));
//                yonghu.setBumenName(bumen.getBumenName());
//                yonghu.setBuyuanId(bumen.getBuyuanId());
//                yonghu.setBuyuanName(bumen.getBuyuanName());
            }
            if (StringUtils.hasText(buyuanId)) {
                yonghu.setBuyuanid(Integer.parseInt(buyuanId));
//                Buyuan buyuan = new Buyuan();
//                buyuan = buyuanService.getBuyuan(Integer.parseInt(buyuanId));
//                yonghu.setBuyuanName(buyuan.getBuyuanName());
            }
            int total = yonghuService.queryYonghus(null, yonghuName, 0, 0, null, null, null, null).size();
            if (total == 0) {
                Date date = new Date();
                yonghu.setYonghudate(date);
                yonghu.setYonghuzong(0);
                yonghuService.save(yonghu);
                request.setAttribute("error", "注册成功，请登录！");
                request.getRequestDispatcher("shouye/index.jsp").forward(request,
                        response);
            } else {
                request.setAttribute("error", "用户名重复，请重新输入！");
                request.getRequestDispatcher("yonghu/zhuceyonghu.jsp").forward(request,
                        response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/deleteYonghu")
    public void deleteYonghu(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        JSONObject result = new JSONObject();
        String delIds = request.getParameter("delIds");
        try {
            String[] str = delIds.split(",");
            for (int i = 0; i < str.length; i++) {
                yonghuService.deleteYonghu(Integer.parseInt(str[i]));
            }
            result.put("success", "true");
            result.put("delNums", str.length);
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/yonghuComboList")
    public void yonghuComboList(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String yonghuName = request.getParameter("yonghuName");
        String yonghuXingming = request.getParameter("yonghuXingming");
        String yonghuId = request.getParameter("yonghuId");
        String yonghuType = request.getParameter("yonghuType");
        String yonghuType1 = request.getParameter("yonghuType1");
        String yonghuType2 = request.getParameter("yonghuType2");
        String yhroleId = request.getParameter("yhroleId");
        String byumenId = request.getParameter("byumenId");
        String byuzhiId = request.getParameter("byuzhiId");
        String byuyuanId = request.getParameter("byuyuanId");
        String yonghuMinzu = request.getParameter("yonghuMinzu");
        String yonghuSex = request.getParameter("yonghuSex");
        String userId = request.getParameter("userId");
        String bumenId = request.getParameter("bumenId");
        String buyuanId = request.getParameter("buyuanId");
        String buzhiId = request.getParameter("buzhiId");
        YongHuPojo yonghu = new YongHuPojo();
        try {
//            if (StringUtils.hasText(yonghuXingming)) {
//                yonghu.setYonghuXingming(yonghuXingming);
//            }
//            if (StringUtils.hasText(yonghuName)) {
//                yonghu.setYonghuName(yonghuName);
//            }
//            if (StringUtils.hasText(yonghuMinzu)) {
//                yonghu.setYonghuMinzu(yonghuMinzu);
//            }
//            if (StringUtils.hasText(yonghuId)) {
//                yonghu.setYonghuId(Integer.parseInt(yonghuId));
//            }
//            if (StringUtils.hasText(byuzhiId)) {
//                yonghu.setByuzhiId(Integer.parseInt(byuzhiId));
//            }
//            if (StringUtils.hasText(byuyuanId)) {
//                yonghu.setByuyuanId(Integer.parseInt(byuyuanId));
//            }
//            if (StringUtils.hasText(yonghuType)) {
//                yonghu.setYonghuType(Integer.parseInt(yonghuType));
//            }
//            if (StringUtils.hasText(yonghuType1)) {
//                yonghu.setYonghuType1(Integer.parseInt(yonghuType1));
//            }
//            if (StringUtils.hasText(yonghuType2)) {
//                yonghu.setYonghuType2(Integer.parseInt(yonghuType2));
//            }
//            if (StringUtils.hasText(yhroleId)) {
//                yonghu.setYhroleId(Integer.parseInt(yhroleId));
//            }
//            if (StringUtils.hasText(byumenId)) {
//                yonghu.setByumenId(Integer.parseInt(byumenId));
//            }
//            if (StringUtils.hasText(yonghuSex)) {
//                yonghu.setYonghuSex(Integer.parseInt(yonghuSex));
//            }
//            if (StringUtils.hasText(userId)) {
//                yonghu.setUserId(Integer.parseInt(userId));
//            }
//            if (StringUtils.hasText(buyuanId)) {
//                yonghu.setBuyuanId(Integer.parseInt(buyuanId));
//            }
//            if (StringUtils.hasText(buzhiId)) {
//                yonghu.setBuzhiId(Integer.parseInt(buzhiId));
//            }
//            if (StringUtils.hasText(bumenId)) {
//                yonghu.setBumenId(Integer.parseInt(bumenId));
//            }
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("id", "");
//            jsonObject.put("yonghuName", "请选择...");
            jsonObject.put("id", "");
            jsonObject.put("value", "请选择...");
            jsonArray.add(jsonObject);
            jsonArray.addAll(JSONArray.fromObject(yonghuService.queryYonghus(yonghu,
                    null, 0, 0, null, null, null, null)
                    .stream().map(d->new SelectListItem(d.getYonghuid().toString(), d.getYonghuname()))
            .collect(Collectors.toList())));
            ResponseUtil.write(response, jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/yonghuTongji")
    public void yonghuTongji(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String sdate = request.getParameter("sdate");
        String edate = request.getParameter("edate");
        String tijiaoUrl = "yonghuTongji"; //?用户统计
        List<Integer> bumenIds = new ArrayList<Integer>();
        List<String> tongjiNames = new ArrayList<String>();
        List<Double> tongjiZongshus = new ArrayList<Double>();
        //List<Bumen> bumens = new ArrayList<Bumen>();
        List<YongHuPojo> yonghus = new ArrayList<YongHuPojo>();
        Double zongshu = 0.0;
        try {
//            bumens = bumenService.queryBumens(null, 0, 0);
//            for (int i = 0; i < bumens.size(); i++) {
//                bumenIds.add(bumens.get(i).getBumenId());
//                tongjiNames.add(bumens.get(i).getBumenName());
//            }
            for (int i = 0; i < bumenIds.size(); i++) {
                Double yonghuZongshu = 0.0;
                YongHuPojo yonghu = new YongHuPojo();
                yonghu.setBumenid(bumenIds.get(i));
                yonghus = yonghuService.queryYonghus(yonghu, null, 0, 0, sdate, edate, null, null);
                for (int j = 0; j < yonghus.size(); j++) {
                    yonghuZongshu = yonghuZongshu + yonghus.size();
                }
                zongshu = zongshu + yonghuZongshu;
                tongjiZongshus.add(yonghuZongshu);
            }

            HttpSession session = request.getSession();
            session.setAttribute("tijiaoUrl", tijiaoUrl);
            session.setAttribute("tongjiNames", tongjiNames);
            session.setAttribute("tongjiZongshus", tongjiZongshus);
            session.setAttribute("zongshu", zongshu);
            response.sendRedirect("tongjitu/bingzhuangtu.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/shangchuanYonghu")
    public void shangchuanYonghu(HttpServletRequest request, HttpServletResponse response, MultipartFile uploadFile)
            throws Exception {
        try {
            String yonghuId = request.getParameter("yonghuId");
            String directory = "/file";
            String targetDirectory = request.getSession().getServletContext().getRealPath(directory);
            String fileName = uploadFile.getOriginalFilename();
            File dir = new File(targetDirectory, fileName);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            //MultipartFile自带的解析方法
            uploadFile.transferTo(dir);

            String shangchuandizhi = "/file" + "/" + fileName;
            String shangchuanname = fileName;
            YongHuPojo yonghu = yonghuService.getYonghu(Integer.parseInt(yonghuId));
            yonghu.setYonghuimg(shangchuandizhi);
            yonghu.setYonghuimgname(shangchuanname);
            yonghuService.modifyYonghu(yonghu);
            JSONObject result = new JSONObject();
            result.put("success", "true");
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @RequestMapping("/daoruYonghu")
//    public void daoruYonghu(HttpServletRequest request, HttpServletResponse response, MultipartFile uploadFile)
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
//                String yonghuName = row.get(0);
//                String yonghuPassword = row.get(1);
//                String yonghuXingming = row.get(2);
//                String yonghuSex = row.get(3);
//                String yonghuAge = row.get(4);
//                String yonghuMinzu = row.get(5);
//                String yonghuPhone = row.get(6);
//                String byuzhiId = row.get(7);
//                Yonghu yonghu = new Yonghu();
//
//                if (StringUtils.hasText(yonghuName)) {
//                    yonghu.setYonghuName(yonghuName);
//                }
//                if (StringUtils.hasText(yonghuPassword)) {
//                    yonghu.setYonghuPassword(yonghuPassword);
//                }
//                if (StringUtils.hasText(yonghuAge)) {
//                    yonghu.setYonghuAge(Integer.parseInt(yonghuAge));
//                }
//                if (StringUtils.hasText(yonghuXingming)) {
//                    yonghu.setYonghuXingming(yonghuXingming);
//                }
//                if (StringUtils.hasText(yonghuSex)) {
//                    if (yonghuSex.equals("男")) {
//                        yonghu.setYonghuSex(0);
//                    } else if (yonghuSex.equals("女")) {
//                        yonghu.setYonghuSex(1);
//                    } else {
//                        yonghu.setYonghuSex(0);
//                    }
//                }
//                if (StringUtils.hasText(yonghuMinzu)) {
//                    yonghu.setYonghuMinzu(yonghuMinzu);
//                }
//                if (StringUtils.hasText(yonghuPhone)) {
//                    yonghu.setYonghuPhone(yonghuPhone);
//                }
//                if (StringUtils.hasText(byuzhiId)) {
//                    yonghu.setByuzhiId(Integer.parseInt(byuzhiId));
//                    Byuzhi byuzhi = new Byuzhi();
//                    byuzhi = byuzhiService.getByuzhi(Integer.parseInt(byuzhiId));
//                    yonghu.setByuzhiName(byuzhi.getByuzhiName());
//                    yonghu.setByumenId(byuzhi.getByumenId());
//                    yonghu.setByumenName(byuzhi.getByumenName());
//                    yonghu.setByuyuanid(byuzhi.getByuyuanid());
//                    yonghu.setByuyuanname(byuzhi.getByuyuanname());
//                }
//                Date date = new Date();
//                yonghu.setYonghudate(date);
//                yonghuService.save(yonghu);
//            }
//            JSONObject result = new JSONObject();
//            result.put("success", "true");
//            ResponseUtil.write(response, result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    @RequestMapping("/daochuYonghu")
//    public void daochuYonghu(HttpServletRequest request, HttpServletResponse response)
//            throws Exception {
//        try {
//            Date date = new Date();
//            String strdate = DateUtil.formatDate(date, "yyyyMMddhhmmss");
//            String excelName = strdate + ".xls";
//            String mubanLujing = "";
//            String daochuLujing = "" + excelName;
//            String delIds =  request.getParameter("delIds");
//            JSONObject result = new JSONObject();
//            String str[] = delIds.split(",");
//            List<List<String>> list = new ArrayList<List<String>>();
//            YongHuPojo yonghu = new YongHuPojo();
//            for (int i = 0; i < str.length; i++) {
//                List<String> row = new ArrayList<String>();
//                yonghu = yonghuService.getYonghu(Integer.parseInt(str[i]));
//                row.add(TypeUtil.toString(i + 1));
//                row.add(yonghu.getYonghuxingming());
//                row.add(yonghu.getByuzhiname());
//                row.add(yonghu.getYonghuphone());
//                row.add(yonghu.getYonghuage().toString());
//                if (yonghu.getYonghusex() == 0) {
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
