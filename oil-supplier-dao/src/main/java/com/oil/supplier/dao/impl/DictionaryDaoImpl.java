package com.oil.supplier.dao.impl;

import com.oil.supplier.dao.DictionaryDao;
import com.oil.supplier.domain.Dictionary;
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
@Repository("dictionaryDao")
public class DictionaryDaoImpl implements DictionaryDao {

    @Autowired
    @Qualifier("sqlSession")
    org.mybatis.spring.SqlSessionTemplate template;

    public Long insert(Dictionary dic) {
        template.insert("com.oil.supplier.dao.DictionaryDao.insert", dic);
        return dic.getId();
    }

    public boolean update(Dictionary dic) {
        Validate.notNull(dic.getId(), "the id column is null");
        template.update("com.oil.supplier.dao.DictionaryDao.update", dic);
        return true;
    }

    public Dictionary getById(Long id) {
        Validate.notNull(id, "the id is null");
        return (Dictionary)template.selectOne("com.oil.supplier.dao.DictionaryDao.getById", id);
    }

    @SuppressWarnings("unchecked")
    public List<Dictionary> getList(Dictionary dic) {
        return (List<Dictionary>) template.selectList("com.oil.supplier.dao.DictionaryDao.getList", dic);
    }

}
