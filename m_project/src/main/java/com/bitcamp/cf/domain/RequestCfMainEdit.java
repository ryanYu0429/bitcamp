package com.bitcamp.cf.domain;

public class RequestCfMainEdit {

	private int m_num;
	private String m_content;
	private String m_id;
	private String m_info;
	private String m_img;
	private String m_title;
	

	
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
		return "RequestCfMainEdit [m_num=" + m_num + ", m_content=" + m_content + ", m_id=" + m_id + ", m_info="
				+ m_info + ", m_img=" + m_img + ", m_title=" + m_title + "]";
	}


	public cfMain toCfMain() {
		
		cfMain main = new cfMain();
		main.setM_num(m_num);
		main.setM_id(m_id);
		main.setM_content(m_content);
		main.setM_info(m_info);
		main.setM_img(m_img);
		main.setM_title(m_title);
		
		return main;
	}
	
	
}
