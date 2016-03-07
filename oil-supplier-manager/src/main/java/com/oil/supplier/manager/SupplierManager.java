package com.oil.supplier.manager;

import com.oil.supplier.domain.Supplier;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-16
 * Time: 下午3:47
 * To change this template use File | Settings | File Templates.
 */
public interface SupplierManager {

    Long createSupplier(Supplier supplier) throws RuntimeException;

    Supplier findById(Long id) throws RuntimeException;

    void updateSupplier(Supplier supplier) throws RuntimeException;
}
