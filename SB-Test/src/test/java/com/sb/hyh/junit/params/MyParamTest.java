package com.sb.hyh.junit.params;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MyParamTest {
    private MyParam t;
    private String name;
    private String pass;
    private boolean result;

    public MyParamTest(String name, String pass, boolean result) {
        this.name = name;
        this.pass = pass;
        this.result = result;
    }

    @Parameters
    public static Collection<Object[]> multipleValues() {
        System.out.println("Initialize Data!");
        return Arrays.asList(new Object[][] { { "aaa", "123", true }, { "", "", false }, { "aaa", "234", false },
                { "", "", false } });
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("类实例化前被调用");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("类实例化被释放后调用");
    }

    @Before
    public void setUp() throws Exception {
        t = new MyParam();
        System.out.println("开始测试前被调用");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("测试结束后被调用");
    }

    @Test
    public void testCheckUser() {
        System.out.println("执行测试");
        // 输入值与期望值以及执行条件
        assertEquals(result, t.checkUser(name, pass));
    }
}
