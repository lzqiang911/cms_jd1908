package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.Comment;

import java.util.List;

/**
 * @ProjectName: cms_jd1908
 * @Decription: 文章拓展类
 * @Author: lzqiang
 * @Created: 19.11.18 18:45
 */
public class ArticleExtend extends Article {
    public static final String STATUS_UNCHECK="未审核";
    public static final String STATUS_CHECK_PASS="审核通过";
    public static final String STATUS_CHECK_NOPASS="审核不通过";

    private Category category;
    private List<Comment> comments;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
