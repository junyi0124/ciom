<%@ page language="java" contentType="text/html; charset=utf-8"  
import="edu.thn.ciom.pojo.*,edu.thn.ciom.util.*,java.util.List,java.util.ArrayList,net.sf.json.JSONArray,net.sf.json.JSONObject,net.sf.json.JsonConfig"
pageEncoding="utf-8"%>
<%
	//String path = request.getContextPath();
	//String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<%
	// 权限验证
	AdminPojo admin = (AdminPojo)session.getAttribute("admin");
	if(admin==null){
		System.out.println("没有得到adminId");
		response.sendRedirect("../shouye/index");
		return;
	}
	PeizhiPojo newJcpeizhi = (PeizhiPojo)session.getAttribute("jcpeizhi");
	List<BiaotiPojo> jcbiaotis = (List<BiaotiPojo>)session.getAttribute("jcbiaotis");
	List<List<DaohangPojo>> jcdaohangslist = (List<List<DaohangPojo>>)session.getAttribute("jcdaohangslist");
	List<DaohangPojo> jcdaohangs = new ArrayList<DaohangPojo>();
	for(int i=0;i<jcdaohangslist.size();i++){
		List<DaohangPojo> rows = jcdaohangslist.get(i);
		for(int j=0;j<rows.size();j++){
			jcdaohangs.add(rows.get(j));
		}
	}
	String adminName = admin.getAdminname();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
	<link rel="icon" href="/static/muban10/assets/favicon.ico">
    <title><%=newJcpeizhi.getJcpeizhiname()%></title>
    <link rel="stylesheet" href="/static/muban10/assets/css/layui.css">
    <link rel="stylesheet" href="/static/muban10/assets/css/admin.css">

</head>
<body class="layui-layout-body">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header custom-header">
            
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item slide-sidebar" lay-unselect>
                    <a href="javascript:;" class="icon-font"><i class="ai ai-menufold"></i></a>
                </li>
            </ul>

            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item">
                    <a href="javascript:;">管理员，<%=adminName %></a>
                    <dl class="layui-nav-child">
                        <dd><a href="/admin/adminmima">修改密码</a></dd>
                        <dd><a href="/shouye/tuichu">退出</a></dd>
                    </dl>
                </li>
            </ul>
        </div>

        <div class="layui-side custom-admin">
            <div class="layui-side-scroll">

                <div class="custom-logo">
                    <h1><%=newJcpeizhi.getJcpeizhiname()%></h1>
                </div>
                <ul id="Nav" class="layui-nav layui-nav-tree">
                    <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon layui-icon-layouts"></i>
                            <em>主页</em>
                        </a>
                        <dl class="layui-nav-child">
                            <dd><a href="/shouye/neiye">欢迎页</a></dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd><a href="/admin/adminmima">修改密码</a></dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd><a href="/admin/rizhi">登录日志</a></dd>
                        </dl>
                    </li>
                    <%for(int i = 0; i < jcbiaotis.size(); i++){ %>
		            <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe857;</i>
                            <em><%= jcbiaotis.get(i).getJcbiaotiname() %></em>
                        </a>
                        <dl class="layui-nav-child">
                        <%for(int j = 0; j < jcdaohangslist.get(i).size(); j++){ %>
		                    <dd><a href="/admin/<%=jcdaohangslist.get(i).get(j).getJcdaohangneirong() %>">
		                    <%=jcdaohangslist.get(i).get(j).getJcdaohangname() %></a></dd>
                        <%} %>
						</dl>
                    </li>
					<%} %>
                </ul>

            </div>
        </div>

        <div class="layui-body">
             <div class="layui-tab app-container" lay-allowClose="true" lay-filter="tabs">
                <ul id="appTabs" class="layui-tab-title custom-tab"></ul>
                <div id="appTabPage" class="layui-tab-content"></div>
            </div>
        </div>

        <div class="layui-footer">
            <p><%=newJcpeizhi.getJcpeizhiname()%></p>
        </div>

        <div class="mobile-mask"></div>
    </div>
    <script src="/static/muban10/assets/layui.js"></script>
    <script src="/static/muban10/index.js" data-main="home"></script>
</body>
</html>