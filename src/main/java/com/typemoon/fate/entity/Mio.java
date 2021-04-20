package com.typemoon.fate.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * >v<
 * </p>
 *
 * @author fandz
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Mio implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;


}
