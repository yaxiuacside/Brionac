package com.brionac.entity.vos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 店铺VO
 */
@Data
public class StoreVO{
    /**
     * ID
     */
    @Schema(description = "店铺ID")
    private Long storeId;

    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    private Integer userId;

    /**
     * 是否自营
     */
    @Schema(description = "是否自营")
    private Boolean selfOperated;

    /**
     * 店铺状态
     */
    @Schema(description = "店铺状态")
    private String storeDisable;

    /**
     * 店铺logo
     */
    @Schema(description = "店铺logo")
    private String storeLogo;

    /**
     * 店铺名称
     */
    @Schema(description = "店铺名称")
    private String storeName;

    /**
     * 详细地址
     */
    @Schema(description = "详细地址")
    private String storeAddressDetail;

    /**
     * 地址id
     */
    @Schema(description = "地址id")
    private String storeAddressIdPath;

    /**
     * 地址名称
     */
    @Schema(description = "地址名称")
    private String storeAddressPath;

    /**
     * 店铺简介
     */
    @Schema(description = "店铺简介")
    private String storeDesc;

    /**
     * 物流评分
     */
    @Schema(description = "物流评分")
    private BigDecimal deliveryScore;

    /**
     * 描述评分
     */
    @Schema(description = "描述评分")
    private BigDecimal descriptionScore;

    /**
     * 服务评分
     */
    @Schema(description = "服务评分")
    private BigDecimal serviceScore;

    /**
     * 商品数量
     */
    @Schema(description = "商品数量")
    private Integer goodsNum;

    /**
     * 收藏数量
     */
    @Schema(description = "收藏数量")
    private Integer collectionNum;


    /**
     * 用户账号
     */
    @Schema(description = "用户账户")
    private String accountNumber;


    /**
     * 注册时间
     */
    @Schema(description = "注册时间")
    private Date creatTime;

    /**
     * 个人简介
     */
    @Schema(description = "个人简介")
    private String summary;

}