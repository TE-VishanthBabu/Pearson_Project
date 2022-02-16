package com.te.stores.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.opencsv.CSVReader;
import com.te.stores.bean.StoresBean;

@ExtendWith(MockitoExtension.class)
public class StoresServiceTest {

	CSVReader reader;
	@InjectMocks
	private StoresServiceImpl service;

	public StoresServiceTest() {
		reader = mock(CSVReader.class);
	}

	@Test
	void testGetStoreById() throws IOException {
		StoresBean store = new StoresBean();
		store.setAddress("knagar");
		store.setCity("chennai");
		store.setStoreId("1525eec4-7bed-4597-bf5a-e06fcede5f4f");
		store.setNumberOfDays(53153453354354L);
		store.setPostCode("600077");
		store.setOpenedDate("12-05-1998");

		assertEquals("1525eec4-7bed-4597-bf5a-e06fcede5f4f", service.getData(store.getStoreId()).getStoreId());
	}

	@Test
	void testGetStoreByCity() throws Exception {
		StoresBean bean = new StoresBean();
		bean.setAddress("knagar");
		bean.setCity("Aberdeen");
		bean.setStoreId("1525eec4-7bed-4597-bf5a-e06fcede5f4f");
		bean.setNumberOfDays(53153453354354L);
		bean.setPostCode("600077");
		bean.setOpenedDate("12-05-1998");

		assertEquals("Aberdeen", service.getAll(bean.getCity()).get(0).getCity());
	}
}
