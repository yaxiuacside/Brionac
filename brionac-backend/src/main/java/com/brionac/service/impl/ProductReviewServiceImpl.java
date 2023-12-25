package com.brionac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brionac.entity.domain.BrionacOrder;
import com.brionac.entity.domain.ProductReview;
import com.brionac.entity.domain.User;
import com.brionac.entity.requests.ProductEvaluateRequest;
import com.brionac.service.BrionacOrderService;
import com.brionac.service.ProductReviewService;
import com.brionac.mapper.ProductReviewMapper;
import com.brionac.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 亚修的小破机
* @description 针对表【product_review(商品评价)】的数据库操作Service实现
* @createDate 2023-12-23 01:07:08
*/
@Service
public class ProductReviewServiceImpl extends ServiceImpl<ProductReviewMapper, ProductReview>
    implements ProductReviewService {


    @Override
    public boolean savaReview(ProductEvaluateRequest request, User user) {
        ProductReview productReview = new ProductReview();

        BeanUtil.copyProperties(request, productReview);

        productReview.setUserId(user.getUserId());
        productReview.setAccountNumber(user.getAccountNumber());
        //拿到订单信息
        return this.save(productReview);
    }
}




