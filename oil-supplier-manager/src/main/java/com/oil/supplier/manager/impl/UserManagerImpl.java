package com.oil.supplier.manager.impl;

import com.jd.common.manager.BaseManager;
import com.oil.supplier.dao.UserDao;
import com.oil.supplier.domain.User;
import com.oil.supplier.manager.UserManager;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: guowenjuan
 * Date: 16-1-14
 * Time: 下午1:41
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserManagerImpl extends BaseManager implements UserManager {

    private final static Logger logger = LoggerFactory.getLogger(UserManagerImpl.class);
    @Autowired
    private UserDao userDao;

    @Override
    public Long createUser(User user) throws RuntimeException {
        Validate.notNull(user, "user is null");
		Validate.notNull(user.getUserId(),"用户名为空！");
		Validate.notNull(user.getPassword(),"密码为空！");
        User u = userDao.getByUserId(user.getUserId());
        if(null != u)
            throw new RuntimeException("用户（" + user.getUserId() + "）已存在！" );
        return userDao.insert(user);
    }

    @Override
    public void updateUser(User user) throws RuntimeException {
        Validate.notNull(user,"user is null");
        Validate.notNull(user.getUserId(),"user id 为空！");
        User u = userDao.getByUserId(user.getUserId());
        if(null == u)
            throw new RuntimeException("更新的用户信息不存在！");
        userDao.update(user);
    }

    @Override
    public User findUserByUserId(String userId) throws RuntimeException {
        if(null == userId)
            return null;
        User user = userDao.getByUserId(userId);
        return user;
    }

    @Override
    public List<User> findUserByUser(User user) throws RuntimeException {
        return userDao.getList(user);
    }

}
