package kr.or.ddit.upload.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/fileDownload")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Content-Disposition", "attacjment; filename=\"" + request.getParameter("pic") + "\"");
		response.setContentType("application/octet-stream");

		String picName = request.getParameter("picName");

		// D:\\A_TeachingMaterial\\7.JspSpring\\fileUpload\moon.png
		String file = FileUtil.fileUploadPath + File.separator + picName;
		System.out.println(picName);
		// file 입출력을 위한 준비
		ServletOutputStream sos = response.getOutputStream();

		File f = new File(file);
		FileInputStream fis = new FileInputStream(f);
		byte[] b = new byte[512];
		int len = 0;
		while ((len = fis.read(b)) != -1) {
			sos.write(b, 0, len);
		}

		sos.close();
		fis.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
