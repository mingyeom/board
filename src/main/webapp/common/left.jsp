<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="/board/main.jsp">Main <span
				class="sr-only">(current)</span></a></li>
		<li class="active"><a href="/boardServlet">게시판 생성</a></li>
		<c:forEach items="${boardVoList }" var="vo">
			<li><a href="/postServlet?board_id=${vo.board_id}&page=1&pageSize=10&board_name=${vo.board_name }">${vo.board_name }</a></li>
		</c:forEach>
	</ul>
</div>