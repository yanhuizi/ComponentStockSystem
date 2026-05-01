package dao;

import db.DBUtil;
import entity.StorageLocation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StorageLocationDao {
    public List<StorageLocation> findAll() throws SQLException {
        String sql = "select id, code, name, remark from storage_location order by code";
        List<StorageLocation> locations = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                locations.add(new StorageLocation(
                        resultSet.getInt("id"),
                        resultSet.getString("code"),
                        resultSet.getString("name"),
                        resultSet.getString("remark")
                ));
            }
        }
        return locations;
    }
}
