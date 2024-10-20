package com.entity.vo;

import com.entity.BijiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 笔记广场
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("biji")
public class BijiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 笔记名称
     */

    @TableField(value = "biji_name")
    private String bijiName;


    /**
     * 笔记编号
     */

    @TableField(value = "biji_uuid_number")
    private String bijiUuidNumber;


    /**
     * 笔记照片
     */

    @TableField(value = "biji_photo")
    private String bijiPhoto;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 笔记类型
     */

    @TableField(value = "biji_types")
    private Integer bijiTypes;


    /**
     * 笔记内容
     */

    @TableField(value = "biji_content")
    private String bijiContent;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：笔记名称
	 */
    public String getBijiName() {
        return bijiName;
    }


    /**
	 * 获取：笔记名称
	 */

    public void setBijiName(String bijiName) {
        this.bijiName = bijiName;
    }
    /**
	 * 设置：笔记编号
	 */
    public String getBijiUuidNumber() {
        return bijiUuidNumber;
    }


    /**
	 * 获取：笔记编号
	 */

    public void setBijiUuidNumber(String bijiUuidNumber) {
        this.bijiUuidNumber = bijiUuidNumber;
    }
    /**
	 * 设置：笔记照片
	 */
    public String getBijiPhoto() {
        return bijiPhoto;
    }


    /**
	 * 获取：笔记照片
	 */

    public void setBijiPhoto(String bijiPhoto) {
        this.bijiPhoto = bijiPhoto;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：笔记类型
	 */
    public Integer getBijiTypes() {
        return bijiTypes;
    }


    /**
	 * 获取：笔记类型
	 */

    public void setBijiTypes(Integer bijiTypes) {
        this.bijiTypes = bijiTypes;
    }
    /**
	 * 设置：笔记内容
	 */
    public String getBijiContent() {
        return bijiContent;
    }


    /**
	 * 获取：笔记内容
	 */

    public void setBijiContent(String bijiContent) {
        this.bijiContent = bijiContent;
    }
    /**
	 * 设置：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
