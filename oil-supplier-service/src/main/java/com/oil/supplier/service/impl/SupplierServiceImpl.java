package com.oil.supplier.service.impl;

import com.oil.supplier.domain.Supplier;
import com.oil.supplier.manager.SupplierManager;
import com.oil.supplier.service.SupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-16
 * Time: 下午3:45
 * To change this template use File | Settings | File Templates.
 */
@Service
public class SupplierServiceImpl implements SupplierService {

    private static final Logger log = LoggerFactory.getLogger(SupplierServiceImpl.class);

    @Autowired
    private SupplierManager supplierManager;

    @Override
    public Long applySupplier(Supplier supplier) {
       return supplierManager.createSupplier(supplier);
    }

    @Override
    public Supplier getSupplierById(Long id) {
        return supplierManager.findById(id);
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        supplierManager.updateSupplier(supplier);
    }

}
