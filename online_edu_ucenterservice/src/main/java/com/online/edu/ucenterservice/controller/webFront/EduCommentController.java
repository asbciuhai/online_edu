package com.online.edu.ucenterservice.controller.webFront;


import com.online.edu.common.VO.ResultVO;
import com.online.edu.common.utils.ResultVOUtil;
import com.online.edu.ucenterservice.pojo.EduComment;
import com.online.edu.ucenterservice.pojo.EduMember;
import com.online.edu.ucenterservice.service.EduCommentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 文章 前端控制器
 * </p>
 *
 * @author 许JIAN林
 * @since 2021-05-12
 */
@RestController
@RequestMapping("/ucenter/educomment")
@CrossOrigin
public class EduCommentController {

    @Autowired
    EduCommentService eduCommentService;

    @ApiOperation("发表评论")
    @PostMapping("")
    //axios post提交是以json,所以无法用（@RequestParam 获取值，目前只知道用Map接收）
    public ResultVO MemberLogin(@RequestBody(required = false) Map map) {

        String memberId = map.get("memberId").toString();
        String content = map.get("content").toString();
        String articleId = map.get("articleId").toString();
        System.out.println(memberId + content+articleId);
        boolean flag = eduCommentService.saveComment(articleId,memberId,content);
        return ResultVOUtil.success();
    }

}

