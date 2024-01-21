package com.comarch.camp.it.rent.car;

import org.apache.commons.codec.digest.DigestUtils;

public class Test {
    public static void main(String[] args) {
        String seed = "v_#(jxXlmQ+Eh&[k[^Xtu{26=;GT_cW${;KhjVQ.";
        String haslo = "mateusz123";

        String hash = DigestUtils.md5Hex(haslo+seed);

        System.out.println(hash);
    }
}
