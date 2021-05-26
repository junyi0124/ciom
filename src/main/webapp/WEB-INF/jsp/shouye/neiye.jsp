<%@ page language="java" contentType="text/html; charset=utf-8" import="edu.thn.ciom.pojo.*,java.util.List"
	pageEncoding="utf-8"%>
<%
	PeizhiPojo newJcpeizhi = (PeizhiPojo)session.getAttribute("jcpeizhi");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><%=newJcpeizhi.getJcpeizhiname()%></title>
</head>
<head>
    <title><%=newJcpeizhi.getJcpeizhiname()%></title><meta charset="UTF-8" />
<body>
<div title="<%=newJcpeizhi.getJcpeizhiname()%>" >
	<div align="center" style="padding-top: 10px;">
	    <font color="#4C91D1" size="8">欢迎使用<%=newJcpeizhi.getJcpeizhiname()%>
	    </font>
    </div>
</div>
</body>
</html>