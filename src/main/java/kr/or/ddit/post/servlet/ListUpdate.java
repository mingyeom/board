package kr.or.ddit.post.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class ListUpdate
 */
@WebServlet("/listUpdate")
@MultipartConfig(maxFileSize = 1024 * 1000 * 3, maxRequestSize = 1024 * 1000 * 15)
public class ListUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int post_id = Integer.parseInt(request.getParameter("id"));

		PostServiceInf postService = new PostService();
		PostVo postVo = postService.getPostpost_id(post_id);

		UploadServiceInf uploadService = new UploadService();
		List<UploadVo> uploadList = uploadService.selectfile_postId(post_id);

		request.setAttribute("postVo", postVo);
		request.setAttribute("uploadList", uploadList);

		RequestDispatcher rd = request
				.getRequestDispatcher("/board/update.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		// 파라미터 확인해야되는데..
		int post_id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		PostServiceInf postService = new PostService();
		PostVo postVo = postService.getPostpost_id(post_id);

		HttpSession session = request.getSession();
		String std_id = (String) session.getAttribute("std_id");

		List<UploadVo> uploadList = (List<UploadVo>) session
				.getAttribute("uploadList");

		postVo.setTitle(title);
		postVo.setContent(content);

		postService.postUpdate(postVo);

		// //////////////
		UploadServiceInf uploadService = new UploadService();
		UploadVo uploadVo = new UploadVo();

		int uploadPost_Id = postService.getPostId(postVo);

		Collection<Part> parts = request.getParts();
		// Part uploadFilePart = request.getPart("uploadFile");

		for (Part part : parts) {

			if (part.getContentType() != null) {

				String contentDisposition = part
						.getHeader("Content-disposition");
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

		// /////////////

		response.sendRedirect("/freeListDetail?id=" + post_id);
	}

}
