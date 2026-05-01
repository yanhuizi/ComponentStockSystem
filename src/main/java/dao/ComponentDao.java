package dao;

import db.DBUtil;
import entity.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComponentDao {
    public List<Component> findAll() throws SQLException {
        String sql = """
                select id, name, model, category_id, location_id, stock, warning_quantity, remark
                from component
                order by id
                """;
        List<Component> components = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                components.add(new Component(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("model"),
                        resultSet.getInt("category_id"),
                        resultSet.getInt("location_id"),
                        resultSet.getInt("stock"),
                        resultSet.getInt("warning_quantity"),
                        resultSet.getString("remark")
                ));
            }
        }
        return components;
    }
}
