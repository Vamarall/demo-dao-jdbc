package model.dao;

import db.DB;
import db.DbException;
import model.entities.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            // Verificar se o ID já existe
            st = conn.prepareStatement("SELECT 1 FROM department WHERE Id = ?");
            st.setInt(1, obj.getId());
            rs = st.executeQuery();

            if (rs.next()) { // Se houver resultados, o ID já existe
                throw new DbException("Error: Department with ID " + obj.getId() + " already exists.");
            }

            // Se não existir, insere o novo departamento
            st = conn.prepareStatement(
                    "INSERT INTO department " +
                            "(Id, Name) " +
                            "VALUES " +
                            "(?, ?)"
            );
            st.setInt(1, obj.getId());
            st.setString(2, obj.getName());
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }


    @Override
    public void update(Department obj) {

    }

    @Override
    public void deleteById(Integer id) {

        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "DELETE FROM department  " +
                            "WHERE Id = ? "
            );
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(

                    "SELECT * FROM department " +
                            "WHERE Id = ? "

            );
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Department dep = instanceOfDepartment(rs);
                return dep;
            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Department> findALl() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Department> list = new ArrayList<>();
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM department "
            );

            rs = st.executeQuery();

            while (rs.next()) {

                Department dep = instanceOfDepartment(rs);
                list.add(dep);

            }
            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);

        }
    }

    private Department instanceOfDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setName(rs.getString("Name"));
        dep.setId(rs.getInt("Id"));
        return dep;
    }
}
