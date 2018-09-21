package com.javarush.test.spring.service;

import java.util.List;

import com.javarush.test.spring.model.Part;

public interface PartService {
    void save(Part part);
    void delete(Long id);
    Part load(Long id);

    List<Part> list();

    List<Part> listAll(Integer page, Integer maxRows, String name);
    List<Part> listRequired(Integer page, Integer maxRows);
    List<Part> listOptional(Integer page, Integer maxRows);
    Integer countComputers();
    Integer countPartsAll(String name);
    Integer countPartsRequired(String name);
    Integer countPartsOptional(String name);
}
