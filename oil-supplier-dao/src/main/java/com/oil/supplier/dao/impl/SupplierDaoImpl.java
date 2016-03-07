package com.oil.supplier.dao.impl;

import com.oil.supplier.dao.SupplierDao;
import com.oil.supplier.domain.Supplier;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: guowenjuan
 * Date: 16-1-14
 * Time: 上午9:42
 * To change this template use File | Settings | File Templates.
 */
@Repository("supplierDao")
public class SupplierDaoImpl implements SupplierDao {

    @Autowired
    @Qualifier("sqlSession")
    org.mybatis.spring.SqlSessionTemplate template;

    public Long insert(Supplier s) {
        template.insert("com.oil.supplier.dao.SupplierDao.insert", s);
        return s.getId();
    }

    public boolean update(Supplier s) {
        Validate.notNull(s.getId(), "the id column is null");
        template.update("com.oil.supplier.dao.SupplierDao.update", s);
        return true;
    }

    public Supplier getById(Long id) {
        Validate.notNull(id, "the id is null");
        return (Supplier)template.selectOne("com.oil.supplier.dao.SupplierDao.getById", id);
    }

    @SuppressWarnings("unchecked")
    public List<Supplier> getList(Supplier s) {
        return (List<Supplier>) template.selectList("com.oil.supplier.dao.SupplierDao.getList", s);
    }
}
