package com.typemoon.fate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author fandz
 * @since 2021-03-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Servant implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 公司名
     */
    private String username;

    private String password;

    private String nickname;

    private String mana;

    private String master;

    /**
     * 状态
     */
    private Integer state;


}
