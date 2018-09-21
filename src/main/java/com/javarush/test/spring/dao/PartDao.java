package com.javarush.test.spring.dao;

import java.util.List;

import com.javarush.test.spring.model.Part;

public interface PartDao {
    void save(Part part);
    void delete(Long id);
    Part load(Long id);
    List<Part> list();
    List<Part> listCombain(Integer page, Integer Limit, Boolean reuired, String name);
    Integer countComputers();
    Integer countParts(Boolean required, String name);
}
