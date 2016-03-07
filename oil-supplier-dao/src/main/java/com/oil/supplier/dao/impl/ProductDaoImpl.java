package com.oil.supplier.dao.impl;

import com.oil.supplier.dao.ProductDao;
import com.oil.supplier.domain.Product;
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
@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

    @Autowired
    @Qualifier("sqlSession")
    org.mybatis.spring.SqlSessionTemplate template;

    public Long insert(Product p) {
        template.insert("com.oil.supplier.dao.ProductDao.insert", p);
        return p.getId();
    }

    public boolean update(Product p) {
        Validate.notNull(p.getId(), "the id column is null");
        template.update("com.oil.supplier.dao.ProductDao.update", p);
        return true;
    }

    public Product getById(Long id) {
        Validate.notNull(id, "the id is null");
        return (Product)template.selectOne("com.oil.supplier.dao.ProductDao.getById", id);
    }

    @SuppressWarnings("unchecked")
    public List<Product> getList(Product p) {
        return (List<Product>) template.selectList("com.oil.supplier.dao.ProductDao.getList", p);
    }
}
