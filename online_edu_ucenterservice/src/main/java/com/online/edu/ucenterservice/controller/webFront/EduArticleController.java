package com.online.edu.ucenterservice.controller.webFront;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online.edu.common.VO.ResultVO;
import com.online.edu.common.enums.ResultEnum;
import com.online.edu.common.utils.ResultVOUtil;
import com.online.edu.ucenterservice.pojo.EduArticle;
import com.online.edu.ucenterservice.pojo.EduArticleVO;
import com.online.edu.ucenterservice.pojo.EduMember;
import com.online.edu.ucenterservice.service.EduArticleService;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
@RequestMapping("/ucenter/eduarticle")
@CrossOrigin
@Slf4j
public class EduArticleController {

    @Autowired
    private EduArticleService eduArticleService;



    @ResponseBody
    @ApiOperation("添加新文章")
    @PostMapping("article")
    public ResultVO addArticle(@RequestBody(required = false) EduArticle eduArticle){

        boolean save = eduArticleService.save(eduArticle);
        if (save){
            return ResultVOUtil.success();
        }else{
            return ResultVOUtil.error(20001,"网络异常");
        }


    }

    @ApiOperation("根据文章id查询文章")
    @GetMapping("{articleId}")
    public ResultVO getArticleById(@PathVariable String articleId){
        System.out.println(articleId);
        EduArticleVO eduArticleVO = eduArticleService.getArticleById(articleId);

        return ResultVOUtil.success(eduArticleVO);
    }


    @ApiOperation("前台分页查询文章列表")
    @GetMapping("{page}/{limit}")
    public ResultVO getPageListArticle(@PathVariable Long page, @PathVariable Long limit){

        Page<EduArticle> pageParam = new Page<EduArticle>(page, limit);

        log.info("【前台操作】查询讲师列表，第"+page+"页，每页"+limit+"条记录");
        Map<String, Object> map = eduArticleService.pageQueryWeb(pageParam);

        return ResultVOUtil.success(map);
    }

}

