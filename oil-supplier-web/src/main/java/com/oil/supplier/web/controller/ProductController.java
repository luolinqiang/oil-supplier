package com.oil.supplier.web.controller;

import com.oil.supplier.common.ResponsesDTO;
import com.oil.supplier.common.ReturnCode;
import com.oil.supplier.domain.Product;
import com.oil.supplier.domain.User;
import com.oil.supplier.domain.vo.PageVo;
import com.oil.supplier.service.ProductService;
import com.oil.supplier.web.base.BaseControllor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-4
 * Time: 下午8:32
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ProductController extends BaseControllor {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    protected ProductService productService;


    @ResponseBody
    @RequestMapping(value = "/pro/getIssue", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=utf-8")
    public ResponsesDTO getIssue(HttpServletRequest request, HttpServletResponse response, @Valid Product product, PageVo pageVo) throws Exception {
        logger.debug("ProductController--->getIssue--->start");
        User user = super.getCurrentUser(request);
        if (null == user) return new ResponsesDTO(ReturnCode.ERROR_LOGIN_TIMEOUT);
        product.setSupplierId(user.getSupplierId());
        List<Product> products = productService.getProduct(product);
        ResponsesDTO responsesDTO = new ResponsesDTO(ReturnCode.ACTIVE_SUCCESS);
        responsesDTO.setData(products);
        return responsesDTO;
    }

    @ResponseBody
    @RequestMapping(value = "/pro/add", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=utf-8")
    public ResponsesDTO addProduct(HttpServletRequest request, HttpServletResponse response, @Valid Product product) throws Exception {
        logger.debug("ProductController--->add--->start");
        User user = super.getCurrentUser(request);
        if (null == user) return new ResponsesDTO(ReturnCode.ERROR_LOGIN_TIMEOUT);
        product.setSupplierId(user.getSupplierId());
        product.setState(1);
        Long pid = productService.issueProduct(product);
        ResponsesDTO responsesDTO = new ResponsesDTO(ReturnCode.ACTIVE_SUCCESS);
        if (null == pid) responsesDTO.setCode(1);
        return responsesDTO;
    }

}
