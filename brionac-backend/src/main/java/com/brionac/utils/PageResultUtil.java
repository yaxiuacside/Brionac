package com.brionac.utils;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brionac.common.PageResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 亚修的小破机
 * Description:
 * ClassName: PageResultUtil
 * date: 2023/12/24
 */
public class PageResultUtil<T> {
    public static<T> PageResult<T> getPageResult(Page<T> page){
        PageResult<T> pageResult = new PageResult<>();
        BeanUtil.copyProperties(page,pageResult);
        return pageResult;
    }

    public static<T> Page<T> listToPage(List<T> list, int pageNum, int pageSize){
        List<T> pageList = new ArrayList<>();
        int curIdx = pageNum > 1 ? (pageNum - 1) * pageSize : 0;
        for (int i = 0; i < pageSize && curIdx + i < list.size(); i++) {
            pageList.add(list.get(curIdx + i));
        }
        Page<T> page = new Page<>(pageNum, pageSize);
        page.setRecords(pageList);
        page.setTotal(list.size());
        return page;
    }

}
