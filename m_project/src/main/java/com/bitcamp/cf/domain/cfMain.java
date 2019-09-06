package com.bitcamp.cf.domain;

public class cfMain {

	private int m_num;
	private String m_content;
	private String m_id;
	private String m_info;
	private String m_img;
	private String m_title;
	
	//default
	
	public cfMain() {
	
	}
	
	
	public int getM_num() {
		return m_num;
	}


	public void setM_num(int m_num) {
		this.m_num = m_num;
	}


	public String getM_content() {
		return m_content;
	}


	public void setM_content(String m_content) {
		this.m_content = m_content;
	}


	public String getM_id() {
		return m_id;
	}


	public void setM_id(String m_id) {
		this.m_id = m_id;
	}


	public String getM_info() {
		return m_info;
	}


	public void setM_info(String m_info) {
		this.m_info = m_info;
	}


	public String getM_img() {
		return m_img;
	}


	public void setM_img(String m_img) {
		this.m_img = m_img;
	}


	public String getM_title() {
		return m_title;
	}


	public void setM_title(String m_title) {
		this.m_title = m_title;
	}


	
	
	
	@Override
	public String toString() {
		return "cfMain [m_num=" + m_num + ", m_content=" + m_content + ", m_id=" + m_id + ", m_info=" + m_info
				+ ", m_img=" + m_img + ", m_title=" + m_title + "]";
	}
	
	

	public cfMain(int m_num, String m_content, String m_id, String m_info, String m_img, String m_title) {
		super();
		this.m_num = m_num;
		this.m_content = m_content;
		this.m_id = m_id;
		this.m_info = m_info;
		this.m_img = m_img;
		this.m_title = m_title;
	}


	/*
	 * // 화면 결과 출력을 위한 HTML 코드 반환 public String makeHtmlDiv() { String str = "";
	 * 
	 * str += "<div class=\"mInfor\"> \n"; str += "	<h3> \n"; str += "		" +
	 * m_num + m_info+ "(" + m_id + ")\n"; str += "	</h3> \n"; str += "	<p> \n"; str
	 * += "		" + m_content; str += "	</p> \n"; str += "</div> \n";
	 * 
	 * return str; }
	 */
	
	
	
}
