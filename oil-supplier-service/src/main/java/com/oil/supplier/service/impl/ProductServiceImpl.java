package com.oil.supplier.service.impl;

import com.oil.supplier.common.CommonConstants;
import com.oil.supplier.common.util.ValidateUtils;
import com.oil.supplier.domain.Product;
import com.oil.supplier.manager.ProductManager;
import com.oil.supplier.service.ProductService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: guowenjuan
 * Date: 16-1-14
 * Time: 下午3:01
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductManager productManager;

    @Override
    public  Long issueProduct(Product product) {
        return productManager.addProduct(product);
    }

    @Override
    public List<Product> getProduct(Product product) {
        return productManager.findProducts(product);
    }

}
