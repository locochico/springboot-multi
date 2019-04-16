package com.skmns.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skmns.common.mapper.CityMapper;
import com.skmns.common.model.City;

@Service
@Transactional
public class CityService {
	@Autowired
    CityMapper cityMapper;
	
	public City getCityById(Long id) {
        return cityMapper.selectCityById(id);
    }

    public List<City> getAllCity() {
        return cityMapper.selectAllCity();
    }

    public void addCity(City city) {
        cityMapper.insertCity(city);
    }
}
