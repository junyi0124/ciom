package edu.thn.ciom.controller;

import edu.thn.ciom.pojo.PeizhiPojo;
import edu.thn.ciom.service.JcpeizhiService;
import edu.thn.ciom.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class JcpeizhiController {

    @Autowired
    private JcpeizhiService jcpeizhiService;

    @RequestMapping("/addJcpeizhi")
    public void addJcpeizhi(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            JSONObject result = new JSONObject();

            String jcpeizhiName = request.getParameter("jcpeizhiName");
            String jcpeizhiNeirong = request.getParameter("jcpeizhiNeirong");
            String jcpeizhiMark = request.getParameter("jcpeizhiMark");
            String bumenBieming = request.getParameter("bumenBieming");
            String buyuanBieming = request.getParameter("buyuanBieming");
            String buzhiBieming = request.getParameter("buzhiBieming");
            String userBieming = request.getParameter("userBieming");
            String uxtypeBieming = request.getParameter("uxtypeBieming");
            String uxinxiBieming = request.getParameter("uxinxiBieming");
            String uyijianBieming = request.getParameter("uyijianBieming");
            String roleBieming = request.getParameter("roleBieming");
            String byumenBieming = request.getParameter("byumenBieming");
            String byuyuanBieming = request.getParameter("byuyuanBieming");
            String byuzhiBieming = request.getParameter("byuzhiBieming");
            String yonghuBieming = request.getParameter("yonghuBieming");
            String yxtypeBieming = request.getParameter("yxtypeBieming");
            String yxinxiBieming = request.getParameter("yxinxiBieming");
            String yyijianBieming = request.getParameter("yyijianBieming");
            String yhroleBieming = request.getParameter("yhroleBieming");
            String ggtypeBieming = request.getParameter("ggtypeBieming");
            String gonggaoBieming = request.getParameter("gonggaoBieming");
            String ggpinglunBieming = request.getParameter("ggpinglunBieming");
            String shujuBieming = request.getParameter("shujuBieming");
            String sjduochuBieming = request.getParameter("sjduochuBieming");
            String sjjianchuBieming = request.getParameter("sjjianchuBieming");
            String sjlaiyuanBieming = request.getParameter("sjlaiyuanBieming");
            String sjleixingBieming = request.getParameter("sjleixingBieming");
            String sjpinglunBieming = request.getParameter("sjpinglunBieming");
            String sjqitaBieming = request.getParameter("sjqitaBieming");
            String sjshaochuBieming = request.getParameter("sjshaochuBieming");
            String sjxingtaiBieming = request.getParameter("sjxingtaiBieming");
            String jcpeizhiType = request.getParameter("jcpeizhiType");
            String jcpeizhiType1 = request.getParameter("jcpeizhiType1");
            String jcpeizhiType2 = request.getParameter("jcpeizhiType2");
            String jcpeizhiId = request.getParameter("jcpeizhiId");
            PeizhiPojo jcpeizhi = new PeizhiPojo();

            if (StringUtils.hasText(jcpeizhiId)) {
                jcpeizhi = jcpeizhiService.getJcpeizhi(Integer.parseInt(jcpeizhiId));
            }
            if (StringUtils.hasText(jcpeizhiName)) {
                jcpeizhi.setJcpeizhiname(jcpeizhiName);
            }
            if (StringUtils.hasText(jcpeizhiNeirong)) {
                jcpeizhi.setJcpeizhineirong(jcpeizhiNeirong);
            }
            if (StringUtils.hasText(jcpeizhiMark)) {
                jcpeizhi.setJcpeizhimark(jcpeizhiMark);
            }
            if (StringUtils.hasText(bumenBieming)) {
                jcpeizhi.setBumenbieming(bumenBieming);
            }
            if (StringUtils.hasText(buyuanBieming)) {
                jcpeizhi.setBuyuanbieming(buyuanBieming);
            }
            if (StringUtils.hasText(buzhiBieming)) {
                jcpeizhi.setBuzhiBieming(buzhiBieming);
            }
            if (StringUtils.hasText(userBieming)) {
                jcpeizhi.setUserBieming(userBieming);
            }
            if (StringUtils.hasText(uxtypeBieming)) {
                jcpeizhi.setUxtypebieming(uxtypeBieming);
            }
            if (StringUtils.hasText(uxinxiBieming)) {
                jcpeizhi.setUxinxibieming(uxinxiBieming);
            }
            if (StringUtils.hasText(uyijianBieming)) {
                jcpeizhi.setUyijianbieming(uyijianBieming);
            }
            if (StringUtils.hasText(roleBieming)) {
                jcpeizhi.setRolebieming(roleBieming);
            }
            if (StringUtils.hasText(byumenBieming)) {
                jcpeizhi.setByumenbieming(byumenBieming);
            }
            if (StringUtils.hasText(byuyuanBieming)) {
                jcpeizhi.setByuyuanbieming(byuyuanBieming);
            }
            if (StringUtils.hasText(byuzhiBieming)) {
                jcpeizhi.setByuzhibieming(byuzhiBieming);
            }
            if (StringUtils.hasText(yonghuBieming)) {
                jcpeizhi.setYonghuBieming(yonghuBieming);
            }
            if (StringUtils.hasText(yxtypeBieming)) {
                jcpeizhi.setYxtypebieming(yxtypeBieming);
            }
            if (StringUtils.hasText(yxinxiBieming)) {
                jcpeizhi.setYxinxibieming(yxinxiBieming);
            }
            if (StringUtils.hasText(yyijianBieming)) {
                jcpeizhi.setYyijianbieming(yyijianBieming);
            }
            if (StringUtils.hasText(yhroleBieming)) {
                jcpeizhi.setYhrolebieming(yhroleBieming);
            }
            if (StringUtils.hasText(ggtypeBieming)) {
                jcpeizhi.setGgtypebieming(ggtypeBieming);
            }
            if (StringUtils.hasText(gonggaoBieming)) {
                jcpeizhi.setGonggaobieming(gonggaoBieming);
            }
            if (StringUtils.hasText(ggpinglunBieming)) {
                jcpeizhi.setGgpinglunbieming(ggpinglunBieming);
            }
            if (StringUtils.hasText(shujuBieming)) {
                jcpeizhi.setShujubieming(shujuBieming);
            }
            if (StringUtils.hasText(sjduochuBieming)) {
                jcpeizhi.setSjduochubieming(sjduochuBieming);
            }
            if (StringUtils.hasText(sjjianchuBieming)) {
                jcpeizhi.setSjjianchubieming(sjjianchuBieming);
            }
            if (StringUtils.hasText(sjlaiyuanBieming)) {
                jcpeizhi.setSjlaiyuanbieming(sjlaiyuanBieming);
            }
            if (StringUtils.hasText(sjleixingBieming)) {
                jcpeizhi.setSjleixingbieming(sjleixingBieming);
            }
            if (StringUtils.hasText(sjpinglunBieming)) {
                jcpeizhi.setSjpinglunbieming(sjpinglunBieming);
            }
            if (StringUtils.hasText(sjqitaBieming)) {
                jcpeizhi.setSjqitabieming(sjqitaBieming);
            }
            if (StringUtils.hasText(sjshaochuBieming)) {
                jcpeizhi.setSjshaochubieming(sjshaochuBieming);
            }
            if (StringUtils.hasText(sjxingtaiBieming)) {
                jcpeizhi.setSjxingtaibieming(sjxingtaiBieming);
            }
            if (StringUtils.hasText(jcpeizhiType)) {
                jcpeizhi.setJcpeizhitype(Integer.parseInt(jcpeizhiType));
            }
            if (StringUtils.hasText(jcpeizhiType1)) {
                jcpeizhi.setJcpeizhitype1(Integer.parseInt(jcpeizhiType1));
            }
            if (StringUtils.hasText(jcpeizhiType2)) {
                jcpeizhi.setJcpeizhitype2(Integer.parseInt(jcpeizhiType2));
            }
            if (StringUtils.hasText(jcpeizhiId)) {
                jcpeizhiService.modifyJcpeizhi(jcpeizhi);
                result.put("success", "true");
                ResponseUtil.write(response, result);
            } else {
                jcpeizhiService.save(jcpeizhi);
                result.put("success", "true");
                ResponseUtil.write(response, result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/getJcpeizhis")
    public void getJcpeizhis(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        System.out.println("你好啊");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        String jcpeizhiName = request.getParameter("jcpeizhiName");
        String jcpeizhiId = request.getParameter("jcpeizhiId");
        String jcpeizhiType = request.getParameter("jcpeizhiType");
        String jcpeizhiType1 = request.getParameter("jcpeizhiType1");
        PeizhiPojo jcpeizhi = new PeizhiPojo();
        PageBean pageBean = null;
        if ((StringUtils.hasText(page)) && (!page.equals("null"))) {
            pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        } else {
            pageBean = new PageBean(0, 0);
        }
        try {
            if (StringUtils.hasText(jcpeizhiName)) {
                jcpeizhi.setJcpeizhiname(jcpeizhiName);
            }
            if (StringUtils.hasText(jcpeizhiId)) {
                jcpeizhi.setJcpeizhiid(Integer.parseInt(jcpeizhiId));
            }
            if (StringUtils.hasText(jcpeizhiType)) {
                jcpeizhi.setJcpeizhitype(Integer.parseInt(jcpeizhiType));
            }
            if (StringUtils.hasText(jcpeizhiType1)) {
                jcpeizhi.setJcpeizhitype1(Integer.parseInt(jcpeizhiType1));
            }
            @SuppressWarnings("unchecked")
            List<PeizhiPojo> jcpeizhis = jcpeizhiService.queryJcpeizhis(jcpeizhi, pageBean.getStart(), pageBean.getRows());
            JSONArray jsonArray = JSONArray.fromObject(jcpeizhis);
            for (PeizhiPojo j : jcpeizhis) {
                System.out.println(j);
            }
            JSONObject result = new JSONObject();
            int total = jcpeizhiService.queryJcpeizhis(jcpeizhi, 0, 0).size();
            result.put("rows", jsonArray);
            result.put("total", total);
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/getJcpeizhi")
    public void getpeizhi(HttpServletRequest request,
                          HttpServletResponse response) throws Exception {
        String jcpeizhiId = request.getParameter("jcpeizhiId");
        int id = Integer.parseInt(jcpeizhiId);
        PeizhiPojo jcpeizhi = jcpeizhiService.getJcpeizhi(id);
        if (jcpeizhi != null) {
            JSONObject result = new JSONObject();
            JSONArray jsonArray = JSONArray.fromObject(jcpeizhi);
            result.put("rows", jsonArray);
            result.put("total", 1);
            ResponseUtil.write(response, result);
        }
        ResponseUtil.write(response, "{\"rows\":[],\"total\":0}");
    }

    @RequestMapping("/deleteJcpeizhi")
    public void deleteJcpeizhi(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            String delIds = request.getParameter("delIds");
            System.out.println("delIds = " + delIds);
            JSONObject result = new JSONObject();
            String[] str = delIds.split(",");
            for (int i = 0; i < str.length; i++) {
                jcpeizhiService.deleteJcpeizhi(Integer.parseInt(str[i]));
            }
            result.put("success", "true");
            result.put("delNums", str.length);
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/jcpeizhiComboList")
    public void jcpeizhiComboList(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String jcpeizhiType = request.getParameter("jcpeizhiType");
        PeizhiPojo jcpeizhi = new PeizhiPojo();
        try {
            if (StringUtils.hasText(jcpeizhiType)) {
                jcpeizhi.setJcpeizhitype(Integer.parseInt(jcpeizhiType));
            }
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", "");
            jsonObject.put("jcpeizhiName", "请选择...");
            jsonArray.add(jsonObject);
            jsonArray.addAll(JSONArray.fromObject(jcpeizhiService.queryJcpeizhis(jcpeizhi, 0, 0)));
            ResponseUtil.write(response, jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
