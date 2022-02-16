package com.te.stores.service;

import java.util.List;

import com.te.stores.bean.StoresBean;

public interface StoresService {

	public List<StoresBean> getAll(String option);

	public StoresBean getData(String storesid);
	
}
