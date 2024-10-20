package com.entity.vo;

import com.entity.RichangrenwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 日常任务
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("richangrenwu")
public class RichangrenwuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 日常任务编号
     */

    @TableField(value = "richangrenwu_uuid_number")
    private String richangrenwuUuidNumber;


    /**
     * 日常任务标题
     */

    @TableField(value = "richangrenwu_name")
    private String richangrenwuName;


    /**
     * 日常任务类型
     */

    @TableField(value = "richangrenwu_types")
    private Integer richangrenwuTypes;


    /**
     * 任务积分
     */

    @TableField(value = "richangrenwu_jifen")
    private Double richangrenwuJifen;


    /**
     * 任务内容
     */

    @TableField(value = "richangrenwu_content")
    private String richangrenwuContent;


    /**
     * 完成标准
     */

    @TableField(value = "richangrenwu_wancheng_content")
    private String richangrenwuWanchengContent;


    /**
     * 创建时间  show3 listShow
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
	 * 设置：日常任务编号
	 */
    public String getRichangrenwuUuidNumber() {
        return richangrenwuUuidNumber;
    }


    /**
	 * 获取：日常任务编号
	 */

    public void setRichangrenwuUuidNumber(String richangrenwuUuidNumber) {
        this.richangrenwuUuidNumber = richangrenwuUuidNumber;
    }
    /**
	 * 设置：日常任务标题
	 */
    public String getRichangrenwuName() {
        return richangrenwuName;
    }


    /**
	 * 获取：日常任务标题
	 */

    public void setRichangrenwuName(String richangrenwuName) {
        this.richangrenwuName = richangrenwuName;
    }
    /**
	 * 设置：日常任务类型
	 */
    public Integer getRichangrenwuTypes() {
        return richangrenwuTypes;
    }


    /**
	 * 获取：日常任务类型
	 */

    public void setRichangrenwuTypes(Integer richangrenwuTypes) {
        this.richangrenwuTypes = richangrenwuTypes;
    }
    /**
	 * 设置：任务积分
	 */
    public Double getRichangrenwuJifen() {
        return richangrenwuJifen;
    }


    /**
	 * 获取：任务积分
	 */

    public void setRichangrenwuJifen(Double richangrenwuJifen) {
        this.richangrenwuJifen = richangrenwuJifen;
    }
    /**
	 * 设置：任务内容
	 */
    public String getRichangrenwuContent() {
        return richangrenwuContent;
    }


    /**
	 * 获取：任务内容
	 */

    public void setRichangrenwuContent(String richangrenwuContent) {
        this.richangrenwuContent = richangrenwuContent;
    }
    /**
	 * 设置：完成标准
	 */
    public String getRichangrenwuWanchengContent() {
        return richangrenwuWanchengContent;
    }


    /**
	 * 获取：完成标准
	 */

    public void setRichangrenwuWanchengContent(String richangrenwuWanchengContent) {
        this.richangrenwuWanchengContent = richangrenwuWanchengContent;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
