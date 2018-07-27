<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<link href="/css/common.css" rel="stylesheet">

<!-- Favicon -->
<link rel="shortcut icon" href="favicon.ico" />

<script type="text/javascript" src="/js/jquery-1.12.4.js"></script>

<script src="/SE2/js/HuskyEZCreator.js"></script>

<script type="text/javascript">
	var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

	$(document).ready(function() {
		// Editor Setting
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors, // 전역변수 명과 동일해야 함.
			elPlaceHolder : "content", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
			sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
			fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true,
			}
		});

		// 전송버튼 클릭이벤트
		$("#saveBtn").click(function() {
			if (confirm("저장하시겠습니까?")) {
				// id가 content인 textarea에 에디터에서 대입
				oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);

				// 이부분에 에디터 validation 검증
				if (validation()) {
					$("#frm").submit();
				}
			}
		})
	});

	// 필수값 Check
	function validation() {
		var contents = $.trim(oEditors[0].getContents());
		if (contents === '<p>&nbsp;</p>' || contents === '') { // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
			alert("내용을 입력하세요.");
			oEditors.getById['content'].exec('FOCUS');
			return false;
		}

		return true;
	}
</script>

</head>

<body>

	<%@include file="/common/top.jsp"%>


	<div class="container-fluid">
		<div class="row">

			<%@include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header"></h2>

						<form id="frm" class="form-horizontal" role="form"
							action="/newPost?board_id=${board_id}" method="post"
							enctype="multipart/form-data">

							<input type="hidden" id="id" name="id">

							<div class="form-group">
								<label for="id" class="col-sm-2 control-label">제목</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="title" name="title"
										placeholder="제목">
								</div>
							</div>

							<div class="form-group">
								<label for="id" class="col-sm-2 control-label">글내용</label>
								<div class="col-sm-10">
									<textarea name="content" id="content" rows="10" cols="100"
										style="width: 766px; height: 412px;"></textarea>
								</div>
							</div>

							<div class="form-group">
								<label for="name" class="col-sm-2 control-label">첨부파일</label>
								<div id="file-btn-list" class="col-sm-10">
									<input type="file" class="btn btn-default" multiple="chum" id="chum" name="chum">
								</div>
							</div>
							
							<div class="form-group">
								<label for="id" class="col-sm-2 control-label"></label>
								<div class="col-sm-10">
									<input type="button" class="btn btn-default" id="addBtn" name="addBtn" value="추가">
								</div>
							</div>
							
							<script type="text/javascript">
							$(function(){
								var addFileTag = "<input type=\"file\" class=\"form-control\" style=\"margin-top:10px;\" multiple=\"chum\" id=\"chum\" name=\"chum\">"; // file tag								
								var fileListSize = $("#file-btn-list").length; // list size
								
								$("#addBtn").click(function(){
									if(fileListSize < 5) {
										$("#file-btn-list").append(addFileTag);
										fileListSize++;										
									} else {
										alert("파일은 5개까지만 가능합니다.");
									}
								});
							});
							</script>

							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button id="saveBtn" class="btn btn-default">저장</button>
								</div>
							</div>

						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
