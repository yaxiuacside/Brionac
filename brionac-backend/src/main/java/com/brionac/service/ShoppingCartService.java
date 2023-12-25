package com.brionac.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brionac.entity.domain.ShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brionac.entity.domain.User;
import com.brionac.entity.requests.AddShoppingCartRequest;

/**
* @author 亚修的小破机
* @description 针对表【shopping_cart】的数据库操作Service
* @createDate 2023-12-23 01:07:09
*/
public interface ShoppingCartService extends IService<ShoppingCart> {

    /**
     * 添加商品到购物车
     *
     * @param request
     * @param userId
     * @param accountNumber
     * @return
     */
    boolean add(AddShoppingCartRequest request, Integer userId, String accountNumber);

    /**
     * 获得购物车数据
     * @param user
     * @return
     */
    Page<ShoppingCart> getCar(User user);

    boolean updateAmount(Integer cartId, Integer amount);
}
