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
public class ShoppingCar {
    private String co_account;
    private int com_ID;
    private int amount;
    private boolean operate;
}
