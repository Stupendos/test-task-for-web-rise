package com.example.demo.dto;

public class SubsDTO {
    private Long id;
    private String nameOfSubs;
    private Integer popularity;

    public SubsDTO(Long id, String nameOfSubs, Integer popularity) {
        this.id = id;
        this.nameOfSubs = nameOfSubs;
        this.popularity = popularity;
    }

    public SubsDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfSubs() {
        return nameOfSubs;
    }

    public void setNameOfSubs(String nameOfSubs) {
        this.nameOfSubs = nameOfSubs;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }
}
