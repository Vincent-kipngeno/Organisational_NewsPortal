package dao;

import models.Department;
import org.junit.*;
import org.sql2o.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Sql2oDepartmentDaoTest {
    private static Sql2oDepartmentDao departmentDao;
    private static Connection conn;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/news_portal_test";
        Sql2o sql2o = new Sql2o(connectionString, "vincent", "Taptet#2001");
        departmentDao = new Sql2oDepartmentDao(sql2o);
        conn = (Connection) sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Clearing database");
        departmentDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("Connection closed");
    }

    @Test
    public void addingDepartmentsSetsId() {
        Department department = setNewDepartment();
        int originalDepartmentId = department.getId();
        departmentDao.add(department);
        assertNotEquals(originalDepartmentId, department.getId());
    }

    @Test
    public void add_individualDepartmentsCanBeFoundById() {
        Department department = setNewDepartment();
        departmentDao.add(department);
        Department foundDepartment = departmentDao.findById(department.getId());
        assertEquals(department, foundDepartment);
    }

    @Test
    public void findById_individualDepartmentCanBeFoundById() {
        Department department = setNewDepartment();
        departmentDao.add(department);
        Department foundDepartment = departmentDao.findById(department.getId());
        assertEquals(department, foundDepartment);
    }

    @Test
    public void getAll_allDepartmentAreReturnedCorrectly() {
        Department department = setNewDepartment();
        departmentDao.add(department);
        assertEquals(1, departmentDao.getAll().size());
    }

    @Test
    public void getAll_nothingIsReturnedFromAnEmptyDatabase() {
        assertEquals(0, departmentDao.getAll().size());
    }

    @Test
    public void update_departmentIsUpdatedCorrectly() {
        Department department = setNewDepartment();
        departmentDao.add(department);
        int currentId = department.getId();
        departmentDao.update(currentId, "maths", "maths subjects", 2);
        Department updatedDepartment = departmentDao.findById(currentId);
        assertNotEquals(department, updatedDepartment);
    }

    @Test
    public void deleteById_individualDepartmentIsDeletedCorrectlyByItsId() {
        Department department = setNewDepartment();
        Department otherDepartment = new Department("Maths","maths subjects", 1);
        departmentDao.add(department);
        departmentDao.add(otherDepartment);
        departmentDao.deleteById(department.getId());
        assertEquals(1, departmentDao.getAll().size());
    }

    @Test
    public void clearAll_allAddedDepartmentCanBeCleared() {
        Department department = setNewDepartment();
        Department otherDepartment = new Department("Maths","Maths subjects", 1);
        departmentDao.add(department);
        departmentDao.add(otherDepartment);
        departmentDao.clearAll();
        assertEquals(0, departmentDao.getAll().size());
    }

    public Department setNewDepartment(){
        return new Department("Science", "science subjects", 5);
    }
}