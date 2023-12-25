package com.brionac.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 物流表
 * @TableName logistics
 */
@TableName(value ="logistics")
@Data
public class Logistics implements Serializable {
    /**
     * 物流id
     */
    @TableId(value = "logistic_id", type = IdType.AUTO)
    private Integer logisticId;

    /**
     * 物流编号
     */
    @TableField(value = "logistic_no")
    private String logisticNo;

    /**
     * 订单id
     */
    @TableField(value = "order_id")
    private Integer orderId;

    /**
     * 订单编号
     */
    @TableField(value = "order_no")
    private String orderNo;

    /**
     * 发货人
     */
    @TableField(value = "sender")
    private String sender;

    /**
     * 发货人联系方式
     */
    @TableField(value = "sender_tel")
    private String senderTel;

    /**
     * 发货人联系地址
     */
    @TableField(value = "sender_add")
    private String senderAdd;

    /**
     * 收货人
     */
    @TableField(value = "receiver")
    private String receiver;

    /**
     * 收货人联系方式
     */
    @TableField(value = "receiver_tel")
    private String receiverTel;

    /**
     * 收货人联系地址
     */
    @TableField(value = "receiver_add")
    private String receiverAdd;

    /**
     * 物流公司
     */
    @TableField(value = "parcel_name")
    private String parcelName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}