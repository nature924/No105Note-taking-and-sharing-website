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
 * 我的关注
 *
 * @author 
 * @email
 */
@TableName("guanzhu")
public class GuanzhuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GuanzhuEntity() {

	}

	public GuanzhuEntity(T t) {
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
     * 关注编号
     */
    @ColumnInfo(comment="关注编号",type="varchar(200)")
    @TableField(value = "guanzhu_uuid_number")

    private String guanzhuUuidNumber;


    /**
     * 关注人
     */
    @ColumnInfo(comment="关注人",type="int(11)")
    @TableField(value = "guanzhu_kucun_number")

    private Integer guanzhuKucunNumber;


    /**
     * 关注时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="关注时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：关注编号
	 */
    public String getGuanzhuUuidNumber() {
        return guanzhuUuidNumber;
    }
    /**
	 * 设置：关注编号
	 */

    public void setGuanzhuUuidNumber(String guanzhuUuidNumber) {
        this.guanzhuUuidNumber = guanzhuUuidNumber;
    }
    /**
	 * 获取：关注人
	 */
    public Integer getGuanzhuKucunNumber() {
        return guanzhuKucunNumber;
    }
    /**
	 * 设置：关注人
	 */

    public void setGuanzhuKucunNumber(Integer guanzhuKucunNumber) {
        this.guanzhuKucunNumber = guanzhuKucunNumber;
    }
    /**
	 * 获取：关注时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：关注时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Guanzhu{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", guanzhuUuidNumber=" + guanzhuUuidNumber +
            ", guanzhuKucunNumber=" + guanzhuKucunNumber +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
