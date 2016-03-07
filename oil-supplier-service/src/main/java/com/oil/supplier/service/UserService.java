package com.oil.supplier.service;

import com.oil.supplier.domain.User;
import com.oil.supplier.domain.vo.UserLoginVo;
import org.springframework.validation.BindingResult;

/**
 * Created with IntelliJ IDEA.
 * User: guowenjuan
 * Date: 16-1-14
 * Time: 下午3:00
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {

    User login(UserLoginVo userLogin, BindingResult valid);

    User getUserByUserId(String userId);

    void updateUserInfo(User user);

    User parseCookie(String cookieValue);
}
