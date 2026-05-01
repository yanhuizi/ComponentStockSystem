package dao;

import db.DBUtil;
import entity.OutRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class OutRecordDao {
    public int add(OutRecord record) throws SQLException {
        String sql = """
                insert into out_record(component_id, quantity, operator, out_time, remark)
                values (?, ?, ?, ?, ?)
                """;
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, record.getComponentId());
            statement.setInt(2, record.getQuantity());
            statement.setString(3, record.getOperator());
            statement.setTimestamp(4, Timestamp.valueOf(record.getOutTime()));
            statement.setString(5, record.getRemark());
            return statement.executeUpdate();
        }
    }
}
