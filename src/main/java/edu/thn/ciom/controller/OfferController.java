package edu.thn.ciom.controller;

import edu.thn.ciom.pojo.DuochuPojo;
import edu.thn.ciom.pojo.ShujuPojo;
import edu.thn.ciom.pojo.UserPojo;
import edu.thn.ciom.pojo.YongHuPojo;
import edu.thn.ciom.service.OfferService;
import edu.thn.ciom.service.ShujuService;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OfferController {

    @Autowired
    private OfferService offerService;

    @Autowired
    private ShujuService shujuService;

    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private UserService userService;

    @RequestMapping("/getSjduochus")
    public void getSjduochus(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        // String sjduochuName = request.getParameter("sjduochuName");
        String sjduochuId = request.getParameter("sjduochuId");
        // String sjduochuType = request.getParameter("sjduochuType");
        // String sjduochuType1 = request.getParameter("sjduochuType1");
        // String sjduochuType2 = request.getParameter("sjduochuType2");
        // String sjlaiyuanId = request.getParameter("sjlaiyuanId");
        // String sjqitaId = request.getParameter("sjqitaId");
        // String shujuId = request.getParameter("shujuId");
        // String sjleixingId = request.getParameter("sjleixingId");
        // String sjxingtaiId = request.getParameter("sjxingtaiId");
        // String yonghuId = request.getParameter("yonghuId");
        // String byumenId = request.getParameter("byumenId");
        // String byuyuanId = request.getParameter("byuyuanId");
        // String byuzhiId = request.getParameter("byuzhiId");
        // String userId = request.getParameter("userId");
        // String bumenId = request.getParameter("bumenId");
        // String buyuanId = request.getParameter("buyuanId");
        // String buzhiId = request.getParameter("buzhiId");
//        String sdate = request.getParameter("sdate");
//        String edate = request.getParameter("edate");
//        String sdate1 = request.getParameter("sdate1");
//        String edate1 = request.getParameter("edate1");

        DuochuPojo sjduochu = new DuochuPojo();

        PageBean pageBean = (StringUtils.hasText(page)) && (!page.equals("null")) ?
                new PageBean(Integer.parseInt(page), Integer.parseInt(rows)):
                new PageBean(0, 0);
        try {
            if (StringUtils.hasText(sjduochuId)) {
                sjduochu.setSjduochuid(Integer.parseInt(sjduochuId));
            }
//            if (StringUtils.hasText(sjduochuName)) {
//                sjduochu.setSjduochuname(sjduochuName);
//            }
//            if (StringUtils.hasText(sjduochuType)) {
//                sjduochu.setSjduochutype(Integer.parseInt(sjduochuType));
//            }
//            if (StringUtils.hasText(sjduochuType1)) {
//                sjduochu.setSjduochutype1(Integer.parseInt(sjduochuType1));
//            }
//            if (StringUtils.hasText(sjduochuType2)) {
//                sjduochu.setSjduochutype2(Integer.parseInt(sjduochuType2));
//            }
//            if (StringUtils.hasText(sjlaiyuanId)) {
//                sjduochu.setSjlaiyuanid(Integer.parseInt(sjlaiyuanId));
//            }
//            if (StringUtils.hasText(sjqitaId)) {
//                sjduochu.setSjqitaid(Integer.parseInt(sjqitaId));
//            }
//            if (StringUtils.hasText(shujuId)) {
//                sjduochu.setShujuid(Integer.parseInt(shujuId));
//            }
//            if (StringUtils.hasText(sjleixingId)) {
//                sjduochu.setSjleixingid(Integer.parseInt(sjleixingId));
//            }
//            if (StringUtils.hasText(sjxingtaiId)) {
//                sjduochu.setSjxingtaiid(Integer.parseInt(sjxingtaiId));
//            }
//            if (StringUtils.hasText(userId)) {
//                sjduochu.setUserid(Integer.parseInt(userId));
//            }
//            if (StringUtils.hasText(bumenId)) {
//                sjduochu.setBumenid(Integer.parseInt(bumenId));
//            }
//            if (StringUtils.hasText(buyuanId)) {
//                sjduochu.setBuyuanid(Integer.parseInt(buyuanId));
//            }
//            if (StringUtils.hasText(buzhiId)) {
//                sjduochu.setBuzhiid(Integer.parseInt(buzhiId));
//            }
//            if (StringUtils.hasText(yonghuId)) {
//                sjduochu.setYonghuid(Integer.parseInt(yonghuId));
//            }
//            if (StringUtils.hasText(byuyuanId)) {
//                sjduochu.setByuyuanid(Integer.parseInt(byuyuanId));
//            }
//            if (StringUtils.hasText(byumenId)) {
//                sjduochu.setByumenid(Integer.parseInt(byumenId));
//            }
//            if (StringUtils.hasText(byuzhiId)) {
//                sjduochu.setByuzhiid(Integer.parseInt(byuzhiId));
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
                    offerService.querySjduochus(
                            sjduochu, pageBean.getStart(), pageBean.getRows()));
            JSONObject result = new JSONObject();
            int total = offerService.querySjduochus(sjduochu, 0, 0).size();
            result.put("rows", jsonArray);
            result.put("total", total);
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/addSjduochu")
    public void addSjduochu(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONObject result = new JSONObject();
        try {
            String shujuId = request.getParameter("shujuid");
//            String sjqitaId = request.getParameter("sjqitaid");
//            String sjlaiyuanId = request.getParameter("sjlaiyuanid");
            String yonghuId = request.getParameter("yonghuid");
            String userId = request.getParameter("userid");
            String sjduochuId = request.getParameter("sjduochuid");
            String sjduochuName = request.getParameter("sjduochuname");
            String sjduochuMark = request.getParameter("sjduochunark");
            String sjduochuMark1 = request.getParameter("sjduochumark1");
            String sjduochuMark2 = request.getParameter("sjduochumark2");
            String sjduochuMark3 = request.getParameter("sjduochumark3");
            String sjduochuDate = request.getParameter("sjduochudate");
            String sjduochuDate1 = request.getParameter("sjduochudate1");
            String sjduochuZong = request.getParameter("sjduochuzong");
            String sjduochuZong1 = request.getParameter("sjduochuzong1");
            String sjduochuZong2 = request.getParameter("sjduochuzong2");
            String sjduochuDouble = request.getParameter("sjduochudouble");
            String sjduochuDouble1 = request.getParameter("sjduochudouble1");
            String sjduochuDouble2 = request.getParameter("sjduochudouble2");
            String sjduochuType = request.getParameter("sjduochutype");
            String sjduochuType1 = request.getParameter("sjduochutype1");
            String sjduochuType2 = request.getParameter("sjduochutype2");
            DuochuPojo sjduochu = new DuochuPojo();

            if (StringUtils.hasText(sjduochuId)) {
                sjduochu = offerService.getSjduochu(Integer.parseInt(sjduochuId));
            }
            if (StringUtils.hasText(sjduochuName)) {
                sjduochu.setSjduochuname(sjduochuName);
            }
            if (StringUtils.hasText(sjduochuMark)) {
                sjduochu.setSjduochumark(sjduochuMark);
            }
            if (StringUtils.hasText(sjduochuMark1)) {
                sjduochu.setSjduochumark1(sjduochuMark1);
            }
            if (StringUtils.hasText(sjduochuMark2)) {
                sjduochu.setSjduochumark2(sjduochuMark2);
            }
            if (StringUtils.hasText(sjduochuMark3)) {
                sjduochu.setSjduochumark3(sjduochuMark3);
            }
            if (StringUtils.hasText(sjduochuDate)) {
                sjduochu.setSjduochudate(DateUtil.formatString(sjduochuDate,
                        "yyyy-MM-dd hh:mm:ss"));
            }
            if (StringUtils.hasText(sjduochuDate1)) {
                sjduochu.setSjduochudate1(DateUtil.formatString(sjduochuDate1,
                        "yyyy-MM-dd hh:mm:ss"));
            }
            if (StringUtils.hasText(sjduochuZong)) {
                sjduochu.setSjduochuzong(Integer.parseInt(sjduochuZong));
            }
            if (StringUtils.hasText(sjduochuZong1)) {
                sjduochu.setSjduochuzong1(Integer.parseInt(sjduochuZong1));
            }
            if (StringUtils.hasText(sjduochuZong2)) {
                sjduochu.setSjduochuzong2(Integer.parseInt(sjduochuZong2));
            }
            if (StringUtils.hasText(sjduochuDouble)) {
                sjduochu.setSjduochudouble(Double.parseDouble(sjduochuDouble));
            }
            if (StringUtils.hasText(sjduochuDouble1)) {
                sjduochu.setSjduochudouble1(Double.parseDouble(sjduochuDouble1));
            }
            if (StringUtils.hasText(sjduochuDouble2)) {
                sjduochu.setSjduochudouble2(Double.parseDouble(sjduochuDouble2));
            }
            if (StringUtils.hasText(sjduochuType)) {
                sjduochu.setSjduochutype(Integer.parseInt(sjduochuType));
            }
            if (StringUtils.hasText(sjduochuType1)) {
                sjduochu.setSjduochutype1(Integer.parseInt(sjduochuType1));
            }
            if (StringUtils.hasText(sjduochuType2)) {
                sjduochu.setSjduochutype2(Integer.parseInt(sjduochuType2));
            }
            if (StringUtils.hasText(shujuId)) {
                sjduochu.setShujuid(Integer.parseInt(shujuId));
                ShujuPojo shuju = new ShujuPojo();
                shuju = shujuService.getShuju(Integer.parseInt(shujuId));
                sjduochu.setShujuname(shuju.getShujuname());
//                sjduochu.setSjleixingId(shuju.getSjleixingId());
//                sjduochu.setSjleixingName(shuju.getSjleixingName());
                sjduochu.setUserid(shuju.getUserid());
                sjduochu.setUsername(shuju.getUsername());
//                sjduochu.setBumenId(shuju.getBumenId());
//                sjduochu.setBumenName(shuju.getBumenName());
//                sjduochu.setBuyuanId(shuju.getBuyuanId());
//                sjduochu.setBuyuanName(shuju.getBuyuanName());
                sjduochu.setBuzhiid(shuju.getBuzhiid());
                sjduochu.setBuzhiname(shuju.getBuzhiname());
            }

            if (StringUtils.hasText(yonghuId)) {
                sjduochu.setYonghuid(Integer.parseInt(yonghuId));
                YongHuPojo yonghu =  yonghuService.getYonghu(Integer.parseInt(yonghuId));
                sjduochu.setYonghuname(yonghu.getYonghuname());
//                sjduochu.setBuzhiId(yonghu.getBuzhiId());
//                sjduochu.setBuzhiName(yonghu.getBuzhiName());
            }
            if (StringUtils.hasText(userId)) {
                sjduochu.setUserid(Integer.parseInt(userId));
                UserPojo user = userService.getUser(Integer.parseInt(userId));
                sjduochu.setUsername(user.getUsername());
//                sjduochu.setBumenId(user.getBumenId());
//                sjduochu.setBumenName(user.getBumenName());
//                sjduochu.setBuyuanId(user.getBuyuanId());
//                sjduochu.setBuyuanName(user.getBuyuanName());
//                sjduochu.setBuzhiId(user.getBuzhiId());
//                sjduochu.setBuzhiName(user.getBuzhiName());
            }
//            if (StringUtils.hasText(sjqitaId)) {
//                sjduochu.setSjqitaid(Integer.parseInt(sjqitaId));
//                Sjqita sjqita = new Sjqita();
//                sjqita = sjqitaService.getSjqita(Integer.parseInt(sjqitaId));
//                sjduochu.setSjqitaName(sjqita.getSjqitaName());
//            }
//            if (StringUtils.hasText(sjlaiyuanId)) {
//                sjduochu.setSjlaiyuanId(Integer.parseInt(sjlaiyuanId));
//                Sjlaiyuan sjlaiyuan = new Sjlaiyuan();
//                sjlaiyuan = sjlaiyuanService.getSjlaiyuan(Integer.parseInt(sjlaiyuanId));
//                sjduochu.setSjlaiyuanName(sjlaiyuan.getSjlaiyuanName());
//            }

            if (StringUtils.hasText(sjduochuId)) {
                offerService.modifySjduochu(sjduochu);
                result.put("success", "true");
//                ResponseUtil.write(response, result);
            } else {
                Date date = new Date();
                sjduochu.setSjduochudate(date);
                sjduochu.setSjduochutype(0);
                offerService.save(sjduochu);
                result.put("success", "true");
//                ResponseUtil.write(response, result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", "false");
            result.put("error", e.getMessage());
        } finally {
            ResponseUtil.write(response, result);
        }
    }

    @RequestMapping("/deleteSjduochu")
    public void deleteSjduochu(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        JSONObject result = new JSONObject();
        String delIds = request.getParameter("delIds");
        try {
            String str[] = delIds.split(",");
            for (int i = 0; i < str.length; i++) {
                offerService.deleteSjduochu(Integer.parseInt(str[i]));
            }
            result.put("success", "true");
            result.put("delNums", str.length);
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/sjduochuComboList")
    public void sjduochuComboList(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String sjduochuName = request.getParameter("sjduochuName");
        String sjduochuId = request.getParameter("sjduochuId");
//        String sjduochuType = request.getParameter("sjduochuType");
//        String sjduochuType1 = request.getParameter("sjduochuType1");
//        String sjduochuType2 = request.getParameter("sjduochuType2");
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
        DuochuPojo sjduochu = new DuochuPojo();
        try {
//            if (StringUtils.hasText(sjduochuName)) {
//                sjduochu.setSjduochuName(sjduochuName);
//            }
//            if (StringUtils.hasText(sjduochuId)) {
//                sjduochu.setSjduochuId(Integer.parseInt(sjduochuId));
//            }
//            if (StringUtils.hasText(sjduochuType)) {
//                sjduochu.setSjduochuType(Integer.parseInt(sjduochuType));
//            }
//            if (StringUtils.hasText(sjduochuType1)) {
//                sjduochu.setSjduochuType1(Integer.parseInt(sjduochuType1));
//            }
//            if (StringUtils.hasText(sjduochuType2)) {
//                sjduochu.setSjduochuType2(Integer.parseInt(sjduochuType2));
//            }
//            if (StringUtils.hasText(sjlaiyuanId)) {
//                sjduochu.setSjlaiyuanId(Integer.parseInt(sjlaiyuanId));
//            }
//            if (StringUtils.hasText(sjqitaId)) {
//                sjduochu.setSjqitaId(Integer.parseInt(sjqitaId));
//            }
//            if (StringUtils.hasText(shujuId)) {
//                sjduochu.setShujuId(Integer.parseInt(shujuId));
//            }
//            if (StringUtils.hasText(sjleixingId)) {
//                sjduochu.setSjleixingId(Integer.parseInt(sjleixingId));
//            }
//            if (StringUtils.hasText(sjxingtaiId)) {
//                sjduochu.setSjxingtaiId(Integer.parseInt(sjxingtaiId));
//            }
//            if (StringUtils.hasText(userId)) {
//                sjduochu.setUserId(Integer.parseInt(userId));
//            }
//            if (StringUtils.hasText(bumenId)) {
//                sjduochu.setBumenId(Integer.parseInt(bumenId));
//            }
//            if (StringUtils.hasText(buyuanId)) {
//                sjduochu.setBuyuanId(Integer.parseInt(buyuanId));
//            }
//            if (StringUtils.hasText(buzhiId)) {
//                sjduochu.setBuzhiId(Integer.parseInt(buzhiId));
//            }
//            if (StringUtils.hasText(yonghuId)) {
//                sjduochu.setYonghuId(Integer.parseInt(yonghuId));
//            }
//            if (StringUtils.hasText(byuyuanId)) {
//                sjduochu.setByuyuanId(Integer.parseInt(byuyuanId));
//            }
//            if (StringUtils.hasText(byumenId)) {
//                sjduochu.setByumenId(Integer.parseInt(byumenId));
//            }
//            if (StringUtils.hasText(byuzhiId)) {
//                sjduochu.setByuzhiId(Integer.parseInt(byuzhiId));
//            }
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", "");
            jsonObject.put("sjduochuname", "请选择...");
            jsonArray.add(jsonObject);
            jsonArray.addAll(JSONArray.fromObject(offerService.querySjduochus(sjduochu,
                    0, 0).stream().map(dc -> new Pair<>(dc.getSjduochuid(), dc.getSjduochuname()))));
            ResponseUtil.write(response, jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/sjduochuTongji")
    public void sjduochuTongji(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        String sdate=request.getParameter("sdate");
//        String edate=request.getParameter("edate");
        String userId = request.getParameter("userId");
        String tijiaoUrl = "shujuTongji";
        List<Integer> shujuIds = new ArrayList<>();
        List<String> tongjiNames = new ArrayList<>();
        List<Double> tongjiZongshus = new ArrayList<>();
        List<ShujuPojo> shujus = new ArrayList<>();
        List<DuochuPojo> sjduochus = new ArrayList<>();

        double zongshu = 0.0;
        DuochuPojo sjduochu = new DuochuPojo();
        ShujuPojo shuju = new ShujuPojo();
        if (StringUtils.hasText(userId)) {
            shuju.setUserid(Integer.parseInt(userId));
        }
        try {
            shujus = shujuService.queryShujus(shuju, 0, 0);
            for (ShujuPojo shujuPojo : shujus) {
                shujuIds.add(shujuPojo.getShujuid());
                tongjiNames.add(shujuPojo.getShujuname());
            }
            for (Integer shujuId : shujuIds) {
                double sjduochuZongshu = 0.0;
                sjduochu.setShujuid(shujuId);
                sjduochus = offerService.querySjduochus(sjduochu, 0, 0);
                for (DuochuPojo duochuPojo : sjduochus) {
                    sjduochuZongshu = sjduochuZongshu + duochuPojo.getSjduochudouble2();
                }
                zongshu = zongshu + sjduochuZongshu;
                tongjiZongshus.add(sjduochuZongshu);
            }

            HttpSession session = request.getSession();
            session.setAttribute("tijiaoUrl", tijiaoUrl);
            session.setAttribute("tongjiNames", tongjiNames);
            session.setAttribute("tongjiZongshus", tongjiZongshus);
            session.setAttribute("zongshu", zongshu);
            response.sendRedirect("tongjitu/bingzhuangtu");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @RequestMapping("/shangchuanSjduochu")
//    public void shangchuanSjduochu(HttpServletRequest request, HttpServletResponse response,MultipartFile uploadFile)
//            throws Exception {
//        try {
//            String sjduochuId = request.getParameter("sjduochuId");
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
//            Sjduochu sjduochu = sjduochuService.getSjduochu(Integer.parseInt(sjduochuId));
//            sjduochu.setSjduochuImg(shangchuandizhi);
//            sjduochu.setSjduochuImgName(shangchuanname);
//            sjduochuService.modifySjduochu(sjduochu);
//            JSONObject result = new JSONObject();
//            result.put("success", "true");
//            ResponseUtil.write(response, result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    @RequestMapping("/daoruSjduochu")
//    public void daoruSjduochu(HttpServletRequest request, HttpServletResponse response, MultipartFile uploadFile)
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
//                String sjduochuName = row.get(0);
//                String sjleixingId = row.get(1);
//                String sjduochuZong = row.get(2);
//                String sjduochuMark = row.get(3);
//                String userId = row.get(4);
//                Sjduochu sjduochu = new Sjduochu();
//
//                if (StringUtils.hasText(sjduochuName)) {
//                    sjduochu.setSjduochuName(sjduochuName);
//                }
//                if (StringUtils.hasText(sjleixingId)) {
//                    sjduochu.setSjleixingId(Integer.parseInt(sjleixingId));
//                    Sjleixing sjleixing = new Sjleixing();
//                    sjleixing = sjleixingService.getSjleixing(Integer.parseInt(sjleixingId));
//                    sjduochu.setSjleixingName(sjleixing.getSjleixingName());
//                }
//                if (StringUtils.hasText(sjduochuZong)) {
//                    sjduochu.setSjduochuZong(Integer.parseInt(sjduochuZong));
//                }
//                if (StringUtils.hasText(sjduochuMark)) {
//                    sjduochu.setSjduochuMark(sjduochuMark);
//                }
//                if (StringUtils.hasText(userId)) {
//                    sjduochu.setUserId(Integer.parseInt(userId));
//                    User user = new User();
//                    user = userService.getUser(Integer.parseInt(userId));
//                    sjduochu.setUserName(user.getUserName());
//                    sjduochu.setBumenId(user.getBumenId());
//                    sjduochu.setBumenName(user.getBumenName());
//                    sjduochu.setBuyuanId(user.getBuyuanId());
//                    sjduochu.setBuyuanName(user.getBuyuanName());
//                    sjduochu.setBuzhiId(user.getBuzhiId());
//                    sjduochu.setBuzhiName(user.getBuzhiName());
//                }
//                Date date = new Date();
//                sjduochu.setSjduochuDate(date);
//                sjduochuService.save(sjduochu);
//            }
//            JSONObject result = new JSONObject();
//            result.put("success", "true");
//            ResponseUtil.write(response, result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @RequestMapping("/daochuSjduochu")
//    public void daochuSjduochu(HttpServletRequest request, HttpServletResponse response)
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
//            Sjduochu sjduochu = new Sjduochu();
//            for (int i = 0; i < str.length; i++) {
//                List<String> row = new ArrayList<String>();
//                sjduochu = sjduochuService.getSjduochu(Integer.parseInt(str[i]));
//                row.add(TypeUtil.toString(i+1));
//                row.add(sjduochu.getSjduochuName());
//                row.add(sjduochu.getSjleixingName());
//                row.add(sjduochu.getSjduochuZong().toString());
//                row.add(sjduochu.getSjduochuMark());
//                row.add(sjduochu.getUserName());
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
