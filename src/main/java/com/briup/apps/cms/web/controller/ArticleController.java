package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Program: cms
 * @author lzqiang
 * @Description: 文章控制器类
 * @DateTime: 2019年11月13日
 */

@Api("文章相关接口")
@RestController
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private IArticleService articleService;
	
	@GetMapping("findAll")
	public Message findAll(){
		List<Article> list = articleService.findAll();
		return MessageUtil.success(list);
	}
	
	@GetMapping("cascadeFindAll")
	public Message cascadeFindAll(){
		List<ArticleExtend> list = articleService.cascadeFindAll();
		return MessageUtil.success(list);
	}

	@GetMapping("findById")
	public Message findById(long id){
		ArticleExtend articleExtend = articleService.findById(id);
		return MessageUtil.success(articleExtend);
	}
	
	@ApiOperation(value = "保存或更新")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "编号",required = false,paramType = "from",dataType = "Long"),
			@ApiImplicitParam(name = "title",value = "标题",required = true,paramType = "from"),
			@ApiImplicitParam(name = "content",value = "内容",required = true,paramType = "from"),
			@ApiImplicitParam(name = "source",value = "源内容",required = true,paramType = "from"),
			@ApiImplicitParam(name = "authorId",value = "作者id",required = true,paramType = "from",dataType = "Long"),
			@ApiImplicitParam(name = "categoryId",value = "栏目id",required = true,paramType = "from",dataType = "Long")
	})
	@PostMapping("saveOrUpdate")
	public Message saveOrUpdate(
			Long id,
			String title,
			String content,
			String source,
			Long authorId,
			Long categoryId) {
		
		Article article = new Article();
		article.setId(id);
		article.setTitle(title);
		article.setContent(content);
		article.setSource(source);
		article.setAuthorId(authorId);
		article.setCategoryId(categoryId);
		
		articleService.saveOrUpdate(article);
		return MessageUtil.success("更新成功");
		
	}
	
	@ApiOperation("通过id删除数据")
	@ApiImplicitParams(
		@ApiImplicitParam(name = "id",value = "编号",required = true,paramType = "query")
	)
	@GetMapping("deleteById")
	public Message deleteById(Long id) {
		articleService.deleteById(id);
		return MessageUtil.success("删除成功");
	}
	
	
	
}
