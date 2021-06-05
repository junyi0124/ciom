<%@ page language="java" import="edu.thn.ciom.pojo.*"  pageEncoding="utf-8"%>
<%
PeizhiPojo newJcpeizhi = (PeizhiPojo)session.getAttribute("jcpeizhi");
// 权限验证
YongHuPojo yh = (YongHuPojo)session.getAttribute("yonghu");
int yonghuId = yh.getYonghuid();
int buzhiId = yh.getBuzhiid();

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
<title><%=title%><%=shaochu%></title>
<link rel="stylesheet" type="text/css" href="/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
var url;
	function searchSjshaochu(){
		$('#dg').datagrid('load',{
			shujuId:$('#s_shujuId').combobox("getValue")
		});
	}
	
	function saveSjshaochu(){
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
	
	function openSjshaochuAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加<%=title%><%=shaochu%>");
		url="../addSjshaochu?yonghuid=<%=yonghuId %>";
	}
	
	function resetValue(){
	}
	
	function deleteSjshaochu(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].sjshaochuid);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删掉这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("../deleteSjshaochu",{delIds:ids},function(result){
					if(result.success){
						$.messager.alert("系统提示","您已成功删除<font color=red>"+result.delNums+"</font>条数据！");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert('系统提示','<font color=red>'+selectedRows[result.errorIndex].sjshaochuName+'</font>'+result.errorMsg);
					}
				},"json");
			}
		});
	}
	
	function closeSjshaochuDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	function openSjshaochuModifyDialog(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		if(row.sjshaochuType!=1){
			$.messager.alert("系统提示","用户还未上传资料！");
			return;
		}
		$("#dlg").dialog("open").dialog("setTitle","编辑<%=title%><%=shaochu%>");
		$("#fm").form("load",row);
		url="../addSjshaochu?sjshaochuId="+row.sjshaochuId;
	}
	
	function formatSex(shujuSex, row) {  
		if(shujuSex==0){
			return "男";
		}
		if(shujuSex==1){
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
	
	function daochuSjshaochu(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要导出的数据！");
			return;
		}
		var sjshaochuIds=[];
		for(var i=0;i<selectedRows.length;i++){
			sjshaochuIds.push(selectedRows[i].sjshaochuid);
		}
		var ids=sjshaochuIds.join(",");
		$.messager.confirm("系统提示","您确认要导出数据吗？",function(r){
			if(r){
				$.post("../daochuSjshaochu",{delIds:ids},function(result){
					if(result.success){
						$.messager.alert("系统提示","您已成功导出数据：D:！");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert('系统提示','<font color=red>'+selectedRows[result.errorIndex].sjshaochuName+'</font>'+result.errorMsg);
					}
				},"json");
			}
		});
	}
	
	function datetostr(dateTime, row) {
		if(dateTime){
			var JsonDateValue = new Date(dateTime.time);
			var text = JsonDateValue.toLocaleString();
			return text;
		}else{
			return "未填写";
		}
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
	
	function daoruSjshaochus(){
		$("#daoru").dialog("open").dialog("setTitle","导入<%=title%><%=shaochu%>");
		daoruurl="../daoruSjshaochu";
	}
	
	function closeDaoruSjshaochu(){
		$("#daoru").dialog("close");
		resetValue();
	}
	
	function saveDaoruSjshaochu(){
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
	
	function shangchuanSjshaochu(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#shangchuan").dialog("open").dialog("setTitle","上传<%=title%><%=shaochu%>");
		$("#shchfm").form("load",row);
		shchurl="../shangchuanSjshaochu?sjshaochuId="+row.sjshaochuId;
	}
	
	function closeShangchuanSjshaochu(){
		$("#shangchuan").dialog("close");
		resetValue();
	}
	
	function saveShangchuanSjshaochu(){
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
	
	function shenheSjshaochu(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要执行的数据！");
			return;
		}
		var row=selectedRows[0];
		url="../addSjshaochu?sjshaochuId="+row.sjshaochuId+"&userId="+userId;
		$.messager.confirm("系统提示","您确认要执行吗？",function(r){
			if(r){
				$.post(url,{sjshaochuType:1},function(result){
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
	<table id="dg" title="<%=title%><%=shaochu%>" class="easyui-datagrid" fitColumns="true"
	 pagination="true" url="../getSjshaochus?yonghuid=<%=yonghuId %>" fit="true" rownumbers="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="sjshaochuid" width="10" hidden="true">编号</th>
				<th field="sjshaochutype" width="20" hidden="true">状态</th>
				<th field="userid" width="20" hidden="true"><%=username%>ID</th>
				<th field="username" width="20"><%=username%></th>
				<th field="shujuid" width="20" hidden="true"><%=title%>ID</th>
				<th field="shujuname" width="20"><%=title%></th>
				<th field="yhrolename" width="20" formatter="formatXiazai">附件</th>
				<th field="sjshaochudouble" width="10">价格</th>
				<th field="sjshaochuname" width="40">单号</th>
				<th field="sjshaochumark" width="40">名称</th>
				<th field="sjshaochumark1" width="80">详情</th>
				<th field="sjshaochuimgname" width="20" formatter="formatXiazai">保单</th>
				<th field="yonghuid" width="10" hidden="true"><%=yonghu%>ID</th>
				<th field="yonghuname" width="20"><%=yonghu%></th>
				<th field="sjshaochudate" width="20" formatter="datetostr">时间</th>
			</tr>
		</thead>
	</table>
	
	<div id="tb">
		<div>
			<a href="javascript:openSjshaochuModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">确认</a>
			<a href="javascript:shangchuanSjshaochu()" class="easyui-linkbutton" iconCls="icon-add" plain="true">上传保单</a>
		</div>
		<div>
		&nbsp;<%=title%>：&nbsp;<input class="easyui-combobox" id="s_shujuid" name="s_shujuid"
		data-options="panelHeight:'auto',editable:false,valueField:'id',textField:'value',url:'../shujuComboList'"/>
		<a href="javascript:searchSjshaochu()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div>
<!--endprint-->
	<div id="dlg" class="easyui-dialog" style="width: 540px;height: 260px;padding: 10px 20px"
		closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="5px;">
				<tr>
					<td>单号：</td>
					<td><input type="text" name="sjshaochuname" id="sjshaochuname" class="easyui-validatebox" required="true"/></td>
					<td>名称：</td>
					<td><input type="text" name="sjshaochumark" id="sjshaochumark" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td valign="top">详情：</td>
					<td colspan="4"><textarea rows="7" cols="55" name="sjshaochumark1" id="sjshaochumark1"></textarea></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveSjshaochu()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeSjshaochuDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
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
		<a href="javascript:saveShangchuanSjshaochu()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeShangchuanSjshaochu()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
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
		<a href="javascript:saveDaoruSjshaochu()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeDaoruSjshaochu()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
	
</body>
</html>