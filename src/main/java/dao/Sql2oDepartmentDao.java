package dao;

import models.Department;
import org.sql2o.*;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao {
    private final Sql2o sql2o;

    public Sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Department department) {

    }

    @Override
    public List<Department> getAll() {
        return null;
    }

    @Override
    public Department findById(int id) {
        return null;
    }

    @Override
    public void update(int id, String name, String description, int noOfEmployees) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}
