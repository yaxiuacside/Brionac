package com.brionac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brionac.entity.domain.Product;
import com.brionac.entity.domain.Store;
import com.brionac.entity.domain.User;
import com.brionac.entity.requests.StoreUpdateRequest;
import com.brionac.service.ProductService;
import com.brionac.service.StoreService;
import com.brionac.mapper.StoreMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.brionac.common.Common.*;
import static com.brionac.utils.CommonUtil.getNullPropertyNames;

/**
* @author 亚修的小破机
* @description 针对表【store】的数据库操作Service实现
* @createDate 2023-12-23 01:07:09
*/
@Service
@Slf4j
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store>
    implements StoreService{

    @Resource
    StoreMapper storeMapper;

    @Autowired
    ProductService productService;

    @Override
    public Page<Store> storeList() {
        Page<Store> storePage = new Page<>();
        return storePage = this.page(storePage);
    }

    @Override
    public Store detail(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(USER_SESSION_KEY);

        Store store = this.getOne(Wrappers.<Store>lambdaQuery().eq(Store::getUserId, user.getUserId()));
        return store;
    }

    @Override
    public Store detail(Integer userId) {
        Store store = this.getOne(Wrappers.<Store>lambdaQuery().eq(Store::getUserId, userId));
        return store;
    }

    @Override
    public Page<Product> productList(HttpServletRequest request) {

        Store store = (Store) request.getSession().getAttribute(STORE_SESSION_KEY);
        Page<Product> page = productService.page(new Page<Product>(), Wrappers.<Product>lambdaQuery().eq(Product::getStoreId, store.getStoreId()));
        return page;
    }

    @Override
    public boolean storeDelete(String id, HttpServletRequest request) {
        log.info("删除店铺id为:{}", id);
        log.info("删除者为:{}", request.getSession().getAttribute(USER_SESSION_KEY));
        return this.removeById(id);
    }

    @Override
    public Store updateStoreInfo(StoreUpdateRequest storeUpdateRequest, HttpServletRequest request) {
        // 获取当前登录的店铺
        Store loginStore = (Store) request.getSession().getAttribute(STORE_SESSION_KEY);

        if(ObjectUtil.isNull(loginStore)){
            log.error("未获取到店铺信息: "+request.getRequestURL());
            throw new RuntimeException("店铺未登录");
        }
        BeanUtil.copyProperties(storeUpdateRequest, loginStore,getNullPropertyNames(storeUpdateRequest));

        this.updateById(loginStore);

        return loginStore;
    }
}




