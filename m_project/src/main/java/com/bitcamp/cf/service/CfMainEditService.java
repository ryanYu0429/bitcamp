package com.bitcamp.cf.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.bitcamp.cf.dao.CfMainDaoInterface;
import com.bitcamp.cf.domain.RequestCfMainEdit;
import com.bitcamp.cf.domain.cfMain;

@Service("editService")
public class CfMainEditService implements CfMainService {

	private CfMainDaoInterface dao;
	
	@Inject
	private SqlSessionTemplate template;
	
	
	public cfMain getEditFormData(int m_num) {
		
		dao = template.getMapper(CfMainDaoInterface.class);
		
		cfMain cfmain = dao.selectCfMainByNum(m_num);
		
		return cfmain;
	}
	
	public int edit(RequestCfMainEdit edit, HttpServletRequest request) {
		
		dao = template.getMapper(CfMainDaoInterface.class);
		
		int rCnt = 0;
		cfMain cfmain = edit.toCfMain();
		
		//String path = "/uploadfile/userphoto";
		//String dir = request.getSession().getServletContext().getRealPath(path);

		rCnt = dao.CfMainUpdate(cfmain);
		
		return rCnt;
	}
	
}
