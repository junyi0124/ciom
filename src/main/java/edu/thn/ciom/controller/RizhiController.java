package edu.thn.ciom.controller;

import edu.thn.ciom.pojo.RizhiPojo;
import edu.thn.ciom.service.RizhiService;
import edu.thn.ciom.util.ResponseUtil;
import org.springframework.stereotype.Controller;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RizhiController {
    @Autowired
    private RizhiService rizhiService;

    @RequestMapping("/getRizhis")
    public void getRizhis(HttpServletRequest request,
                          HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String page = (String) request.getParameter("page");
        String rows = (String) request.getParameter("rows");
        String rizhiName = (String) request.getParameter("rizhiName");
        String rizhiId = (String) request.getParameter("rizhiId");
        PageBean pageBean = null;
        if ((StringUtils.hasText(page))&&(!page.equals("null"))) {
            pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        }else{
            pageBean = new PageBean(0,0);
        }
        RizhiPojo rizhi = new RizhiPojo();
        try {
            if (StringUtils.hasText(rizhiName)) {
                rizhi.setRizhiname(rizhiName);
            }
            if (StringUtils.hasText(rizhiId)) {
                rizhi.setRizhiid(Integer.parseInt(rizhiId));
            }
            JSONArray jsonArray = JSONArray.fromObject(rizhiService.queryRizhis(rizhi, pageBean.getStart(), pageBean.getRows()));
            JSONObject result = new JSONObject();
            int total = rizhiService.queryRizhis(rizhi, 0, 0).size();
            result.put("rows", jsonArray);
            result.put("total", total);
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/deleteRizhi")
    public void deleteRizhi(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            String delIds = (String) request.getParameter("delIds");
            System.out.println("delIds = " + delIds);
            JSONObject result = new JSONObject();
            String str[] = delIds.split(",");
            for (int i = 0; i < str.length; i++) {
                rizhiService.deleteRizhi(Integer.parseInt(str[i]));
            }
            result.put("success", "true");
            result.put("delNums", str.length);
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
