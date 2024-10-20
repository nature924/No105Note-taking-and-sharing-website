package com.entity.model;

import com.entity.BijiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 笔记广场
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BijiModel implements Serializable {
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
     * 笔记名称
     */
    private String bijiName;


    /**
     * 笔记编号
     */
    private String bijiUuidNumber;


    /**
     * 笔记照片
     */
    private String bijiPhoto;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 笔记类型
     */
    private Integer bijiTypes;


    /**
     * 笔记内容
     */
    private String bijiContent;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
