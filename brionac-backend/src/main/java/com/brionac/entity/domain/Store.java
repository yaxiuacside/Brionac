package com.brionac.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 店铺表
 * @TableName store
 */
@TableName(value ="store")
@Data
public class Store implements Serializable {
    /**
     * ID
     */
    @TableId(value = "store_id", type = IdType.AUTO)
    private Integer storeId;

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
}