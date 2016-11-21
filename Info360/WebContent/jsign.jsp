<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="CFG_person" class="com.infotrends.bean.CFG_person"></jsp:useBean>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>INFO360</title>

   <link rel="shortcut icon" href="favicon.ico"> 
    <link href="hplus/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="hplus/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="hplus/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="hplus/css/animate.css" rel="stylesheet">
    <link href="hplus/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<style>
 li {list-style-type:none;}
 
</style>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">

<label class="col-sm-3 control-label">文本框：</label>
<div class="col-sm-9">
    <input type="text" name="" class="form-control" placeholder="请输入文本"> <span class="help-block m-b-none">说明文字</span>

</div>

<label class="col-sm-3 control-label">密码框：</label>
<div class="col-sm-9">
    <input type="password" class="form-control" name="password" placeholder="请输入密码">
</div>

<label class="col-sm-3 control-label">下拉列表：</label>
<div class="col-sm-9">
    <select class="form-control" name="">
        <option>选项 1</option>
        <option>选项 2</option>
        <option>选项 3</option>
        <option>选项 4</option>
    </select>
</div>

<label class="col-sm-3 control-label">单选框：</label>
<div class="col-sm-9">
    <label class="radio-inline">
        <input type="radio" checked="" value="option1" id="optionsRadios1" name="optionsRadios">选项1</label>
    <label class="radio-inline">
        <input type="radio" value="option2" id="optionsRadios2" name="optionsRadios">选项2</label>
</div>

<label class="col-sm-3 control-label">复选框：</label>
<div class="col-sm-9">
    <label class="checkbox-inline">
        <input type="checkbox" value="option1" id="inlineCheckbox1">选项1</label>
    <label class="checkbox-inline">
        <input type="checkbox" value="option2" id="inlineCheckbox2">选项2</label>
    <label class="checkbox-inline">
        <input type="checkbox" value="option3" id="inlineCheckbox3">选项3</label>
</div>





	<!-- 全局js -->
    <script src="hplus/js/jquery.min.js?v=2.1.4"></script>					  <!-- MENU必備 -->
    <script src="hplus/js/bootstrap.min.js?v=3.3.6"></script>					  <!-- MENU必備 -->
    <script src="hplus/js/plugins/metisMenu/jquery.metisMenu.js"></script>	  <!-- MENU必備 -->
    <script src="hplus/js/plugins/slimscroll/jquery.slimscroll.min.js"></script><!-- MENU必備 -->
    <script src="hplus/js/plugins/layer/layer.min.js"></script>				  <!-- MENU必備 -->
    <!-- 自定义js -->
    <script type="text/javascript" src="hplus/js/contabs.js"></script>		  <!-- MENU必備 -->
  
    <!-- Bootstrap table -->
    <script src="hplus/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>			  <!-- TABLE相關 -->
    <script src="hplus/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>	  <!-- TABLE相關 -->
    <script src="hplus/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>	  <!-- TABLE相關語句 -->
	<!-- Peity -->
    <script src="hplus/js/demo/bootstrap-table-demo.js"></script>
</body>

<script>
var myMap = new Map();
$.post("RESTful/Query_PersonInfo", { "dbid":"" },
   function(data){
	
	//$("#ID").value = data.Status;
	$("#user_name").val(data.person.user_name);
	$("#first_name").val(data.person.first_name);
	$("#emailaddress").val(data.person.emailaddress);
	$("#state").val(data.person.state);
	$("#last_name").val(data.person.last_name);
	$("#account").val(data.person.account);
	$("#createdatetime").val(data.person.createdatetime);
	$("#dbid").val(data.person.dbid);
	$("#dn").val(data.person.dn);
	$("#password").val(data.person.password);
	

	myMap.set('user_name', data.person.user_name);
	myMap.set('first_name', data.person.first_name);
	myMap.set('emailaddress', data.person.emailaddress);
	myMap.set('state', data.person.state);
	myMap.set('last_name', data.person.last_name);
	myMap.set('account', data.person.account);
	myMap.set('createdatetime', data.person.createdatetime);
	myMap.set('dbid', data.person.dbid);
	myMap.set('dn', data.person.dn);
	myMap.set('employee_id', data.person.employee_id);
	myMap.set('password', data.person.password);


</script>

</html>
