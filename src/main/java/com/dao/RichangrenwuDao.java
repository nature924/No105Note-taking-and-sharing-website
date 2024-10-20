package com.dao;

import com.entity.RichangrenwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.RichangrenwuView;

/**
 * 日常任务 Dao 接口
 *
 * @author 
 */
public interface RichangrenwuDao extends BaseMapper<RichangrenwuEntity> {

   List<RichangrenwuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
