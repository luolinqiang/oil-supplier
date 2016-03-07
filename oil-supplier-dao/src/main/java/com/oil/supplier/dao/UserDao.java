package com.oil.supplier.dao;

import com.oil.supplier.domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: guowenjuan
 * Date: 16-1-13
 * Time: 下午4:11
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao extends AbstractDao<User> {

    public User getByUserId(String userId);
}
