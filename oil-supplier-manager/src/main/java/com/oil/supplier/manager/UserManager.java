package com.oil.supplier.manager;

import com.jd.common.manager.ManagerException;
import com.oil.supplier.domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: guowenjuan
 * Date: 16-1-14
 * Time: 下午1:31
 * To change this template use File | Settings | File Templates.
 */
public interface UserManager {

    public Long createUser(User user) throws RuntimeException;

    public void updateUser(User user) throws RuntimeException;

    public User findUserByUserId(String userId) throws RuntimeException;

    public List<User> findUserByUser(User user) throws RuntimeException;

}
