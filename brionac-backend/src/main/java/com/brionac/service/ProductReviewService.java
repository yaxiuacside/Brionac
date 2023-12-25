package com.brionac.service;

import com.brionac.entity.domain.ProductReview;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brionac.entity.domain.User;
import com.brionac.entity.requests.ProductEvaluateRequest;

/**
* @author 亚修的小破机
* @description 针对表【product_review(商品评价)】的数据库操作Service
* @createDate 2023-12-23 01:07:08
*/
public interface ProductReviewService extends IService<ProductReview> {

    /**
     * 添加评论
     * @param request
     * @param user
     * @return
     */
    boolean savaReview(ProductEvaluateRequest request, User user);
}
