package com.brionac.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品退货表
 * @TableName return_goods
 */
@TableName(value ="return_goods")
@Data
public class ReturnGoods implements Serializable {
    /**
     * 退货id
     */
    @TableId(value = "return_id", type = IdType.AUTO)
    private Integer returnId;

    /**
     * 申请时间
     */
    @TableField(value = "apply_time")
    private Date applyTime;

    /**
     * 订单ID
     */
    @TableField(value = "order_id")
    private Integer orderId;

    /**
     * 订单编号
     */
    @TableField(value = "order_no")
    private String orderNo;

    /**
     * 用户账号
     */
    @TableField(value = "user_number")
    private String userNumber;

    /**
     * 用户名称
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 退款金额
     */
    @TableField(value = "return_price")
    private Double returnPrice;

    /**
     * 操作员账号
     */
    @TableField(value = "operator_number")
    private String operatorNumber;

    /**
     * 操作员名称
     */
    @TableField(value = "operator_name")
    private String operatorName;

    /**
     * 处理时间
     */
    @TableField(value = "deal_time")
    private Date dealTime;

    /**
     * 退货原因ID
     */
    @TableField(value = "reason_id")
    private Integer reasonId;

    /**
     * 退货原因
     */
    @TableField(value = "return_reason")
    private String returnReason;

    /**
     * 退货状态
     */
    @TableField(value = "return_state")
    private String returnState;

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
        ReturnGoods other = (ReturnGoods) that;
        return (this.getReturnId() == null ? other.getReturnId() == null : this.getReturnId().equals(other.getReturnId()))
            && (this.getApplyTime() == null ? other.getApplyTime() == null : this.getApplyTime().equals(other.getApplyTime()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getUserNumber() == null ? other.getUserNumber() == null : this.getUserNumber().equals(other.getUserNumber()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getReturnPrice() == null ? other.getReturnPrice() == null : this.getReturnPrice().equals(other.getReturnPrice()))
            && (this.getOperatorNumber() == null ? other.getOperatorNumber() == null : this.getOperatorNumber().equals(other.getOperatorNumber()))
            && (this.getOperatorName() == null ? other.getOperatorName() == null : this.getOperatorName().equals(other.getOperatorName()))
            && (this.getDealTime() == null ? other.getDealTime() == null : this.getDealTime().equals(other.getDealTime()))
            && (this.getReasonId() == null ? other.getReasonId() == null : this.getReasonId().equals(other.getReasonId()))
            && (this.getReturnReason() == null ? other.getReturnReason() == null : this.getReturnReason().equals(other.getReturnReason()))
            && (this.getReturnState() == null ? other.getReturnState() == null : this.getReturnState().equals(other.getReturnState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReturnId() == null) ? 0 : getReturnId().hashCode());
        result = prime * result + ((getApplyTime() == null) ? 0 : getApplyTime().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getUserNumber() == null) ? 0 : getUserNumber().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getReturnPrice() == null) ? 0 : getReturnPrice().hashCode());
        result = prime * result + ((getOperatorNumber() == null) ? 0 : getOperatorNumber().hashCode());
        result = prime * result + ((getOperatorName() == null) ? 0 : getOperatorName().hashCode());
        result = prime * result + ((getDealTime() == null) ? 0 : getDealTime().hashCode());
        result = prime * result + ((getReasonId() == null) ? 0 : getReasonId().hashCode());
        result = prime * result + ((getReturnReason() == null) ? 0 : getReturnReason().hashCode());
        result = prime * result + ((getReturnState() == null) ? 0 : getReturnState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", returnId=").append(returnId);
        sb.append(", applyTime=").append(applyTime);
        sb.append(", orderId=").append(orderId);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", userNumber=").append(userNumber);
        sb.append(", userName=").append(userName);
        sb.append(", returnPrice=").append(returnPrice);
        sb.append(", operatorNumber=").append(operatorNumber);
        sb.append(", operatorName=").append(operatorName);
        sb.append(", dealTime=").append(dealTime);
        sb.append(", reasonId=").append(reasonId);
        sb.append(", returnReason=").append(returnReason);
        sb.append(", returnState=").append(returnState);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}