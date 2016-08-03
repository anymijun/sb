package com.sb.hyh.dbunit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyDBtester {
    private TestDB2 db2;

    @Before
    public void setUp() throws Exception {
        db2 = new TestDB2();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        try {
            db2.test1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            db2.test2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        try {
            db2.test3();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
