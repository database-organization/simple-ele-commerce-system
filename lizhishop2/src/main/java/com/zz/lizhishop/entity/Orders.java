package com.zz.lizhishop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Timer;

/**
 * @author Bamboo
 * @school GUET
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private int ID;
    private String co_account;
    private String sh_account;
    private int com_ID;
    private int amount;
    private String is_pay;
    private double total;
    private Timer time;
}
