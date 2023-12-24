package com.brionac.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brionac.entity.domain.Product;
import com.brionac.entity.domain.Store;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brionac.entity.requests.StoreUpdateRequest;

import javax.servlet.http.HttpServletRequest;

/**
* @author 亚修的小破机
* @description 针对表【store】的数据库操作Service
* @createDate 2023-12-23 01:07:09
*/
public interface StoreService extends IService<Store> {

    /**
     * 全部店铺
     *
     * @return
     */
    Page<Store> storeList();

    /**
     * 店铺信息
     * @param request
     * @return
     */
    Store detail(HttpServletRequest request);

    Store detail(Integer userId);

    /**
     * 店铺商品
     * @param request
     * @return
     */
    Page<Product> productList(HttpServletRequest request);

    /**
     * 删除店铺
     *
     * @param id
     * @param request
     * @return
     */
    boolean storeDelete(String id, HttpServletRequest request);

    /**
     * 修改店铺信息
     * @param storeUpdateRequest
     * @param request
     * @return
     */
    Store updateStoreInfo(StoreUpdateRequest storeUpdateRequest, HttpServletRequest request);
}
