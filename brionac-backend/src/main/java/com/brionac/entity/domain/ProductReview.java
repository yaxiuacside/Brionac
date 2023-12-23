package com.brionac.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品评价
 * @TableName product_review
 */
@TableName(value ="product_review")
@Data
public class ProductReview implements Serializable {
    /**
     * 用户评论id
     */
    @TableId(value = "review_id", type = IdType.AUTO)
    private Integer reviewId;

    /**
     * 用户
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 用户帐号
     */
    @TableField(value = "account_number")
    private String accountNumber;

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
     * 订单编号
     */
    @TableField(value = "order_no")
    private String orderNo;

    /**
     * 评论时间
     */
    @TableField(value = "review_time")
    private Date reviewTime;

    /**
     * 商品评星
     */
    @TableField(value = "star_level")
    private Double starLevel;

    /**
     * 商品评价
     */
    @TableField(value = "product_review")
    private String productReview;

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
        ProductReview other = (ProductReview) that;
        return (this.getReviewId() == null ? other.getReviewId() == null : this.getReviewId().equals(other.getReviewId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAccountNumber() == null ? other.getAccountNumber() == null : this.getAccountNumber().equals(other.getAccountNumber()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getProductNo() == null ? other.getProductNo() == null : this.getProductNo().equals(other.getProductNo()))
            && (this.getProductSpecs() == null ? other.getProductSpecs() == null : this.getProductSpecs().equals(other.getProductSpecs()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getReviewTime() == null ? other.getReviewTime() == null : this.getReviewTime().equals(other.getReviewTime()))
            && (this.getStarLevel() == null ? other.getStarLevel() == null : this.getStarLevel().equals(other.getStarLevel()))
            && (this.getProductReview() == null ? other.getProductReview() == null : this.getProductReview().equals(other.getProductReview()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReviewId() == null) ? 0 : getReviewId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAccountNumber() == null) ? 0 : getAccountNumber().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProductNo() == null) ? 0 : getProductNo().hashCode());
        result = prime * result + ((getProductSpecs() == null) ? 0 : getProductSpecs().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getReviewTime() == null) ? 0 : getReviewTime().hashCode());
        result = prime * result + ((getStarLevel() == null) ? 0 : getStarLevel().hashCode());
        result = prime * result + ((getProductReview() == null) ? 0 : getProductReview().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", reviewId=").append(reviewId);
        sb.append(", userId=").append(userId);
        sb.append(", accountNumber=").append(accountNumber);
        sb.append(", productId=").append(productId);
        sb.append(", productNo=").append(productNo);
        sb.append(", productSpecs=").append(productSpecs);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", reviewTime=").append(reviewTime);
        sb.append(", starLevel=").append(starLevel);
        sb.append(", productReview=").append(productReview);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}