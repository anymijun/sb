package com.sb.hyh.coverage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyTestTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCheckUser() {
        assertEquals("OK", MyTest.checkUser("aaa"));
        // assertEquals("NO",mt.checkUser("aaa2"));
    }
}
