<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container">
		<h1>Memo Page</h1>
		
		<div>
			    <div class="form-group">
			      <label for="writer">Writer:</label>
			      <input type="text" class="form-control" value="${member.id}" id="writer" placeholder="Enter Writer" name="writer">
			    </div> 
    
			    <div class="form-group">
			      <label for="contents">Contents:</label>
			      <textarea class="form-control" rows="10" id="contents" name="contents"></textarea>
			    </div>
			    
			    <div class="form-group">
			    <button type="submit" class="btn btn-default" id="write">Write</button>
			    </div>
		</div>
		
		
		<div>
		<table  id="result" class="table table-border">
			
		</table>
		</div>
		<button id="more" class="btn btn-danger">더보기</button>
		
	</div>
	
	
	
	
<script type="text/javascript">

	var curPage=1;
	getList();
	
	//***************  DEL **************
	
	$("#result").on("click", ".del", function() {
		var num = $(this).attr("title");
		
		$.ajax({
			url : "./memoDelete",
			type : 'post',
			data : {num:num},
			success: function(data) {
				data=data.trim();
				if(data>0){
					$("#result").html('');
					curPage=1;
					getList();
				}else {
					alert("Delete Fail");
				}
			}
		});
		
		
		/* $.post("./memoDelete",{num:num}, function(data) {
			data=data.trim();
			if(data>0){
				getList();
			}else {
				alert("Delete Fail");
			}
		});
		 */
	});
	
	
	//*************** Write *******************
	
	$("#write").click(function() {
		var writer = $("#writer").val();
		var contents = $("#contents").val();
		
		$.ajax({
			url : "./memoWrite",
			type : 'post',
			data :{writer:writer, 
				   contents:contents},
			success : function(result) {
				alert(result);
				$("#writer").val('');
				$("#contents").val('');
				$("#result").html('');
				curPage=1;
				getList();
			}	
		});
	});
	
	
		/* $.post("./memoWrite",{writer:writer, contents:contents},function(result) {
			alert(result);
			$("#writer").val('');
			$("#contents").val('');
			getList();
		}); */
	
	//**************** List ******************
	
	
	function getList() {
		$.ajax({
			url :"./memoList",
			type : 'get',
			data : {curPage:curPage},
			success: function(data) {
				$("#result").append(data);
			}
		});
		
		/* $.get("./memoList", function(data) {
			$("#result").html(data);
		}); */
		
	}
	
	//**************** more ******************
	
		$("#more").click(function() {
			curPage++;
			getList();
		});
	
	
	
	
	
	
	//var num=$("#num").val();
	//var name=$("#name").val();

	//$.get("./memoTest?num="+num, function(result){
	//	$("#result").html(result);
	//});
	
// 	   $.get("./memoTest?num="+num+"&name="+name, function(data) {
//		alert("success");
//		alert(data);
//		$("#result").html(data);
//	});

	// location.href="./memoTest";
	// $("#frm").submit();

</script>
</body>
</html>