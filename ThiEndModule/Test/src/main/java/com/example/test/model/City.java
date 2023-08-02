package com.example.test.model;

public class City {
    private int id;
    private String city;
    private String nation;
    private int area;
    private int population;
    private int GDP;
    private String introduce;

    public City() {
    }

    public City(int id, String city, String nation, int area, int population, int GDP, String introduce) {
        this.id = id;
        this.city = city;
        this.nation = nation;
        this.area = area;
        this.population = population;
        this.GDP = GDP;
        this.introduce = introduce;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getGDP() {
        return GDP;
    }

    public void setGDP(int GDP) {
        this.GDP = GDP;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
