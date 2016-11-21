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
    <link href="hplus/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="hplus/css/animate.css" rel="stylesheet">
    <link href="hplus/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<style>
 li {list-style-type:none;}
</style>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">

<!-- MENU -->
<div class=" content-tabs" style="width:70%;height:30px;float:left;background-color: #424B5C">
		<div>
                <button class="roll-nav roll-left J_tabLeft " style="background-color: #424B5C" ><i class="fa fa-backward"></i></button>
                 
                <nav class="page-tabs J_menuTabs" >
                    <div class="page-tabs-content" >
                        <a href="javascript:;" class="active J_menuTab" data-id="jindex.html" style="background-color: #424B5C"> 首页</a>
                    </div>
                </nav>  
                
                <button class="roll-nav roll-right J_tabRight"  style="background-color: #424B5C"><i class="fa fa-forward"></i> </button>
               
                <div class="btn-group roll-nav roll-right">
                    <button class="dropdown J_tabClose" data-toggle="dropdown" style="background-color: #424B5C">關閉操作<span class="caret"></span></button>
                    
                    <ul role="menu" class="dropdown-menu dropdown-menu-right" style="background-color: #424B5C">
                        <li class="J_tabShowActive"><a>定為當前選項卡</a></li> 
               
                        <li class="J_tabCloseAll"><a>關閉全部選項卡</a></li> 
                        <li class="J_tabCloseOther"><a>關閉其他選項卡</a></li>
                    </ul>
                </div>
    	 </div>
	</div>


<div style="width:30%;height:30px;float:right;background-color: #424B5C">
		<div class="row ">                 
                   <ul class=" navbar-nav">
                            <li>
                                <a aria-expanded="false" role="button"  href="jindex.html">首頁  </a>
                            </li>
                    </ul>

                    <ul class=" navbar-nav">
                            <li class="dropdown">
                                <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown">部門/人員 <span class="caret"></span></a>
                                <ul role="menu" class="dropdown-menu">
                                    <li><a class="J_menuItem" href="jtable.jsp">Table</a>
                                    </li>
                                    <li><a class="J_menuItem" href="jinput.jsp">Input</a>
                                    </li>
                                    <li><a class="J_menuItem" href="jsign.jsp">个人资料</a>
                                    </li>
                                    <li><a class="J_menuItem" href="project_detail.html">项目详情</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown">&nbsp;&nbsp; 選單2 <span class="caret"></span></a>
                                <ul role="menu" class="dropdown-menu">
                                    <li><a class="J_menuItem" href="NewFile.html">123</a>
                                    </li>
                                    <li><a class="J_menuItem" href="login.html">菜单列表</a>
                                    </li>
                                    <li><a class="J_menuItem" href="">菜单列表</a>
                                    </li>
                                    <li><a class="J_menuItem" href="">M菜单列表</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown">&nbsp;&nbsp; 選單3 <span class="caret"></span></a>
                                <ul role="menu" class="dropdown-menu">
                                    <li><a class="J_menuItem" href="form_#">qq菜单列表</a>
                                    </li>
                                    <li><a href="">菜单列表</a>
                                    </li>
                                    <li><a href="">菜单列表</a>
                                    </li>
                                    <li><a href="">菜单列表</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown">&nbsp;&nbsp; 選單4 <span class="caret"></span></a>
                                <ul role="menu" class="dropdown-menu">
                                    <li><a href="">菜单列表</a>
                                    </li>
                                    <li><a href="">菜单列表</a>
                                    </li>
                                    <li><a href="">菜单列表</a>
                                    </li>
                                    <li><a href="">菜单列表</a>
                                    </li>
                                </ul>
                            </li>
                        </ul> 
                    </div>
            </div>
<!-- Menu結束 -->
<!-- DIV -->
	<div id="wrapper">
        <div id="page" class="gray-bg dashbard-1" style=" height:800px;margin-top: 5px">
        
            <div class=" J_mainContent" id="content-main">
              
               <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="jindex.html?v=4.0" frameborder="0" data-id="jindex.html" seamless></iframe>
            	
            </div> 
        </div>
    </div>
<!-- DIV END -->    
	<!-- 全局js -->
    <script src="hplus/js/jquery.min.js?v=2.1.4"></script>					  <!-- MENU必備 -->
    <script src="hplus/js/bootstrap.min.js?v=3.3.6"></script>					  <!-- MENU必備 -->
    <script src="hplus/js/plugins/metisMenu/jquery.metisMenu.js"></script>	  <!-- MENU必備 -->
    <script src="hplus/js/plugins/slimscroll/jquery.slimscroll.min.js"></script><!-- MENU必備 -->
    <script src="hplus/js/plugins/layer/layer.min.js"></script>				  <!-- MENU必備 -->
    <!-- 自定义js -->
    <script type="text/javascript" src="hplus/js/contabs.js"></script>		   <!-- MENU必備 -->
  
</body>

</html>
