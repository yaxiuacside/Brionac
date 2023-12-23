package com.brionac.entity.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName store
 */
@TableName(value ="store")
@Data
public class Store implements Serializable {
    /**
     * ID
     */
    @TableId(value = "store_id")
    private Long storeId;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 是否自营
     */
    @TableField(value = "self_operated")
    private Boolean selfOperated;

    /**
     * 店铺状态
     */
    @TableField(value = "store_disable")
    private String storeDisable;

    /**
     * 店铺logo
     */
    @TableField(value = "store_logo")
    private String storeLogo;

    /**
     * 店铺名称
     */
    @TableField(value = "store_name")
    private String storeName;

    /**
     * 详细地址
     */
    @TableField(value = "store_address_detail")
    private String storeAddressDetail;

    /**
     * 地址id
     */
    @TableField(value = "store_address_id_path")
    private String storeAddressIdPath;

    /**
     * 地址名称
     */
    @TableField(value = "store_address_path")
    private String storeAddressPath;

    /**
     * 店铺简介
     */
    @TableField(value = "store_desc")
    private String storeDesc;

    /**
     * 物流评分
     */
    @TableField(value = "delivery_score")
    private BigDecimal deliveryScore;

    /**
     * 描述评分
     */
    @TableField(value = "description_score")
    private BigDecimal descriptionScore;

    /**
     * 服务评分
     */
    @TableField(value = "service_score")
    private BigDecimal serviceScore;

    /**
     * 商品数量
     */
    @TableField(value = "goods_num")
    private Integer goodsNum;

    /**
     * 收藏数量
     */
    @TableField(value = "collection_num")
    private Integer collectionNum;

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
        Store other = (Store) that;
        return (this.getStoreId() == null ? other.getStoreId() == null : this.getStoreId().equals(other.getStoreId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getSelfOperated() == null ? other.getSelfOperated() == null : this.getSelfOperated().equals(other.getSelfOperated()))
            && (this.getStoreDisable() == null ? other.getStoreDisable() == null : this.getStoreDisable().equals(other.getStoreDisable()))
            && (this.getStoreLogo() == null ? other.getStoreLogo() == null : this.getStoreLogo().equals(other.getStoreLogo()))
            && (this.getStoreName() == null ? other.getStoreName() == null : this.getStoreName().equals(other.getStoreName()))
            && (this.getStoreAddressDetail() == null ? other.getStoreAddressDetail() == null : this.getStoreAddressDetail().equals(other.getStoreAddressDetail()))
            && (this.getStoreAddressIdPath() == null ? other.getStoreAddressIdPath() == null : this.getStoreAddressIdPath().equals(other.getStoreAddressIdPath()))
            && (this.getStoreAddressPath() == null ? other.getStoreAddressPath() == null : this.getStoreAddressPath().equals(other.getStoreAddressPath()))
            && (this.getStoreDesc() == null ? other.getStoreDesc() == null : this.getStoreDesc().equals(other.getStoreDesc()))
            && (this.getDeliveryScore() == null ? other.getDeliveryScore() == null : this.getDeliveryScore().equals(other.getDeliveryScore()))
            && (this.getDescriptionScore() == null ? other.getDescriptionScore() == null : this.getDescriptionScore().equals(other.getDescriptionScore()))
            && (this.getServiceScore() == null ? other.getServiceScore() == null : this.getServiceScore().equals(other.getServiceScore()))
            && (this.getGoodsNum() == null ? other.getGoodsNum() == null : this.getGoodsNum().equals(other.getGoodsNum()))
            && (this.getCollectionNum() == null ? other.getCollectionNum() == null : this.getCollectionNum().equals(other.getCollectionNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStoreId() == null) ? 0 : getStoreId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getSelfOperated() == null) ? 0 : getSelfOperated().hashCode());
        result = prime * result + ((getStoreDisable() == null) ? 0 : getStoreDisable().hashCode());
        result = prime * result + ((getStoreLogo() == null) ? 0 : getStoreLogo().hashCode());
        result = prime * result + ((getStoreName() == null) ? 0 : getStoreName().hashCode());
        result = prime * result + ((getStoreAddressDetail() == null) ? 0 : getStoreAddressDetail().hashCode());
        result = prime * result + ((getStoreAddressIdPath() == null) ? 0 : getStoreAddressIdPath().hashCode());
        result = prime * result + ((getStoreAddressPath() == null) ? 0 : getStoreAddressPath().hashCode());
        result = prime * result + ((getStoreDesc() == null) ? 0 : getStoreDesc().hashCode());
        result = prime * result + ((getDeliveryScore() == null) ? 0 : getDeliveryScore().hashCode());
        result = prime * result + ((getDescriptionScore() == null) ? 0 : getDescriptionScore().hashCode());
        result = prime * result + ((getServiceScore() == null) ? 0 : getServiceScore().hashCode());
        result = prime * result + ((getGoodsNum() == null) ? 0 : getGoodsNum().hashCode());
        result = prime * result + ((getCollectionNum() == null) ? 0 : getCollectionNum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", storeId=").append(storeId);
        sb.append(", userId=").append(userId);
        sb.append(", selfOperated=").append(selfOperated);
        sb.append(", storeDisable=").append(storeDisable);
        sb.append(", storeLogo=").append(storeLogo);
        sb.append(", storeName=").append(storeName);
        sb.append(", storeAddressDetail=").append(storeAddressDetail);
        sb.append(", storeAddressIdPath=").append(storeAddressIdPath);
        sb.append(", storeAddressPath=").append(storeAddressPath);
        sb.append(", storeDesc=").append(storeDesc);
        sb.append(", deliveryScore=").append(deliveryScore);
        sb.append(", descriptionScore=").append(descriptionScore);
        sb.append(", serviceScore=").append(serviceScore);
        sb.append(", goodsNum=").append(goodsNum);
        sb.append(", collectionNum=").append(collectionNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}