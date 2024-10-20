package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.RichangrenwuLingquEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 领取任务
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("richangrenwu_lingqu")
public class RichangrenwuLingquView extends RichangrenwuLingquEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 任务状态的值
	*/
	@ColumnInfo(comment="任务状态的字典表值",type="varchar(200)")
	private String richangrenwuLingquValue;
	/**
	* 审核状态的值
	*/
	@ColumnInfo(comment="审核状态的字典表值",type="varchar(200)")
	private String richangrenwuLingquYesnoValue;

	//级联表 日常任务
		/**
		* 日常任务编号
		*/

		@ColumnInfo(comment="日常任务编号",type="varchar(200)")
		private String richangrenwuUuidNumber;
		/**
		* 日常任务标题
		*/

		@ColumnInfo(comment="日常任务标题",type="varchar(200)")
		private String richangrenwuName;
		/**
		* 日常任务类型
		*/
		@ColumnInfo(comment="日常任务类型",type="int(11)")
		private Integer richangrenwuTypes;
			/**
			* 日常任务类型的值
			*/
			@ColumnInfo(comment="日常任务类型的字典表值",type="varchar(200)")
			private String richangrenwuValue;
		/**
		* 任务积分
		*/
		@ColumnInfo(comment="任务积分",type="decimal(10,2)")
		private Double richangrenwuJifen;
		/**
		* 任务内容
		*/

		@ColumnInfo(comment="任务内容",type="longtext")
		private String richangrenwuContent;
		/**
		* 完成标准
		*/

		@ColumnInfo(comment="完成标准",type="longtext")
		private String richangrenwuWanchengContent;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 积分
		*/
		@ColumnInfo(comment="积分",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 用户介绍
		*/

		@ColumnInfo(comment="用户介绍",type="longtext")
		private String yonghuContent;
		/**
		* 账户状态
		*/
		@ColumnInfo(comment="账户状态",type="int(11)")
		private Integer jinyongTypes;
			/**
			* 账户状态的值
			*/
			@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
			private String jinyongValue;



	public RichangrenwuLingquView() {

	}

	public RichangrenwuLingquView(RichangrenwuLingquEntity richangrenwuLingquEntity) {
		try {
			BeanUtils.copyProperties(this, richangrenwuLingquEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 任务状态的值
	*/
	public String getRichangrenwuLingquValue() {
		return richangrenwuLingquValue;
	}
	/**
	* 设置： 任务状态的值
	*/
	public void setRichangrenwuLingquValue(String richangrenwuLingquValue) {
		this.richangrenwuLingquValue = richangrenwuLingquValue;
	}
	//当前表的
	/**
	* 获取： 审核状态的值
	*/
	public String getRichangrenwuLingquYesnoValue() {
		return richangrenwuLingquYesnoValue;
	}
	/**
	* 设置： 审核状态的值
	*/
	public void setRichangrenwuLingquYesnoValue(String richangrenwuLingquYesnoValue) {
		this.richangrenwuLingquYesnoValue = richangrenwuLingquYesnoValue;
	}


	//级联表的get和set 日常任务

		/**
		* 获取： 日常任务编号
		*/
		public String getRichangrenwuUuidNumber() {
			return richangrenwuUuidNumber;
		}
		/**
		* 设置： 日常任务编号
		*/
		public void setRichangrenwuUuidNumber(String richangrenwuUuidNumber) {
			this.richangrenwuUuidNumber = richangrenwuUuidNumber;
		}

		/**
		* 获取： 日常任务标题
		*/
		public String getRichangrenwuName() {
			return richangrenwuName;
		}
		/**
		* 设置： 日常任务标题
		*/
		public void setRichangrenwuName(String richangrenwuName) {
			this.richangrenwuName = richangrenwuName;
		}
		/**
		* 获取： 日常任务类型
		*/
		public Integer getRichangrenwuTypes() {
			return richangrenwuTypes;
		}
		/**
		* 设置： 日常任务类型
		*/
		public void setRichangrenwuTypes(Integer richangrenwuTypes) {
			this.richangrenwuTypes = richangrenwuTypes;
		}


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

		/**
		* 获取： 任务积分
		*/
		public Double getRichangrenwuJifen() {
			return richangrenwuJifen;
		}
		/**
		* 设置： 任务积分
		*/
		public void setRichangrenwuJifen(Double richangrenwuJifen) {
			this.richangrenwuJifen = richangrenwuJifen;
		}

		/**
		* 获取： 任务内容
		*/
		public String getRichangrenwuContent() {
			return richangrenwuContent;
		}
		/**
		* 设置： 任务内容
		*/
		public void setRichangrenwuContent(String richangrenwuContent) {
			this.richangrenwuContent = richangrenwuContent;
		}

		/**
		* 获取： 完成标准
		*/
		public String getRichangrenwuWanchengContent() {
			return richangrenwuWanchengContent;
		}
		/**
		* 设置： 完成标准
		*/
		public void setRichangrenwuWanchengContent(String richangrenwuWanchengContent) {
			this.richangrenwuWanchengContent = richangrenwuWanchengContent;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 积分
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 积分
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}

		/**
		* 获取： 用户介绍
		*/
		public String getYonghuContent() {
			return yonghuContent;
		}
		/**
		* 设置： 用户介绍
		*/
		public void setYonghuContent(String yonghuContent) {
			this.yonghuContent = yonghuContent;
		}
		/**
		* 获取： 账户状态
		*/
		public Integer getJinyongTypes() {
			return jinyongTypes;
		}
		/**
		* 设置： 账户状态
		*/
		public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
		}


			/**
			* 获取： 账户状态的值
			*/
			public String getJinyongValue() {
				return jinyongValue;
			}
			/**
			* 设置： 账户状态的值
			*/
			public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
			}


	@Override
	public String toString() {
		return "RichangrenwuLingquView{" +
			", richangrenwuLingquValue=" + richangrenwuLingquValue +
			", richangrenwuLingquYesnoValue=" + richangrenwuLingquYesnoValue +
			", richangrenwuUuidNumber=" + richangrenwuUuidNumber +
			", richangrenwuName=" + richangrenwuName +
			", richangrenwuJifen=" + richangrenwuJifen +
			", richangrenwuContent=" + richangrenwuContent +
			", richangrenwuWanchengContent=" + richangrenwuWanchengContent +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", yonghuContent=" + yonghuContent +
			"} " + super.toString();
	}
}
