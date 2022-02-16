package com.te.stores.bean;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StoresBeanTest {
	String json = "{\"storeid\":\"10\",\"postcode\":\"563377\",\"city\":\"chennai\",\"address\":\"t-nagar\",\"openeddate\":null,\"numberofdays\":null}";
	ObjectMapper mapper = new ObjectMapper();

	@Test
	void test() throws JsonProcessingException, ParseException {
		StoresBean bean=new StoresBean();
		bean.setStoreId("10");
		bean.setPostCode("563377");
		bean.setAddress("t-nagar");
		bean.setCity("chennai");
		
		System.out.println(mapper.writeValueAsString(bean));

		StoresBean readValue = mapper.readValue(json, StoresBean.class);

		assertEquals(json, mapper.writeValueAsString(readValue));
	}

	

}


