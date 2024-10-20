package com.dao;

import com.entity.BijiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BijiView;

/**
 * 笔记广场 Dao 接口
 *
 * @author 
 */
public interface BijiDao extends BaseMapper<BijiEntity> {

   List<BijiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
