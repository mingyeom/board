package kr.or.ddit.board.model;

import java.util.Date;

public class BoardVo {
	
	private int board_id;
	private String board_name;
	private int use_yn;
	private String writer;
	private Date boarddate;
	
	public BoardVo() {
		
	}
	
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public int getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(int use_yn) {
		this.use_yn = use_yn;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getBoarddate() {
		return boarddate;
	}
	public void setBoarddate(Date boarddate) {
		this.boarddate = boarddate;
	}
	
	@Override
	public String toString() {
		return "BoardVo [board_id=" + board_id + ", board_name=" + board_name
				+ ", use_yn=" + use_yn + ", writer=" + writer + ", boarddate="
				+ boarddate + "]";
	}
	
}
