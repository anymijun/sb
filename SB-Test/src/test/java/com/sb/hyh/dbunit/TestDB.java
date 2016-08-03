package com.sb.hyh.dbunit;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;

/**
 * create table user ( id int primary key auto_increment, name varchar(20), age
 * int ); insert into user(name,age) values('hong',11); insert into
 * user(name,age) values('yihui',11); insert into user(name,age)
 * values('huang',11);
 */
public class TestDB {
    /**
     * 备份
     */
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");
        IDatabaseConnection connection = new DatabaseConnection(conn);

        QueryDataSet dataSet = new QueryDataSet(connection);
        DatabaseConfig config = connection.getConfig();
        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
        // dataSet.addTable("user");
        dataSet.addTable("user", "select * from user where id < 2");
        FlatXmlDataSet.write(dataSet, new FileOutputStream("dbunit.xml"));
    }
}
