package com.brionac.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brionac.entity.domain.Purchase;
import com.brionac.service.PurchaseService;
import com.brionac.mapper.PurchaseMapper;
import org.springframework.stereotype.Service;

/**
* @author 亚修的小破机
* @description 针对表【purchase(采购表)】的数据库操作Service实现
* @createDate 2023-12-23 01:07:08
*/
@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase>
    implements PurchaseService {

}




