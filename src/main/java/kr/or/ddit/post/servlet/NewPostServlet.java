package kr.or.ddit.post.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;
import kr.or.ddit.upload.model.UploadVo;
import kr.or.ddit.upload.service.UploadService;
import kr.or.ddit.upload.service.UploadServiceInf;
import kr.or.ddit.upload.web.FileUtil;

/**
 * Servlet implementation class NewPostServlet
 */
@WebServlet("/newPost")
@MultipartConfig(maxFileSize = 1024 * 1000 * 5, maxRequestSize = 1024 * 1000 * 16)
public class NewPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		int board_id = Integer.parseInt(request.getParameter("board_id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		PostServiceInf postService = new PostService();
		PostVo postVo = new PostVo();

		UploadServiceInf uploadService = new UploadService();
		UploadVo uploadVo = new UploadVo();

		HttpSession session = request.getSession();
		String std_id = (String) session.getAttribute("std_id");

		postVo.setStd_id(std_id);
		postVo.setBoard_id(board_id);
		postVo.setTitle(title);
		postVo.setContent(content);

		postService.insertPost(postVo);

		int uploadPost_Id = postService.getPostId(postVo);

		Collection<Part> parts = request.getParts();
		// Part uploadFilePart = request.getPart("uploadFile");

		for (Part part : parts) {
			
			if (part.getContentType() != null) {

				String contentDisposition = part.getHeader("Content-disposition");
				String filename = FileUtil.getFileName(contentDisposition); // pic

				String path = FileUtil.fileUploadPath;

				if (part.getSize() > 0) {

					String picName = UUID.randomUUID().toString();
					part.write(path + File.separator + picName);
					part.delete();

					if (!filename.equals(null)) {
						uploadVo.setPic(filename);
						uploadVo.setPicname(picName);
						uploadVo.setPicpath(path);
						uploadVo.setPost_id(uploadPost_Id);

						uploadService.uploadFile(uploadVo);
					}

				}
			}

		}

		response.sendRedirect("/postServlet?board_id=" + board_id
				+ "&page=1&pageSize=10");

	}

}
