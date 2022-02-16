package com.te.stores.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.stores.bean.StoresResponse;
import com.te.stores.service.StoresServiceImpl;

@RestController
@RequestMapping("/pearson")
public class StoresController {
	
	@Autowired
	private StoresServiceImpl service;

	@GetMapping(path="/getall/",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity< StoresResponse> getall(@RequestParam String option){
		StoresResponse response=new StoresResponse(false,service.getAll(option));
		return new ResponseEntity<StoresResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping(path="/getData/{storeid}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<StoresResponse> getStoresData(@PathVariable String storeid){
		StoresResponse response=new StoresResponse(false,service.getData(storeid));
		return new ResponseEntity<StoresResponse>(response,HttpStatus.OK);
	}
	

}
