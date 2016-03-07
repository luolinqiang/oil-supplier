package com.oil.supplier.web.base;

import com.oil.supplier.common.ReturnCode;
import org.apache.log4j.Logger;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

public abstract class GlobalControllor {

    private static final Logger logger = Logger.getLogger(GlobalControllor.class);

    @ResponseBody
    @ExceptionHandler({TypeMismatchException.class})
    public Map<String, ? extends Object> typeMismatchException(TypeMismatchException e) {
        logger.error(e.getMessage());
        this.printStackTrace(e);
        Map<String, Object> map = (Map<String, Object>) ReturnCode.ERROR_PARAMS.Map();
        map.put("msg", "值为 '" + e.getValue() + "' 参数错误！");
        return map;
    }

    @ResponseBody
    @ExceptionHandler({Exception.class})
    public Map<String, ? extends Object> exception(Exception e) {
        logger.error(e.getMessage());
        printStackTrace(e);
        Map<String, Object> map = (Map<String, Object>) ReturnCode.ERROR_SERVER.Map();
        map.put("data", e.getMessage());
        return map;
    }

    @ResponseBody
    @ExceptionHandler({RuntimeException.class})
    public Map<String, ? extends Object> exception(RuntimeException e) {
        logger.error(e.getMessage());
        printStackTrace(e);
        Map<String, Object> map = (Map<String, Object>) ReturnCode.ERROR_SERVER.Map();
        map.put("data", e.getMessage());
        map.remove("msg");
        return map;
    }

    private void printStackTrace(Exception e) {
        StringWriter w = new StringWriter();
        PrintWriter pw = new PrintWriter(w);
        e.printStackTrace(pw);
        pw.flush();
        logger.error(w.toString());
    }
}
