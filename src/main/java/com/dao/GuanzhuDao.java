package com.dao;

import com.entity.GuanzhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GuanzhuView;

/**
 * 我的关注 Dao 接口
 *
 * @author 
 */
public interface GuanzhuDao extends BaseMapper<GuanzhuEntity> {

   List<GuanzhuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
