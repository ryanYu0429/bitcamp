package com.bitcamp.cf.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.bitcamp.cf.dao.CfMainDaoInterface;
import com.bitcamp.cf.domain.ListViewData;
import com.bitcamp.cf.domain.SearchParam;
import com.bitcamp.cf.domain.cfMain;

@Service("listService")
public class CfMainListService implements CfMainService {

	private CfMainDaoInterface dao;
	
	@Inject
	private SqlSessionTemplate template;
	
	/*
	 * final int CFMAIN_CNT_List = 5;
	 * 
	 * public ListViewData getListData(int currentPageNumber, SearchParam
	 * searchParam) {
	 * 
	 * dao = template.getMapper(CfMainDaoInterface.class);
	 * 
	 * ListViewData listData = new ListViewData();
	 * 
	 * listData.setCurrentPageNumber(currentPageNumber);
	 * 
	 * int totalCnt = dao.selectTotalCount(searchParam);
	 * 
	 * int totalPageCnt = 0;
	 * 
	 * if(totalCnt>0) { totalPageCnt = totalCnt/CFMAIN_CNT_List;
	 * if(totalCnt%CFMAIN_CNT_List>0) { totalPageCnt++; } }
	 * 
	 * listData.setPageTotalCount(totalPageCnt);
	 * 
	 * int index= (currentPageNumber-1)*CFMAIN_CNT_List;
	 * 
	 * List<cfMain> cfMainList = null;
	 * 
	 * Map<String, Object> params = new HashMap<String, Object>();
	 * params.put("search", searchParam); params.put("index", index);
	 * params.put("count", CFMAIN_CNT_List);
	 * 
	 * cfMainList = dao.selectList(params);
	 * 
	 * listData.setCfMainList(cfMainList); for(cfMain cf : cfMainList) {
	 * System.out.println(cf); }
	 * 
	 * int no = totalCnt - index; listData.setNo(no);
	 * 
	 * listData.setTotalCount(totalCnt);
	 * 
	 * return listData;
	 * 
	 * }
	 */
	
	
	public List<cfMain> getAllList(){
		
		dao = template.getMapper(CfMainDaoInterface.class);
		
		List<cfMain> list = dao.selectAllList();
		
		return list;
	}
	
	
	
	
	
	
	
	
	
}
