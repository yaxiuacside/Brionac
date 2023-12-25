package com.brionac.entity.vos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 亚修的小破机
 * Description: 店铺查看订单VO
 * ClassName: StoreOrderVO
 * date: 2023/12/25
 */
@Schema(name = "店铺查看订单VO",description = "店铺查看订单VO")
@Data
public class StoreOrderVO {
    /**
     * 订单id
     */
    @Schema(description = "订单id")
    private Integer orderId;

    /**
     * 订单编号
     */
    @Schema(description = "订单编号")
    private String orderNo;

    /**
     * 下单时间
     */
    @Schema(description = "下单时间")
    private Date orderTime;

    /**
     * 商品编号
     */
    @Schema(description = "商品编号")
    private String productNo;

    /**
     * 商品规格
     */
    @Schema(description = "商品规格")
    private String productSpecs;

    /**
     * 用户名称
     */
    @Schema(description = "用户名称")
    private String userName;

    /**
     * 商品金额
     */
    @Schema(description = "商品金额")
    private BigDecimal payPrice;

    /**
     * 购买数量
     */
    @Schema(description = "购买数量")
    private Integer payAmount;

    /**
     * 订单状态
     */
    @Schema(description = "订单状态 0-未支付 1-已支付 2-已发货 3-已收货 4-已评价 5-已退款 6-已完成")
    private String orderState;

    /**
     * 退货状态
     */
    @Schema(description = "退货状态 0-无退货 1-申请退货 2-已经处理退货")
    private Integer returnState;

}
