package com.dao;

import com.entity.RichangrenwuLingquEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.RichangrenwuLingquView;

/**
 * 领取任务 Dao 接口
 *
 * @author 
 */
public interface RichangrenwuLingquDao extends BaseMapper<RichangrenwuLingquEntity> {

   List<RichangrenwuLingquView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
