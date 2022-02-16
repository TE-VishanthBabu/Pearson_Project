package com.te.stores.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StoresBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@CsvBindByName(column = "Store Id")
	private String storeId;

	@CsvBindByName(column = "Post Code")
	private String postCode;

	@CsvBindByName(column = "City")
	private String city;

	@CsvBindByName(column = "Address")
	private String address;

	@CsvBindByName(column = "Opened Date")
	@CsvDate(value = "dd/MM/yyyy")
	private String openedDate;

	public StoresBean(String storeId, String postCode, String city, String address, String openedDate,
			Long numberOfDays) {
		super();
		this.storeId = storeId;
		this.postCode = postCode;
		this.city = city;
		this.address = address;
		this.openedDate = openedDate;
		this.numberOfDays = numberOfDays;
	}

	private Long numberOfDays;

	public StoresBean() {
		super();
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOpenedDate() {
		return openedDate;
	}

	public void setOpenedDate(String openedDate) {
		this.openedDate = openedDate;
	}

	public Long getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(Long numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "StoresBean [storeId=" + storeId + ", postCode=" + postCode + ", city=" + city + ", address=" + address
				+ ", openedDate=" + openedDate + ", numberOfDays=" + numberOfDays + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, city, numberOfDays, openedDate, postCode, storeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoresBean other = (StoresBean) obj;
		return Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& Objects.equals(numberOfDays, other.numberOfDays) && Objects.equals(openedDate, other.openedDate)
				&& Objects.equals(postCode, other.postCode) && Objects.equals(storeId, other.storeId);
	}

	


}
