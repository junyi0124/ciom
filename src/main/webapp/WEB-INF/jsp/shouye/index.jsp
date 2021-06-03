<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="../jiazai/jcpeizhibaohan.jsp"%>
<%
	PeizhiPojo newJcpeizhi = (PeizhiPojo)session.getAttribute("jcpeizhi");
	Session.
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><%=newJcpeizhi.getJcpeizhiname()%></title>
<style type="text/css">
<!--
body,td,th {
	font-family: 微软雅黑;
	font-size: 12px;
	color: #333333;
}
body {
    margin:0 auto;
	background-image: url(/static/images/loginbg.jpg);
	background-repeat: no-repeat;
	background-position: center top;
	background-color:#F2F2F2;
	width:1000px;
}
a:link {
	color: #333333;
	text-decoration: none;
}
a:visited {
	text-decoration: none;
	color: #333333;
}
a:hover {
	text-decoration: none;
	color: #01A2AA;
}
a:active {
	text-decoration: none;
	color: #01A2AA;
}
.login2016{ width:auto; height:455px; padding-top:305px; padding-left:710px; padding-right:48px;}
#logtab{}
#logtab td{height:55px;}
.reglink{ color:#FFFFFF; font-weight:bold; font-size:14px;}
.reglink a{ color:#FFFFFF!important;}

#logtab input{
	width:180px;
	height:38px;
	line-height:38px;
	background-color:#FFFFFF;
	padding-left:50px;
    border:0px #fff solid;
	color:#666666;
	font-size:14px;
	border-radius:3px;
}
#logtab select{
	width:224px;
	height:38px;
	line-height:38px;
	background-color:#FFFFFF;
	
    border:0px #fff solid;
	color:#666666;
	font-size:14px;
	border-radius:3px;
}
#logtab .input1{
	background-image: url(/static/images/login_3.jpg);
	background-repeat: no-repeat;
	background-position: left center;
}

#logtab .input2{
	background-image: url(/static/images/login_6.jpg);
	background-repeat: no-repeat;
	background-position: left center;
}

#logtab .input3{
    width:100px!important;
	background-image: url(/static/images/login_11.jpg);
	background-repeat: no-repeat;
	background-position: left center;
}

.bottom2016{ width:1000px; height:105px; padding-top:35px; line-height:35px; text-align:center; color:#878787;}
.bottom2016 a{ color:#878787!important;}

-->
</style> 

<style>
a:link{text-decoration: none;color: gray}
a:active{text-decoration:blink}
a:hover{text-decoration:underline;color: red}
a:visited{text-decoration: none;color: yellow}
</style>

<script language="javascript">
function checklogin()
{
  if(document.login.userName.value=='')
     {alert('请输入帐户');
      document.login.userName.focus();
      return false
    }
  if (document.login.password.value=='')
   {alert('请输入密码');
    document.login.password.focus();
    return false
   }
}
</script>
</head>
<body>

<div class="login2016">
<form class="formname" action="/login" name="login" method="post" onSubmit="return checklogin();">
  <table width="100%" border="0" cellspacing="0" cellpadding="0" id="logtab">
    <tr>
      <td><input type="text" name="userName"  class="input1" /></td>
    </tr>
    <tr>
      <td><input type="password" name="password"  class="input2" /></td>
    </tr>
    <tr>
      <td><table width="100%" border="0" cellspacing="0" cellpadding="0" id="logtab">
        <tr>
          <td>
              <select name="loginType" class="select">
                <option value="admin">管理员</option>
                <option value="user"><%=newJcpeizhi.getUserBieming()%></option>
                <option value="yonghu"><%=newJcpeizhi.getYonghuBieming()%></option>
              </select>
            </td>
          <td></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td valign="middle"><input type="image" src="/static/images/login_14.jpg" width="274" height="40" border="0"  style="padding-left:0px;width:224px;"/></td>
    </tr>
  </table> </form>
  <a href="../user/zhuceuser"><%=newJcpeizhi.getUserBieming()%>注册</a>&nbsp;&nbsp;
  <a href="../yonghu/zhuceyonghu"><%=newJcpeizhi.getYonghuBieming()%>注册</a><br>
  <font color="red">${error }</font>
</div>
</body></html>