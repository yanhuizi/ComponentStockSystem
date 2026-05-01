package dao;

import db.DBUtil;
import entity.InRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class InRecordDao {
    public int add(InRecord record) throws SQLException {
        String sql = """
                insert into in_record(component_id, quantity, operator, in_time, remark)
                values (?, ?, ?, ?, ?)
                """;
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, record.getComponentId());
            statement.setInt(2, record.getQuantity());
            statement.setString(3, record.getOperator());
            statement.setTimestamp(4, Timestamp.valueOf(record.getInTime()));
            statement.setString(5, record.getRemark());
            return statement.executeUpdate();
        }
    }
}
