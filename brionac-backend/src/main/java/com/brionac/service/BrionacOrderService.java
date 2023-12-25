package com.brionac.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brionac.entity.domain.BrionacOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brionac.entity.domain.Store;
import com.brionac.entity.domain.User;
import com.brionac.entity.requests.StoreDeliverRequest;
import com.brionac.entity.vos.StoreOrderVO;

import java.util.List;

/**
* @author 亚修的小破机
* @description 针对表【order(订单表)】的数据库操作Service
* @createDate 2023-12-23 01:07:08
*/
public interface BrionacOrderService extends IService<BrionacOrder> {

    /**
     * 购物车结算
     * @param cartIds
     * @param user
     * @return
     */
    boolean settlement(List<Integer> cartIds, User user);

    /**
     * 查看店铺的订单
     *
     * @param store
     * @return
     */
    Page<StoreOrderVO> getStoreOrder(Store store);

    /**
     * 商家发货
     * @param orderId
     * @param store
     * @return
     */
    boolean deliver(StoreDeliverRequest orderId, Store store);
}
