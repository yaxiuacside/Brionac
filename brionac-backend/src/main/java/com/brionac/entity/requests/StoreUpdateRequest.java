package com.brionac.entity.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用户信息修改request
 */
@Data
@Schema(name = "店铺信息修改request",description = "店铺信息修改request")
public class StoreUpdateRequest {

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
     * 店铺简介
     */
    @Schema(description = "店铺简介")
    private String storeDesc;

}