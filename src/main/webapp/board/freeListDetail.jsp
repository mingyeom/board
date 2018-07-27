<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

						<form id="frm" class="form-horizontal" role="form" name="frm"
							method="get">

							<input type="hidden" name="id" value="${postVo.post_id }">
							<input type="hidden" name="board_id" value="${postVo.board_id }">

							<div class="form-group">
								<label for="id" class="col-sm-2 control-label">제목</label>
								<div class="col-sm-10">
									<label class="control-label">${postVo.title }</label>
								</div>
							</div>

							<div class="form-group">
								<label for="id" class="col-sm-2 control-label">글내용</label>
								<div class="col-sm-10">
									<label class="control-label">${postVo.content }</label>
								</div>
							</div>

							<div class="form-group">
								<label for="name" class="col-sm-2 control-label">첨부파일</label>
								<div class="col-sm-10">
									<c:forEach items="${uploadList }" var="uploadList">
										<label class="control-label"><a
											href="/fileDownload?pic=${uploadList.pic}&picName=${uploadList.picname}">${uploadList.pic }</a></label>
										<br>
									</c:forEach>
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<input type="button" value="수정" class="btn btn-default"
										onclick="mappingAction('modify')">
									<c:if test="${postVo.std_id == std_id}">
										<input type="button" value="삭제" class="btn btn-default"
											onclick="mappingAction('delete')">
									</c:if>
									<input type="button" class="btn btn-default" value="답글"
										onclick="mappingAction('answer')">
								</div>
							</div>

						</form>

						<div class="form-group">
							<label for="call_cnt" class="col-sm-2 control-label">댓글</label>

							<div class="col-sm-10">
								<c:forEach items="${replyVo }" var="replyVo">
									<form method="post" class="form-horizontal"
										action="/replyDelete">
										<input type="hidden" id="id" name="id"
											value="${postVo.post_id }"> <input type="hidden"
											id="com_id" name="com_id" value="${replyVo.com_id }">
										<c:choose>
											<c:when test="${replyVo.isyn == 0}">
												<label class="control-label">${replyVo.context }</label>
												<input type="hidden" class="form-control" id="context"
													name="context" value="${replyVo.context }">

												<label class="control-label">[${replyVo.std_id} / <fmt:formatDate
														value="${replyVo.comdate }" pattern="yyyy-MM-dd" />]
												</label>

												<input type="submit" class="btn btn-default" id="delReply"
													value="삭제">
												<br>
											</c:when>

											<c:otherwise>
												<label class="control-label">[삭제 된 게시글 입니다.]</label>

												<br>
											</c:otherwise>
										</c:choose>
									</form>
								</c:forEach>
							</div>
						</div>

						<form method="post" class="form-horizontal" action="/replySave">
							<input type="hidden" id="id" name="id" value="${postVo.post_id }">
							<div class="col-sm-2"></div>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="reply" name="reply"
									placeholder="댓글쓰기"> <input type="submit"
									class="btn btn-default" id="reply" value="댓글저장">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
	function mappingAction(val) {

		var form = document.frm;

		if (val == "modify") {
			form.action = "/listUpdate";
		} else if (val == "delete") {
			form.action = "/delete";
		} else if (val == "answer") {
			form.action = "/answer";
		} else {
			return false;
		}

		form.submit();

	}
</script>

</html>
