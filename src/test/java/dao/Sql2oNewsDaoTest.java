package dao;

import models.News;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Sql2oNewsDaoTest {
    private static Sql2oNewsDao newsDao;
    private static Connection conn;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://ec2-54-146-4-66.compute-1.amazonaws.com:5432/dbnidr13lp3djo?sslmode=require";
        Sql2o sql2o = new Sql2o(connectionString, "fnkyesutqgwoik", "c9b6e3d07b6a38e18b90a1be3c996c364175a30831be43388c348ea2096f2aa6");
        newsDao = new Sql2oNewsDao(sql2o);
        conn = (Connection) sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Clearing database");
        newsDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("Connection closed");
    }

    @Test
    public void addingNewsSetsId() {
        News news = setUpNews();
        int originalNewsId = news.getId();
        newsDao.add(news);
        assertNotEquals(originalNewsId, news.getId());
    }

    @Test
    public void add_individualNewsCanBeFoundById() {
        News news = setUpNews();
        newsDao.add(news);
        News foundNews = newsDao.findById(news.getId());
        assertEquals(news, foundNews);
    }

    @Test
    public void findById_individualNewsCanBeFoundById() {
        News news = setUpNews();
        newsDao.add(news);
        News foundNews = newsDao.findById(news.getId());
        assertEquals(news, foundNews);
    }

    @Test
    public void getAll_allNewsAreReturnedCorrectly() {
        News news = setUpNews();
        newsDao.add(news);
        assertEquals(1, newsDao.getAll().size());
    }

    @Test
    public void getAll_nothingIsReturnedFromAnEmptyDatabase() {
        assertEquals(0, newsDao.getAll().size());
    }

    @Test
    public void update_newsIsUpdatedCorrectly() {
        News news = setUpNews();
        newsDao.add(news);
        int currentId = news.getId();
        newsDao.update(currentId, "maths", "maths subjects");
        News updatedNews = newsDao.findById(currentId);
        assertNotEquals(news, updatedNews);
    }

    @Test
    public void deleteById_individualNewsIsDeletedCorrectlyByItsId() {
        News news = setUpNews();
        News otherNews = new News("Schools to open","Mutali");
        newsDao.add(news);
        newsDao.add(otherNews);
        newsDao.deleteById(news.getId());
        assertEquals(1, newsDao.getAll().size());
    }

    @Test
    public void clearAll_allAddedNewsCanBeCleared() {
        News news = setUpNews();
        News otherNews = new News("Schools to open","Mutali");
        newsDao.add(news);
        newsDao.add(otherNews);
        newsDao.clearAll();
        assertEquals(0, newsDao.getAll().size());
    }

    public News setUpNews(){
        return new News("Schools to close", "M Kitavi");
    }
}