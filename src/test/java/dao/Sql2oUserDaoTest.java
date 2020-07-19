package dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oUserDaoTest {
    private static Sql2oUserDao userDao;
    private static Connection conn;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/news_portal_test";
        Sql2o sql2o = new Sql2o(connectionString, "vincent", "Taptet#2001");
        userDao = new Sql2oUserDao(sql2o);
        conn = (Connection) sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Clearing database");
        userDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("Connection closed");
    }

}