package kr.or.ddit.upload.model;

public class UploadVo {
	
	private int chum_id;
	private int post_id;
	private String pic;
	private String picpath;
	private String picname;
	
	public UploadVo(){
		
	}

	public int getChum_id() {
		return chum_id;
	}

	public void setChum_id(int chum_id) {
		this.chum_id = chum_id;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

	public String getPicname() {
		return picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}

	@Override
	public String toString() {
		return "UploadVo [chum_id=" + chum_id + ", post_id=" + post_id
				+ ", pic=" + pic + ", picpath=" + picpath + ", picname="
				+ picname + "]";
	}
	
}
