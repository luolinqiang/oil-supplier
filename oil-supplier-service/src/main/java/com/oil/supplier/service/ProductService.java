package com.oil.supplier.service;


import com.oil.supplier.domain.Product;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: guowenjuan
 * Date: 16-1-14
 * Time: 下午3:00
 * To change this template use File | Settings | File Templates.
 */
public interface ProductService {

    Long issueProduct(Product product);

    List<Product> getProduct(Product product);
}
