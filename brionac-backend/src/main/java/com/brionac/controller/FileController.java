package com.brionac.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.brionac.common.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

//设置跨域
@RestController
@RequestMapping("/files")
public class FileController {

    @Value("${server.port}")
    private String port;

    private static final String ip = "http://localhost";

    @Operation(summary = "上传文件",description = "上传文件",tags = "文件管理")
    @PostMapping("/upload")
    public Result<?> upload(MultipartFile file) throws IOException {
        // 定义文件的唯一标识
        String flag = IdUtil.fastSimpleUUID();
        // 获取文件的文件名
        String originalFilename = file.getOriginalFilename();
        // 拼接总的文件名
        String fileName = flag + "_" + originalFilename;
        // 获取上传的路径 拼接的路径为项目路径下的/resources/files/目录下
        String rootFilePath = System.getProperty("user.dir") + "/brionac-backend/src/main/resources/files/" + fileName;
        // 将文件写入你的路径
        FileUtil.writeBytes(file.getBytes(), rootFilePath);
        // 返回文件的URL
        return Result.success(ip + ":" + port + "/files/" + fileName);
    }

    @Operation(summary = "预览图片",description = "前端使用src标签绑定一个图片的时候就会使用到Get方法预览到网页上",tags = "文件管理")
    @Parameter(name = "fileName",description = "文件名",in = ParameterIn.PATH)
    @GetMapping("/{fileName}")
    public void getFiles(@PathVariable String fileName, HttpServletResponse response) {
        // 新建一个输出流
        OutputStream os;
//        导出路径
        String basePath = System.getProperty("user.dir") + "/brionac-backend/src/main/resources/files/";
//        找到所有的文件
//        List<String> fileNames = FileUtil.listFileNames(basePath);
//        找到对应的文件
//        String filename = fileNames.stream().filter(name -> name.contains(fileName)).findAny().orElse("");

        try {
            if (StrUtil.isNotEmpty(fileName)) {
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(basePath + fileName);
                os = response.getOutputStream();
                os.write(bytes);
                os.flush();
                os.close();
            }
        } catch (Exception e) {
            System.out.println("文件下载失败");
        }
    }
}
