package com.oil.supplier.manager;

import com.oil.supplier.domain.Dictionary;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-19
 * Time: 下午12:54
 * To change this template use File | Settings | File Templates.
 */
public interface DictionaryManager {

    public List<Dictionary> findDictionary(Dictionary dic) throws RuntimeException;
}
