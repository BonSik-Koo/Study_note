package com.example.spring.bulk_insert;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BulkJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    public void saveALL(List<Bulk> bulks) {
        final String sql = "INSERT INTO bulk(name) VALUES (?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Bulk bulk = bulks.get(i);
                ps.setString(1, bulk.getName());
            }

            @Override
            public int getBatchSize() {
                return bulks.size();
            }
        });
    }

}
