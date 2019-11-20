package com.briup.apps.cms.service;


import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.utils.CustomerException;

import java.util.List;

public interface IArticleService {
	
	//
	List<Article> findAll();
	//级联查询，查询文章时查询出栏目
	List<ArticleExtend> cascadeFindAll();
	//查询文章时查询出评论内容
	ArticleExtend findById(long id);
	
	void saveOrUpdate(Article article) throws CustomerException;
	//删除
	void deleteById(long id) throws CustomerException;
	
}
