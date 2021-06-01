package edu.thn.ciom.controller;

import edu.thn.ciom.pojo.BuzhiPojo;
import edu.thn.ciom.pojo.SelectListItem;
import edu.thn.ciom.service.BuzhiService;
import edu.thn.ciom.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.Collectors;

@Controller
public class BuzhiController {
    @Autowired
    private BuzhiService buzhiService;
//    @Autowired
//    private BuyuanService buyuanService;
//    @Autowired
//    private BumenService bumenService;

    @RequestMapping("/addBuzhi")
    public void addBuzhi(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            JSONObject result = new JSONObject();

            String buzhiName = request.getParameter("buzhiName");
            String buzhiMark = request.getParameter("buzhiMark");
            String buzhiMark1 = request.getParameter("buzhiMark1");
            String buzhiMark2 = request.getParameter("buzhiMark2");
            String buzhiType = request.getParameter("buzhiType");
            String buzhiType1 = request.getParameter("buzhiType1");
            String buzhiType2 = request.getParameter("buzhiType2");
            String buzhiDouble = request.getParameter("buzhiDouble");
            String buzhiDouble1 = request.getParameter("buzhiDouble1");
            String buzhiDouble2 = request.getParameter("buzhiDouble2");
            String buyuanId = request.getParameter("buyuanId");
            String buyuanName = request.getParameter("buyuanName");
            String bumenId = request.getParameter("bumenId");
            String buzhiId = request.getParameter("buzhiid");
            BuzhiPojo buzhi = new BuzhiPojo();

            if (StringUtils.hasText(buzhiId)) {
                buzhi = buzhiService.getBuzhi(Integer.parseInt(buzhiId));
            }
            if (StringUtils.hasText(buzhiName)) {
                buzhi.setBuzhiname(buzhiName);
            }
            if (StringUtils.hasText(buzhiMark)) {
                buzhi.setBuzhimark(buzhiMark);
            }
            if (StringUtils.hasText(buzhiMark1)) {
                buzhi.setBuzhimark1(buzhiMark1);
            }
            if (StringUtils.hasText(buzhiMark2)) {
                buzhi.setBuzhimark2(buzhiMark2);
            }
            if (StringUtils.hasText(buzhiType)) {
                buzhi.setBuzhitype(Integer.parseInt(buzhiType));
            }
            if (StringUtils.hasText(buzhiType1)) {
                buzhi.setBuzhitype1(Integer.parseInt(buzhiType1));
            }
            if (StringUtils.hasText(buzhiType2)) {
                buzhi.setBuzhitype2(Integer.parseInt(buzhiType2));
            }
            if (StringUtils.hasText(buzhiDouble)) {
                buzhi.setBuzhidouble(Double.parseDouble(buzhiDouble));
            }
            if (StringUtils.hasText(buzhiDouble1)) {
                buzhi.setBuzhidouble1(Double.parseDouble(buzhiDouble1));
            }
            if (StringUtils.hasText(buzhiDouble2)) {
                buzhi.setBuzhidouble2(Double.parseDouble(buzhiDouble2));
            }
            if (StringUtils.hasText(bumenId)) {
                buzhi.setBumenid(Integer.parseInt(bumenId));
            }
            if (StringUtils.hasText(buzhiName)) {
                buzhi.setBumenname(buzhiName);
            }
            if (StringUtils.hasText(buyuanId)) {
                buzhi.setBuyuanid(Integer.parseInt(buyuanId));
            }

            if (StringUtils.hasText(buyuanName)) {
                buzhi.setBuyuanname(buyuanName);
            }
            if (StringUtils.hasText(buzhiId)) {
                buzhiService.modifyBuzhi(buzhi);
            } else {
                buzhiService.save(buzhi);
            }
            result.put("success", "true");

            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/getBuzhis")
    public void getBuzhis(HttpServletRequest request,
                          HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        String buzhiName = request.getParameter("buzhiName");
        String buzhiType = request.getParameter("buzhiType");
        String buyuanId = request.getParameter("buyuanId");
        String bumenId = request.getParameter("bumenId");
        BuzhiPojo buzhi = new BuzhiPojo();
        if (StringUtils.hasText(buzhiName)) {
            buzhi.setBuzhiname(buzhiName);
        }
        if (StringUtils.hasText(buzhiType)) {
            buzhi.setBuzhitype(Integer.parseInt(buzhiType));
        }
        if (StringUtils.hasText(buyuanId)) {
            buzhi.setBuyuanid(Integer.parseInt(buyuanId));
        }
        if (StringUtils.hasText(bumenId)) {
            buzhi.setBumenid(Integer.parseInt(bumenId));
        }
        PageBean pageBean = null;
        if ((StringUtils.hasText(page)) && (!page.equals("null"))) {
            pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        } else {
            pageBean = new PageBean(0, 0);
        }
        try {
            JSONArray jsonArray = JSONArray.fromObject(buzhiService.queryBuzhis(buzhi, pageBean.getStart(), pageBean.getRows()));
            JSONObject result = new JSONObject();
            int total = buzhiService.queryBuzhis(buzhi, 0, 0).size();
            result.put("rows", jsonArray);
            result.put("total", total);
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/deleteBuzhi")
    public void deleteBuzhi(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            String delIds = request.getParameter("delIds");
            System.out.println("delIds = " + delIds);
            JSONObject result = new JSONObject();
            String[] str = delIds.split(",");
            for (int i = 0; i < str.length; i++) {
                buzhiService.deleteBuzhi(Integer.parseInt(str[i]));
            }
            result.put("success", "true");
            result.put("delNums", str.length);
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/buzhiComboList")
    public void buzhiComboList(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String buzhiName = request.getParameter("buzhiname");
        String buzhiType = request.getParameter("buzhiyype");
        String buyuanId = request.getParameter("buyuanid");
        String bumenId = request.getParameter("bumenid");
        BuzhiPojo buzhi = new BuzhiPojo();
        if (StringUtils.hasText(buzhiName)) {
            buzhi.setBuzhiname(buzhiName);
        }
        if (StringUtils.hasText(buzhiType)) {
            buzhi.setBuzhitype(Integer.parseInt(buzhiType));
        }
        if (StringUtils.hasText(buyuanId)) {
            buzhi.setBuyuanid(Integer.parseInt(buyuanId));
        }
        if (StringUtils.hasText(bumenId)) {
            buzhi.setBumenid(Integer.parseInt(bumenId));
        }
        try {
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", "");
            jsonObject.put("value", "请选择...");
            jsonArray.add(jsonObject);
            jsonArray.addAll(
                    JSONArray.fromObject(buzhiService.queryBuzhis(buzhi, 0, 0)
                            .stream().map(d -> new SelectListItem(d.getBuzhiid(), d.getBuzhiname()))
                            .collect(Collectors.toList())));
            ResponseUtil.write(response, jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
