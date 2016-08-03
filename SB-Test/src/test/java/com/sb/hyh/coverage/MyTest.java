package com.sb.hyh.coverage;

public class MyTest {

    public static String checkUser(String name) {
        if ("aaa".equals(name)) {
            return "OK";
        } else {
            return "NO";
        }
    }
}
