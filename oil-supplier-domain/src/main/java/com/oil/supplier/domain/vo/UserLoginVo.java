package com.oil.supplier.domain.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
/**
 * Created with IntelliJ IDEA.
 * User: guowenjuan
 * Date: 16-1-14
 * Time: 下午3:27
 * To change this template use File | Settings | File Templates.
 */
public class UserLoginVo extends VoBaseObject {

    private static final long serialVersionUID = 1L;

    private Long id;
    @NotNull(message = "用户名为空！")
    @Pattern(regexp = "^1\\d{10}$", message = "用户名不正确")
    private String userId;
    @NotNull(message = "密码为空！")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
