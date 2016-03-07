package com.oil.supplier.manager;

import com.oil.supplier.domain.Product;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-16
 * Time: 下午3:47
 * To change this template use File | Settings | File Templates.
 */
public interface ProductManager {

    Long addProduct(Product product) throws RuntimeException;

    List<Product> findProducts(Product product) throws RuntimeException;
}
