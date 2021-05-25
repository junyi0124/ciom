package edu.thn.ciom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * visit web-inf/jsp/** /*.jsp
 */
@Controller
public class JspController {

    @RequestMapping(value="/index", method= RequestMethod.GET)
    public String Index() {
        return "index";
    }

    @RequestMapping(value = "/shouye/index", method= RequestMethod.GET)
    public String shou_ye_index() {
        return "shouye/index";
    }

    @RequestMapping(value = "/shouye/neiye", method= RequestMethod.GET)
    public String shou_ye_nei_ye() {
        return "shouye/neiye";
    }

    @RequestMapping(value = "/shouye/tuichu", method= RequestMethod.GET)
    public String shou_ye_tui_chu() {
        return "shouye/tuichu";
    }

    @RequestMapping(value = "/admin/adminmima", method= RequestMethod.GET)
    public String admin_mima() {
        return "admin/adminmima";
    }

    @RequestMapping(value = "/admin/yonghu", method= RequestMethod.GET)
    public String admin_yonghu() {
        return "admin/yonghu";
    }

    @RequestMapping(value = "/admin/user", method= RequestMethod.GET)
    public String admin_user() {
        return "admin/user";
    }

    @RequestMapping(value = "/jiazai/jcpeizhibaohan", method= RequestMethod.GET)
    public String load_peizhi() {
        return "jiazai/jcpeizhibaohan";
    }

}

