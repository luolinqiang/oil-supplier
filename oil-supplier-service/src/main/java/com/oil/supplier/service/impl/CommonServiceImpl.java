package com.oil.supplier.service.impl;

import com.oil.supplier.domain.Area;
import com.oil.supplier.domain.Dictionary;
import com.oil.supplier.manager.AreaManager;
import com.oil.supplier.manager.DictionaryManager;
import com.oil.supplier.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-19
 * Time: 下午1:00
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CommonServiceImpl implements CommonService {

    private static final Logger log = LoggerFactory.getLogger(CommonServiceImpl.class);

    @Autowired
    private AreaManager areaManager;

    @Autowired
    private DictionaryManager dictionaryManager;

    @Override
    public List<Area> getChildrenByAreaId(Long pid) {

        return areaManager.findChildrenByPid(pid);

    }

    @Override
    public List<Dictionary> getDictionary(Dictionary dic) {
        return dictionaryManager.findDictionary(dic);
    }

}
