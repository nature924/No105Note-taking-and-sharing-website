package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 笔记广场
 *
 * @author 
 * @email
 */
@TableName("biji")
public class BijiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BijiEntity() {

	}

	public BijiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 笔记名称
     */
    @ColumnInfo(comment="笔记名称",type="varchar(200)")
    @TableField(value = "biji_name")

    private String bijiName;


    /**
     * 笔记编号
     */
    @ColumnInfo(comment="笔记编号",type="varchar(200)")
    @TableField(value = "biji_uuid_number")

    private String bijiUuidNumber;


    /**
     * 笔记照片
     */
    @ColumnInfo(comment="笔记照片",type="varchar(200)")
    @TableField(value = "biji_photo")

    private String bijiPhoto;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 笔记类型
     */
    @ColumnInfo(comment="笔记类型",type="int(11)")
    @TableField(value = "biji_types")

    private Integer bijiTypes;


    /**
     * 笔记内容
     */
    @ColumnInfo(comment="笔记内容",type="longtext")
    @TableField(value = "biji_content")

    private String bijiContent;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="发布时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：笔记名称
	 */
    public String getBijiName() {
        return bijiName;
    }
    /**
	 * 设置：笔记名称
	 */

    public void setBijiName(String bijiName) {
        this.bijiName = bijiName;
    }
    /**
	 * 获取：笔记编号
	 */
    public String getBijiUuidNumber() {
        return bijiUuidNumber;
    }
    /**
	 * 设置：笔记编号
	 */

    public void setBijiUuidNumber(String bijiUuidNumber) {
        this.bijiUuidNumber = bijiUuidNumber;
    }
    /**
	 * 获取：笔记照片
	 */
    public String getBijiPhoto() {
        return bijiPhoto;
    }
    /**
	 * 设置：笔记照片
	 */

    public void setBijiPhoto(String bijiPhoto) {
        this.bijiPhoto = bijiPhoto;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：笔记类型
	 */
    public Integer getBijiTypes() {
        return bijiTypes;
    }
    /**
	 * 设置：笔记类型
	 */

    public void setBijiTypes(Integer bijiTypes) {
        this.bijiTypes = bijiTypes;
    }
    /**
	 * 获取：笔记内容
	 */
    public String getBijiContent() {
        return bijiContent;
    }
    /**
	 * 设置：笔记内容
	 */

    public void setBijiContent(String bijiContent) {
        this.bijiContent = bijiContent;
    }
    /**
	 * 获取：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Biji{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", bijiName=" + bijiName +
            ", bijiUuidNumber=" + bijiUuidNumber +
            ", bijiPhoto=" + bijiPhoto +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", bijiTypes=" + bijiTypes +
            ", bijiContent=" + bijiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
