package com.online.edu.ucenterservice.service.impl;

import com.online.edu.ucenterservice.mapper.EduMemberMapper;
import com.online.edu.ucenterservice.pojo.EduComment;
import com.online.edu.ucenterservice.mapper.EduCommentMapper;
import com.online.edu.ucenterservice.pojo.EduMember;
import com.online.edu.ucenterservice.service.EduCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章 服务实现类
 * </p>
 *
 * @author 许JIAN林
 * @since 2021-05-12
 */
@Service
public class EduCommentServiceImpl extends ServiceImpl<EduCommentMapper, EduComment> implements EduCommentService {

    @Autowired
    EduMemberMapper eduMemberMapper;


    @Override
    public boolean saveComment(String articleId, String memberId, String content) {
        EduMember eduMember = eduMemberMapper.selectById(memberId);
        EduComment eduComment = new EduComment();
        eduComment.setAuthor(eduMember.getNickname());
        eduComment.setAvatar(eduMember.getAvatar());
        eduComment.setParentId(articleId);
        eduComment.setReplyCount(0);
        eduComment.setContent(content);
        eduComment.setUserId(eduMember.getId());
        int insert = baseMapper.insert(eduComment);
        return insert>0;
    }
}
