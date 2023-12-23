package com.brionac.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brionac.entity.domain.ProductReview;
import com.brionac.service.ProductReviewService;
import com.brionac.mapper.ProductReviewMapper;
import org.springframework.stereotype.Service;

/**
* @author 亚修的小破机
* @description 针对表【product_review(商品评价)】的数据库操作Service实现
* @createDate 2023-12-23 01:07:08
*/
@Service
public class ProductReviewServiceImpl extends ServiceImpl<ProductReviewMapper, ProductReview>
    implements ProductReviewService {

}




