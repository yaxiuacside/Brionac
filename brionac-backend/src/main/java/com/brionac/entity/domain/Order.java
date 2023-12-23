package com.brionac.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 订单表
 * @TableName order
 */
@TableName(value ="order")
@Data
public class Order implements Serializable {
    /**
     * 订单id
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 订单编号
     */
    @TableField(value = "order_no")
    private String orderNo;

    /**
     * 下单时间
     */
    @TableField(value = "order_time")
    private Date orderTime;

    /**
     * 商品ID
     */
    @TableField(value = "product_id")
    private Integer productId;

    /**
     * 商品编号
     */
    @TableField(value = "product_no")
    private String productNo;

    /**
     * 商品规格
     */
    @TableField(value = "product_specs")
    private String productSpecs;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 用户账号
     */
    @TableField(value = "user_account")
    private String userAccount;

    /**
     * 用户名称
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 联系方式
     */
    @TableField(value = "contact_way")
    private String contactWay;

    /**
     * 商品金额
     */
    @TableField(value = "pay_price")
    private Double payPrice;

    /**
     * 购买数量
     */
    @TableField(value = "pay_amount")
    private Integer payAmount;

    /**
     * 支付方式
     */
    @TableField(value = "pay_type")
    private String payType;

    /**
     * 订单状态
     */
    @TableField(value = "order_state")
    private String orderState;

    /**
     * 收货地址
     */
    @TableField(value = "accept_address")
    private String acceptAddress;

    /**
     * 退货状态
     */
    @TableField(value = "return_state")
    private Integer returnState;

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
        Order other = (Order) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getOrderTime() == null ? other.getOrderTime() == null : this.getOrderTime().equals(other.getOrderTime()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getProductNo() == null ? other.getProductNo() == null : this.getProductNo().equals(other.getProductNo()))
            && (this.getProductSpecs() == null ? other.getProductSpecs() == null : this.getProductSpecs().equals(other.getProductSpecs()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserAccount() == null ? other.getUserAccount() == null : this.getUserAccount().equals(other.getUserAccount()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getContactWay() == null ? other.getContactWay() == null : this.getContactWay().equals(other.getContactWay()))
            && (this.getPayPrice() == null ? other.getPayPrice() == null : this.getPayPrice().equals(other.getPayPrice()))
            && (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getOrderState() == null ? other.getOrderState() == null : this.getOrderState().equals(other.getOrderState()))
            && (this.getAcceptAddress() == null ? other.getAcceptAddress() == null : this.getAcceptAddress().equals(other.getAcceptAddress()))
            && (this.getReturnState() == null ? other.getReturnState() == null : this.getReturnState().equals(other.getReturnState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getOrderTime() == null) ? 0 : getOrderTime().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProductNo() == null) ? 0 : getProductNo().hashCode());
        result = prime * result + ((getProductSpecs() == null) ? 0 : getProductSpecs().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserAccount() == null) ? 0 : getUserAccount().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getContactWay() == null) ? 0 : getContactWay().hashCode());
        result = prime * result + ((getPayPrice() == null) ? 0 : getPayPrice().hashCode());
        result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getOrderState() == null) ? 0 : getOrderState().hashCode());
        result = prime * result + ((getAcceptAddress() == null) ? 0 : getAcceptAddress().hashCode());
        result = prime * result + ((getReturnState() == null) ? 0 : getReturnState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", productId=").append(productId);
        sb.append(", productNo=").append(productNo);
        sb.append(", productSpecs=").append(productSpecs);
        sb.append(", userId=").append(userId);
        sb.append(", userAccount=").append(userAccount);
        sb.append(", userName=").append(userName);
        sb.append(", contactWay=").append(contactWay);
        sb.append(", payPrice=").append(payPrice);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", payType=").append(payType);
        sb.append(", orderState=").append(orderState);
        sb.append(", acceptAddress=").append(acceptAddress);
        sb.append(", returnState=").append(returnState);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}