package com.oil.supplier.manager.impl;

import com.jd.common.manager.BaseManager;
import com.oil.supplier.dao.AreaDao;
import com.oil.supplier.domain.Area;
import com.oil.supplier.manager.AreaManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-19
 * Time: 下午12:56
 * To change this template use File | Settings | File Templates.
 */
@Service
public class AreaManagerImpl extends BaseManager implements AreaManager {

    private final static Logger logger = LoggerFactory.getLogger(AreaManagerImpl.class);
    @Autowired
    private AreaDao areaDao;

    public List<Area> findChildrenByPid(Long pid) throws RuntimeException {
        return  areaDao.getListByPid(pid);
    }
}
