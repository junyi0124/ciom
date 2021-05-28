package edu.thn.ciom.controller;

import edu.thn.ciom.pojo.AdminPojo;
import edu.thn.ciom.pojo.PeizhiPojo;
import edu.thn.ciom.service.AdminService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/mimaAdmin")
    public void mimaAdmin(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            JSONObject result = new JSONObject();

            String adminPassword = request.getParameter("adminPassword");
            String adminPassword1 = request.getParameter("adminPassword1");
            AdminPojo admin = new AdminPojo();
            admin.setAdminname("admin");
            admin.setAdminpassword(adminPassword);

//            PeizhiPojo p = new PeizhiPojo();
//            p.getBuzhiBieming()


            if (adminService.queryAdmins(admin, 0, 0).size() == 1) {
                admin = (AdminPojo) (adminService.queryAdmins(admin, 0, 0)).get(0);
                admin.setAdminpassword(adminPassword1);
                adminService.modifyAdmin(admin);
                request.setAttribute("error", "密码修改成功！");
                request.getRequestDispatcher("admin/adminmima").forward(request,
                        response);
            } else {
                result.put("success", "true");
                request.setAttribute("error", "原密码错误，请重新输入！");
                request.getRequestDispatcher("admin/adminmima").forward(request,
                        response);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
