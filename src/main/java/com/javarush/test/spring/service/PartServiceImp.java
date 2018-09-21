package com.javarush.test.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javarush.test.spring.dao.PartDao;
import com.javarush.test.spring.model.Part;

/**
 * @author imssbora
 *
 */
@Service
public class PartServiceImp implements PartService {

    @Autowired
    private PartDao partDao;

    @Transactional
    public void save(Part part) {
        partDao.save(part);
    }

    @Transactional
    public void delete(Long id) {
        partDao.delete(id);
    }

    @Transactional
    public Part load(Long id) {
        return partDao.load(id);
    }

    @Transactional(readOnly = true)
    public List<Part> list() {
        return partDao.list();
    }

    @Transactional(readOnly = true)
    public List<Part> listAll(Integer page, Integer maxRows, String name){
        return partDao.listCombain(page, maxRows, null, name);
    }


    @Transactional(readOnly = true)
    public List<Part> listRequired(Integer page, Integer maxRows){
        return partDao.listCombain(page, maxRows, true, null);
    }

    @Transactional(readOnly = true)
    public List<Part> listOptional(Integer page, Integer maxRows){
        return partDao.listCombain(page, maxRows, false, null);
    }

    @Transactional(readOnly = true)
    public Integer countComputers(){
        return partDao.countComputers();
    }

    @Transactional(readOnly = true)
    public Integer countPartsAll(String name){
        return partDao.countParts(null, name);
    }

    @Transactional(readOnly = true)
    public Integer countPartsOptional(String name){
        return partDao.countParts(false, name);
    }

    @Transactional(readOnly = true)
    public Integer countPartsRequired(String name){
        return partDao.countParts(true, name);
    }
}
