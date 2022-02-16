package com.te.stores.bean.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.stores.bean.StoresBean;
import com.te.stores.service.StoresService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StoresControllerTest {

	@MockBean
	private StoresService service;

	private MockMvc mvc;

	@Autowired
	private WebApplicationContext context;

	ObjectMapper mapper = new ObjectMapper();

	@BeforeEach
	void settingup() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();

	}

	@Test
	void getInfoByIdTest() throws UnsupportedEncodingException, Exception {
		StoresBean stores = new StoresBean();
		stores.setStoreId("10er");
		stores.setPostCode("56ty");
		stores.setAddress("KK Nagar");

		when(service.getData(Mockito.anyString())).thenReturn(stores);
		String content = mvc
				.perform(get("/getData/10er").contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(mapper.writeValueAsString(stores)))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		assertEquals(stores, mapper.readValue(content, StoresBean.class));
	}

}
