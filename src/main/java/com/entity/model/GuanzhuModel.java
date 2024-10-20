package com.entity.model;

import com.entity.GuanzhuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 我的关注
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GuanzhuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 关注编号
     */
    private String guanzhuUuidNumber;


    /**
     * 关注人
     */
    private Integer guanzhuKucunNumber;


    /**
     * 关注时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
