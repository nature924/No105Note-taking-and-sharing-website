package com.entity.model;

import com.entity.RichangrenwuLingquEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 领取任务
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class RichangrenwuLingquModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 日常任务
     */
    private Integer richangrenwuId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 领取任务编号
     */
    private String richangrenwuLingquUuidNumber;


    /**
     * 所属日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date richangrenwuLingquTime;


    /**
     * 领取时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 任务状态
     */
    private Integer richangrenwuLingquTypes;


    /**
     * 审核状态
     */
    private Integer richangrenwuLingquYesnoTypes;


    /**
     * 审核回复
     */
    private String richangrenwuLingquYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date richangrenwuLingquShenheTime;


    /**
     * 创建时间   show3 listShow
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
	 * 获取：创建时间   show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间   show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
