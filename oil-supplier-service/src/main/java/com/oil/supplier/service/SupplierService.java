package com.oil.supplier.service;

import com.oil.supplier.domain.Supplier;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-16
 * Time: 下午3:44
 * To change this template use File | Settings | File Templates.
 */
public interface SupplierService {

    Long applySupplier(Supplier supplier);

    Supplier getSupplierById(Long id);

    void updateSupplier(Supplier supplier);
}
