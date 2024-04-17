package org.example.expensetracking.configuration;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;
import java.util.UUID;

public class UUIDTypeHandler extends BaseTypeHandler<UUID> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, UUID parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.toString());
    }

    @Override
    public UUID getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return UUID.fromString(rs.getString(columnName));
    }

    @Override
    public UUID getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return UUID.fromString(rs.getString(columnIndex));
    }

    @Override
    public UUID getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return UUID.fromString(cs.getString(columnIndex));
    }


    @Override
    public void setParameter(PreparedStatement ps, int i, UUID parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter, Types.OTHER);
    }

    @Override
    public UUID getResult(ResultSet rs, String columnName) throws SQLException {
        return (UUID) rs.getObject(columnName);
    }

    @Override
    public UUID getResult(ResultSet rs, int columnIndex) throws SQLException {
        return (UUID) rs.getObject(columnIndex);
    }

    @Override
    public UUID getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return (UUID) cs.getObject(columnIndex);
    }
}