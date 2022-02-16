package com.te.stores.service;

import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.te.stores.bean.StoresBean;
import com.te.stores.exception.CustomException;

@Service
public class StoresServiceImpl implements StoresService {

	@Override
	public List<StoresBean> getAll(String option) {

		List<StoresBean> list1 = null;

		Map<String, String> map = new HashMap();
		map.put("Store Id", "storeId");
		map.put("Post Code", "postCode");
		map.put("City", "city");
		map.put("Address", "address");
		map.put("Opened Date", "openedDate");

		HeaderColumnNameTranslateMappingStrategy<StoresBean> strategy = new HeaderColumnNameTranslateMappingStrategy<StoresBean>();
		strategy.setType(StoresBean.class);
		strategy.setColumnMapping(map);

		CSVReader reader = null;

		try {
			reader = new CSVReader(new FileReader("src/main/resources\\stores.csv"));

		} catch (Exception e) {
			throw new CustomException("DATA NOT FOUND");
		}

		CsvToBean bean = new CsvToBean();

		List<StoresBean> list = bean.parse(strategy, reader);

		for (StoresBean storesBean : list) {

			Date from = null;
			try {
				from = new SimpleDateFormat("dd/MM/yyyy").parse(storesBean.getOpenedDate());

				Date to = new Date();

				long diffInMillies = Math.abs(to.getTime() - from.getTime());
				long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

				storesBean.setNumberOfDays(diff);

			} catch (ParseException e) {

				e.printStackTrace();
			}

		}

		if (option.equalsIgnoreCase("city")) {
			list1 = list.stream().sorted((a, b) -> a.getCity().compareTo(b.getCity()))
					.collect(Collectors.toList());

		} else if (option.equalsIgnoreCase("openeddate")) {
			list1 = list.stream().sorted((i, j) -> i.getOpenedDate().compareTo(j.getOpenedDate()))
					.collect(Collectors.toList());
		}
		return list1;
	}
	
	//end of getall

	@Override
	public StoresBean getData(String storesid) {
		Map<String, String> map = new HashMap();
		map.put("Store Id", "storeid");
		map.put("Post Code", "postcode");
		map.put("City", "city");
		map.put("Address", "address");
		map.put("Opened Date", "openeddate");

		HeaderColumnNameTranslateMappingStrategy<StoresBean> strategy = new HeaderColumnNameTranslateMappingStrategy<StoresBean>();
		strategy.setType(StoresBean.class);
		strategy.setColumnMapping(map);

		CSVReader reader = null;

		try {
			reader = new CSVReader(new FileReader("src/main/resources\\stores.csv"));

		} catch (Exception e) {
			throw new CustomException("Path Not found");
		}

		CsvToBean bean = new CsvToBean();

		List<StoresBean> list = bean.parse(strategy, reader);

		StoresBean res = null;

		for (StoresBean storeinfo : list) {
			Date from = null;
			try {
				from = new SimpleDateFormat("dd/MM/yyyy").parse(storeinfo.getOpenedDate());

				Date to = new Date();

				long diffInMillies = Math.abs(to.getTime() - from.getTime());
				long difference = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

				storeinfo.setNumberOfDays(difference);

			} catch (Exception e) {
				e.printStackTrace();
			}
			if (storeinfo.getStoreId().equals(storesid)) {
				res = storeinfo;
			}
		}
		if (res != null) {
			return res;
		} else {
			throw new CustomException("Please Enter Valid ID");
		}

	}
}//end of getinfo by store id
