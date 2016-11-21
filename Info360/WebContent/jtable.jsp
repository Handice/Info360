<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

 <!-- End Example Pagination -->
 
    <div class="col-sm-12">
                        <!-- Example Events -->
                        <div class="example-wrap">
                           <h4 class="example-title">員工管理</h4>
                            <div class="example">
                           
                                <div class="btn-group hidden-xs" id="exampleTableEventsToolbar" role="group">
                                    <button type="button" class="btn btn-outline btn-default">
                                        <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>
                                    </button>
                                    <button type="button" class="btn btn-outline btn-default">
                                        <i class="glyphicon glyphicon-heart" aria-hidden="true"></i>
                                    </button>
                                    <button type="button" class="btn btn-outline btn-default">
                                        <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>
                                    </button>
                                </div>
                           

  <table id="table">
    <thead>
        <tr>
            <th id="user_name">user_name</th>
            <th id="first_name;">first_name;</th>
            <th id="emailaddress">emailaddress</th>
            <th id="state">state</th>
            <th id="last_name">last_name</th>
            <th id="account">account</th>
            <th id="createdatetime">createdatetime</th>
            <th id="dbid">dbid</th>
            <th id="dn">dn</th>
            <th id="password">password</th>
        </tr>
    </thead>
</table>
                            </div>
                        </div>
                       </div>
                        <!-- End Example Events -->
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
    <script src="js/switchjson.js"></script>
</body>

<script>
var myMap = new Map();
$.post("RESTful/Query_PersonInfo", { "dbid":"101" },
   function(data){
	
	switchjson(data);
	//$("#ID").value = data.Status;
	alert(data.person.user_name);
	//$("#user_name").val(data.person.user_name);
	$("#user_name").innertext=data.person.user_name;
	$("#first_name").val(data.person.first_name);
	$("#emailaddress").val(data.person.emailaddress);
	$("#state").val(data.person.state);
	$("#last_name").val(data.person.last_name);
	$("#account").val(data.person.account);
	$("#createdatetime").val(data.person.createdatetime);
	$("#dbid").val(data.person.dbid);
	$("#dn").val(data.person.dn);
	$("#password").val(data.person.password) });


$('#table').bootstrapTable({
    columns: [{
        field: 'user_name',
        title: 'user_name'
    }, {
        field: 'first_name',
        title: 'first_name'
    }, {
        field: 'emailaddress',
        title: 'emailaddress'
    },{
        field: 'state',
        title: 'state'
    },
    {
        field: 'last_name',
        title: 'last_name'
    },
    {
        field: 'account',
        title: 'account'
    },
    {
        field: 'createdatetime',
        title: 'createdatetime'
    }, {
        field: 'dbid',
        title: 'dbid'
    }, {
        field: 'dn',
        title: 'dn'
    }, {
        field: 'password',
        title: 'password'
    }],
    //dataSource: [ { status: myMap.get('user_name'), dbid: myMap.get('first_name'), state: myMap.get('emailaddress'), first_name: myMap.get('state'), last_name: myMap.get('last_name'), user_name: myMap.get('account'), is_agent: myMap.get('createdatetime'), is_admin: myMap.get('dbid'), employee_id: myMap.get('dn'), error: myMap.get('password') }]
	data:data.person
});
}, "json");



</script>

</html>
