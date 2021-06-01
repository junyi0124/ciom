package edu.thn.ciom.controller;

import edu.thn.ciom.pojo.*;
import edu.thn.ciom.service.ShujuService;
import edu.thn.ciom.service.TypeService;
import edu.thn.ciom.service.UserService;
import edu.thn.ciom.service.YonghuService;
import edu.thn.ciom.util.DateUtil;
import edu.thn.ciom.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ShujuController {
    @Autowired
    private ShujuService shujuService;
    @Autowired
    private TypeService typeService;

    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private UserService userService;


    @RequestMapping("/getShujus")
    public void getShujus(HttpServletRequest request,
                          HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        String shujuId = request.getParameter("shujuId");
        String shujuName = request.getParameter("shujuName");
        String sjleixingId = request.getParameter("sjleixingId");
//        String shujuType = request.getParameter("shujuType");
//        String shujuType1 = request.getParameter("shujuType1");
//        String sjxingtaiId = request.getParameter("sjxingtaiId");
//        String shujuZong2 = request.getParameter("shujuZong2");
//        String yonghuId = request.getParameter("yonghuId");
//        String byumenId = request.getParameter("byumenId");
//        String byuyuanId = request.getParameter("byuyuanId");
//        String byuzhiId = request.getParameter("byuzhiId");
//        String userId = request.getParameter("userId");
//        String bumenId = request.getParameter("bumenId");
//        String buyuanId = request.getParameter("buyuanId");
//        String buzhiId = request.getParameter("buzhiId");
//        String sdate = request.getParameter("sdate");
//        String edate = request.getParameter("edate");
//        String sdate1 = request.getParameter("sdate1");
//        String edate1 = request.getParameter("edate1");
        ShujuPojo shuju = new ShujuPojo();
        PageBean pageBean;
        if ((StringUtils.hasText(page)) && (!page.equals("null"))) {
            pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        } else {
            pageBean = new PageBean(0, 0);
        }
        try {
            if (StringUtils.hasText(shujuId)) {
                shuju.setShujuid(Integer.parseInt(shujuId));
            }
            if (StringUtils.hasText(shujuName)) {
                shuju.setShujuname(shujuName);
            }
            if (StringUtils.hasText(sjleixingId)) {
                shuju.setSjleixingid(Integer.parseInt(sjleixingId));
            }
//            if (StringUtils.hasText(shujuType)) {
//                shuju.setShujutype(Integer.parseInt(shujuType));
//            }
//            if (StringUtils.hasText(shujuType1)) {
//                shuju.setShujutype1(Integer.parseInt(shujuType1));
//            }
//            if (StringUtils.hasText(sjxingtaiId)) {
//                shuju.setSjxingtaiid(Integer.parseInt(sjxingtaiId));
//            }
//            if (StringUtils.hasText(shujuZong2)) {
//                shuju.setShujuZong2(Integer.parseInt(shujuZong2));
//            }
//            if (StringUtils.hasText(userId)) {
//                shuju.setUserId(Integer.parseInt(userId));
//            }
//            if (StringUtils.hasText(bumenId)) {
//                shuju.setBumenId(Integer.parseInt(bumenId));
//            }
//            if (StringUtils.hasText(buyuanId)) {
//                shuju.setBuyuanId(Integer.parseInt(buyuanId));
//            }
//            if (StringUtils.hasText(buzhiId)) {
//                shuju.setBuzhiId(Integer.parseInt(buzhiId));
//            }
//            if (StringUtils.hasText(yonghuId)) {
//                shuju.setYonghuId(Integer.parseInt(yonghuId));
//            }
//            if (StringUtils.hasText(byuyuanId)) {
//                shuju.setByuyuanId(Integer.parseInt(byuyuanId));
//            }
//            if (StringUtils.hasText(byumenId)) {
//                shuju.setByumenId(Integer.parseInt(byumenId));
//            }
//            if (StringUtils.hasText(byuzhiId)) {
//                shuju.setByuzhiId(Integer.parseInt(byuzhiId));
//            }
//            if (StringUtils.hasText(sdate1)) {
//                Date date = new Date();
//                sdate1 = DateUtil.formatDate(date, "yyyy-MM-dd HH:mm:ss");
//            }
//            if (StringUtils.hasText(edate1)) {
//                Date date = new Date();
//                edate1 = DateUtil.formatDate(date, "yyyy-MM-dd HH:mm:ss");
//            }
            JSONArray jsonArray = JSONArray.fromObject(
                    shujuService.queryShujus(
                            shuju, pageBean.getStart(), pageBean.getRows()));
            JSONObject result = new JSONObject();
            int total = shujuService.queryShujus(shuju, 0, 0).size();
            result.put("rows", jsonArray);
            result.put("total", total);
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/addShuju")
    public void addShuju(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            JSONObject result = new JSONObject();

            String shujuName = request.getParameter("shujuName");
            String shujuMark = request.getParameter("shujuMark");
            String shujuMark1 = request.getParameter("shujuMark1");
            String shujuMark2 = request.getParameter("shujuMark2");
            String shujuMark3 = request.getParameter("shujuMark3");
            String shujuDate = request.getParameter("shujuDate");
            String shujuDate1 = request.getParameter("shujuDate1");
            String shujuZong = request.getParameter("shujuZong");
            String shujuZong1 = request.getParameter("shujuZong1");
            String shujuZong2 = request.getParameter("shujuZong2");
            String shujuType = request.getParameter("shujuType");
            String shujuType1 = request.getParameter("shujuType1");
            String shujuType2 = request.getParameter("shujuType2");
            String sjleixingId = request.getParameter("sjleixingId");
            String sjxingtaiId = request.getParameter("sjxingtaiId");
            String shujuDouble = request.getParameter("shujuDouble");
            String shujuDouble1 = request.getParameter("shujuDouble1");
            String shujuDouble2 = request.getParameter("shujuDouble2");
            String shujuDouble3 = request.getParameter("shujuDouble3");
            String shujuDouble4 = request.getParameter("shujuDouble4");
            String yonghuId = request.getParameter("yonghuId");
            String userId = request.getParameter("userId");
            String buzhiId = request.getParameter("buzhiId");
            String shujuId = request.getParameter("shujuId");
            ShujuPojo shuju = new ShujuPojo();

            if (StringUtils.hasText(shujuId)) {
                shuju = shujuService.getShuju(Integer.parseInt(shujuId));
            }
            if (StringUtils.hasText(shujuName)) {
                shuju.setShujuname(shujuName);
            }
            if (StringUtils.hasText(shujuMark)) {
                shuju.setShujumark(shujuMark);
            }
            if (StringUtils.hasText(shujuMark1)) {
                shuju.setShujumark1(shujuMark1);
            }
            if (StringUtils.hasText(shujuMark2)) {
                shuju.setShujumark2(shujuMark2);
            }
            if (StringUtils.hasText(shujuMark3)) {
                shuju.setShujumark3(shujuMark3);
            }
            if (StringUtils.hasText(shujuDate)) {
                shuju.setShujudate(DateUtil.formatString(shujuDate,
                        "yyyy-MM-dd hh:mm:ss"));
            }
            if (StringUtils.hasText(shujuDate1)) {
                shuju.setShujudate1(DateUtil.formatString(shujuDate1,
                        "yyyy-MM-dd hh:mm:ss"));
            }
            if (StringUtils.hasText(shujuZong)) {
                shuju.setShujuzong(Integer.parseInt(shujuZong));
            }
            if (StringUtils.hasText(shujuZong1)) {
                shuju.setShujuzong1(Integer.parseInt(shujuZong1));
            }
            if (StringUtils.hasText(shujuZong2)) {
                shuju.setShujuzong2(Integer.parseInt(shujuZong2));
            }
            if (StringUtils.hasText(shujuType)) {
                shuju.setShujutype(Integer.parseInt(shujuType));
            }
            if (StringUtils.hasText(shujuType1)) {
                shuju.setShujutype1(Integer.parseInt(shujuType1));
            }
            if (StringUtils.hasText(shujuType2)) {
                shuju.setShujutype2(Integer.parseInt(shujuType2));
            }
            if (StringUtils.hasText(shujuDouble)) {
                shuju.setShujudouble(Double.parseDouble(shujuDouble));
            }
            if (StringUtils.hasText(shujuDouble1)) {
                shuju.setShujudouble1(Double.parseDouble(shujuDouble1));
            }
            if (StringUtils.hasText(shujuDouble2)) {
                shuju.setShujudouble2(Double.parseDouble(shujuDouble2));
            }
            if (StringUtils.hasText(shujuDouble3)) {
                shuju.setShujudouble3(Double.parseDouble(shujuDouble3));
            }
            if (StringUtils.hasText(shujuDouble4)) {
                shuju.setShujudouble4(Double.parseDouble(shujuDouble4));
            }
            if (StringUtils.hasText(sjleixingId)) {
                shuju.setSjleixingid(Integer.parseInt(sjleixingId));
                LeiXingPojo sjleixing = typeService.getSjleixing(Integer.parseInt(sjleixingId));
                shuju.setSjleixingname(sjleixing.getSjleixingname());
            }
//            if (StringUtils.hasText(sjxingtaiId)) {
//                shuju.setSjxingtaiId(Integer.parseInt(sjxingtaiId));
//                Sjxingtai sjxingtai = new Sjxingtai();
//                sjxingtai = sjxingtaiService.getSjxingtai(Integer.parseInt(sjxingtaiId));
//                shuju.setSjxingtaiName(sjxingtai.getSjxingtaiName());
//            }
            if (StringUtils.hasText(yonghuId)) {
                shuju.setYonghuid(Integer.parseInt(yonghuId));
                YongHuPojo yonghu = yonghuService.getYonghu(Integer.parseInt(yonghuId));
                shuju.setYonghuname(yonghu.getYonghuname());
                shuju.setByumenid(yonghu.getByumenid());
                shuju.setByumenname(yonghu.getByumenname());
                shuju.setByuyuanid(yonghu.getByuyuanid());
                shuju.setByuyuanname(yonghu.getByuyuanname());
                shuju.setByuzhiid(yonghu.getByuzhiid());
                shuju.setByuzhiname(yonghu.getByuzhiname());
                shuju.setUserid(yonghu.getUserid());
                shuju.setUsername(yonghu.getUsername());
                shuju.setBumenid(yonghu.getBumenid());
                shuju.setBumenname(yonghu.getBumenname());
                shuju.setBuyuanid(yonghu.getBuyuanid());
                shuju.setBuyuanname(yonghu.getBuyuanname());
                shuju.setBuzhiid(yonghu.getBuzhiid());
                shuju.setBuzhiname(yonghu.getBuzhiname());
            }
            if (StringUtils.hasText(userId)) {
                shuju.setUserid(Integer.parseInt(userId));
                UserPojo user =  userService.getUser(Integer.parseInt(userId));
                shuju.setUsername(user.getUsername());
//                shuju.setBumenId(user.getBumenId());
//                shuju.setBumenName(user.getBumenName());
//                shuju.setBuyuanId(user.getBuyuanId());
//                shuju.setBuyuanName(user.getBuyuanName());
//                shuju.setBuzhiId(user.getBuzhiId());
//                shuju.setBuzhiName(user.getBuzhiName());
            }
//            if (StringUtils.hasText(buzhiId)) {
//                shuju.setBuzhiId(Integer.parseInt(buzhiId));
//                Buzhi buzhi = new Buzhi();
//                buzhi = buzhiService.getBuzhi(Integer.parseInt(buzhiId));
//                shuju.setBuzhiName(buzhi.getBuzhiName());
//                shuju.setBumenId(buzhi.getBumenId());
//                shuju.setBumenName(buzhi.getBumenName());
//                shuju.setBuyuanId(buzhi.getBuyuanId());
//                shuju.setBuyuanName(buzhi.getBuyuanName());
//            }
            if (StringUtils.hasText(shujuId)) {
                shujuService.modifyShuju(shuju);
                result.put("success", "true");
                ResponseUtil.write(response, result);
            } else {
                Date date = new Date();
                shuju.setShujudate(date);
                shuju.setShujutype(0);
                shuju.setShujudouble1(0.0);
                shuju.setShujudouble2(0.0);
                shujuService.save(shuju);
                result.put("success", "true");
                ResponseUtil.write(response, result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/deleteShuju")
    public void deleteShuju(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        JSONObject result = new JSONObject();
        String delIds = request.getParameter("delIds");
        try {
            String str[] = delIds.split(",");
            for (int i = 0; i < str.length; i++) {
                shujuService.deleteShuju(Integer.parseInt(str[i]));
            }
            result.put("success", "true");
            result.put("delNums", str.length);
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/shujuComboList")
    public void shujuComboList(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String shujuName = request.getParameter("shujuName");
        String shujuId = request.getParameter("shujuId");
//        String shujuType = request.getParameter("shujuType");
//        String shujuType1 = request.getParameter("shujuType1");
//        String sjleixingId = request.getParameter("sjleixingId");
//        String sjxingtaiId = request.getParameter("sjxingtaiId");
//        String shujuZong2 = request.getParameter("shujuZong2");
//        String yonghuId = request.getParameter("yonghuId");
//        String byumenId = request.getParameter("byumenId");
//        String byuyuanId = request.getParameter("byuyuanId");
//        String byuzhiId = request.getParameter("byuzhiId");
//        String userId = request.getParameter("userId");
//        String bumenId = request.getParameter("bumenId");
//        String buyuanId = request.getParameter("buyuanId");
//        String buzhiId = request.getParameter("buzhiId");
        ShujuPojo shuju = new ShujuPojo();
        try {
            if (StringUtils.hasText(shujuId)) {
                shuju.setShujuid(Integer.parseInt(shujuId));
            }
            if (StringUtils.hasText(shujuName)) {
                shuju.setShujuname(shujuName);
            }
//            if (StringUtils.hasText(shujuType)) {
//                shuju.setShujuType(Integer.parseInt(shujuType));
//            }
//            if (StringUtils.hasText(shujuType1)) {
//                shuju.setShujuType1(Integer.parseInt(shujuType1));
//            }
//            if (StringUtils.hasText(sjleixingId)) {
//                shuju.setSjleixingId(Integer.parseInt(sjleixingId));
//            }
//            if (StringUtils.hasText(sjxingtaiId)) {
//                shuju.setSjxingtaiId(Integer.parseInt(sjxingtaiId));
//            }
//            if (StringUtils.hasText(shujuZong2)) {
//                shuju.setShujuZong2(Integer.parseInt(shujuZong2));
//            }
//            if (StringUtils.hasText(userId)) {
//                shuju.setUserId(Integer.parseInt(userId));
//            }
//            if (StringUtils.hasText(bumenId)) {
//                shuju.setBumenId(Integer.parseInt(bumenId));
//            }
//            if (StringUtils.hasText(buyuanId)) {
//                shuju.setBuyuanId(Integer.parseInt(buyuanId));
//            }
//            if (StringUtils.hasText(buzhiId)) {
//                shuju.setBuzhiId(Integer.parseInt(buzhiId));
//            }
//            if (StringUtils.hasText(yonghuId)) {
//                shuju.setYonghuId(Integer.parseInt(yonghuId));
//            }
//            if (StringUtils.hasText(byuyuanId)) {
//                shuju.setByuyuanId(Integer.parseInt(byuyuanId));
//            }
//            if (StringUtils.hasText(byumenId)) {
//                shuju.setByumenId(Integer.parseInt(byumenId));
//            }
//            if (StringUtils.hasText(byuzhiId)) {
//                shuju.setByuzhiId(Integer.parseInt(byuzhiId));
//            }
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", "");
            jsonObject.put("value", "请选择...");
            jsonArray.add(jsonObject);
            jsonArray.addAll(JSONArray.fromObject(shujuService.queryShujus(shuju,
                    0, 0)
                    .stream()
                    .map(dc -> new SelectListItem(dc.getShujuid(), dc.getShujuname()))
                    .collect(Collectors.toList())));
            ResponseUtil.write(response, jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/shujuTongji")
    public void shujuTongji(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        String sdate = request.getParameter("sdate");
//        String edate = request.getParameter("edate");
        String userId = request.getParameter("userId");
        String tijiaoUrl = "shujuTongji";
        List<Integer> sjleixingIds = new ArrayList<Integer>();
        List<String> tongjiNames = new ArrayList<String>();
        List<Double> tongjiZongshus = new ArrayList<Double>();
        List<LeiXingPojo> sjleixings = new ArrayList<LeiXingPojo>();
        List<ShujuPojo> shujus = new ArrayList<ShujuPojo>();
        Double zongshu = 0.0;
        ShujuPojo shuju = new ShujuPojo();
        if (StringUtils.hasText(userId)) {
            shuju.setUserid(Integer.parseInt(userId));
        }
        try {
            sjleixings = typeService.querySjleixings(null, 0, 0);
            for (int i = 0; i < sjleixings.size(); i++) {
                sjleixingIds.add(sjleixings.get(i).getSjleixingid());
                tongjiNames.add(sjleixings.get(i).getSjleixingname());
            }
            for (int i = 0; i < sjleixingIds.size(); i++) {
                Double shujuZongshu = 0.0;
                shuju.setSjleixingid(sjleixingIds.get(i));
                shujus = shujuService.queryShujus(shuju, 0, 0);
                for (int j = 0; j < shujus.size(); j++) {
                    shujuZongshu = shujuZongshu + shujus.get(j).getShujuzong();
                }
                zongshu = zongshu + shujuZongshu;
                tongjiZongshus.add(shujuZongshu);
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

    @RequestMapping("/shangchuanShuju")
    public void shangchuanShuju(HttpServletRequest request, HttpServletResponse response, MultipartFile uploadFile)
            throws Exception {
        try {
            String shujuId = request.getParameter("shujuId");
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
            ShujuPojo shuju = shujuService.getShuju(Integer.parseInt(shujuId));
            shuju.setShujuimg(shangchuandizhi);
            shuju.setShujuimgname(shangchuanname);
            shujuService.modifyShuju(shuju);
            JSONObject result = new JSONObject();
            result.put("success", "true");
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @RequestMapping("/daoruShuju")
//    public void daoruShuju(HttpServletRequest request, HttpServletResponse response, MultipartFile uploadFile)
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
//                String shujuName = row.get(0);
//                String sjleixingId = row.get(1);
//                String shujuZong = row.get(2);
//                String shujuMark = row.get(3);
//                String userId = row.get(4);
//                ShujuPojo shuju = new ShujuPojo();
//
//                if (StringUtils.hasText(shujuName)) {
//                    shuju.setShujuName(shujuName);
//                }
//                if (StringUtils.hasText(sjleixingId)) {
//                    shuju.setSjleixingId(Integer.parseInt(sjleixingId));
//                    Sjleixing sjleixing = new Sjleixing();
//                    sjleixing = sjleixingService.getSjleixing(Integer.parseInt(sjleixingId));
//                    shuju.setSjleixingname(sjleixing.getSjleixingName());
//                }
//                if (StringUtils.hasText(shujuZong)) {
//                    shuju.setShujuZong(Integer.parseInt(shujuZong));
//                }
//                if (StringUtils.hasText(shujuMark)) {
//                    shuju.setShujuMark(shujuMark);
//                }
//                if (StringUtils.hasText(userId)) {
//                    shuju.setUserId(Integer.parseInt(userId));
//                    User user = new User();
//                    user = userService.getUser(Integer.parseInt(userId));
//                    shuju.setUsername(user.getUserName());
//                    shuju.setBumenid(user.getBumenId());
//                    shuju.setBumenname(user.getBumenName());
//                    shuju.setBuyuanid(user.getBuyuanId());
//                    shuju.setBuyuanname(user.getBuyuanName());
//                    shuju.setBuzhiid(user.getBuzhiid());
//                    shuju.setBuzhiname(user.getBuzhiname());
//                }
//                Date date = new Date();
//                shuju.setShujudate(date);
//                shujuService.save(shuju);
//            }
//            JSONObject result = new JSONObject();
//            result.put("success", "true");
//            ResponseUtil.write(response, result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @RequestMapping("/daochuShuju")
//    public void daochuShuju(HttpServletRequest request, HttpServletResponse response)
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
//            ShujuPojo shuju = new ShujuPojo();
//            for (int i = 0; i < str.length; i++) {
//                List<String> row = new ArrayList<String>();
//                shuju = shujuService.getShuju(Integer.parseInt(str[i]));
//                row.add(TypeUtil.toString(i + 1));
//                row.add(shuju.getShujuName());
//                row.add(shuju.getSjleixingName());
//                row.add(shuju.getShujuZong().toString());
//                row.add(shuju.getShujuMark());
//                row.add(shuju.getUserName());
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
