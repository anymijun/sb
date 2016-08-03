package com.sb.hyh.dbunit;

import java.io.FileInputStream;
import org.dbunit.DBTestCase;
import org.dbunit.Assertion;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;

public class TestDB2 extends DBTestCase {

    public TestDB2() {
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost/test");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "root");
    }

    // 必须实现数据库集合返回接口,供后续测试比对使用
    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSet(new FileInputStream("dbunit.xml"));
    }

    // 进行结构比较
    public void test1() throws Exception {
        // 从数据库里读取记录
        IDataSet dbDataSet = getConnection().createDataSet();
        ITable dbTable = dbDataSet.getTable("user");

        // 从备份文件里读取记录
        IDataSet xmlDataSet = new FlatXmlDataSet(new FileInputStream("dbunit.xml"));
        ITable xmlTable = xmlDataSet.getTable("user");

        // 判断数据源记录与备份记录是否一致
        Assertion.assertEquals(xmlTable, dbTable);
    }

    // 表结构和dbunit3.xml结构不一致
    public void test2() throws Exception {
        // 从数据库里获取表结构
        IDataSet dbDataSet = getConnection().createDataSet();
        ITable dbTable = dbDataSet.getTable("user");

        // 从用例里获取表结构
        IDataSet xmlDataSet = new FlatXmlDataSet(new FileInputStream("dbunit2.xml"));
        ITable xmlTable = xmlDataSet.getTable("user");
        // 第一种写法
        // dbTable =
        // DefaultColumnFilter.includedColumnsTable(dbTable,xmlTable.getTableMetaData().getColumns());
        // 第二种写法
        // 设置表结构用于比较
        dbTable = DefaultColumnFilter.includedColumnsTable(dbTable, xmlDataSet.getTableMetaData("user").getColumns());
        // 比较断言判断表结构是否一致
        Assertion.assertEquals(xmlTable, dbTable);
    }

    // 只比较name
    public void test3() throws Exception {
        // 从数据库里获取记录
        IDataSet dbDataSet = getConnection().createDataSet();
        ITable dbTable = dbDataSet.getTable("user");

        // 从备份文件获取记录
        IDataSet xmlDataSet = new FlatXmlDataSet(new FileInputStream("dbunit3.xml"));
        ITable xmlTable = xmlDataSet.getTable("user");

        // 排除不用于比较的列，只比较用户名
        dbTable = DefaultColumnFilter.excludedColumnsTable(dbTable, new String[] { "id", "age" });
        xmlTable = DefaultColumnFilter.excludedColumnsTable(xmlTable, new String[] { "id", "age" });

        // 断言比较结果
        Assertion.assertEquals(xmlTable, dbTable);
    }

    // 在把xml里的数据导入到db里之前，需要对数据库里的表的数据做的操作。
    @Override
    protected DatabaseOperation getSetUpOperation() throws Exception {
        System.out.println("setup...");
        // 测试前清空插入的测试记录
        return DatabaseOperation.CLEAN_INSERT;
    }

    // 测试执行完以后，需要对数据库里的表里的数据做的操作
    @Override
    protected DatabaseOperation getTearDownOperation() throws Exception {
        System.out.println("teardown...");
        // 测试后删除插入的测试记录
        return DatabaseOperation.DELETE_ALL;
    }
}
