package com.bitcamp.cf.service;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.bitcamp.cf.dao.CfMainDaoInterface;

@Service("deleteService")
public class CfMainDeleteService implements CfMainService {

	private CfMainDaoInterface dao;
	
	@Inject
	private SqlSessionTemplate template;
	
	public int CfMainDelete(int m_num) {
		
		dao = template.getMapper(CfMainDaoInterface.class);
		
		return dao.CfMainDelete(m_num);
	}
}
