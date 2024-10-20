package com.entity.model;

import com.entity.RichangrenwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 日常任务
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class RichangrenwuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 日常任务编号
     */
    private String richangrenwuUuidNumber;


    /**
     * 日常任务标题
     */
    private String richangrenwuName;


    /**
     * 日常任务类型
     */
    private Integer richangrenwuTypes;


    /**
     * 任务积分
     */
    private Double richangrenwuJifen;


    /**
     * 任务内容
     */
    private String richangrenwuContent;


    /**
     * 完成标准
     */
    private String richangrenwuWanchengContent;


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
