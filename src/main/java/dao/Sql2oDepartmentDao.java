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
        String sql = "INSERT INTO departments (name, description, noofemployees) VALUES (:name, :description, :noOfEmployees);";
        try (Connection conn = sql2o.open()) {
            int id = (int) conn.createQuery(sql, true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Department> getAll() {
        String sql = "SELECT * FROM departments;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Department.class);
        }
    }

    @Override
    public Department findById(int id) {
        String sql = "SELECT * FROM departments WHERE id = :id;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Department.class);
        }
    }

    @Override
    public void update(int id, String name, String description, int noOfEmployees) {
        String sql = "UPDATE departments SET (name, description, noofemployees) = (:name, :description, :noOfEmployees) ";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("description", description)
                    .addParameter("noOfEmployees", noOfEmployees)
                    .executeUpdate();
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM departments WHERE id = :id ;";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE FROM departments;";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        }
    }
}
