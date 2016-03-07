package com.oil.supplier.web.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.jd.common.web.cookie.CookieUtils;
import com.oil.supplier.common.CommonConstants;
import com.oil.supplier.common.ResponsesDTO;
import com.oil.supplier.common.ReturnCode;
import com.oil.supplier.domain.User;
import com.oil.supplier.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: guowenjuan
 * Date: 15-11-9
 * Time: 下午5:58
 * To change this template use File | Settings | File Templates.
 */
public class TicketRequiredInterceptor extends AbstractInterceptor {

    private static final Logger logger = Logger.getLogger(TicketRequiredInterceptor.class);

    @Autowired
    protected CookieUtils cookieUtils;

    @Autowired
    protected UserService userService;

    @Override
    public final boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
        String cookieValue = cookieUtils.getCookieValue(request, CommonConstants.OIL_DETECTION_PIN_COOKIE);
        logger.info(String.format("【TicketRequiredInterceptor】【cookieValue:%s】", cookieValue));
        if (null == cookieValue) {
            boolean isAjax = ((null == request.getHeader("X-Requested-With")) ? false : true);
            if (!isAjax) {
                String redirectUrl = request.getRequestURI();
                response.sendRedirect("/m/login.html?redirectUrl=" + redirectUrl);
            } else {
                ResponsesDTO responsesDTO = new ResponsesDTO(ReturnCode.ERROR_NO_LOGIN);
                response.setCharacterEncoding("utf-8");
                response.getWriter().write(JSONObject.toJSONString(responsesDTO));
                response.getWriter().flush();
            }
            return false;
        }
        User user = userService.parseCookie(cookieValue);
        if (user.getUserType() != CommonConstants.User.USER_TYPE_B || null == user.getSupplierId()) {
            response.sendRedirect("/m/req-supply.html");
            return false;
        }
        return true;
    }




}
