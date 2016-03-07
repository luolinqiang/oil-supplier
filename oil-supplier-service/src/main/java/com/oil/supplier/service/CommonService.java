package com.oil.supplier.service;

import com.oil.supplier.domain.Area;
import com.oil.supplier.domain.Dictionary;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-19
 * Time: 下午1:00
 * To change this template use File | Settings | File Templates.
 */
public interface CommonService {

    List<Area> getChildrenByAreaId(Long pid);

    List<Dictionary> getDictionary(Dictionary dic);
}
