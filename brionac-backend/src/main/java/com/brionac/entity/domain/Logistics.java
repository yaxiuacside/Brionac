package com.brionac.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 物流表
 * @TableName logistics
 */
@Schema(name = "物流信息",description = "物流信息表")
@TableName(value ="logistics")
@Data
public class Logistics implements Serializable {
    /**
     * 物流id
     */
    @TableId(value = "logistic_id", type = IdType.AUTO)
    @Schema(description = "主键id")
    private Integer logisticId;

    /**
     * 订单编号
     */
    @TableField(value = "order_no")
    @Schema(description = "订单编号")
    private String orderNo;

    /**
     * 发货人
     */
    @TableField(value = "sender")
    @Schema(description = "发货人")
    private String sender;

    /**
     * 发货人联系方式
     */
    @TableField(value = "sender_tel")
    @Schema(description = "发货人联系方式")
    private String senderTel;

    /**
     * 发货人联系地址
     */
    @TableField(value = "sender_add")
    @Schema(description = "发货人联系地址")
    private String senderAdd;

    /**
     * 收货人
     */
    @TableField(value = "receiver")
    @Schema(description = "收货人")
    private String receiver;

    /**
     * 收货人联系方式
     */
    @TableField(value = "receiver_tel")
    @Schema(description = "收货人联系方式")
    private String receiverTel;

    /**
     * 收货人联系地址
     */
    @TableField(value = "receiver_add")
    @Schema(description = "收货人联系地址")
    private String receiverAdd;

    /**
     * 物流公司
     */
    @TableField(value = "parcel_name")
    @Schema(description = "物流公司")
    private String parcelName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Logistics other = (Logistics) that;
        return (this.getLogisticId() == null ? other.getLogisticId() == null : this.getLogisticId().equals(other.getLogisticId()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getSender() == null ? other.getSender() == null : this.getSender().equals(other.getSender()))
            && (this.getSenderTel() == null ? other.getSenderTel() == null : this.getSenderTel().equals(other.getSenderTel()))
            && (this.getSenderAdd() == null ? other.getSenderAdd() == null : this.getSenderAdd().equals(other.getSenderAdd()))
            && (this.getReceiver() == null ? other.getReceiver() == null : this.getReceiver().equals(other.getReceiver()))
            && (this.getReceiverTel() == null ? other.getReceiverTel() == null : this.getReceiverTel().equals(other.getReceiverTel()))
            && (this.getReceiverAdd() == null ? other.getReceiverAdd() == null : this.getReceiverAdd().equals(other.getReceiverAdd()))
            && (this.getParcelName() == null ? other.getParcelName() == null : this.getParcelName().equals(other.getParcelName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLogisticId() == null) ? 0 : getLogisticId().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getSender() == null) ? 0 : getSender().hashCode());
        result = prime * result + ((getSenderTel() == null) ? 0 : getSenderTel().hashCode());
        result = prime * result + ((getSenderAdd() == null) ? 0 : getSenderAdd().hashCode());
        result = prime * result + ((getReceiver() == null) ? 0 : getReceiver().hashCode());
        result = prime * result + ((getReceiverTel() == null) ? 0 : getReceiverTel().hashCode());
        result = prime * result + ((getReceiverAdd() == null) ? 0 : getReceiverAdd().hashCode());
        result = prime * result + ((getParcelName() == null) ? 0 : getParcelName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", logisticId=").append(logisticId);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", sender=").append(sender);
        sb.append(", senderTel=").append(senderTel);
        sb.append(", senderAdd=").append(senderAdd);
        sb.append(", receiver=").append(receiver);
        sb.append(", receiverTel=").append(receiverTel);
        sb.append(", receiverAdd=").append(receiverAdd);
        sb.append(", parcelName=").append(parcelName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}