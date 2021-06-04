package edu.thn.ciom.controller;

import edu.thn.ciom.pojo.LeiXingPojo;
import edu.thn.ciom.pojo.SelectListItem;
import edu.thn.ciom.service.TypeService;
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
import java.util.stream.Collectors;

@Controller
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("/getSjleixings")
    public void getSjleixings(HttpServletRequest request,
                              HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        String sjleixingId = request.getParameter("sjleixingid");
        String sjleixingName = request.getParameter("sjleixingname");
//        String sjleixingType = request.getParameter("sjleixingType");
//        String sjleixingType1 = request.getParameter("sjleixingType1");
//        String sjleixingPhone = request.getParameter("sjleixingPhone");
        LeiXingPojo sjleixing = new LeiXingPojo();
        PageBean pageBean = null;
        if ((StringUtils.hasText(page)) && (!page.equals("null"))) {
            pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        } else {
            pageBean = new PageBean(0, 0);
        }
        try {
            if (StringUtils.hasText(sjleixingName)) {
                sjleixing.setSjleixingname(sjleixingName);
            }
//            if (StringUtils.hasText(sjleixingPhone)) {
//                sjleixing.setSjleixingphone(sjleixingPhone);
//            }
            if (StringUtils.hasText(sjleixingId)) {
                sjleixing.setSjleixingid(Integer.parseInt(sjleixingId));
            }
//            if (StringUtils.hasText(sjleixingType)) {
//                sjleixing.setSjleixingtype(Integer.parseInt(sjleixingType));
//            }
//            if (StringUtils.hasText(sjleixingType1)) {
//                sjleixing.setSjleixingtype1(Integer.parseInt(sjleixingType1));
//            }
            JSONArray jsonArray = JSONArray.fromObject(typeService.querySjleixings(
                    sjleixing, pageBean.getStart(), pageBean.getRows()));
            JSONObject result = new JSONObject();
            int total = typeService.querySjleixings(sjleixing, 0, 0).size();
            result.put("rows", jsonArray);
            result.put("total", total);
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/addSjleixing")
    public void addSjleixing(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        boolean isNew = true;
        try {
            JSONObject result = new JSONObject();

            String sjleixingId = (String) request.getParameter("sjleixingid");
            String sjleixingName = (String) request.getParameter("sjleixingname");
            String sjleixingMark = (String) request.getParameter("sjleixingmark");
//            String sjleixingPhone = (String) request.getParameter("sjleixingPhone");
//            String sjleixingMark1 = (String) request.getParameter("sjleixingMark1");
//            String sjleixingMark2 = (String) request.getParameter("sjleixingMark2");
//            String sjleixingDizhi = (String) request.getParameter("sjleixingDizhi");
//            String sjleixingDate = (String) request.getParameter("sjleixingDate");
//            String sjleixingDate1 = (String) request.getParameter("sjleixingDate1");
//            String sjleixingType = (String) request.getParameter("sjleixingType");
//            String sjleixingType1 = (String) request.getParameter("sjleixingType1");
//            String sjleixingDouble = (String) request.getParameter("sjleixingDouble");
//            String sjleixingDouble1 = (String) request.getParameter("sjleixingDouble1");
            LeiXingPojo typePojo = new LeiXingPojo();

            if (StringUtils.hasText(sjleixingId)) {
                typePojo = typeService.getSjleixing(Integer.parseInt(sjleixingId));
                if (typePojo != null) isNew = false;
            }

            if (StringUtils.hasText(sjleixingName)) {
                typePojo.setSjleixingname(sjleixingName);
            }
            if (StringUtils.hasText(sjleixingMark)) {
                typePojo.setSjleixingmark(sjleixingMark);
            }
//            if (StringUtils.hasText(sjleixingPhone)) {
//                typePojo.setSjleixingPhone(sjleixingPhone);
//            }
//            if (StringUtils.hasText(sjleixingMark1)) {
//                typePojo.setSjleixingMark1(sjleixingMark1);
//            }
//            if (StringUtils.hasText(sjleixingMark2)) {
//                typePojo.setSjleixingMark2(sjleixingMark2);
//            }
//            if (StringUtils.hasText(sjleixingDizhi)) {
//                typePojo.setSjleixingDizhi(sjleixingDizhi);
//            }
//            if (StringUtils.hasText(sjleixingDate)) {
//                typePojo.setSjleixingDate(DateUtil.formatString(sjleixingDate,
//                        "yyyy-MM-dd hh:mm:ss"));
//            }
//            if (StringUtils.hasText(sjleixingDate1)) {
//                typePojo.setSjleixingDate1(DateUtil.formatString(sjleixingDate1,
//                        "yyyy-MM-dd hh:mm:ss"));
//            }
//            if (StringUtils.hasText(sjleixingType)) {
//                typePojo.setSjleixingType(Integer.parseInt(sjleixingType));
//            }
//            if (StringUtils.hasText(sjleixingType1)) {
//                typePojo.setSjleixingType1(Integer.parseInt(sjleixingType1));
//            }
//            if (StringUtils.hasText(sjleixingDouble)) {
//                typePojo.setSjleixingDouble(Double.parseDouble(sjleixingDouble));
//            }
//            if (StringUtils.hasText(sjleixingDouble1)) {
//                typePojo.setSjleixingDouble1(Double.parseDouble(sjleixingDouble1));
//            }
            if (StringUtils.hasText(sjleixingId)) {
                Date date = new Date();
                typePojo.setSjleixingdate(date);
                typeService.modifySjleixing(typePojo);
                result.put("success", "true");
                ResponseUtil.write(response, result);
            } else {
                typeService.save(typePojo);
                result.put("success", "true");
                ResponseUtil.write(response, result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/deleteSjleixing")
    public void deleteSjleixing(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            String delIds = (String) request.getParameter("delIds");
            System.out.println("delIds = " + delIds);
            JSONObject result = new JSONObject();
            String str[] = delIds.split(",");
            for (int i = 0; i < str.length; i++) {
                typeService.deleteSjleixing(Integer.parseInt(str[i]));
            }
            result.put("success", "true");
            result.put("delNums", str.length);
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/sjleixingComboList")
    public void sjleixingComboList(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String sjleixingType1 = (String) request.getParameter("sjleixingType1");
        String sjleixingType = (String) request.getParameter("sjleixingType");
        LeiXingPojo sjleixing = new LeiXingPojo();
        try {
            if (StringUtils.hasText(sjleixingType)) {
                sjleixing.setSjleixingtype(Integer.parseInt(sjleixingType));
            }
            if (StringUtils.hasText(sjleixingType1)) {
                sjleixing.setSjleixingtype1(Integer.parseInt(sjleixingType1));
            }
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", "");
            jsonObject.put("value", "请选择...");
            jsonArray.add(jsonObject);
            jsonArray.addAll(JSONArray.fromObject(
                    typeService.querySjleixings(sjleixing, 0, 0)
                            .stream().map(d -> new SelectListItem(d.getSjleixingid(), d.getSjleixingname()))
                            .collect(Collectors.toList())));
            ResponseUtil.write(response, jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
