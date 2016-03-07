package com.oil.supplier.manager.impl;

import com.jd.common.manager.BaseManager;
import com.oil.supplier.dao.ProductDao;
import com.oil.supplier.domain.Product;
import com.oil.supplier.manager.ProductManager;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-4
 * Time: 下午8:11
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ProductManagerImpl extends BaseManager implements ProductManager {

    private final static Logger logger = LoggerFactory.getLogger(ProductManagerImpl.class);
    @Autowired
    private ProductDao productDao;

    @Override
    public Long addProduct(Product product) throws RuntimeException {
        Validate.notNull(product.getName(), "商品名称为空！");
        return productDao.insert(product);
    }

    @Override
    public List<Product> findProducts(Product product) throws RuntimeException {
        Validate.notNull(product, "查询商品为空！");
        return productDao.getList(product);
    }

}
