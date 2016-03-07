package com.oil.supplier.dao;

import com.oil.supplier.domain.Area;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-19
 * Time: 下午12:03
 * To change this template use File | Settings | File Templates.
 */
public interface AreaDao extends AbstractDao<Area> {

    public List<Area> getListByPid(Long pid);


}
