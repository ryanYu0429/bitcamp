package com.bitcamp.cf.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.cf.domain.RequestCfMainEdit;
import com.bitcamp.cf.domain.RequestCfMainInsert;
import com.bitcamp.cf.domain.cfMain;
import com.bitcamp.cf.service.CfMainDeleteService;
import com.bitcamp.cf.service.CfMainEditService;
import com.bitcamp.cf.service.CfMainListService;
import com.bitcamp.cf.service.InsertMainService;

@RestController // @ResponseBody 생략한다
@RequestMapping("rest/cfMain")
public class RestFulAllController {
	
	@Autowired
	private CfMainListService listService;

	@Autowired
	private InsertMainService insertService;
	
	@Autowired
	private CfMainDeleteService deleteService;
	
	@Autowired
	private CfMainEditService editService;
	
	
	
	@GetMapping
	public ResponseEntity<List<cfMain>> getAllList(){
		
		List<cfMain> list = listService.getAllList();
		
		ResponseEntity<List<cfMain>> entity = new ResponseEntity<List<cfMain>>(list,HttpStatus.OK);
		
		return entity;
			
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> insertMain(RequestCfMainInsert insertRequest, HttpServletRequest request){
		
		System.out.println("check : " + insertRequest);
		
		int cnt = insertService.cfMainInsert(request, insertRequest);
		
		return new ResponseEntity<String>(cnt>0 ? "SUCCESS" : "FAIL" , HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@DeleteMapping("/{m_num}")
	public ResponseEntity<String> deleteCfMain(
			@PathVariable("m_num") int m_num
			){
		return new ResponseEntity<String>(
				deleteService.CfMainDelete(m_num)>0?"SUCCESS":"FAIL",
				HttpStatus.OK
				);
		
	}
	
	@CrossOrigin
	@GetMapping("/{m_num}")
	public ResponseEntity<cfMain> getCfMain(@PathVariable("m_num") int m_num){
		
		cfMain main = editService.getEditFormData(m_num);
		
		return new ResponseEntity<cfMain>(main, HttpStatus.OK);
			
	}
	
	@CrossOrigin
	@PutMapping("/{m_num}")
	public ResponseEntity<String> editCfMain(
			@PathVariable("m_num") int m_num,
			@RequestBody RequestCfMainEdit editRequest,
			HttpServletRequest request
			){
		
		editRequest.setM_num(m_num);
		System.out.println(editRequest);
		
		int cnt = editService.edit(editRequest, request);
		
		return new ResponseEntity<String>(cnt>0?"SUCCESS":"FAIL", HttpStatus.OK);
		
		
	}
	
	
	
	
	
}
