package com.online.edu.ucenterservice.service;

import com.online.edu.ucenterservice.pojo.EduComment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 文章 服务类
 * </p>
 *
 * @author 许JIAN林
 * @since 2021-05-12
 */
public interface EduCommentService extends IService<EduComment> {

    boolean saveComment(String articleId,String memberId, String content);
}
