package com.javarush.test.spring.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javarush.test.spring.model.Part;

/**
 * @author imssbora
 */
@Repository
public class PartDaoImp implements PartDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Part part) {
        sessionFactory.getCurrentSession().saveOrUpdate(part);
    }

    @Override
    public void delete(Long id) {

        sessionFactory.getCurrentSession().createQuery("delete from Part where id="+id).executeUpdate();
    }

    @Override
    public Part load(Long id){
        return (Part) sessionFactory.getCurrentSession().get(Part.class, id);
    }

    @Override
    public List<Part> list() {
        @SuppressWarnings("unchecked")
        TypedQuery<Part> query = sessionFactory.getCurrentSession().createQuery("from Part");
        return query.getResultList();
    }

    @Override
    public List<Part> listCombain(Integer start, Integer maxRows, Boolean required, String name) {
        String stringQuery = "from Part";
        if(required != null || name != null) stringQuery += " where ";
        if(required != null) stringQuery += "required = " + required;
        if(name != null) stringQuery += "name = '" + name + "'";
        @SuppressWarnings("unchecked")
        TypedQuery<Part> query = sessionFactory.getCurrentSession().createQuery(stringQuery);
        query.setFirstResult(start);
        query.setMaxResults(maxRows);
        return query.getResultList();
    }

    @Override
    public Integer countComputers() {
        return (Integer)sessionFactory.getCurrentSession().createQuery("select min(qty) from Part where REQUIRED=1").uniqueResult();
    }

    @Override
    public Integer countParts(Boolean required, String name) {
        String query = "select count(*) from Part";
        if(required != null || name != null) query += " where ";
        if(required != null) query += "required = " + required;
        if(name != null) query += "name = '" + required + "'";

        return ((Long)sessionFactory.getCurrentSession().createQuery(query).uniqueResult()).intValue();
    }
}
