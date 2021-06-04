<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%

	String error = (String)session.getAttribute("error");
	if(error!=null && error.length() >0) {
	    session.removeAttribute("error");
	}
%>