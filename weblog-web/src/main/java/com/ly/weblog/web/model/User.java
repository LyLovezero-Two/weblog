package com.ly.weblog.web.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;



/**
 * @author: 骆洋
 * @date: 2025/11/22 15:06
 * @description: User
 **/
@Data
@Schema(name = "User", description = "用户实体类")
public class User {
    //用户名
    @NotBlank(message = "用户名不能为空")
    @Schema(description = "用户名")
    private String username;
    //性别
    @NotNull(message = "性别不能为空")
    @Schema(description = "性别")
    private Integer sex;
    //年龄
    @NotNull(message = "年龄不能为空")
    @Min(value = 18, message = "年龄不能小于18岁")
    @Max(value = 100, message = "年龄不能大于100岁")
    @Schema(description = "年龄")
    private Integer age;
    //邮箱
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    @Schema(description = "邮箱")
    private String email;
}
