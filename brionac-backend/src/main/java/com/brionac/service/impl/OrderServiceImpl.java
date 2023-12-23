package com.brionac.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brionac.entity.domain.Order;
import com.brionac.service.OrderService;
import com.brionac.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
* @author 亚修的小破机
* @description 针对表【order(订单表)】的数据库操作Service实现
* @createDate 2023-12-23 01:07:08
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService {

}




