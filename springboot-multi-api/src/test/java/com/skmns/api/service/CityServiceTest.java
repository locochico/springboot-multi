package com.skmns.api.service;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.skmns.common.model.City;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class CityServiceTest {

	@Autowired
	CityService service;

	@Test
	public void getCityById() {
		City city = service.getCityById(1L);
		log.info("city : {}", city);
	}

	@Test
	public void getAllCity() {
		List<City> cities = service.getAllCity();
		log.info("cities : {}", cities);
	}

	//@Test
	@Ignore
	public void addCities() {
		service.addCity(new City("����", "�̱�", 1_000_000L));
		service.addCity(new City("����", "����", 2_000_000L));
		service.addCity(new City("�ĸ�", "������", 3_000_000L));
	}
}
