<%@ page language="java" import="edu.thn.ciom.pojo.*"  pageEncoding="utf-8"%>
<%
PeizhiPojo newJcpeizhi = (PeizhiPojo)session.getAttribute("jcpeizhi");
UserPojo user = (UserPojo)session.getAttribute("user");
int buzhiId = user.getBuzhiid();
int userId = user.getUserid();

String title    = newJcpeizhi.getShujubieming();
String shaochu  = newJcpeizhi.getSjshaochubieming();
String jianchu  = newJcpeizhi.getSjjianchubieming();
String douchu   = newJcpeizhi.getSjduochubieming();
String username = newJcpeizhi.getUserBieming();
String yonghu   = newJcpeizhi.getYonghuBieming();
String typename = newJcpeizhi.getSjleixingbieming();
String areaname = newJcpeizhi.getBuzhiBieming();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><%=title%>信息</title>
<link rel="stylesheet" type="text/css" href="/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
var url;
var userId = <%=userId%>;
	function searchShuju(){
		$('#dg').datagrid('load',{
			shujuname:$('#s_shujuname').val(),
			sjleixingid:$('#s_sjleixingid').combobox("getValue")
		});
	}
	
	function saveShuju(){
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
			
				var s=result;
				var result = eval('(' + result + ')');
			
				if(result.errorMsg){
					$.messager.alert("系统提示",result.errorMsg);
					return;
				}else{
					$.messager.alert("系统提示","保存成功");
					resetValue();
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				}
			}
		});
	}
	
	function openShujuAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加<%=title%>信息");
		url="../addShuju?userid="+userId;
	}
	
	function resetValue(){
	}
	
	function deleteShuju(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].shujuid);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删掉这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("../deleteShuju",{delIds:ids},function(result){
					if(result.success){
						$.messager.alert("系统提示","您已成功删除<font color=red>"+result.delNums+"</font>条数据！");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert('系统提示','<font color=red>'+selectedRows[result.errorIndex].shujuname+'</font>'+result.errorMsg);
					}
				},"json");
			}
		});
	}
	
	function closeShujuDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	function openShujuModifyDialog() {
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","编辑<%=title%>信息");
		$("#fm").form("load",row);
		url="../addShuju?shujuid="+row.shujuid;
	}
	
	function formatSex(shujuSex, row) {  
		if(shujuSex==0) {
			return "男";
		}
		if(shujuSex==1) {
			return "女";
		}
	}
	
	function formatType1(shujuType1, row) {  
		if(shujuType1==0){
			return "零";
		}
		if(shujuType1==1){
			return "一";
		}
	}
	
	function formatType(shujuType, row) {  
		if(shujuType==0){
			return "0";
		}
		if(shujuType==1){
			return "1";
		}
	}
	
	function formatChakan(shujuImg, row) {
		if(shujuImg){
			return '<a target="_blank" style="color:red;" href="../' + shujuImg + '">查看' + '</a>'; 
		}else {
			return "未上传";
		}
	}
	
	function formatXiazai(shujuImgName, row) {
		if(shujuImgName){
			return '<a target="_blank" style="color:red;" href="../downFile?filename=' + shujuImgName + '">下载' + '</a>'; 
		}else {
			return "未上传";
		}
	}
	
	function daochuShuju() {
		var selectedRows = $("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要导出的数据！");
			return;
		}
		var shujuIds=[];
		for(var i=0;i<selectedRows.length;i++){
			shujuIds.push(selectedRows[i].shujuid);
		}
		var ids=shujuIds.join(",");
		$.messager.confirm("系统提示","您确认要导出数据吗？",function(r){
			if(r){
				$.post("../daochuShuju",{delIds:ids},function(result){
					if(result.success){
						$.messager.alert("系统提示","您已成功导出数据：D:！");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert('系统提示','<font color=red>'+selectedRows[result.errorIndex].shujuname+'</font>'+result.errorMsg);
					}
				},"json");
			}
		});
	}
	
	function doPrint() {      
        bdhtml=window.document.body.innerHTML;      
        sprnstr="<!--startprint-->";      
        eprnstr="<!--endprint-->";      
        prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17);      
        prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));      
        window.document.body.innerHTML=prnhtml;   
        window.print();      
	}
	
	function daoruShujus(){
		$("#daoru").dialog("open").dialog("setTitle","导入<%=title%>信息");
		daoruurl="../daoruShuju";
	}
	
	function closeDaoruShuju(){
		$("#daoru").dialog("close");
		resetValue();
	}
	
	function saveDaoruShuju(){
		$("#drfm").form("submit",{
			url:daoruurl,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
			
				if(result.errorMsg){
					$.messager.alert("系统提示",result.errorMsg);
					return;
				}else{
					$.messager.alert("系统提示","保存成功");
					resetValue();
					$("#daoru").dialog("close");
					$("#dg").datagrid("reload");
				}
			}
		});
	}
	
	function shangchuanShuju(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#shangchuan").dialog("open").dialog("setTitle","上传<%=title%>信息");
		$("#shchfm").form("load",row);
		shchurl="../shangchuanShuju?shujuid="+row.shujuid;
	}
	
	function closeShangchuanShuju(){
		$("#shangchuan").dialog("close");
		resetValue();
	}
	
	function saveShangchuanShuju(){
		$("#shchfm").form("submit",{
			url:shchurl,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
			
				var s=result;
				var result = eval('(' + result + ')');
			
				if(result.errorMsg){
					$.messager.alert("系统提示",result.errorMsg);
					return;
				}else{
					$.messager.alert("系统提示","保存成功");
					resetValue();
					$("#shangchuan").dialog("close");
					$("#dg").datagrid("reload");
				}
			}
		});
	}
	
	function datetostr(date, row) {
		if(date){
			var date = new Date(date.time);
        	var y=date.getFullYear();
        	var m=date.getMonth()+1;
        	var d=date.getDate();
        	var h=date.getHours();
        	var m1=date.getMinutes();
        	var s=date.getSeconds();
        	m = m<10?("0"+m):m;
        	d = d<10?("0"+d):d;
        	return y+"-"+m+"-"+d;
			var text = JsonDateValue.toLocaleString();
			return text;
		}else{
			return "未填写";
		}
	}
	
	function shenheShuju() {
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要执行的数据！");
			return;
		}
		var row=selectedRows[0];
		url="../addShuju?shujuid="+row.shujuid;
		$.messager.confirm("系统提示","您确认要执行吗？",function(r){
			if(r){
				$.post(url,{shujuType:1},function(result){
					if(result.errorMsg){
						$.messager.alert("系统提示",result.errorMsg);
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert("系统提示","您已成功执行！");
						$("#dg").datagrid("reload");
					}
				},"json");
			}
		});
	}
</script>
</head>
<body style="margin: 5px;">
<!--startprint-->
	<table id="dg" title="<%=title%>信息" class="easyui-datagrid" fitColumns="true"
	 pagination="true" url="../getShujus?userid=<%= userId %>" fit="true" rownumbers="true" toolbar="#tb">
		<thead>
			<tr>
			<!--
				<th field="cb" checkbox="true"></th>
				<th field="shujuid" width="10" hidden="true">编号</th>
				<th field="sjleixingid" width="20" hidden="true"><%=typename%>ID</th>
				<th field="sjleixingName" width="20"><%=typename%></th>
				<th field="shujuName" width="20">车牌</th>
				<th field="shujuMark" width="20">品牌</th>
				<th field="shujuMark1" width="20">型号</th>
				<th field="shujuMark2" width="40">配置</th>
				<th field="shujuMark3" width="20">购买年</th>
				<th field="shujuZong" width="10">里程</th>
				<th field="shujuDouble" width="10">购价</th>
				<th field="shujuImg" width="20" formatter="formatChakan">照片</th>
				<th field="userid" width="20" hidden="true"><%=username%>ID</th>
				<th field="userName" width="20"><%=username%></th>
				<th field="buzhiId" width="10" hidden="true"><%=areaname%>ID</th>
				<th field="buzhiName" width="20"><%=areaname%></th>
				<th field="shujuDate" width="20" formatter="datetostr">时间</th>
  -->
                <th field="cb" checkbox="true"></th>
                <th field="shujuid" width="10" hidden="true">编号</th>
                <th field="sjleixingid" width="20" hidden="true"><%=typename%>ID</th>
                <th field="sjleixingname" width="20"><%=typename%></th>
                <th field="shujuname" width="20">车牌</th>
                <th field="shujumark" width="20">品牌</th>
                <th field="shujumark1" width="20">型号</th>
                <th field="shujumark2" width="40">配置</th>
                <th field="shujumark3" width="20">购买年</th>
                <th field="shujuzong" width="10">里程</th>
                <th field="shujudouble" width="10">购价</th>
                <th field="shujuimg" width="20" formatter="formatChakan">照片</th>
                <th field="userid" width="20" hidden="true"><%=username%>ID</th>
                <th field="username" width="20"><%=username%></th>
                <th field="buzhiid" width="10" hidden="true"><%=areaname%>ID</th>
                <th field="buzhiname" width="20"><%=areaname%></th>
                <th field="shujudate" width="20" formatter="datetostr">时间</th>
			</tr>
		</thead>
	</table>
	
	<div id="tb">
		<div>
			<a href="javascript:openShujuAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openShujuModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deleteShuju()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
			<a href="javascript:shangchuanShuju()" class="easyui-linkbutton" iconCls="icon-add" plain="true">上传照片</a>
		</div>
		<div>
		&nbsp;车牌：&nbsp;<input type="text" name="s_shujuname" id="s_shujuname" size="10"/>
		&nbsp;<%=typename%>：&nbsp;<input class="easyui-combobox" id="s_sjleixingid" name="s_sjleixingid"
		data-options="panelHeight:'auto',editable:false,valueField:'id',textField:'value',url:'../sjleixingComboList'"/>
		<a href="javascript:searchShuju()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div>
<!--endprint-->
	<div id="dlg" class="easyui-dialog" style="width: 540px;height: 220px;padding: 10px 20px"
		closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="5px;">
				<tr>
					<td><%=typename%>：</td>
					<td><input class="easyui-combobox" id="sjleixingid" name="sjleixingid"
					data-options="panelHeight:'auto',editable:false,valueField:'id',textField:'value',url:'../sjleixingComboList'"/></td>
					<td>车牌：</td>
					<td><input type="text" name="shujuname" id="shujuname" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>品牌：</td>
					<td><input type="text" name="shujumark" id="shujumark" class="easyui-validatebox" required="true"/></td>
					<td>型号：</td>
					<td><input type="text" name="shujumark1" id="shujumark1" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>配置：</td>
					<td><input type="text" name="shujumark2" id="shujumark2" class="easyui-validatebox" required="true"/></td>
					<td>购买年：</td>
					<td><input type="text" name="shujumark3" id="shujumark3" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>里程：</td>
					<td><input type="text" name="shujuzong" id="shujuzong" class="easyui-validatebox" required="true"/></td>
					<td>购价：</td>
					<td><input type="text" name="shujudouble" id="shujudouble" class="easyui-validatebox" required="true"/></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveShuju()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeShujuDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
<!--上传-->	
	<div id="shangchuan" class="easyui-dialog" style="width: 320px;height: 140px;padding: 10px 20px"
		closed="true" buttons="#shangchuan-buttons">
		<form id="shchfm" method="post" enctype="multipart/form-data">
			<table cellspacing="5px;">
				<tr>
					<td><input type="file" name="uploadFile" id="uploadFile" class="easyui-validatebox" required="true"/></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="shangchuan-buttons">
		<a href="javascript:saveShangchuanShuju()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeShangchuanShuju()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
<!--导入-->	
	<div id="daoru" class="easyui-dialog" style="width: 320px;height: 140px;padding: 10px 20px"
		closed="true" buttons="#daoru-buttons">
		<form id="drfm" method="post" enctype="multipart/form-data">
			<table cellspacing="5px;">
				<tr>
					<td><input type="file" name="uploadFile" id="uploadFile" class="easyui-validatebox" required="true"/></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="daoru-buttons">
		<a href="javascript:saveDaoruShuju()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeDaoruShuju()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
	
</body>
</html>