package com.skmns.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.skmns.common.model.City;

@Mapper
public interface CityMapper {
    City selectCityById(Long id);
    
    List<City> selectAllCity();
    
    void insertCity(City city);
}
