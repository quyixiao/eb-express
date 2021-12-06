package com.lz.express.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.Date;

/**
* <p>
* 菜单权限表
* </p>*物流表
* @author quyixiao
* @since 2021-12-06
*/

@Data
@TableName("lt_user_express")
public class UserExpress implements java.io.Serializable {
    //主键，自增id
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    //是否删除状态，1：删除，0：有效
    private Integer isDelete;
    //创建时间
    private Date gmtCreate;
    //最后修改时间
    private Date gmtModified;
    //物流单号
    private String expressNo;
    //回调地址
    private String callBackUrl;
    /**
     * 主键，自增id
     * @return
     */
    public Long getId() {
        return id;
    }
    /**
     * 主键，自增id
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 是否删除状态，1：删除，0：有效
     * @return
     */
    public Integer getIsDelete() {
        return isDelete;
    }
    /**
     * 是否删除状态，1：删除，0：有效
     * @param isDelete
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 创建时间
     * @return
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }
    /**
     * 创建时间
     * @param gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 最后修改时间
     * @return
     */
    public Date getGmtModified() {
        return gmtModified;
    }
    /**
     * 最后修改时间
     * @param gmtModified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 物流单号
     * @return
     */
    public String getExpressNo() {
        return expressNo;
    }
    /**
     * 物流单号
     * @param expressNo
     */
    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }

    /**
     * 回调地址
     * @return
     */
    public String getCallBackUrl() {
        return callBackUrl;
    }
    /**
     * 回调地址
     * @param callBackUrl
     */
    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }

    @Override
    public String toString() {
        return "UserExpress{" +
                ",id=" + id +
                ",isDelete=" + isDelete +
                ",gmtCreate=" + gmtCreate +
                ",gmtModified=" + gmtModified +
                ",expressNo=" + expressNo +
                ",callBackUrl=" + callBackUrl +
                "}";
    }
}
