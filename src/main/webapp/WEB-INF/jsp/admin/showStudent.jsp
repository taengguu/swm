<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title>学生信息显示</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 引入bootstrap -->
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="../css/ui.jqgrid.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="../js/jquery-3.2.1.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.1.1.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/jquery.jqGrid.min.js"></script>
	<script type="text/javascript" src="../js/grid.locale-en.js"></script>
	
	<%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>

</head>
<body>
	<!-- 顶栏 -->
	<jsp:include page="top.jsp"></jsp:include>
	<!-- 中间主体 -->
	<div class="container" id="content">
		<div class="row">
			<jsp:include page="menu.jsp"></jsp:include>
			<div class="col-md-10">
				<div class="panel panel-default">
				    <div class="panel-heading">
						<div class="row">
					    	<h1 class="col-md-5">学生名单管理</h1>
							<form class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;" action="/ssm/admin/selectStudent" id="form1" method="post">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="请输入姓名" name="findByName">
									<span class="input-group-addon btn" id="sub">搜索</span>
								</div>
							</form>
							<button class="btn btn-default col-md-2" style="margin-top: 20px" onClick="location.href='/ssm/admin/addStudent'">
								添加用户信息
								<sapn class="glyphicon glyphicon-plus"/>
							</button>

						</div>
				    </div>
				    <table class="table table-bordered">
					        <thead>
					            <tr>
					                <th>学号</th>
				  					<th>姓名</th>
				  					<th>性别</th>
				  					<th>出生年份</th>
				  					<th>入学时间</th>
				  					<th>班级</th>
				  					<th>操作</th>
					            </tr>
					        </thead>
					        <tbody>
							<c:forEach  items="${studentList}" var="item">
								<tr>
									<td>${item.userId}</td>
									<td>${item.userName}</td>
									<td>${item.sex}</td>
									<td><fmt:formatDate value="${item.birthYear}" dateStyle="medium" /></td>
									<td><fmt:formatDate value="${item.grade}" dateStyle="medium" /></td>
									<td>${item.collegeName}</td>
									<td>
										<button class="btn btn-default btn-xs btn-info" onClick="location.href='/ssm/admin/editStudent?id=${item.userId}'">修改</button>
										<button class="btn btn-default btn-xs btn-danger btn-primary" onClick="location.href='/ssm/admin/removeStudent?id=${item.userId}'">删除</button>
										<!--弹出框-->
									</td>
								</tr>
							</c:forEach>
					        </tbody>
				    </table>
				    <table id="student_list"></table>
				    <div class="panel-footer">
						<c:if test="${page != null}">
							<nav style="text-align: center">
								<ul class="pagination">
									<li><a href="/ssm/admin/showStudent?page=1">首页</a></li>
									<c:if test="${page.isFirstPage  ==false}">
										<li><a href="/ssm/admin/showStudent?page=${page.prePage}">&laquo;上一页</a></li>
									</c:if>
									<li class="active"><a href="">${page.getPageNum()}</a></li>
									<c:if test="${page.getPageNum()+1 <= page.pages}">
										<li><a href="/ssm/admin/showStudent?page=${page.getPageNum()+1}">${page.getPageNum()+1}</a></li>
									</c:if>
									<c:if test="${page.getPageNum()+2 <= page.pages}">
										<li><a href="/ssm/admin/showStudent?page=${page.getPageNum()+2}">${page.getPageNum()+2}</a></li>
									</c:if>
									<c:if test="${page.getPageNum()+3 <= page.pages}">
										<li><a href="/ssm/admin/showStudent?page=${page.getPageNum()+3}">${page.getPageNum()+3}</a></li>
									</c:if>
									<c:if test="${page.getPageNum()+4 <= page.pages}">
										<li><a href="/ssm/admin/showStudent?page=${page.getPageNum()+4}">${page.getPageNum()+4}</a></li>
									</c:if>
									<li><a href="/ssm/admin/showStudent?page=${page.getLastPage()}">最后一页&raquo;</a></li>
								</ul>
							</nav>
						</c:if>
				    </div>
				</div>

			</div>
		</div>
	</div>
	<div class="container" id="footer">
		<div class="row">
			<div class="col-md-12"></div>
		</div>
	</div>
</body>
	<script type="text/javascript">
	$(function(){

		
		$("#student_list").jqGrid({  
	        url : '/ssm/admin/showStudentGrid',  
	        contentType : 'application/json',  
	        mtype : "post",  
	        datatype : 'json',  
	        prmNames : {search : "search"},  
	        jsonReader : {id : "0", repeatitems : false, userdata : "userdata"},  
	        height : "auto",  
	        colNames:['id','名字', '性别','出生日期','毕业日期','毕业院校'],  
		    colModel:[  
		        {name:'userId',index:'userId'},  
		        {name:'userName',index:'userName'},  
		        {name:'sex',index:'sex'} ,
		        {name:'birthYear',index:'birthYear'} ,
		        {name:'grade',index:'grade'} ,
		        {name:'collegeName',index:'collegeName'}  ],  
	        pager : "#pager",  
	        autoWidth : true,  
	        rowNum : 10,  
	        rownumbers : true,  
	        viewrecords: true,   
	        caption : "用户列表"  
	        });  
	    $(window).bind('resize', function() {  
	        $("#list").setGridWidth($("#_grid").width() - 10);  
	    }).trigger('resize');  
	    jQuery("#list").jqGrid('navGrid', '#pager', {});  
		
	});
	
	
	
		$("#nav li:nth-child(2)").addClass("active");

        function confirmd() {
            var msg = "您真的确定要删除吗？！";
            if (confirm(msg)==true){
                return true;
            }else{
                return false;
            }
        };

        $("#sub").click(function () {
            $("#form1").submit();
        }); 
        <c:if test="${pagingVO != null}">
			if (${pagingVO.curentPageNo} == ${pagingVO.totalCount}) {
				$(".pagination li:last-child").addClass("disabled")
			};

			if (${pagingVO.curentPageNo} == ${1}) {
				$(".pagination li:nth-child(1)").addClass("disabled")
			};
        </c:if>
	</script>
</html>