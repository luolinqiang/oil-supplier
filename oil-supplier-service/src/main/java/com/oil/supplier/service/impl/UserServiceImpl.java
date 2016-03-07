package com.oil.supplier.service.impl;

import com.oil.supplier.common.CommonConstants;
import com.oil.supplier.common.util.ValidateUtils;
import com.oil.supplier.domain.User;
import com.oil.supplier.domain.vo.UserLoginVo;
import com.oil.supplier.manager.UserManager;
import com.oil.supplier.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

/**
 * Created with IntelliJ IDEA.
 * User: guowenjuan
 * Date: 16-1-14
 * Time: 下午3:01
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserManager userManager;

    @Override
    public User login(UserLoginVo userLogin, BindingResult valid) {
        String userId = userLogin.getUserId();
        String password = userLogin.getPassword();
        if (valid.hasErrors()) {
            throw new RuntimeException(ValidateUtils.validator(valid.getAllErrors()));
        }
        User user = userManager.findUserByUserId(userId);
        if (null == user) {
            throw new RuntimeException("用户不存在");
        }
        if (!user.getPassword().equalsIgnoreCase(password.trim())) {
            throw new RuntimeException("用户名或密码不正确");
        }
        return user;
    }

    @Override
    public User getUserByUserId(String userId) {
        return userManager.findUserByUserId(userId);
    }

    @Override
    public void updateUserInfo(User user) {
        userManager.updateUser(user);
    }


    public User parseCookie(String cookieValue) {
        String[] splitArr = cookieValue.split("\\" + CommonConstants.SEPARATOR);
        User user = new User();

        if (splitArr != null && splitArr.length >= 4) {
            user.setUserId(splitArr[0]);
            user.setPhone(splitArr[0]);
            if (StringUtils.isNotBlank(splitArr[1]) && !"null".equalsIgnoreCase(splitArr[1])) {
                user.setUserType(Integer.parseInt(splitArr[1]));
            }
            if (StringUtils.isNotBlank(splitArr[2]) && !"null".equalsIgnoreCase(splitArr[2])) {
                user.setId(Long.parseLong(splitArr[2]));
            }
            if (StringUtils.isNotBlank(splitArr[3]) && !"null".equalsIgnoreCase(splitArr[3])) {
                user.setSupplierId(Long.parseLong(splitArr[3]));
            }
            return user;
        }

        if (splitArr != null && splitArr.length >= 3) {
            user.setUserId(splitArr[0]);
            user.setPhone(splitArr[0]);
            if (StringUtils.isNotBlank(splitArr[1]) && !"null".equalsIgnoreCase(splitArr[1])) {
                user.setUserType(Integer.parseInt(splitArr[1]));
            }
            if (StringUtils.isNotBlank(splitArr[2]) && !"null".equalsIgnoreCase(splitArr[2])) {
                user.setId(Long.parseLong(splitArr[2]));
            }

            if (splitArr.length >= 4 && StringUtils.isNotBlank(splitArr[3]) && !"null".equalsIgnoreCase(splitArr[3])) {
                user.setSupplierId(Long.parseLong(splitArr[3]));
            }
            return user;
        }
        return null;
    }
}
