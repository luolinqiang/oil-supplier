package com.oil.supplier.dao.impl;

import com.oil.supplier.dao.UserDao;
import com.oil.supplier.domain.User;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: guowenjuan
 * Date: 16-1-13
 * Time: 下午4:14
 * To change this template use File | Settings | File Templates.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    @Qualifier("sqlSession")
    org.mybatis.spring.SqlSessionTemplate template;

    public Long insert(User u) {
        template.insert("com.oil.supplier.dao.UserDao.insert", u);
        return u.getId();
    }

    public boolean update(User u) {
        Validate.notNull(u.getId(), "the id column is null");
        template.update("com.oil.supplier.dao.UserDao.update", u);
        return true;
    }

    public User getById(Long id) {
        Validate.notNull(id, "the id is null");
        return (User)template.selectOne("com.oil.supplier.dao.UserDao.getById", id);
    }

    public User getByUserId(String userId) {
        Validate.notNull(userId, "the id is null");
        return (User)template.selectOne("com.oil.supplier.dao.UserDao.getByUserId", userId);
    }

    @SuppressWarnings("unchecked")
    public List<User> getList(User u) {
        return (List<User>) template.selectList("com.oil.supplier.dao.UserDao.getList", u);
    }

}
