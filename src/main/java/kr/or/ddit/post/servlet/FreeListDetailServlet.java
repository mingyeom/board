package kr.or.ddit.post.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;
import kr.or.ddit.reply.model.ReplyVo;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceInf;
import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;
import kr.or.ddit.upload.model.UploadVo;
import kr.or.ddit.upload.service.UploadService;
import kr.or.ddit.upload.service.UploadServiceInf;

/**
 * Servlet implementation class FreeListDetailServlet
 */
@WebServlet("/freeListDetail")
public class FreeListDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Method : doGet
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * Method 설명 : 게시글 상세보기 페이지로 넘긴다.
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		PostServiceInf postService = new PostService();
		PostVo postVo = postService.getPostpost_id(id);
		
		UploadServiceInf uploadService = new UploadService();
		List<UploadVo> uploadList = uploadService.selectfile_postId(id);
		
		ReplyServiceInf replyService = new ReplyService();
		List<ReplyVo> replyVo = replyService.getReply_id(id);

		request.setAttribute("postVo", postVo);
		request.setAttribute("replyVo", replyVo);
		
		HttpSession session = request.getSession();
		session.setAttribute("uploadList", uploadList);
		String std_id = (String) session.getAttribute("std_id");

		request.getRequestDispatcher("/board/freeListDetail.jsp").forward(
				request, response);
	}

}
