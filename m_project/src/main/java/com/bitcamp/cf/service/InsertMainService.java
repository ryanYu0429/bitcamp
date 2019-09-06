package com.bitcamp.cf.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.bitcamp.cf.dao.CfMainDaoInterface;
import com.bitcamp.cf.domain.RequestCfMainInsert;
import com.bitcamp.cf.domain.cfMain;

@Service("insertCfMainService")
public class InsertMainService implements CfMainService{

	private CfMainDaoInterface dao;
	
	@Inject
	private SqlSessionTemplate template;
	
	
	public int cfMainInsert(HttpServletRequest request, RequestCfMainInsert insertMain) {
	
		dao =template.getMapper(CfMainDaoInterface.class);
		
		//String path = "/uploadfile/userphoto";
		//String dir = request.getSession().getServletContext().getRealPath(path);
		
		cfMain cfmain = insertMain.toCfMain();
		
		int resultCnt = 0;
		
		resultCnt = dao.insertCfMain(cfmain);
		
		return resultCnt;
		
	}
	

	
	
}
