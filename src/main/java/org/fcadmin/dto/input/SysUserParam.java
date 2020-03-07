package org.fcadmin.dto.input;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.fcadmin.utils.JsonInt2Bool;

import javax.validation.constraints.NotNull;

@Data
public class SysUserParam {
    private Integer id;
    @NotNull(message = "姓名不可以为空")
    private String username;
    @NotNull(message = "昵称不可以为空")
    private String nickName;
    @NotNull(message = "性别不可以为空")
    private String sex;
    private String phone;
    private String email;
    private String avatar;
    @NotNull(message = "flag不可以为空")
    @JsonDeserialize(using = JsonInt2Bool.class)
    private Boolean flag;
    private String token;
    private String openId;

}
