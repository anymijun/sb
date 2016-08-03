﻿﻿<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	String contextPath = request.getContextPath();
String id = request.getParameter("id");
String type = request.getParameter("type");
if(type == null || "".equals(type)){
	response.getWriter().write("参数错误!!!");
	return;
}
String action = "";
if(id == null ){
	id = "";
	action = "add";
}else{
	action = "update";
}
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>文章修改</title>
<link href="../css/base.css" rel="stylesheet" />
<link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />
<!--[if IE 7]>
	<link rel="stylesheet" href="../assets/css/font-awesome-ie7.min.css" />
<![endif]-->
<link rel="stylesheet" href="../assets/css/ace.min.css" />
<link rel="stylesheet" href="../assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="../assets/css/ace-skins.min.css" />
<!--[if lte IE 8]>
	<link rel="stylesheet" href="../assets/css/ace-ie.min.css" />
<![endif]-->
<script src="../assets/js/ace-extra.min.js"></script>
<!--[if lt IE 9]>
	<script src="../assets/js/html5shiv.js"></script>
	<script src="../assets/js/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" href="../assets/css/jquery-ui-1.10.3.custom.min.css" />
<link rel="stylesheet" href="../assets/css/chosen.css" />
<script src="../ckeditor/ckeditor.js"
	type="text/javascript"></script>
<script type="text/javascript">  
       var contextPath='<%=contextPath%>';
       var id='<%=id%>';
       var action='<%=action%>';
       var type='<%=type%>';
</script>
</head>
<body style="background-color: #fff;">
	<div class="breadcrumbs" id="breadcrumbs">
		<script type="text/javascript">
			try {
				ace.settings.check('breadcrumbs', 'fixed')
			} catch (e) {
			}
		</script>
		<ul class="breadcrumb">
			<li><i class="icon-home home-icon"></i> <a href="../index.jsp">首页</a>
			</li>
			<li class="active">管理</li>
		</ul>
	</div>
	<div class="page-content">
		<div class="page-header">
			<h1>
				管理 <small> <i class="icon-double-angle-right"> 文章修改 </i>
				</small>
			</h1>
		</div>
		<!-- /.page-header -->
		<div class="row" style="height: 100%">
			<div class="col-xs-12">
				<div class="popover-inner" style="">
					<h3 class="popover-title" id="">文章修改</h3>
					<div class="popover-content" id="" style=" ">
						<form class="form-horizontal" style="padding-top: 10px;"
							method="post" id="newsForm" enctype="multipart/form-data">
							<input type="hidden" value="" id="id"  name="id" />
							<input type="hidden" value="<%=type%>" id="type"  name="type" />
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">标题：</label>
								<div class="col-sm-9">
									<input name="title" id="title" class="form-control" value="" />
								</div>
								<span class="input_tip" style="line-height: 30px;">*</span>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">摘要：</label>
								<div class="col-sm-9">
									<input name="digest" id="digest" class="form-control" value="" />
								</div>
								<span class="input_tip" style="line-height: 30px;">*</span>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">内容：</label>
								<div class="col-sm-9">
									<textarea cols="80" id="content" name="content"></textarea>
								</div>
								<span class="input_tip" style="line-height: 30px;">*</span>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">封面：</label>
								<div class="col-sm-9">
									<input type="file" name="photo" id="photo" />
									<br/>
									<img src="" alt="" width = "160" height="160" id="img" style="display: none;"/>
								</div>
								<span class="input_tip" style="line-height: 30px;">*</span>
							</div>
						</form>
					</div>
					<script>
						CKEDITOR.replace('content', {
							filebrowserImageBrowseUrl : 'servlet/ImageBrower.brower',
							filebrowserImageUploadUrl : 'servlet/ImageUpload.upload'
						});
					</script>
					<div class="popover-footer"
						style="  overflow: hidden; text-align: center;">
						<button type="button" class="btn btn-primary"
							style="padding: 0px; margin: 0px 5px 5px 0px;" id="cancel">
							<i class="icon-ok"></i>取消
						</button>
						<button type="button" class="btn btn-danger"
							style="padding: 0px; margin: 0px 5px 5px 0px;" id="save">
							<i class="icon-edit"></i>保存
						</button>
		
					</div>
				</div>
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</div>
	<div id="loading"
		style="width: 32px; height: 32px; position: absolute; left: 40%; top: 40%; display: none;">
		<img src="../assets/css/images/loading.gif"
			width="32" height="32" />
	</div>
	<div class="popover"
		style="z-index: 9999; width: 150px; position: absolute; left: 45%; top: 45%;">
		<div class="arrow"></div>
		<div class="popover-inner">
			<h3 class="popover-title">操作提示</h3>
			<div class="popover-content" id="popover-content">
				<p>操作成功</p>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='../assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='../assets/js/jquery-2.0.3.min.js'>"
								+ "<"+"script>");
	</script>
	
	<!--[if IE]>
		<script type="text/javascript">
			window.jQuery || document.write("<script src='../assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");
		</script>
	<![endif]-->
	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='../assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"script>");
	</script>
	<script src="../assets/js/bootstrap.min.js"></script>
	<script src="../assets/js/typeahead-bs2.min.js"></script>

	<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
	<![endif]-->
	<script src="../assets/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="../assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="../assets/js/jquery.slimscroll.min.js"></script>
	<script src="../assets/js/jquery.easy-pie-chart.min.js"></script>
	<script src="../assets/js/jquery.sparkline.min.js"></script>
	<script src="../assets/js/ace-elements.min.js"></script>
	<script src="../assets/js/ace.min.js"></script>
	<script src="../js/common.js"></script>
	<script src="../assets/js/jquery-form.js"></script>
	<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>
	
	<script type="text/javascript">
		
		init();
		function init() {
			if(action == "update"){
				getData(1);
			}
		}

		function getData() {
			$("#loading").show();
			$.ajax({
				url : contextPath + '/api/news',
				type : "POST",
				dataType : 'json',
				data : {
					action : 'get',
					id : id
				},
				success : function(rs, textStatus, jqXHR) {
					$("#loading").hide();
					if (rs.success) {
						var data = rs.data;
						$("#id").val(data.id);						
						$("#content").val(data.content);						
						$("#title").val(data.title);						
						$("#digest").val(data.digest);	
						$("#type").val(data.type);	
						$("#img").show();
						$("#img").attr("src",contextPath + data.img);
						CKEDITOR.instances.content.setData(data.content);
					} else {
						showMessage("获取数据失败,请稍后再试");
					}
				},
				error : function() {
					$("#loading").hide();
					showMessage("请稍后再试");
				}
			});
		}

		$("#save").bind("click", function() {
			if ($("#title").val()  == "") {
				showMessage("请输入标题!!!");
				return;
			}
			var data = CKEDITOR.instances.content.getData();
			if(data == ""){
				showMessage("请输入文章内容!!!");
				return;
			}
			$("#content").val(data);
			if ($("#digest").val()  == "") {
				showMessage("请输入文章摘要!!!");
				return;
			}
			if(action == "add"){
				if($("#photo").val() == ""){
					showMessage("请上传文章封面!!!");
					return;
				}
			}
			$("#newsForm").ajaxSubmit({
				type : "POST",
				url : contextPath + '/api/news?action=' + action,
				dataType : 'json',
				success : function(data) {
					if (data.success) {
						showMessage(data.msg);
						if(action == "update"){
							getData();
						}else{
							setTimeout(function(){window.location.href="news_list.jsp?type=" + type},2000);
						}
					} else {
						showMessage(data.msg);
					}
					$("#loading").hide();
				},
				error : function(msg) {
					$("#loading").hide();
					showMessage("操作失败");
				}
			});
		});
	</script>
</body>
</html>