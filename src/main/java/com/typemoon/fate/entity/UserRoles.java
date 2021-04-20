package com.typemoon.fate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色权限表
 * </p>
 *
 * @author fandz
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色
     */
    private String username;

    /**
     * 权柄
     */
    private String roleName;


}
