package com.oil.supplier.web.base;

import com.jd.common.web.cookie.CookieUtils;
import com.oil.supplier.common.CommonConstants;
import com.oil.supplier.common.ResponsesDTO;
import com.oil.supplier.common.ReturnCode;
import com.oil.supplier.domain.Supplier;
import com.oil.supplier.domain.User;
import com.oil.supplier.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseControllor extends GlobalControllor {

    private static final Logger logger = Logger.getLogger(BaseControllor.class);

    @Autowired
    protected CookieUtils cookieUtils;

    @Autowired
    protected UserService userService;

    protected User getCurrentUser(HttpServletRequest request) {
        String cookieValue = cookieUtils.getCookieValue(request, CommonConstants.OIL_DETECTION_PIN_COOKIE);
        if (null == cookieValue) return null;
        User user = userService.parseCookie(cookieValue);
        return user;
    }

    protected void setCookieRedis(HttpServletResponse response, User user, ResponsesDTO responsesDTO) {
        Integer userType = user.getUserType();
        String userId = user.getUserId();
        String device = user.getDevice();

        if (responsesDTO.getCode() == ReturnCode.ACTIVE_SUCCESS.code()) {
            User userR = (User) responsesDTO.getData();
//            String value = String.format(CommonConstants.COOKIE_FORMAT, userId, userType, userR.getId(), device);
            String value = String.format(CommonConstants.COOKIE_FORMAT, userId, userType, userR.getId(), userR.getSupplierId());
            cookieUtils.setCookie(response, CommonConstants.OIL_DETECTION_PIN_COOKIE, value);
//            String key = String.format(CommonCacheImpl.KEY, SysConstants.REDIS_PREFIX, "cookie_" + userR.getUserType(), userR.getUserId());
//            commonCache.setex(key, value, Constants.REDIS_COOKIE_TIMEOUT);
        }
    }

    protected void removeCookieRedis(HttpServletRequest request, HttpServletResponse response) {
        cookieUtils.deleteCookie(response, CommonConstants.OIL_DETECTION_PIN_COOKIE);
//        User user = this.getUserInfo(request);
//        if (user != null) {
//            String key = String.format(CommonCacheImpl.KEY, SysConstants.REDIS_PREFIX, "cookie_"
//                    + user.getUserType(), user.getUserId());
//            commonCache.remove(key);
//        }
    }
}
