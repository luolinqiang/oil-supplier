package com.oil.supplier.dao.impl;

import com.oil.supplier.dao.OrderDao;
import com.oil.supplier.domain.Order;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-19
 * Time: 下午12:32
 * To change this template use File | Settings | File Templates.
 */
@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {

    @Autowired
    @Qualifier("sqlSession")
    org.mybatis.spring.SqlSessionTemplate template;

    public Long insert(Order order) {
        template.insert("com.oil.supplier.dao.OrderDao.insert", order);
        return order.getId();
    }

    public boolean update(Order order) {
        Validate.notNull(order.getId(), "the id column is null");
        template.update("com.oil.supplier.dao.OrderDao.update", order);
        return true;
    }

    public Order getById(Long id) {
        Validate.notNull(id, "the id is null");
        return (Order)template.selectOne("com.oil.supplier.dao.OrderDao.getById", id);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getList(Order order) {
        return (List<Order>) template.selectList("com.oil.supplier.dao.OrderDao.getList", order);
    }

}
