package com.brionac.entity.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 亚修的小破机
 * Description: 商家发货request
 * ClassName: StoreDeliverRequest
 * date: 2023/12/26
 */
@Schema(name = "商家发货request",description = "商家发货request")
@Data
public class StoreDeliverRequest {

    /**
     * 订单Id
     */
    @Schema(description = "订单Id")
    private Integer orderId;

    /**
     * 订单编号
     */
    @Schema(description = "订单编号")
    private String orderNo;
    /**
     * 物流编号
     */
    @Schema(description = "物流编号")
    private String logisticNo;

    /**
     * 物流公司
     */
    @Schema(description = "物流公司")
    private String parcelName;
}
