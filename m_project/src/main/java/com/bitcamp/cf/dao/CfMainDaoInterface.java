package com.bitcamp.cf.dao;

import java.util.List;
import java.util.Map;

import com.bitcamp.cf.domain.SearchParam;
import com.bitcamp.cf.domain.cfMain;

public interface CfMainDaoInterface {

	public List<cfMain> selectList(Map<String, Object> params);
	
	public List<cfMain> selectAllList();
	
	public int selectTotalCount(SearchParam searchParam);
	
	public int insertCfMain (cfMain cfMain);
	
	public int CfMainDelete(int m_num);
	
	public int CfMainUpdate (cfMain cfmain);
	
	// 수정폼에서 정보 획득
	public cfMain selectCfMainByNum (int m_num);
}
