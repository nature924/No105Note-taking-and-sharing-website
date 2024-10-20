package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.BijiCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 笔记收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("biji_collection")
public class BijiCollectionView extends BijiCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String bijiCollectionValue;

	//级联表 笔记广场
					 
		/**
		* 笔记广场 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer bijiYonghuId;
		/**
		* 笔记名称
		*/

		@ColumnInfo(comment="笔记名称",type="varchar(200)")
		private String bijiName;
		/**
		* 笔记编号
		*/

		@ColumnInfo(comment="笔记编号",type="varchar(200)")
		private String bijiUuidNumber;
		/**
		* 笔记照片
		*/

		@ColumnInfo(comment="笔记照片",type="varchar(200)")
		private String bijiPhoto;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 笔记类型
		*/
		@ColumnInfo(comment="笔记类型",type="int(11)")
		private Integer bijiTypes;
			/**
			* 笔记类型的值
			*/
			@ColumnInfo(comment="笔记类型的字典表值",type="varchar(200)")
			private String bijiValue;
		/**
		* 笔记内容
		*/

		@ColumnInfo(comment="笔记内容",type="longtext")
		private String bijiContent;
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



	public BijiCollectionView() {

	}

	public BijiCollectionView(BijiCollectionEntity bijiCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, bijiCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getBijiCollectionValue() {
		return bijiCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setBijiCollectionValue(String bijiCollectionValue) {
		this.bijiCollectionValue = bijiCollectionValue;
	}


	//级联表的get和set 笔记广场
		/**
		* 获取：笔记广场 的 用户
		*/
		public Integer getBijiYonghuId() {
			return bijiYonghuId;
		}
		/**
		* 设置：笔记广场 的 用户
		*/
		public void setBijiYonghuId(Integer bijiYonghuId) {
			this.bijiYonghuId = bijiYonghuId;
		}

		/**
		* 获取： 笔记名称
		*/
		public String getBijiName() {
			return bijiName;
		}
		/**
		* 设置： 笔记名称
		*/
		public void setBijiName(String bijiName) {
			this.bijiName = bijiName;
		}

		/**
		* 获取： 笔记编号
		*/
		public String getBijiUuidNumber() {
			return bijiUuidNumber;
		}
		/**
		* 设置： 笔记编号
		*/
		public void setBijiUuidNumber(String bijiUuidNumber) {
			this.bijiUuidNumber = bijiUuidNumber;
		}

		/**
		* 获取： 笔记照片
		*/
		public String getBijiPhoto() {
			return bijiPhoto;
		}
		/**
		* 设置： 笔记照片
		*/
		public void setBijiPhoto(String bijiPhoto) {
			this.bijiPhoto = bijiPhoto;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}
		/**
		* 获取： 笔记类型
		*/
		public Integer getBijiTypes() {
			return bijiTypes;
		}
		/**
		* 设置： 笔记类型
		*/
		public void setBijiTypes(Integer bijiTypes) {
			this.bijiTypes = bijiTypes;
		}


			/**
			* 获取： 笔记类型的值
			*/
			public String getBijiValue() {
				return bijiValue;
			}
			/**
			* 设置： 笔记类型的值
			*/
			public void setBijiValue(String bijiValue) {
				this.bijiValue = bijiValue;
			}

		/**
		* 获取： 笔记内容
		*/
		public String getBijiContent() {
			return bijiContent;
		}
		/**
		* 设置： 笔记内容
		*/
		public void setBijiContent(String bijiContent) {
			this.bijiContent = bijiContent;
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
		return "BijiCollectionView{" +
			", bijiCollectionValue=" + bijiCollectionValue +
			", bijiName=" + bijiName +
			", bijiUuidNumber=" + bijiUuidNumber +
			", bijiPhoto=" + bijiPhoto +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", bijiContent=" + bijiContent +
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
