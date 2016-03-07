package com.oil.supplier.manager.impl;

import com.jd.common.manager.BaseManager;
import com.oil.supplier.dao.DictionaryDao;
import com.oil.supplier.domain.Dictionary;
import com.oil.supplier.manager.DictionaryManager;
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
public class DictionaryManagerImpl extends BaseManager implements DictionaryManager {

    private final static Logger logger = LoggerFactory.getLogger(DictionaryManagerImpl.class);
    @Autowired
    private DictionaryDao dictionaryDao;

    public List<Dictionary> findDictionary(Dictionary dic) throws RuntimeException {
        return  dictionaryDao.getList(dic);
    }
}
