package com.oil.supplier.dao;

import java.util.List;

public interface AbstractDao<T> {

    /**
     * 插入一条对象记录
     * @param o
     * @return
     */
	public Long insert(T o);

    /**
     * 更新对象,对象的id值不能为空
     * @param o
     * @return
     */
	public boolean update(T o);

    /**
     * 根据id获得对象
     * @param id
     * @return
     */
	public T getById(Long id);
	/**
	 * 获得对象集合
	 * @return 对象集合
	 */
	public List<T> getList(T o);
}
