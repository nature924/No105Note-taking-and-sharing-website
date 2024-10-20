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
 * 日常任务
 *
 * @author 
 * @email
 */
@TableName("richangrenwu")
public class RichangrenwuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public RichangrenwuEntity() {

	}

	public RichangrenwuEntity(T t) {
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
     * 日常任务编号
     */
    @ColumnInfo(comment="日常任务编号",type="varchar(200)")
    @TableField(value = "richangrenwu_uuid_number")

    private String richangrenwuUuidNumber;


    /**
     * 日常任务标题
     */
    @ColumnInfo(comment="日常任务标题",type="varchar(200)")
    @TableField(value = "richangrenwu_name")

    private String richangrenwuName;


    /**
     * 日常任务类型
     */
    @ColumnInfo(comment="日常任务类型",type="int(11)")
    @TableField(value = "richangrenwu_types")

    private Integer richangrenwuTypes;


    /**
     * 任务积分
     */
    @ColumnInfo(comment="任务积分",type="decimal(10,2)")
    @TableField(value = "richangrenwu_jifen")

    private Double richangrenwuJifen;


    /**
     * 任务内容
     */
    @ColumnInfo(comment="任务内容",type="longtext")
    @TableField(value = "richangrenwu_content")

    private String richangrenwuContent;


    /**
     * 完成标准
     */
    @ColumnInfo(comment="完成标准",type="longtext")
    @TableField(value = "richangrenwu_wancheng_content")

    private String richangrenwuWanchengContent;


    /**
     * 创建时间   listShow
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
	 * 获取：日常任务编号
	 */
    public String getRichangrenwuUuidNumber() {
        return richangrenwuUuidNumber;
    }
    /**
	 * 设置：日常任务编号
	 */

    public void setRichangrenwuUuidNumber(String richangrenwuUuidNumber) {
        this.richangrenwuUuidNumber = richangrenwuUuidNumber;
    }
    /**
	 * 获取：日常任务标题
	 */
    public String getRichangrenwuName() {
        return richangrenwuName;
    }
    /**
	 * 设置：日常任务标题
	 */

    public void setRichangrenwuName(String richangrenwuName) {
        this.richangrenwuName = richangrenwuName;
    }
    /**
	 * 获取：日常任务类型
	 */
    public Integer getRichangrenwuTypes() {
        return richangrenwuTypes;
    }
    /**
	 * 设置：日常任务类型
	 */

    public void setRichangrenwuTypes(Integer richangrenwuTypes) {
        this.richangrenwuTypes = richangrenwuTypes;
    }
    /**
	 * 获取：任务积分
	 */
    public Double getRichangrenwuJifen() {
        return richangrenwuJifen;
    }
    /**
	 * 设置：任务积分
	 */

    public void setRichangrenwuJifen(Double richangrenwuJifen) {
        this.richangrenwuJifen = richangrenwuJifen;
    }
    /**
	 * 获取：任务内容
	 */
    public String getRichangrenwuContent() {
        return richangrenwuContent;
    }
    /**
	 * 设置：任务内容
	 */

    public void setRichangrenwuContent(String richangrenwuContent) {
        this.richangrenwuContent = richangrenwuContent;
    }
    /**
	 * 获取：完成标准
	 */
    public String getRichangrenwuWanchengContent() {
        return richangrenwuWanchengContent;
    }
    /**
	 * 设置：完成标准
	 */

    public void setRichangrenwuWanchengContent(String richangrenwuWanchengContent) {
        this.richangrenwuWanchengContent = richangrenwuWanchengContent;
    }
    /**
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Richangrenwu{" +
            ", id=" + id +
            ", richangrenwuUuidNumber=" + richangrenwuUuidNumber +
            ", richangrenwuName=" + richangrenwuName +
            ", richangrenwuTypes=" + richangrenwuTypes +
            ", richangrenwuJifen=" + richangrenwuJifen +
            ", richangrenwuContent=" + richangrenwuContent +
            ", richangrenwuWanchengContent=" + richangrenwuWanchengContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
