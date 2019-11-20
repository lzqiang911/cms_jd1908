package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.CategoryExample;
import com.briup.apps.cms.dao.CategoryMapper;
import com.briup.apps.cms.service.ICategoryService;
import com.briup.apps.cms.utils.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService{

	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public List<Category> findAll() {

		return categoryMapper.selectByExample(new CategoryExample());
	}

	@Override
	public void saveOrUpdate(Category category) throws CustomerException {
		if(category.getId() != null) {
			categoryMapper.updateByPrimaryKey(category);
		}else {
			CategoryExample example = new CategoryExample();
			example.createCriteria().andNameEqualTo(category.getName());
			List<Category> list = categoryMapper.selectByExample(example);
			if(list.size() > 0) {
				throw new CustomerException("栏目名不能重复");
			}
			categoryMapper.insert(category);
		}
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		Category category = categoryMapper.selectByPrimaryKey(id);
		if(category == null) {
			throw new CustomerException("栏目不存在");
		}
		categoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void batchDelete(long[] ids) throws CustomerException {
		for (long id : ids) {
			this.deleteById(id);
		}
	}

}
