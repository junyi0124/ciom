package edu.thn.ciom.controller;

import edu.thn.ciom.pojo.*;
import edu.thn.ciom.service.*;
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
public class LoginController {

    @Autowired
    private RizhiService rizhiService;
    @Autowired
    private UserService userService;
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private AdminService adminService;

    @Autowired
    private JcdaohangService jcdaohangService;
    @Autowired
    private JcbiaotiService jcbiaotiService;
    @Autowired
    private JcpeizhiService jcpeizhiService;


    @RequestMapping("/login")
    public void loginUser(HttpServletRequest request,
                          HttpServletResponse response) throws Exception {
        String userName = (String) request.getParameter("userName");
        String password = (String) request.getParameter("password");
        String loginType = (String) request.getParameter("loginType");

        String ip = request.getRemoteAddr();
        Date date = new Date();
        RizhiPojo rizhi = new RizhiPojo();
        rizhi.setRizhiname(userName);
        rizhi.setDate(date);
        rizhi.setDengluip(ip);
        rizhiService.save(rizhi);

        if (StringUtils.hasText(userName) || StringUtils.hasText(password)) {
            request.setAttribute("error", "用户名或密码为空！");
            request.getRequestDispatcher("shouye/index").forward(request,
                    response);
        } else {
            PeizhiPojo config = jiazaiPeizhi();
            if (config == null) {
                request.setAttribute("error", "系统还未配置参数，联系管理员！");
                // 服务器跳转
                request.getRequestDispatcher("shouye/index").forward(request, response);
            } else {
                // 获取Session
                HttpSession session = request.getSession();
                session.setAttribute("jcpeizhi", config);
                if ("admin".equals(loginType)) {
                    AdminPojo admin = new AdminPojo();
                    admin.setAdminname(userName);
                    admin.setAdminpassword(password);
                    try {
                        if (adminService.queryAdmins(admin, 0, 0).size() == 1) {
                            session.setAttribute("admin", admin);
                            List<BiaotiPojo> jcbiaotis = jiazaiBiaoti(1);
                            if (jcbiaotis.size() == 0) {
                                request.setAttribute("error", "系统还未配置标题，联系管理员！");
                                // 服务器跳转
                                request.getRequestDispatcher("shouye/index").forward(request, response);
                            } else {
                                List<List<DaohangPojo>> jcdaohangslist = jiazaiDaohang(jcbiaotis);
                                session.setAttribute("jcdaohangslist", jcdaohangslist);
                                session.setAttribute("jcbiaotis", jcbiaotis);
                                session.setAttribute("admin", admin);
                                // 客户端跳转
                                response.sendRedirect("houtai/adminMain");
                            }
                        } else {
                            request.setAttribute("error", "用户名或密码错误！");
                            // 服务器跳转
                            request.getRequestDispatcher("shouye/index").forward(request, response);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        request.setAttribute("error", "服务器错误！");
                        // 服务器跳转
                        request.getRequestDispatcher("shouye/index").forward(request, response);
                    }
                } else if (loginType.equals("yonghu")) {
                    YongHuPojo yonghu = new YongHuPojo();
                    yonghu.setYonghuname(userName);
                    yonghu.setYonghupassword(password);
                    try {
                        if (yonghuService.queryYonghus(yonghu, userName, 0, 0, null, null, null, null).size() == 1) {
                            YongHuPojo yonghuLogin = (YongHuPojo) (yonghuService.queryYonghus(yonghu, userName, 0, 0, null, null, null, null)).get(0);
                            List<BiaotiPojo> jcbiaotis = jiazaiBiaoti(3);
                            if (jcbiaotis.size() == 0) {
                                request.setAttribute("error", "系统还未配置标题，联系管理员！");
                                // 服务器跳转
                                request.getRequestDispatcher("shouye/index.jsp").forward(request, response);
                            } else {
                                List<List<DaohangPojo>> jcdaohangslist = jiazaiDaohang(jcbiaotis);
                                session.setAttribute("jcdaohangslist", jcdaohangslist);
                                session.setAttribute("jcbiaotis", jcbiaotis);
                                session.setAttribute("yonghu", yonghuLogin);
                                // 客户端跳转
                                response.sendRedirect("houtai/yonghuMain");
                            }
                        } else {
                            request.setAttribute("error", "用户名或密码错误！");
                            // 服务器跳转
                            request.getRequestDispatcher("shouye/index").forward(request, response);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        request.setAttribute("error", "服务器错误！");
                        // 服务器跳转
                        request.getRequestDispatcher("shouye/index").forward(request, response);
                    }
                } else if (loginType.equals("user")) {
                    UserPojo user = new UserPojo();
                    user.setUsername(userName);
                    user.setUserpassword(password);
                    try {
                        if (userService.queryUsers(user, userName, 0, 0, null, null, null, null).size() == 1) {
                            UserPojo userLogin = (UserPojo) (userService.queryUsers(user, userName, 0, 0, null, null, null, null)).get(0);
                            List<BiaotiPojo> jcbiaotis = jiazaiBiaoti(2);
                            if (jcbiaotis.size() == 0) {
                                request.setAttribute("error", "系统还未配置标题，联系管理员！");
                                // 服务器跳转
                                request.getRequestDispatcher("shouye/index").forward(request, response);
                            } else {
                                List<List<DaohangPojo>> jcdaohangslist = jiazaiDaohang(jcbiaotis);
                                session.setAttribute("jcdaohangslist", jcdaohangslist);
                                session.setAttribute("jcbiaotis", jcbiaotis);
                                session.setAttribute("user", userLogin);
                                // 客户端跳转
                                response.sendRedirect("houtai/userMain");
                            }
                        } else {
                            request.setAttribute("error", "用户名或密码错误！");
                            // 服务器跳转
                            request.getRequestDispatcher("shouye/index").forward(request, response);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        request.setAttribute("error", "服务器错误！");
                        // 服务器跳转
                        request.getRequestDispatcher("shouye/index").forward(request, response);
                    }
                } else {
                    request.setAttribute("error", "登录权限错误！");
                    // 服务器跳转
                    request.getRequestDispatcher("shouye/index").forward(request, response);
                }
            }
        }
    }

    //Jcpeizhi
    private PeizhiPojo jiazaiPeizhi() {
        List<PeizhiPojo> jcpeizhis = new ArrayList<PeizhiPojo>();
        jcpeizhis = jcpeizhiService.queryJcpeizhis(null, 0, 0);
        if (jcpeizhis.size() > 0) {
            return jcpeizhis.get(0);
        } else {
            return null;
        }
    }

    //Jcbiaoti
    private List<BiaotiPojo> jiazaiBiaoti(int jcbiaotiType) {
        BiaotiPojo jcbiaoti = new BiaotiPojo();
        jcbiaoti.setJcbiaotitype(jcbiaotiType);
        jcbiaoti.setJcbiaotitype1(0);
        List<BiaotiPojo> jcbiaotis = new ArrayList<BiaotiPojo>();
        jcbiaotis = jcbiaotiService.queryJcbiaotis(jcbiaoti, 0, 0);
        return jcbiaotis;
    }

    private List<List<DaohangPojo>> jiazaiDaohang(List<BiaotiPojo> jcbiaotis) {
        List<List<DaohangPojo>> jcdaohangslist = new ArrayList<>();
        for (int i = 0; i < jcbiaotis.size(); i++) {
            List<DaohangPojo> jcdaohangs = new ArrayList<DaohangPojo>();
            DaohangPojo jcdaohang = new DaohangPojo();
            jcdaohang.setJcdaohangtype1(0);
            jcdaohang.setJcbiaotiid(jcbiaotis.get(i).getJcbiaotiid());
            jcdaohangs = jcdaohangService.queryJcdaohangs(jcdaohang, 0, 0);
            jcdaohangslist.add(jcdaohangs);
        }
        return jcdaohangslist;
    }
}
