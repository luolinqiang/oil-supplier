package com.oil.supplier.manager.impl;

import com.jd.common.manager.BaseManager;
import com.oil.supplier.dao.SupplierDao;
import com.oil.supplier.domain.Supplier;
import com.oil.supplier.manager.SupplierManager;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-16
 * Time: 下午3:48
 * To change this template use File | Settings | File Templates.
 */
@Service
public class SupplierManagerImpl extends BaseManager implements SupplierManager {

    private final static Logger logger = LoggerFactory.getLogger(SupplierManagerImpl.class);
    @Autowired
    private SupplierDao supplierDao;

    @Override
    public Long createSupplier(Supplier supplier) throws RuntimeException {
        Validate.notNull(supplier.getCompanyName(),"公司名称为空！");
        return supplierDao.insert(supplier);
    }

    @Override
    public Supplier findById(Long id) throws RuntimeException {
        if(null == id)
            return null;

        Supplier supplier = supplierDao.getById(id);
        return supplier;
    }

    @Override
    public void updateSupplier(Supplier supplier) throws RuntimeException {
        Validate.notNull(supplier.getId(),"supplier id 为空！");
        supplierDao.update(supplier);
    }
}
