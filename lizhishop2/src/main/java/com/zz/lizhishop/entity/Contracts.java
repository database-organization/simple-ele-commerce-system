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
public class Contracts {
    int ID;
    String sh_account;
    String ch_account;
    int com_ID;
    int amount;
    int total;
    String time;
}
