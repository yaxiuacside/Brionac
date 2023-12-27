package com.brionac.constants;

/**
 * @author 亚修的小破机
 * Description: 订单状态码
 * ClassName: OrderState
 * date: 2023/12/25
 */
public interface OrderState {
    // 未付款
    Integer UNPAID = 0;
    // 已付款
    Integer PAID = 1;
    // 已发货
    Integer DELIVERED = 2;
    // 已收货
    Integer RECEIVE = 3;
    // 已取消
    Integer CANCELED = 4;
    // 已退款
    Integer REFUNDED = 5;
    //已完成
    Integer COMPLETED = 6;
}
