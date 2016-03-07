package com.oil.supplier.common.exception;

import com.alibaba.fastjson.JSONObject;
import com.oil.supplier.common.ResponsesDTO;
import com.oil.supplier.common.ReturnCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: guowenjuan
 * Date: 15-12-22
 * Time: 上午11:14
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionHandler implements HandlerExceptionResolver {

    private static final Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {

        log.error(ex.getMessage(), ex);
        try {
            ResponsesDTO responsesDTO = new ResponsesDTO(ReturnCode.ACTIVE_EXCEPTION);
            responsesDTO.setData(ex.getMessage());
//            PrintWriter out = response.getWriter();
//            out.write(JSONObject.toJSONString(responsesDTO));
//            out.flush();
            //response.setCharacterEncoding("utf-8");
            response.getWriter().write(JSONObject.toJSONString(responsesDTO));
            response.getWriter().flush();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
