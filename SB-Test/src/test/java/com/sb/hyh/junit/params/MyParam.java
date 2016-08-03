package com.sb.hyh.junit.params;

public class MyParam {

    public boolean checkUser(String name, String pass) {
        boolean b = true;
        if (name.equalsIgnoreCase("aaa") && pass.equalsIgnoreCase("123")) {
            b = true;
        } else {
            b = false;
        }
        return b;
    }
}
