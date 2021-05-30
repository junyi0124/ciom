package edu.thn.ciom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * visit web-inf/jsp/** /*.jsp
 */
@Controller
public class JspController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultView() {
        return "forward:/shouye/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String Index() {
        return "index";
    }

    @RequestMapping(value = "/shouye/index", method = RequestMethod.GET)
    public String shou_ye_index() {
        return "shouye/index";
    }

    @RequestMapping(value = "/shouye/neiye", method = RequestMethod.GET)
    public String shou_ye_nei_ye() {
        return "shouye/neiye";
    }

    @RequestMapping(value = "/shouye/tuichu", method = RequestMethod.GET)
    public String shou_ye_tui_chu() {
        return "shouye/tuichu";
    }

    @RequestMapping(value = "/admin/adminmima", method = RequestMethod.GET)
    public String admin_mima() {
        return "admin/adminmima";
    }

    @RequestMapping(value = "/admin/yonghu", method = RequestMethod.GET)
    public String admin_yonghu() {
        return "admin/yonghu";
    }

    @RequestMapping(value = "/admin/user", method = RequestMethod.GET)
    public String admin_user() {
        return "admin/user";
    }

    @RequestMapping(value = "/admin/rizhi", method = RequestMethod.GET)
    public String admin_rizhi() {
        return "admin/rizhi";
    }

    @RequestMapping(value = "/admin/buzhi", method = RequestMethod.GET)
    public String admin_buzhi() {
        return "admin/buzhi";
    }

    @RequestMapping(value = "/jiazai/jcpeizhibaohan", method = RequestMethod.GET)
    public String load_peizhi() {
        return "jiazai/jcpeizhibaohan";
    }

    @RequestMapping(value = "/houtai/adminMain", method = RequestMethod.GET)
    public String backend_admin() {
        return "houtai/adminMain";
    }
    /*
    GET /admin/sjleixing    车辆类型
    GET /admin/shuju        车辆信息
    GET /admin/sjduochu     报价信息
    GET /admin/sjjianchu    交流信息
    GET /admin/sjshaochu    下单信息
     */

    @RequestMapping(value = "/houtai/yonghuMain", method = RequestMethod.GET)
    public String backend_yonghu() {
        return "houtai/yonghuMain";
    }

    /*
    GET /yonghu/yonghu     个人信息
    GET /yonghu/yonghumima 个人信息
    GET /yonghu/shuju      车辆信息
    GET /yonghu/sjduochu   报价信息
    GET /yonghu/sjjianchu  交流信息
    GET /yonghu/sjshaochu  下单信息
     */

    @RequestMapping(value = "/houtai/userMain", method = RequestMethod.GET)
    public String backend_user() {
        return "houtai/userMain";
    }
/*
GET /user/shuju     车辆信息
GET /user/sjduochu  报价信息
GET /user/sjjianchu 交流信息
GET /user/sjshaochu 下单信息
 */
}

