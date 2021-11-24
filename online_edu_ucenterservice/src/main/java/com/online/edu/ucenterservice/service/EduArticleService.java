package com.online.edu.ucenterservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online.edu.ucenterservice.pojo.EduArticle;
import com.baomidou.mybatisplus.extension.service.IService;
import com.online.edu.ucenterservice.pojo.EduArticleVO;

import java.util.Map;

/**
 * <p>
 * 文章 服务类
 * </p>
 *
 * @author 许JIAN林
 * @since 2021-05-12
 */
public interface EduArticleService extends IService<EduArticle> {

    Map<String, Object> pageQueryWeb(Page<EduArticle> pageParam);

    EduArticleVO getArticleById(String id);
}
