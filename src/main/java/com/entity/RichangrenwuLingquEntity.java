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
 * 领取任务
 *
 * @author 
 * @email
 */
@TableName("richangrenwu_lingqu")
public class RichangrenwuLingquEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public RichangrenwuLingquEntity() {

	}

	public RichangrenwuLingquEntity(T t) {
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
     * 日常任务
     */
    @ColumnInfo(comment="日常任务",type="int(11)")
    @TableField(value = "richangrenwu_id")

    private Integer richangrenwuId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 领取任务编号
     */
    @ColumnInfo(comment="领取任务编号",type="varchar(200)")
    @TableField(value = "richangrenwu_lingqu_uuid_number")

    private String richangrenwuLingquUuidNumber;


    /**
     * 所属日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="所属日期",type="date")
    @TableField(value = "richangrenwu_lingqu_time")

    private Date richangrenwuLingquTime;


    /**
     * 领取时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="领取时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 任务状态
     */
    @ColumnInfo(comment="任务状态",type="int(11)")
    @TableField(value = "richangrenwu_lingqu_types")

    private Integer richangrenwuLingquTypes;


    /**
     * 审核状态
     */
    @ColumnInfo(comment="审核状态",type="int(11)")
    @TableField(value = "richangrenwu_lingqu_yesno_types")

    private Integer richangrenwuLingquYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "richangrenwu_lingqu_yesno_text")

    private String richangrenwuLingquYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "richangrenwu_lingqu_shenhe_time")

    private Date richangrenwuLingquShenheTime;


    /**
     * 创建时间    listShow
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
	 * 获取：日常任务
	 */
    public Integer getRichangrenwuId() {
        return richangrenwuId;
    }
    /**
	 * 设置：日常任务
	 */

    public void setRichangrenwuId(Integer richangrenwuId) {
        this.richangrenwuId = richangrenwuId;
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
	 * 获取：领取任务编号
	 */
    public String getRichangrenwuLingquUuidNumber() {
        return richangrenwuLingquUuidNumber;
    }
    /**
	 * 设置：领取任务编号
	 */

    public void setRichangrenwuLingquUuidNumber(String richangrenwuLingquUuidNumber) {
        this.richangrenwuLingquUuidNumber = richangrenwuLingquUuidNumber;
    }
    /**
	 * 获取：所属日期
	 */
    public Date getRichangrenwuLingquTime() {
        return richangrenwuLingquTime;
    }
    /**
	 * 设置：所属日期
	 */

    public void setRichangrenwuLingquTime(Date richangrenwuLingquTime) {
        this.richangrenwuLingquTime = richangrenwuLingquTime;
    }
    /**
	 * 获取：领取时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：领取时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：任务状态
	 */
    public Integer getRichangrenwuLingquTypes() {
        return richangrenwuLingquTypes;
    }
    /**
	 * 设置：任务状态
	 */

    public void setRichangrenwuLingquTypes(Integer richangrenwuLingquTypes) {
        this.richangrenwuLingquTypes = richangrenwuLingquTypes;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getRichangrenwuLingquYesnoTypes() {
        return richangrenwuLingquYesnoTypes;
    }
    /**
	 * 设置：审核状态
	 */

    public void setRichangrenwuLingquYesnoTypes(Integer richangrenwuLingquYesnoTypes) {
        this.richangrenwuLingquYesnoTypes = richangrenwuLingquYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getRichangrenwuLingquYesnoText() {
        return richangrenwuLingquYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setRichangrenwuLingquYesnoText(String richangrenwuLingquYesnoText) {
        this.richangrenwuLingquYesnoText = richangrenwuLingquYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getRichangrenwuLingquShenheTime() {
        return richangrenwuLingquShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setRichangrenwuLingquShenheTime(Date richangrenwuLingquShenheTime) {
        this.richangrenwuLingquShenheTime = richangrenwuLingquShenheTime;
    }
    /**
	 * 获取：创建时间    listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间    listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "RichangrenwuLingqu{" +
            ", id=" + id +
            ", richangrenwuId=" + richangrenwuId +
            ", yonghuId=" + yonghuId +
            ", richangrenwuLingquUuidNumber=" + richangrenwuLingquUuidNumber +
            ", richangrenwuLingquTime=" + DateUtil.convertString(richangrenwuLingquTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", richangrenwuLingquTypes=" + richangrenwuLingquTypes +
            ", richangrenwuLingquYesnoTypes=" + richangrenwuLingquYesnoTypes +
            ", richangrenwuLingquYesnoText=" + richangrenwuLingquYesnoText +
            ", richangrenwuLingquShenheTime=" + DateUtil.convertString(richangrenwuLingquShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
