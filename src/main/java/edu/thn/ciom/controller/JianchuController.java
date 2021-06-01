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
import java.util.Date;
import java.util.stream.Collectors;

@Controller
public class JianchuController {
    @Autowired
    private JianchuService jianchuService;
    @Autowired
    private ShujuService shujuService;
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private UserService userService;
    
    @RequestMapping("/getSjjianchus")
    public void getSjjianchus(HttpServletRequest request,
                              HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        String shujuId = request.getParameter("shujuId");
//        String sjjianchuId = request.getParameter("sjjianchuId");
//        String sjjianchuName = request.getParameter("sjjianchuName");
//        String sjjianchuType = request.getParameter("sjjianchuType");
//        String sjjianchuType1 = request.getParameter("sjjianchuType1");
//        String sjjianchuType2 = request.getParameter("sjjianchuType2");
//        String sjlaiyuanId = request.getParameter("sjlaiyuanId");
//        String sjqitaId = request.getParameter("sjqitaId");
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
//        String sdate = request.getParameter("sdate");
//        String edate = request.getParameter("edate");
//        String sdate1 = request.getParameter("sdate1");
//        String edate1 = request.getParameter("edate1");
        JianChuPojo sjjianchu = new JianChuPojo();
        PageBean pageBean = null;
        if ((StringUtils.hasText(page))&&(!page.equals("null"))) {
            pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
        }else{
            pageBean = new PageBean(0,0);
        }
        try {
            if (StringUtils.hasText(shujuId)) {
                sjjianchu.setShujuid(Integer.parseInt(shujuId));
            }
//            if (StringUtils.hasText(sjjianchuName)) {
//                sjjianchu.setSjjianchuName(sjjianchuName);
//            }
//            if (StringUtils.hasText(sjjianchuId)) {
//                sjjianchu.setSjjianchuId(Integer.parseInt(sjjianchuId));
//            }
//            if (StringUtils.hasText(sjjianchuType)) {
//                sjjianchu.setSjjianchuType(Integer.parseInt(sjjianchuType));
//            }
//            if (StringUtils.hasText(sjjianchuType1)) {
//                sjjianchu.setSjjianchuType1(Integer.parseInt(sjjianchuType1));
//            }
//            if (StringUtils.hasText(sjjianchuType2)) {
//                sjjianchu.setSjjianchuType2(Integer.parseInt(sjjianchuType2));
//            }
//            if (StringUtils.hasText(sjlaiyuanId)) {
//                sjjianchu.setSjlaiyuanId(Integer.parseInt(sjlaiyuanId));
//            }
//            if (StringUtils.hasText(sjqitaId)) {
//                sjjianchu.setSjqitaId(Integer.parseInt(sjqitaId));
//            }
//
//            if (StringUtils.hasText(sjleixingId)) {
//                sjjianchu.setSjleixingId(Integer.parseInt(sjleixingId));
//            }
//            if (StringUtils.hasText(sjxingtaiId)) {
//                sjjianchu.setSjxingtaiId(Integer.parseInt(sjxingtaiId));
//            }
//            if (StringUtils.hasText(userId)) {
//                sjjianchu.setUserId(Integer.parseInt(userId));
//            }
//            if (StringUtils.hasText(bumenId)) {
//                sjjianchu.setBumenId(Integer.parseInt(bumenId));
//            }
//            if (StringUtils.hasText(buyuanId)) {
//                sjjianchu.setBuyuanId(Integer.parseInt(buyuanId));
//            }
//            if (StringUtils.hasText(buzhiId)) {
//                sjjianchu.setBuzhiId(Integer.parseInt(buzhiId));
//            }
//            if (StringUtils.hasText(yonghuId)) {
//                sjjianchu.setYonghuId(Integer.parseInt(yonghuId));
//            }
//            if (StringUtils.hasText(byuyuanId)) {
//                sjjianchu.setByuyuanId(Integer.parseInt(byuyuanId));
//            }
//            if (StringUtils.hasText(byumenId)) {
//                sjjianchu.setByumenId(Integer.parseInt(byumenId));
//            }
//            if (StringUtils.hasText(byuzhiId)) {
//                sjjianchu.setByuzhiId(Integer.parseInt(byuzhiId));
//            }
//            if (StringUtils.hasText(sdate1)) {
//                Date date = new Date();
//                sdate1 = DateUtil.formatDate(date, "yyyy-MM-dd HH:mm:ss");
//            }
//            if (StringUtils.hasText(edate1)) {
//                Date date = new Date();
//                edate1 = DateUtil.formatDate(date, "yyyy-MM-dd HH:mm:ss");
//            }
            JSONArray jsonArray = JSONArray.fromObject(jianchuService.querySjjianchus(
                    sjjianchu, pageBean.getStart(), pageBean.getRows()));
            JSONObject result = new JSONObject();
            int total = jianchuService.querySjjianchus(sjjianchu, 0,0).size();
            result.put("rows", jsonArray);
            result.put("total", total);
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/addSjjianchu")
    public void addSjjianchu(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            JSONObject result = new JSONObject();

            String sjjianchuName = request.getParameter("sjjianchuName");
            String sjjianchuMark = request.getParameter("sjjianchuMark");
            String sjjianchuMark1 = request.getParameter("sjjianchuMark1");
            String sjjianchuMark2 = request.getParameter("sjjianchuMark2");
            String sjjianchuMark3 = request.getParameter("sjjianchuMark3");
            String sjjianchuDate = request.getParameter("sjjianchuDate");
            String sjjianchuDate1 = request.getParameter("sjjianchuDate1");
            String sjjianchuZong = request.getParameter("sjjianchuZong");
            String sjjianchuZong1 = request.getParameter("sjjianchuZong1");
            String sjjianchuZong2 = request.getParameter("sjjianchuZong2");
            String sjjianchuDouble = request.getParameter("sjjianchuDouble");
            String sjjianchuDouble1 = request.getParameter("sjjianchuDouble1");
            String sjjianchuDouble2 = request.getParameter("sjjianchuDouble2");
            String sjjianchuType = request.getParameter("sjjianchuType");
            String sjjianchuType1 = request.getParameter("sjjianchuType1");
            String sjjianchuType2 = request.getParameter("sjjianchuType2");
            String shujuId = request.getParameter("shujuId");
            String sjqitaId = request.getParameter("sjqitaId");
            String sjlaiyuanId = request.getParameter("sjlaiyuanId");
            String yonghuId = request.getParameter("yonghuId");
            String userId = request.getParameter("userId");
            String sjjianchuId = request.getParameter("sjjianchuId");
            JianChuPojo sjjianchu = new JianChuPojo();

            if (StringUtils.hasText(sjjianchuId)) {
                sjjianchu = jianchuService.getSjjianchu(Integer.parseInt(sjjianchuId));
            }
            if (StringUtils.hasText(sjjianchuName)) {
                sjjianchu.setSjjianchuname(sjjianchuName);
            }
            if (StringUtils.hasText(sjjianchuMark)) {
                sjjianchu.setSjjianchumark(sjjianchuMark);
            }
            if (StringUtils.hasText(sjjianchuMark1)) {
                sjjianchu.setSjjianchumark1(sjjianchuMark1);
            }
            if (StringUtils.hasText(sjjianchuMark2)) {
                sjjianchu.setSjjianchumark2(sjjianchuMark2);
            }
            if (StringUtils.hasText(sjjianchuMark3)) {
                sjjianchu.setSjjianchumark3(sjjianchuMark3);
            }
            if (StringUtils.hasText(sjjianchuDate)) {
                sjjianchu.setSjjianchudate(DateUtil.formatString(sjjianchuDate,
                        "yyyy-MM-dd hh:mm:ss"));
            }
            if (StringUtils.hasText(sjjianchuDate1)) {
                sjjianchu.setSjjianchudate1(DateUtil.formatString(sjjianchuDate1,
                        "yyyy-MM-dd hh:mm:ss"));
            }
            if (StringUtils.hasText(sjjianchuZong)) {
                sjjianchu.setSjjianchuzong(Integer.parseInt(sjjianchuZong));
            }
            if (StringUtils.hasText(sjjianchuZong1)) {
                sjjianchu.setSjjianchuzong1(Integer.parseInt(sjjianchuZong1));
            }
            if (StringUtils.hasText(sjjianchuZong2)) {
                sjjianchu.setSjjianchuzong2(Integer.parseInt(sjjianchuZong2));
            }
            if (StringUtils.hasText(sjjianchuDouble)) {
                sjjianchu.setSjjianchudouble(Double.parseDouble(sjjianchuDouble));
            }
            if (StringUtils.hasText(sjjianchuDouble1)) {
                sjjianchu.setSjjianchudouble1(Double.parseDouble(sjjianchuDouble1));
            }
            if (StringUtils.hasText(sjjianchuDouble2)) {
                sjjianchu.setSjjianchudouble2(Double.parseDouble(sjjianchuDouble2));
            }
            if (StringUtils.hasText(sjjianchuType)) {
                sjjianchu.setSjjianchutype(Integer.parseInt(sjjianchuType));
            }
            if (StringUtils.hasText(sjjianchuType1)) {
                sjjianchu.setSjjianchutype1(Integer.parseInt(sjjianchuType1));
            }
            if (StringUtils.hasText(sjjianchuType2)) {
                sjjianchu.setSjjianchutype2(Integer.parseInt(sjjianchuType2));
            }
            if (StringUtils.hasText(shujuId)) {
                sjjianchu.setShujuid(Integer.parseInt(shujuId));
                ShujuPojo shuju = shujuService.getShuju(Integer.parseInt(shujuId));
                if(shuju!=null) sjjianchu.setShujuname(shuju.getShujuname());
//                sjjianchu.setSjleixingId(shuju.getSjleixingId());
//                sjjianchu.setSjleixingName(shuju.getSjleixingName());
//                sjjianchu.setUserId(shuju.getUserId());
//                sjjianchu.setUserName(shuju.getUserName());
//                sjjianchu.setBumenId(shuju.getBumenId());
//                sjjianchu.setBumenName(shuju.getBumenName());
//                sjjianchu.setBuyuanId(shuju.getBuyuanId());
//                sjjianchu.setBuyuanName(shuju.getBuyuanName());
//                sjjianchu.setBuzhiId(shuju.getBuzhiId());
//                sjjianchu.setBuzhiName(shuju.getBuzhiName());
            }

            if (StringUtils.hasText(yonghuId)) {
                sjjianchu.setYonghuid(Integer.parseInt(yonghuId));
                YongHuPojo yonghu = yonghuService.getYonghu(Integer.parseInt(yonghuId));
                if(yonghu!=null) sjjianchu.setYonghuname(yonghu.getYonghuname());
//                sjjianchu.setBuzhiId(yonghu.getBuzhiId());
//                sjjianchu.setBuzhiName(yonghu.getBuzhiName());
            }
            if (StringUtils.hasText(userId)) {
                sjjianchu.setUserid(Integer.parseInt(userId));
                UserPojo user = userService.getUser(Integer.parseInt(userId));
                if(user!=null) sjjianchu.setUsername(user.getUsername());
//                sjjianchu.setBumenId(user.getBumenId());
//                sjjianchu.setBumenName(user.getBumenName());
//                sjjianchu.setBuyuanId(user.getBuyuanId());
//                sjjianchu.setBuyuanName(user.getBuyuanName());
//                sjjianchu.setBuzhiId(user.getBuzhiId());
//                sjjianchu.setBuzhiName(user.getBuzhiName());
            }

//            if (StringUtils.hasText(sjqitaId)) {
//                sjjianchu.setSjqitaId(Integer.parseInt(sjqitaId));
//                Sjqita sjqita = new Sjqita();
//                sjqita = sjqitaService.getSjqita(Integer.parseInt(sjqitaId));
//                sjjianchu.setSjqitaName(sjqita.getSjqitaName());
//            }
//            if (StringUtils.hasText(sjlaiyuanId)) {
//                sjjianchu.setSjlaiyuanId(Integer.parseInt(sjlaiyuanId));
//                Sjlaiyuan sjlaiyuan = new Sjlaiyuan();
//                sjlaiyuan = sjlaiyuanService.getSjlaiyuan(Integer.parseInt(sjlaiyuanId));
//                sjjianchu.setSjlaiyuanName(sjlaiyuan.getSjlaiyuanName());
//            }

            if (StringUtils.hasText(sjjianchuId)) {
                jianchuService.modifySjjianchu(sjjianchu);
                result.put("success", "true");
                ResponseUtil.write(response, result);
            } else {
                Date date = new Date();
                sjjianchu.setSjjianchudate(date);
                sjjianchu.setSjjianchutype(0);
                jianchuService.save(sjjianchu);
                result.put("success", "true");
                ResponseUtil.write(response, result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/deleteSjjianchu")
    public void deleteSjjianchu(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        JSONObject result = new JSONObject();
        String delIds = request.getParameter("delIds");
        try {
            String str[] = delIds.split(",");
            for (int i = 0; i < str.length; i++) {
                jianchuService.deleteSjjianchu(Integer.parseInt(str[i]));
            }
            result.put("success", "true");
            result.put("delNums", str.length);
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/sjjianchuComboList")
    public void sjjianchuComboList(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        String sjjianchuName = request.getParameter("sjjianchuName");
//        String sjjianchuId = request.getParameter("sjjianchuId");
//        String sjjianchuType = request.getParameter("sjjianchuType");
//        String sjjianchuType1 = request.getParameter("sjjianchuType1");
//        String sjjianchuType2 = request.getParameter("sjjianchuType2");
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
        JianChuPojo sjjianchu = new JianChuPojo();
        try {
//            if (StringUtils.hasText(sjjianchuName)) {
//                sjjianchu.setSjjianchuName(sjjianchuName);
//            }
//            if (StringUtils.hasText(sjjianchuId)) {
//                sjjianchu.setSjjianchuId(Integer.parseInt(sjjianchuId));
//            }
//            if (StringUtils.hasText(sjjianchuType)) {
//                sjjianchu.setSjjianchuType(Integer.parseInt(sjjianchuType));
//            }
//            if (StringUtils.hasText(sjjianchuType1)) {
//                sjjianchu.setSjjianchuType1(Integer.parseInt(sjjianchuType1));
//            }
//            if (StringUtils.hasText(sjjianchuType2)) {
//                sjjianchu.setSjjianchuType2(Integer.parseInt(sjjianchuType2));
//            }
//            if (StringUtils.hasText(sjlaiyuanId)) {
//                sjjianchu.setSjlaiyuanId(Integer.parseInt(sjlaiyuanId));
//            }
//            if (StringUtils.hasText(sjqitaId)) {
//                sjjianchu.setSjqitaId(Integer.parseInt(sjqitaId));
//            }
//            if (StringUtils.hasText(shujuId)) {
//                sjjianchu.setShujuId(Integer.parseInt(shujuId));
//            }
//            if (StringUtils.hasText(sjleixingId)) {
//                sjjianchu.setSjleixingId(Integer.parseInt(sjleixingId));
//            }
//            if (StringUtils.hasText(sjxingtaiId)) {
//                sjjianchu.setSjxingtaiId(Integer.parseInt(sjxingtaiId));
//            }
//            if (StringUtils.hasText(userId)) {
//                sjjianchu.setUserId(Integer.parseInt(userId));
//            }
//            if (StringUtils.hasText(bumenId)) {
//                sjjianchu.setBumenId(Integer.parseInt(bumenId));
//            }
//            if (StringUtils.hasText(buyuanId)) {
//                sjjianchu.setBuyuanId(Integer.parseInt(buyuanId));
//            }
//            if (StringUtils.hasText(buzhiId)) {
//                sjjianchu.setBuzhiId(Integer.parseInt(buzhiId));
//            }
//            if (StringUtils.hasText(yonghuId)) {
//                sjjianchu.setYonghuId(Integer.parseInt(yonghuId));
//            }
//            if (StringUtils.hasText(byuyuanId)) {
//                sjjianchu.setByuyuanId(Integer.parseInt(byuyuanId));
//            }
//            if (StringUtils.hasText(byumenId)) {
//                sjjianchu.setByumenId(Integer.parseInt(byumenId));
//            }
//            if (StringUtils.hasText(byuzhiId)) {
//                sjjianchu.setByuzhiId(Integer.parseInt(byuzhiId));
//            }
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", "");
            jsonObject.put("value", "请选择...");
            jsonArray.add(jsonObject);
            jsonArray.addAll(
                    JSONArray.fromObject(
                        jianchuService.querySjjianchus(sjjianchu,0,0)
                        .stream().map(j->new SelectListItem(j.getSjjianchuid().toString(), j.getSjjianchuimgname()))
                        .collect(Collectors.toList())));

            ResponseUtil.write(response, jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @RequestMapping("/sjjianchuTongji")
//    public void sjjianchuTongji(HttpServletRequest request, HttpServletResponse response)
//            throws Exception {
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        String sdate=request.getParameter("sdate");
//        String edate=request.getParameter("edate");
//        String userId=request.getParameter("userId");
//        String tijiaoUrl = "shujuTongji";
//        List<Integer> shujuIds = new ArrayList<Integer>();
//        List<String> tongjiNames = new ArrayList<String>();
//        List<Double> tongjiZongshus = new ArrayList<Double>();
//        List<Shuju> shujus = new ArrayList<Shuju>();
//        List<Sjjianchu> sjjianchus = new ArrayList<Sjjianchu>();
//        Double zongshu = 0.0;
//        Sjjianchu sjjianchu = new Sjjianchu();
//        Shuju shuju = new Shuju();
//        if (StringUtils.hasText(userId)) {
//            shuju.setUserId(Integer.parseInt(userId));
//        }
//        try {
//            shujus = shujuService.queryShujus(shuju, 0,0, null, null, null, null);
//            for(int i=0;i<shujus.size();i++){
//                shujuIds.add(shujus.get(i).getShujuId());
//                tongjiNames.add(shujus.get(i).getShujuName());
//            }
//            for(int i=0;i<shujuIds.size();i++){
//                Double sjjianchuZongshu = 0.0;
//                sjjianchu.setShujuId(shujuIds.get(i));
//                sjjianchus = jianchuService.querySjjianchus(sjjianchu, 0,0,sdate,edate, null, null);
//                for(int j=0;j<sjjianchus.size();j++){
//                    sjjianchuZongshu = sjjianchuZongshu + sjjianchus.get(j).getSjjianchuDouble2();
//                }
//                zongshu = zongshu + sjjianchuZongshu;
//                tongjiZongshus.add(sjjianchuZongshu);
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
//    @RequestMapping("/shangchuanSjjianchu")
//    public void shangchuanSjjianchu(HttpServletRequest request, HttpServletResponse response,MultipartFile uploadFile)
//            throws Exception {
//        try {
//            String sjjianchuId = request.getParameter("sjjianchuId");
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
//            Sjjianchu sjjianchu = jianchuService.getSjjianchu(Integer.parseInt(sjjianchuId));
//            sjjianchu.setSjjianchuImg(shangchuandizhi);
//            sjjianchu.setSjjianchuImgName(shangchuanname);
//            jianchuService.modifySjjianchu(sjjianchu);
//            JSONObject result = new JSONObject();
//            result.put("success", "true");
//            ResponseUtil.write(response, result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @RequestMapping("/daoruSjjianchu")
//    public void daoruSjjianchu(HttpServletRequest request, HttpServletResponse response,MultipartFile uploadFile)
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
//                String sjjianchuName = row.get(0);
//                String sjleixingId = row.get(1);
//                String sjjianchuZong = row.get(2);
//                String sjjianchuMark = row.get(3);
//                String userId = row.get(4);
//                Sjjianchu sjjianchu = new Sjjianchu();
//
//                if (StringUtils.hasText(sjjianchuName)) {
//                    sjjianchu.setSjjianchuName(sjjianchuName);
//                }
//                if (StringUtils.hasText(sjleixingId)) {
//                    sjjianchu.setSjleixingId(Integer.parseInt(sjleixingId));
//                    Sjleixing sjleixing = new Sjleixing();
//                    sjleixing = sjleixingService.getSjleixing(Integer.parseInt(sjleixingId));
//                    sjjianchu.setSjleixingName(sjleixing.getSjleixingName());
//                }
//                if (StringUtils.hasText(sjjianchuZong)) {
//                    sjjianchu.setSjjianchuZong(Integer.parseInt(sjjianchuZong));
//                }
//                if (StringUtils.hasText(sjjianchuMark)) {
//                    sjjianchu.setSjjianchuMark(sjjianchuMark);
//                }
//                if (StringUtils.hasText(userId)) {
//                    sjjianchu.setUserId(Integer.parseInt(userId));
//                    User user = new User();
//                    user = userService.getUser(Integer.parseInt(userId));
//                    sjjianchu.setUserName(user.getUserName());
//                    sjjianchu.setBumenId(user.getBumenId());
//                    sjjianchu.setBumenName(user.getBumenName());
//                    sjjianchu.setBuyuanId(user.getBuyuanId());
//                    sjjianchu.setBuyuanName(user.getBuyuanName());
//                    sjjianchu.setBuzhiId(user.getBuzhiId());
//                    sjjianchu.setBuzhiName(user.getBuzhiName());
//                }
//                Date date = new Date();
//                sjjianchu.setSjjianchuDate(date);
//                jianchuService.save(sjjianchu);
//            }
//            JSONObject result = new JSONObject();
//            result.put("success", "true");
//            ResponseUtil.write(response, result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @RequestMapping("/daochuSjjianchu")
//    public void daochuSjjianchu(HttpServletRequest request, HttpServletResponse response)
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
//            Sjjianchu sjjianchu = new Sjjianchu();
//            for (int i = 0; i < str.length; i++) {
//                List<String> row = new ArrayList<String>();
//                sjjianchu = jianchuService.getSjjianchu(Integer.parseInt(str[i]));
//                row.add(TypeUtil.toString(i+1));
//                row.add(sjjianchu.getSjjianchuName());
//                row.add(sjjianchu.getSjleixingName());
//                row.add(sjjianchu.getSjjianchuZong().toString());
//                row.add(sjjianchu.getSjjianchuMark());
//                row.add(sjjianchu.getUserName());
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
