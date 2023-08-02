package com.example.test.service;

import com.example.test.model.City;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {
    List<City> cityList;

    public CityService() {
        cityList = new ArrayList<>();
        cityList.add(new City(1, "City A", "Nation A", 100, 1000, 50, "Introduce A"));
        cityList.add(new City(2, "City B", "Nation B", 100, 1000, 50, "Introduce B"));
        cityList.add(new City(3, "City C", "Nation C", 100, 1000, 50, "Introduce C"));
        cityList.add(new City(4, "City D", "Nation D", 100, 1000, 50, "Introduce D"));
        cityList.add(new City(5, "City E", "Nation E", 100, 1000, 50, "Introduce E"));
    }
    public List<City> getCityList() {
        return cityList;
    }
    public City findCityById(int id) {
        for (City city : cityList) {
            if (city.getId() == id) return city;
        }
        return null;
    }
    public int findIndexById(int id) {
        for (int i = 0; i < cityList.size(); i++) {
            if (cityList.get(i).getId() == id) return i;
        }
        return -1;
    }
    public void editCity(int id, City city) {
        int index = findIndexById(id);
        if (index != -1) {
            cityList.set(index, city);
        }
    }
    public void createCity(City city) {
        cityList.add(city);
    }
    public void deleteCity(int id) {
        int index = findIndexById(id);
        if (index != -1) {
            cityList.remove(index);
        }
    }
}
