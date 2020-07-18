package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {

    @Test
    public void newDepartment_departmentInstantiatesCorrectly() {
        Department department = setupDepartment();
        assertTrue(department instanceof  Department);
    }

    @Test
    public void getName_departmentIstantiatesWithNameCorrectly() {
        Department department = setupDepartment();
        assertEquals("Science", department.getName());
    }

    @Test
    public void getDescription_departmentIstantiatesWithDescriptionCorrectly() {
        Department department = setupDepartment();
        assertEquals("Science subjects", department.getDescription());
    }

    @Test
    public void getNoOfEmployees_departmentIstantiatesWithNoOfEmployeesCorrectly() {
        Department department = setupDepartment();
        assertEquals(5, department.getNoOfEmployees());
    }

    @Test
    public void getId_departmentIstantiatesWithIdCorrectly() {
        Department department = setupDepartment();
        department.setId(1);
        assertEquals(1, department.getId());
    }

    @Test
    public void setName_nameCanBeSetCorrectly() {
        Department department = setupDepartment();
        department.setName("Maths");
        assertEquals("Maths", department.getName());
    }

    @Test
    public void setDescription_descriptionCanBeSetCorrectly() {
        Department department = setupDepartment();
        department.setDescription("Maths");
        assertEquals("Maths", department.getDescription());
    }

    @Test
    public void setNoOfEmployees_noOfEmployeesCanBeSetCorrectly() {
        Department department = setupDepartment();
        department.setNoOfEmployees(1);
        assertEquals(1, department.getNoOfEmployees());
    }

    //helpers
    public Department setupDepartment() {
        return new Department("Science", "Science subjects", 5);
    }
}