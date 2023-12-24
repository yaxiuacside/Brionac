package com.brionac.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author 亚修的小破机
 * Description: 分页结果类
 * ClassName: PageResult
 * date: 2023/12/24
 */
@Schema(name = "分页结果类",description = "分页结果类, 记录分页结果")
@Data
public class PageResult<T> {
    @Schema(description = "数据")
    protected List<T> records;
    @Schema(description = "总数据的数据条数")
    protected long total;
    @Schema(description = "页数大小",defaultValue = "10")
    protected long size;
    @Schema(description = "当前页")
    protected long current;
}
