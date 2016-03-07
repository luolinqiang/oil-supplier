package com.oil.supplier.dao.impl;

import com.oil.supplier.dao.PicDao;
import com.oil.supplier.domain.Pic;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: guowenjuan
 * Date: 16-1-14
 * Time: 上午9:35
 * To change this template use File | Settings | File Templates.
 */
@Repository("picDao")
public class PicDaoImpl implements PicDao {

    @Autowired
    @Qualifier("sqlSession")
    org.mybatis.spring.SqlSessionTemplate template;

    public Long insert(Pic pic) {
        template.insert("com.oil.supplier.dao.PicDao.insert", pic);
        return pic.getId();
    }

    public boolean update(Pic pic) {
        Validate.notNull(pic.getId(), "the id column is null");
        template.update("com.oil.supplier.dao.PicDao.update", pic);
        return true;
    }

    public Pic getById(Long id) {
        Validate.notNull(id, "the id is null");
        return (Pic)template.selectOne("com.oil.supplier.dao.PicDao.getById", id);
    }

    @SuppressWarnings("unchecked")
    public List<Pic> getList(Pic pic) {
        return (List<Pic>) template.selectList("com.oil.supplier.dao.PicDao.getList", pic);
    }

}
