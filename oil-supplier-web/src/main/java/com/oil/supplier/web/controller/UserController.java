package com.oil.supplier.web.controller;

import com.oil.supplier.common.CommonConstants;
import com.oil.supplier.common.ResponsesDTO;
import com.oil.supplier.common.ReturnCode;
import com.oil.supplier.common.util.DESUtil;
import com.oil.supplier.domain.Supplier;
import com.oil.supplier.domain.User;
import com.oil.supplier.domain.vo.UserLoginVo;
import com.oil.supplier.service.SupplierService;
import com.oil.supplier.service.UserService;
import com.oil.supplier.web.base.BaseControllor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 * User: guowenjuan
 * Date: 16-1-21
 * Time: 下午4:31
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/u")
public class UserController extends BaseControllor {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    protected UserService userService;

    @Autowired
    protected SupplierService supplierService;

    @ResponseBody
    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=utf-8")
    public ResponsesDTO loginUser(HttpServletResponse response, @Valid UserLoginVo userLoginVo, BindingResult valid) throws Exception {
        logger.debug("UserController--->login--->start");
        ResponsesDTO responsesDTO = new ResponsesDTO(ReturnCode.ACTIVE_SUCCESS);
//        try {
//            String encryptString = DESUtil.encrypt(userLoginVo.getPassword(), "12345678");
//            userLoginVo.setPassword(encryptString);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        User user = userService.login(userLoginVo, valid);
        responsesDTO.setData(user);
        setCookieRedis(response, user, responsesDTO);
        return responsesDTO;
    }

    @ResponseBody
    @RequestMapping(value = "/status", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=utf-8")
    public ResponsesDTO getSupplierState(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResponsesDTO responsesDTO = new ResponsesDTO(ReturnCode.ACTIVE_SUCCESS);
        User user = super.getCurrentUser(request);
        if (null == user) {
            responsesDTO.setCode(1011);
            return responsesDTO;
        }
        if (null == user.getSupplierId())
            responsesDTO.setData(0);
        else {
            if (user.getUserType() == CommonConstants.User.USER_TYPE_C)
                responsesDTO.setData(2);
            else {
                Supplier supplier = supplierService.getSupplierById(user.getSupplierId());
                responsesDTO.setData(supplier);
            }
        }
        return responsesDTO;
    }

    @ResponseBody
    @RequestMapping(value = "/applySupplier", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=utf-8")
    public ResponsesDTO applySupplier(HttpServletRequest request, HttpServletResponse response, @Valid Supplier supplier) throws Exception {
        ResponsesDTO responsesDTO = new ResponsesDTO(ReturnCode.ACTIVE_SUCCESS);
        User user = super.getCurrentUser(request);
        if (null == user) {
            responsesDTO.setCode(1011);
            return responsesDTO;
        }
        if (null == supplier.getId()) {
            supplier.setType(1);
            supplier.setState(1);
            Long sid = supplierService.applySupplier(supplier);
            user.setSupplierId(sid);
            userService.updateUserInfo(user);
            responsesDTO.setData(user);
            setCookieRedis(response, user, responsesDTO);
        } else {
            supplierService.updateSupplier(supplier);
        }
        return responsesDTO;
    }
}
