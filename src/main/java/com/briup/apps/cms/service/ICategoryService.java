package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.utils.CustomerException;

public interface ICategoryService {

	//查询所有
	List<Category> findAll();
	//保存或更新
	void saveOrUpdate(Category category) throws CustomerException;
	//通过id删除
	void deleteById(long id)throws CustomerException;
	//批量删除
	void batchDelete(long[] ids)throws CustomerException;
}
