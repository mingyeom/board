package kr.or.ddit.reply.model;

import java.util.Date;

public class ReplyVo {
	
	private int com_id;
	private Date comdate;
	private String context;
	private int post_id;
	private String std_id;
	private String isyn;
  
	public ReplyVo(){
		
	}

	public int getCom_id() {
		return com_id;
	}

	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}

	public Date getComdate() {
		return comdate;
	}

	public void setComdate(Date comdate) {
		this.comdate = comdate;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getStd_id() {
		return std_id;
	}

	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}

	public String getIsyn() {
		return isyn;
	}

	public void setIsyn(String isyn) {
		this.isyn = isyn;
	}

	@Override
	public String toString() {
		return "ReplyVo [com_id=" + com_id + ", comdate=" + comdate
				+ ", context=" + context + ", post_id=" + post_id + ", std_id="
				+ std_id + ", isyn=" + isyn + "]";
	}
	
}
