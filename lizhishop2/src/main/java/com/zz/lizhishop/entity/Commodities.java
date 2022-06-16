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
public class Commodities {
    private int ID;
    private String name;
    private String url;
    private String price;
    private int amount;
    private String owerAccount;
}
