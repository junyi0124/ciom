<%@ page language="java" contentType="text/html; charset=utf-8"  
import="edu.thn.ciom.pojo.*,edu.thn.ciom.util.*,java.util.List,java.util.ArrayList,net.sf.json.JSONArray,net.sf.json.JSONObject,net.sf.json.JsonConfig"
pageEncoding="utf-8"%>
<%
	StringBuffer jcpeizhiparam = new StringBuffer("jcpeizhiId=1");
	List<PeizhiPojo> jcpeizhis = new ArrayList<PeizhiPojo>();
	PeizhiPojo jcpeizhi = null;
	int jcpeizhisshuliang = 0;
	String jcpeizhipath = request.getContextPath();
	String jcpeizhibasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+jcpeizhipath+"/";
	
	String jcpeizhiurl = jcpeizhibasePath + "getJcpeizhis";
	JSONObject jcpeizhiresult = PostUtil.sendPost(jcpeizhiurl, jcpeizhiparam.toString());
	if(jcpeizhiresult != null) {
		JSONArray jcpeizhijsonArray = (JSONArray)jcpeizhiresult.get("rows");
		//System.out.println(jcpeizhijsonArray);
		jcpeizhis = JSONArray.toList(jcpeizhijsonArray, new PeizhiPojo(), new JsonConfig());
		if( jcpeizhis.size() > 0){
			jcpeizhi = jcpeizhis.get(0);
		}
		for(int i = 0;i < jcpeizhis.size();i++){
			System.out.println(jcpeizhis.get(i).getJcpeizhiname());
		}
		jcpeizhisshuliang = (Integer)jcpeizhiresult.get("total");
	}
	session.setAttribute("jcpeizhi", jcpeizhi);
%>