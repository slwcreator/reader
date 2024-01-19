package com.slwer.reader.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Utils {
    public static String md5Digest(String source, Integer salt) {
        char[] c = source.toCharArray();
        for (int i = 0; i < c.length; i++) {
            c[i] = (char) (c[i] + salt);
        }
        return DigestUtils.md5Hex(new String(c));
    }
}
