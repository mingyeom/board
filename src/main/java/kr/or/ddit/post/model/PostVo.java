package kr.or.ddit.post.model;

import java.util.Date;


public class PostVo {
	
	private int post_id;
	private int board_id;
    private int post_papa;
	private int post_gid;
	private String title;
	private String content;
	private String writer;
	private Date postdate;
	private String del_yn;
	private String std_id;
	
	public PostVo(){
		
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public int getPost_papa() {
		return post_papa;
	}

	public void setPost_papa(int post_papa) {
		this.post_papa = post_papa;
	}

	public int getPost_gid() {
		return post_gid;
	}

	public void setPost_gid(int post_gid) {
		this.post_gid = post_gid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getPostdate() {
		return postdate;
	}

	public void setPostdate(java.sql.Date postdate) {
		this.postdate = postdate;
	}

	public String getDel_yn() {
		return del_yn;
	}

	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}

	public String getStd_id() {
		return std_id;
	}

	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}

	@Override
	public String toString() {
		return "PostVo [post_id=" + post_id + ", board_id=" + board_id
				+ ", post_papa=" + post_papa + ", post_gid=" + post_gid
				+ ", title=" + title + ", content=" + content + ", writer="
				+ writer + ", postdate=" + postdate + ", del_yn=" + del_yn
				+ ", std_id=" + std_id + "]";
	}
	
}
