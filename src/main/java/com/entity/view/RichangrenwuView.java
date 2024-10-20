package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.RichangrenwuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 日常任务
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("richangrenwu")
public class RichangrenwuView extends RichangrenwuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 日常任务类型的值
	*/
	@ColumnInfo(comment="日常任务类型的字典表值",type="varchar(200)")
	private String richangrenwuValue;




	public RichangrenwuView() {

	}

	public RichangrenwuView(RichangrenwuEntity richangrenwuEntity) {
		try {
			BeanUtils.copyProperties(this, richangrenwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 日常任务类型的值
	*/
	public String getRichangrenwuValue() {
		return richangrenwuValue;
	}
	/**
	* 设置： 日常任务类型的值
	*/
	public void setRichangrenwuValue(String richangrenwuValue) {
		this.richangrenwuValue = richangrenwuValue;
	}




	@Override
	public String toString() {
		return "RichangrenwuView{" +
			", richangrenwuValue=" + richangrenwuValue +
			"} " + super.toString();
	}
}
