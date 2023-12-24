package com.brionac.service;

import com.brionac.entity.domain.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brionac.entity.requests.ProductAddRequest;

/**
* @author 亚修的小破机
* @description 针对表【product(商品表)】的数据库操作Service
* @createDate 2023-12-23 01:07:08
*/
public interface ProductService extends IService<Product> {

    boolean addDefaultSpecs(ProductAddRequest request, Integer storeId);

    /**
     * 更改商品的状态信息
     * @param productId
     * @param saleStatus
     * @return
     */
    boolean sale(Integer productId, Integer saleStatus);
}
