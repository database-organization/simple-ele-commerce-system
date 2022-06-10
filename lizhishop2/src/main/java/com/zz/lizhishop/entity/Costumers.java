package com.zz.lizhishop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bamboo
 * @school GUET
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Costumers {
    private String account;
    private String password;
    private double balance;
    private String address;
}
