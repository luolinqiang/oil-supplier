package com.oil.supplier.dao.impl;

import com.oil.supplier.dao.AreaDao;
import com.oil.supplier.domain.Area;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-19
 * Time: 下午12:32
 * To change this template use File | Settings | File Templates.
 */
@Repository("areaDao")
public class AreaDaoImpl implements AreaDao {

    @Autowired
    @Qualifier("sqlSession")
    org.mybatis.spring.SqlSessionTemplate template;

    public Long insert(Area area) {
        template.insert("com.oil.supplier.dao.AreaDao.insert", area);
        return area.getId();
    }

    public boolean update(Area area) {
        Validate.notNull(area.getId(), "the id column is null");
        template.update("com.oil.supplier.dao.AreaDao.update", area);
        return true;
    }

    public Area getById(Long id) {
        Validate.notNull(id, "the id is null");
        return (Area)template.selectOne("com.oil.supplier.dao.AreaDao.getById", id);
    }

    @SuppressWarnings("unchecked")
    public List<Area> getList(Area area) {
        return (List<Area>) template.selectList("com.oil.supplier.dao.AreaDao.getList", area);
    }

    public List<Area> getListByPid(Long pid) {
        Validate.notNull(pid, "the pid is null");
        Area area = new Area();
        area.setPid(pid);
        return (List<Area>) template.selectList("com.oil.supplier.dao.AreaDao.getList", area);
    }
}
