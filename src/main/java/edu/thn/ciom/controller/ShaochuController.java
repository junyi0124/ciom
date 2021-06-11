package edu.thn.ciom.controller;

import edu.thn.ciom.pojo.ShaoChuPojo;
import edu.thn.ciom.pojo.ShujuPojo;
// import edu.thn.ciom.pojo.UserPojo;
import edu.thn.ciom.pojo.YongHuPojo;
import edu.thn.ciom.service.ShaochuService;
import edu.thn.ciom.service.ShujuService;
import edu.thn.ciom.service.UserService;
import edu.thn.ciom.service.YonghuService;
// import edu.thn.ciom.util.DateUtil;
import edu.thn.ciom.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ShaochuController {

    @Autowired
    private ShaochuService shaochuService;

    @Autowired
    private YonghuService yonghuService;

    // @Autowired
    // private UserService userService;

    @Autowired
    private ShujuService shujuService;

    @RequestMapping("/getSjshaochus")
    public void getSjshaochus(HttpServletRequest request,
                              HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
//        String sjshaochuName = request.getParameter("sjshaochuName");
        String sjshaochuId = request.getParameter("sjshaochuId");
//        String sjshaochuType = request.getParameter("sjshaochuType");
//        String sjshaochuType1 = request.getParameter("sjshaochuType1");
//        String sjshaochuType2 = request.getParameter("sjshaochuType2");
//        String sjlaiyuanId = request.getParameter("sjlaiyuanId");
//        String sjqitaId = request.getParameter("sjqitaId");
        String shujuId = request.getParameter("shujuId");
//        String sjleixingId = request.getParameter("sjleixingId");
//        String sjxingtaiId = request.getParameter("sjxingtaiId");
//        String yonghuId = request.getParameter("yonghuId");
//        String byumenId = request.getParameter("byumenId");
//        String byuyuanId = request.getParameter("byuyuanId");
//        String byuzhiId = request.getParameter("byuzhiId");
        String userId = request.getParameter("userid");
//        String bumenId = request.getParameter("bumenId");
//        String buyuanId = request.getParameter("buyuanId");
//        String buzhiId = request.getParameter("buzhiId");
//        String sdate = request.getParameter("sdate");
//        String edate = request.getParameter("edate");
//        String sdate1 = request.getParameter("sdate1");
//        String edate1 = request.getParameter("edate1");
        ShaoChuPojo sjshaochu = new ShaoChuPojo();
        PageBean pageBean = null;
        if ((StringUtils.hasText(page)) && (!page.equals("null"))) {
            pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        } else {
            pageBean = new PageBean(0, 0);
        }
        try {
            if (StringUtils.hasText(sjshaochuId)) {
                sjshaochu.setSjshaochuid(Integer.parseInt(sjshaochuId));
            }
//            if (StringUtils.hasText(sjshaochuName)) {
//                sjshaochu.setSjshaochuname(sjshaochuName);
//            }
//            if (StringUtils.hasText(sjshaochuType)) {
//                sjshaochu.setSjshaochutype(Integer.parseInt(sjshaochuType));
//            }
//            if (StringUtils.hasText(sjshaochuType1)) {
//                sjshaochu.setSjshaochutype1(Integer.parseInt(sjshaochuType1));
//            }
//            if (StringUtils.hasText(sjshaochuType2)) {
//                sjshaochu.setSjshaochutype2(Integer.parseInt(sjshaochuType2));
//            }
//            if (StringUtils.hasText(sjlaiyuanId)) {
//                sjshaochu.setSjlaiyuanId(Integer.parseInt(sjlaiyuanId));
//            }
//            if (StringUtils.hasText(sjqitaId)) {
//                sjshaochu.setSjqitaId(Integer.parseInt(sjqitaId));
//            }
//            if (StringUtils.hasText(shujuId)) {
//                sjshaochu.setShujuId(Integer.parseInt(shujuId));
//            }
//            if (StringUtils.hasText(sjleixingId)) {
//                sjshaochu.setSjleixingId(Integer.parseInt(sjleixingId));
//            }
//            if (StringUtils.hasText(sjxingtaiId)) {
//                sjshaochu.setSjxingtaiId(Integer.parseInt(sjxingtaiId));
//            }
//            if (StringUtils.hasText(userId)) {
//                sjshaochu.setUserId(Integer.parseInt(userId));
//            }
//            if (StringUtils.hasText(bumenId)) {
//                sjshaochu.setBumenId(Integer.parseInt(bumenId));
//            }
//            if (StringUtils.hasText(buyuanId)) {
//                sjshaochu.setBuyuanId(Integer.parseInt(buyuanId));
//            }
//            if (StringUtils.hasText(buzhiId)) {
//                sjshaochu.setBuzhiId(Integer.parseInt(buzhiId));
//            }
//            if (StringUtils.hasText(yonghuId)) {
//                sjshaochu.setYonghuId(Integer.parseInt(yonghuId));
//            }
//            if (StringUtils.hasText(byuyuanId)) {
//                sjshaochu.setByuyuanId(Integer.parseInt(byuyuanId));
//            }
//            if (StringUtils.hasText(byumenId)) {
//                sjshaochu.setByumenId(Integer.parseInt(byumenId));
//            }
//            if (StringUtils.hasText(byuzhiId)) {
//                sjshaochu.setByuzhiId(Integer.parseInt(byuzhiId));
//            }
//            if (StringUtils.hasText(sdate1)) {
//                Date date = new Date();
//                sdate1 = DateUtil.formatDate(date, "yyyy-MM-dd HH:mm:ss");
//            }
//            if (StringUtils.hasText(edate1)) {
//                Date date = new Date();
//                edate1 = DateUtil.formatDate(date, "yyyy-MM-dd HH:mm:ss");
//            }
            JSONArray jsonArray = JSONArray.fromObject(shaochuService.querySjshaochus(
                    sjshaochu, pageBean.getStart(), pageBean.getRows()));
            JSONObject result = new JSONObject();
            int total = shaochuService.querySjshaochus(sjshaochu, 0, 0).size();
            result.put("rows", jsonArray);
            result.put("total", total);
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/addSjshaochu")
    public void addSjshaochu(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONObject result = new JSONObject();
        try {

            String shujuId = request.getParameter("shujuid");
            String yonghuId = request.getParameter("yonghuid");
            String sjshaochuDouble = request.getParameter("sjshaochudouble");

            String sjshaochuId = request.getParameter("sjshaochuid");
//            String sjshaochuName = request.getParameter("sjshaochuName");
//            String sjshaochuMark = request.getParameter("sjshaochuMark");
//            String sjshaochuMark1 = request.getParameter("sjshaochuMark1");
//            String sjshaochuMark2 = request.getParameter("sjshaochuMark2");
//            String sjshaochuMark3 = request.getParameter("sjshaochuMark3");
//            String sjshaochuDate = request.getParameter("sjshaochuDate");
//            String sjshaochuDate1 = request.getParameter("sjshaochuDate1");
//            String sjshaochuZong = request.getParameter("sjshaochuZong");
//            String sjshaochuZong1 = request.getParameter("sjshaochuZong1");
//            String sjshaochuZong2 = request.getParameter("sjshaochuZong2");
//            String sjshaochuDouble1 = request.getParameter("sjshaochuDouble1");
//            String sjshaochuDouble2 = request.getParameter("sjshaochuDouble2");
//            String sjshaochuType = request.getParameter("sjshaochuType");
//            String sjshaochuType1 = request.getParameter("sjshaochuType1");
//            String sjshaochuType2 = request.getParameter("sjshaochuType2");
//            String sjqitaId = request.getParameter("sjqitaId");
//            String sjlaiyuanId = request.getParameter("sjlaiyuanId");
//            String userId = request.getParameter("userId");
            ShaoChuPojo sjshaochu;

            if (StringUtils.hasText(sjshaochuId)) {
                sjshaochu = shaochuService.getSjshaochu(Integer.parseInt(sjshaochuId));
            }else{
                sjshaochu = new ShaoChuPojo();
            }

//            if (StringUtils.hasText(sjshaochuName)) {
//                sjshaochu.setSjshaochuname(sjshaochuName);
//            }
//            if (StringUtils.hasText(sjshaochuMark)) {
//                sjshaochu.setSjshaochumark(sjshaochuMark);
//            }
//            if (StringUtils.hasText(sjshaochuMark1)) {
//                sjshaochu.setSjshaochumark1(sjshaochuMark1);
//            }
//            if (StringUtils.hasText(sjshaochuMark2)) {
//                sjshaochu.setSjshaochumark2(sjshaochuMark2);
//            }
//            if (StringUtils.hasText(sjshaochuMark3)) {
//                sjshaochu.setSjshaochumark3(sjshaochuMark3);
//            }
//            if (StringUtils.hasText(sjshaochuDate)) {
//                sjshaochu.setSjshaochudate(DateUtil.formatString(sjshaochuDate,
//                        "yyyy-MM-dd hh:mm:ss"));
//            }
//            if (StringUtils.hasText(sjshaochuDate1)) {
//                sjshaochu.setSjshaochudate1(DateUtil.formatString(sjshaochuDate1,
//                        "yyyy-MM-dd hh:mm:ss"));
//            }
//            if (StringUtils.hasText(sjshaochuZong)) {
//                sjshaochu.setSjshaochuzong(Integer.parseInt(sjshaochuZong));
//            }
//            if (StringUtils.hasText(sjshaochuZong1)) {
//                sjshaochu.setSjshaochuzong1(Integer.parseInt(sjshaochuZong1));
//            }
//            if (StringUtils.hasText(sjshaochuZong2)) {
//                sjshaochu.setSjshaochuzong2(Integer.parseInt(sjshaochuZong2));
//            }
            if (StringUtils.hasText(sjshaochuDouble)) {
                sjshaochu.setSjshaochudouble(Double.parseDouble(sjshaochuDouble));
            }
//            if (StringUtils.hasText(sjshaochuDouble1)) {
//                sjshaochu.setSjshaochudouble1(Double.parseDouble(sjshaochuDouble1));
//            }
//            if (StringUtils.hasText(sjshaochuDouble2)) {
//                sjshaochu.setSjshaochudouble2(Double.parseDouble(sjshaochuDouble2));
//            }
//            if (StringUtils.hasText(sjshaochuType)) {
//                sjshaochu.setSjshaochutype(Integer.parseInt(sjshaochuType));
//            }
//            if (StringUtils.hasText(sjshaochuType1)) {
//                sjshaochu.setSjshaochutype1(Integer.parseInt(sjshaochuType1));
//            }
//            if (StringUtils.hasText(sjshaochuType2)) {
//                sjshaochu.setSjshaochutype2(Integer.parseInt(sjshaochuType2));
//            }
            if (StringUtils.hasText(shujuId)) {
                sjshaochu.setShujuid(Integer.parseInt(shujuId));
                ShujuPojo shuju = new ShujuPojo();
                shuju = shujuService.getShuju(Integer.parseInt(shujuId));
                sjshaochu.setShujuname(shuju.getShujuname());
                sjshaochu.setSjleixingid(shuju.getSjleixingid());
                sjshaochu.setSjleixingname(shuju.getSjleixingname());
                sjshaochu.setUserid(shuju.getUserid());
                sjshaochu.setUsername(shuju.getUsername());
//                sjshaochu.setBumenId(shuju.getBumenId());
//                sjshaochu.setBumenName(shuju.getBumenName());
//                sjshaochu.setBuyuanId(shuju.getBuyuanId());
//                sjshaochu.setBuyuanName(shuju.getBuyuanName());
                sjshaochu.setBuzhiid(shuju.getBuzhiid());
                sjshaochu.setBuzhiname(shuju.getBuzhiname());
            }

            if (StringUtils.hasText(yonghuId)) {
                sjshaochu.setYonghuid(Integer.parseInt(yonghuId));
                YongHuPojo yonghu = new YongHuPojo();
                yonghu = yonghuService.getYonghu(Integer.parseInt(yonghuId));
                sjshaochu.setYonghuname(yonghu.getYonghuname());
//                sjshaochu.setBuzhiId(yonghu.getBuzhiId());
//                sjshaochu.setBuzhiName(yonghu.getBuzhiName());
            }
//            if (StringUtils.hasText(userId)) {
//                sjshaochu.setUserid(Integer.parseInt(userId));
//                UserPojo user = new UserPojo();
//                user = userService.getUser(Integer.parseInt(userId));
//                sjshaochu.setUsername(user.getUsername());
//                sjshaochu.setBumenId(user.getBumenId());
//                sjshaochu.setBumenName(user.getBumenName());
//                sjshaochu.setBuyuanId(user.getBuyuanId());
//                sjshaochu.setBuyuanName(user.getBuyuanName());
//                sjshaochu.setBuzhiId(user.getBuzhiId());
//                sjshaochu.setBuzhiName(user.getBuzhiName());
//            }
//            if (StringUtils.hasText(sjqitaId)) {
//                sjshaochu.setSjqitaId(Integer.parseInt(sjqitaId));
//                Sjqita sjqita = new Sjqita();
//                sjqita = sjqitaService.getSjqita(Integer.parseInt(sjqitaId));
//                sjshaochu.setSjqitaName(sjqita.getSjqitaName());
//            }
//            if (StringUtils.hasText(sjlaiyuanId)) {
//                sjshaochu.setSjlaiyuanId(Integer.parseInt(sjlaiyuanId));
//                Sjlaiyuan sjlaiyuan = new Sjlaiyuan();
//                sjlaiyuan = sjlaiyuanService.getSjlaiyuan(Integer.parseInt(sjlaiyuanId));
//                sjshaochu.setSjlaiyuanName(sjlaiyuan.getSjlaiyuanName());
//            }
            if (StringUtils.hasText(sjshaochuId)) {
                shaochuService.modifySjshaochu(sjshaochu);
                result.put("success", "true");
                ResponseUtil.write(response, result);
            } else {
                Date date = new Date();
                sjshaochu.setSjshaochudate(date);
                sjshaochu.setSjshaochutype(0);
                shaochuService.save(sjshaochu);
                result.put("success", "true");
                ResponseUtil.write(response, result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/deleteSjshaochu")
    public void deleteSjshaochu(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        JSONObject result = new JSONObject();
        String delIds = request.getParameter("delIds");
        try {
            String str[] = delIds.split(",");
            for (int i = 0; i < str.length; i++) {
                shaochuService.deleteSjshaochu(Integer.parseInt(str[i]));
            }
            result.put("success", "true");
            result.put("delNums", str.length);
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/sjshaochuComboList")
    public void sjshaochuComboList(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String sjshaochuId = request.getParameter("sjshaochuId");
        String sjshaochuName = request.getParameter("sjshaochuName");
//        String sjshaochuType = request.getParameter("sjshaochuType");
//        String sjshaochuType1 = request.getParameter("sjshaochuType1");
//        String sjshaochuType2 = request.getParameter("sjshaochuType2");
//        String sjlaiyuanId = request.getParameter("sjlaiyuanId");
//        String sjqitaId = request.getParameter("sjqitaId");
//        String shujuId = request.getParameter("shujuId");
//        String sjleixingId = request.getParameter("sjleixingId");
//        String sjxingtaiId = request.getParameter("sjxingtaiId");
//        String yonghuId = request.getParameter("yonghuId");
//        String byumenId = request.getParameter("byumenId");
//        String byuyuanId = request.getParameter("byuyuanId");
//        String byuzhiId = request.getParameter("byuzhiId");
//        String userId = request.getParameter("userId");
//        String bumenId = request.getParameter("bumenId");
//        String buyuanId = request.getParameter("buyuanId");
//        String buzhiId = request.getParameter("buzhiId");
        ShaoChuPojo sjshaochu = new ShaoChuPojo();
        try {
            if (StringUtils.hasText(sjshaochuName)) {
                sjshaochu.setSjshaochuname(sjshaochuName);
            }
            if (StringUtils.hasText(sjshaochuId)) {
                sjshaochu.setSjshaochuid(Integer.parseInt(sjshaochuId));
            }
//            if (StringUtils.hasText(sjshaochuType)) {
//                sjshaochu.setSjshaochuType(Integer.parseInt(sjshaochuType));
//            }
//            if (StringUtils.hasText(sjshaochuType1)) {
//                sjshaochu.setSjshaochuType1(Integer.parseInt(sjshaochuType1));
//            }
//            if (StringUtils.hasText(sjshaochuType2)) {
//                sjshaochu.setSjshaochuType2(Integer.parseInt(sjshaochuType2));
//            }
//            if (StringUtils.hasText(sjlaiyuanId)) {
//                sjshaochu.setSjlaiyuanId(Integer.parseInt(sjlaiyuanId));
//            }
//            if (StringUtils.hasText(sjqitaId)) {
//                sjshaochu.setSjqitaId(Integer.parseInt(sjqitaId));
//            }
//            if (StringUtils.hasText(shujuId)) {
//                sjshaochu.setShujuId(Integer.parseInt(shujuId));
//            }
//            if (StringUtils.hasText(sjleixingId)) {
//                sjshaochu.setSjleixingId(Integer.parseInt(sjleixingId));
//            }
//            if (StringUtils.hasText(sjxingtaiId)) {
//                sjshaochu.setSjxingtaiId(Integer.parseInt(sjxingtaiId));
//            }
//            if (StringUtils.hasText(userId)) {
//                sjshaochu.setUserId(Integer.parseInt(userId));
//            }
//            if (StringUtils.hasText(bumenId)) {
//                sjshaochu.setBumenId(Integer.parseInt(bumenId));
//            }
//            if (StringUtils.hasText(buyuanId)) {
//                sjshaochu.setBuyuanId(Integer.parseInt(buyuanId));
//            }
//            if (StringUtils.hasText(buzhiId)) {
//                sjshaochu.setBuzhiId(Integer.parseInt(buzhiId));
//            }
//            if (StringUtils.hasText(yonghuId)) {
//                sjshaochu.setYonghuId(Integer.parseInt(yonghuId));
//            }
//            if (StringUtils.hasText(byuyuanId)) {
//                sjshaochu.setByuyuanId(Integer.parseInt(byuyuanId));
//            }
//            if (StringUtils.hasText(byumenId)) {
//                sjshaochu.setByumenId(Integer.parseInt(byumenId));
//            }
//            if (StringUtils.hasText(byuzhiId)) {
//                sjshaochu.setByuzhiId(Integer.parseInt(byuzhiId));
//            }
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", "");
            jsonObject.put("sjshaochuName", "请选择...");
            jsonArray.add(jsonObject);
            jsonArray.addAll(JSONArray.fromObject(
                    shaochuService.querySjshaochus(sjshaochu, 0, 0)));
            ResponseUtil.write(response, jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/sjshaochuTongji")
    public void sjshaochuTongji(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String sdate = request.getParameter("sdate");
        String edate = request.getParameter("edate");
        String userId = request.getParameter("userId");
        String tijiaoUrl = "shujuTongji";
        List<Integer> shujuIds = new ArrayList<Integer>();
        List<String> tongjiNames = new ArrayList<String>();
        List<Double> tongjiZongshus = new ArrayList<Double>();
        List<ShujuPojo> shujus = new ArrayList<ShujuPojo>();
        List<ShaoChuPojo> sjshaochus = new ArrayList<ShaoChuPojo>();
        Double zongshu = 0.0;
        ShaoChuPojo sjshaochu = new ShaoChuPojo();
        ShujuPojo shuju = new ShujuPojo();
        if (StringUtils.hasText(userId)) {
            shuju.setUserid(Integer.parseInt(userId));
        }
        try {
            shujus = shujuService.queryShujus(shuju, 0, 0);
            for (int i = 0; i < shujus.size(); i++) {
                shujuIds.add(shujus.get(i).getShujuid());
                tongjiNames.add(shujus.get(i).getShujuname());
            }
            for (int i = 0; i < shujuIds.size(); i++) {
                Double sjshaochuZongshu = 0.0;
                sjshaochu.setShujuid(shujuIds.get(i));
                sjshaochus = shaochuService.querySjshaochus(sjshaochu, 0, 0);
                for (int j = 0; j < sjshaochus.size(); j++) {
                    sjshaochuZongshu = sjshaochuZongshu + sjshaochus.get(j).getSjshaochudouble2();
                }
                zongshu = zongshu + sjshaochuZongshu;
                tongjiZongshus.add(sjshaochuZongshu);
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

//    @RequestMapping("/shangchuanSjshaochu")
//    public void shangchuanSjshaochu(HttpServletRequest request, HttpServletResponse response, MultipartFile uploadFile)
//            throws Exception {
//        try {
//            String sjshaochuId = request.getParameter("sjshaochuId");
//            String directory = "/file";
//            String targetDirectory = request.getSession().getServletContext().getRealPath(directory);
//            String fileName = uploadFile.getOriginalFilename();
//            File dir = new File(targetDirectory,fileName);
//            if(!dir.exists()){
//                dir.mkdirs();
//            }
//            //MultipartFile自带的解析方法
//            uploadFile.transferTo(dir);
//
//            String shangchuandizhi = "/file" + "/" + fileName;
//            String shangchuanname = fileName;
//            Sjshaochu sjshaochu = sjshaochuService.getSjshaochu(Integer.parseInt(sjshaochuId));
//            sjshaochu.setSjshaochuImg(shangchuandizhi);
//            sjshaochu.setSjshaochuImgName(shangchuanname);
//            sjshaochuService.modifySjshaochu(sjshaochu);
//            JSONObject result = new JSONObject();
//            result.put("success", "true");
//            ResponseUtil.write(response, result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @RequestMapping("/shipinSjshaochu")
//    public void shipinSjshaochu(HttpServletRequest request, HttpServletResponse response,MultipartFile uploadFile)
//            throws Exception {
//        try {
//            String sjshaochuId = request.getParameter("sjshaochuId");
//            String directory = "/file";
//            String targetDirectory = request.getSession().getServletContext().getRealPath(directory);
//            String fileName = uploadFile.getOriginalFilename();
//            File dir = new File(targetDirectory,fileName);
//            if(!dir.exists()){
//                dir.mkdirs();
//            }
//            //MultipartFile自带的解析方法
//            uploadFile.transferTo(dir);
//
//            String shangchuandizhi = "/file" + "/" + fileName;
//            String shangchuanname = fileName;
//            Sjshaochu sjshaochu = sjshaochuService.getSjshaochu(Integer.parseInt(sjshaochuId));
//            sjshaochu.setByuyuanName(shangchuandizhi);
//            sjshaochu.setYhroleName(shangchuanname);
//            sjshaochu.setSjshaochuType(1);
//            sjshaochuService.modifySjshaochu(sjshaochu);
//            JSONObject result = new JSONObject();
//            result.put("success", "true");
//            ResponseUtil.write(response, result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @RequestMapping("/daoruSjshaochu")
//    public void daoruSjshaochu(HttpServletRequest request, HttpServletResponse response,MultipartFile uploadFile)
//            throws Exception {
//        try {
//            String directory = "/file";
//            String targetDirectory = request.getSession().getServletContext().getRealPath(directory);
//            String fileName = uploadFile.getOriginalFilename();
//            File dir = new File(targetDirectory,fileName);
//            if(!dir.exists()){
//                dir.mkdirs();
//            }
//            //MultipartFile自带的解析方法
//            uploadFile.transferTo(dir);
//            excelFile = new FileInputStream(dir);
//            List<List<String>> list = new ArrayList<List<String>>();
//            list = ExcelUtil.jiexiExcel(excelFile);
//            for (int i = 1; i < list.size(); i++) {
//                List<String> row = list.get(i);
//                String sjshaochuName = row.get(0);
//                String sjleixingId = row.get(1);
//                String sjshaochuZong = row.get(2);
//                String sjshaochuMark = row.get(3);
//                String userId = row.get(4);
//                Sjshaochu sjshaochu = new Sjshaochu();
//
//                if (StringUtils.hasText(sjshaochuName)) {
//                    sjshaochu.setSjshaochuName(sjshaochuName);
//                }
//                if (StringUtils.hasText(sjleixingId)) {
//                    sjshaochu.setSjleixingId(Integer.parseInt(sjleixingId));
//                    Sjleixing sjleixing = new Sjleixing();
//                    sjleixing = sjleixingService.getSjleixing(Integer.parseInt(sjleixingId));
//                    sjshaochu.setSjleixingName(sjleixing.getSjleixingName());
//                }
//                if (StringUtils.hasText(sjshaochuZong)) {
//                    sjshaochu.setSjshaochuZong(Integer.parseInt(sjshaochuZong));
//                }
//                if (StringUtils.hasText(sjshaochuMark)) {
//                    sjshaochu.setSjshaochuMark(sjshaochuMark);
//                }
//                if (StringUtils.hasText(userId)) {
//                    sjshaochu.setUserId(Integer.parseInt(userId));
//                    User user = new User();
//                    user = userService.getUser(Integer.parseInt(userId));
//                    sjshaochu.setUserName(user.getUserName());
//                    sjshaochu.setBumenId(user.getBumenId());
//                    sjshaochu.setBumenName(user.getBumenName());
//                    sjshaochu.setBuyuanId(user.getBuyuanId());
//                    sjshaochu.setBuyuanName(user.getBuyuanName());
//                    sjshaochu.setBuzhiId(user.getBuzhiId());
//                    sjshaochu.setBuzhiName(user.getBuzhiName());
//                }
//                Date date = new Date();
//                sjshaochu.setSjshaochuDate(date);
//                sjshaochuService.save(sjshaochu);
//            }
//            JSONObject result = new JSONObject();
//            result.put("success", "true");
//            ResponseUtil.write(response, result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @RequestMapping("/daochuSjshaochu")
//    public void daochuSjshaochu(HttpServletRequest request, HttpServletResponse response)
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
//            Sjshaochu sjshaochu = new Sjshaochu();
//            for (int i = 0; i < str.length; i++) {
//                List<String> row = new ArrayList<String>();
//                sjshaochu = sjshaochuService.getSjshaochu(Integer.parseInt(str[i]));
//                row.add(TypeUtil.toString(i+1));
//                row.add(sjshaochu.getSjshaochuName());
//                row.add(sjshaochu.getSjleixingName());
//                row.add(sjshaochu.getSjshaochuZong().toString());
//                row.add(sjshaochu.getSjshaochuMark());
//                row.add(sjshaochu.getUserName());
//                list.add(row);
//            }
//            if(ExcelUtil.daochuExcle(list, mubanLujing, daochuLujing)){
//                result.put("success", "true");
//                ResponseUtil.write(response, result);
//            }else{
//                result.put("success", "true");
//                result.put("errorMsg", "导出Excel出错！");
//                ResponseUtil.write(response, result);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
