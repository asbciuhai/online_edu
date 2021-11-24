package com.online.edu.ucenterservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online.edu.ucenterservice.mapper.EduCommentMapper;
import com.online.edu.ucenterservice.pojo.EduArticle;
import com.online.edu.ucenterservice.mapper.EduArticleMapper;
import com.online.edu.ucenterservice.pojo.EduArticleVO;
import com.online.edu.ucenterservice.pojo.EduComment;
import com.online.edu.ucenterservice.service.EduArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文章 服务实现类
 * </p>
 *
 * @author 许JIAN林
 * @since 2021-05-12
 */
@Service
public class EduArticleServiceImpl extends ServiceImpl<EduArticleMapper, EduArticle> implements EduArticleService {

    @Autowired
    EduCommentMapper eduCommentMapper;


    @Override
    public Map<String, Object> pageQueryWeb(Page<EduArticle> pageParam) {
        //分页查询后的结果
        baseMapper.selectPage(pageParam, null);

        //文章列表
        List<EduArticle> records = pageParam.getRecords();
        //总记录数
        long total = pageParam.getTotal();
        //页面记录数大小
        long size = pageParam.getSize();
        //当前页
        long current = pageParam.getCurrent();
        //总页数
        long pages = pageParam.getPages();
        //是否有下一页
        boolean hasNext = pageParam.hasNext();
        //是否有上一页
        boolean hasPrevious = pageParam.hasPrevious();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("items", records);
        map.put("total", total);
        map.put("size", size);
        map.put("current", current);
        map.put("pages",pages);
        map.put("hasNext", hasNext);
        map.put("hasPrevious",hasPrevious);

        return map;
    }

    @Override
    public EduArticleVO getArticleById(String id) {
        EduArticleVO eduArticleVO = new EduArticleVO();

        EduArticle eduArticle = baseMapper.selectById(id);

        QueryWrapper Wrapper = new QueryWrapper();
        Wrapper.eq("parent_id", id);
        List<EduComment> eduComments = eduCommentMapper.selectList(Wrapper);

        if (eduArticle!=null){
            BeanUtils.copyProperties(eduArticle,eduArticleVO);
        }

        eduArticleVO.setEduComments(eduComments);

        return eduArticleVO;
    }
}
