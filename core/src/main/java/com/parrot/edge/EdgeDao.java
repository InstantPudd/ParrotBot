package com.parrot.edge;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class EdgeDao {

    private static final RowMapper<Edge> ROW_MAPPER = new BeanPropertyRowMapper<>(Edge.class);

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private GeneratedKeyHolder generatedKeyHolder;

    public Optional<Edge> getEdge(long id) {
        try {
            return Optional.of(
                namedParameterJdbcTemplate.queryForObject(
                    "SELECT " +
                        "id, " +
                        "idVertexFrom, " +
                        "idVertexTo, " +
                        "numOccurrences " +
                    "FROM " +
                        "Edge " +
                    "WHERE " +
                        "id=%id",
                    ImmutableMap.of("id", id),
                    ROW_MAPPER
                )
            );
        } catch(EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public long createEdge(CreateEdgeRequest request) {
        namedParameterJdbcTemplate.update(
            "INSERT INTO Edge (" +
                "idVertexFrom, " +
                "idVertexTo, " +
                "numOccurrences " +
            ") VALUES (" +
                ":idVertexFrom, " +
                ":idVertexTo, " +
                ":numOccurrences " +
            ")",
            new MapSqlParameterSource(
                ImmutableMap.<String, Object>builder()
                    .put("idVertexFrom", request.getIdVertexFrom())
                    .put("idVertexTo", request.getIdVertexTo())
                    .put("numOccurrences", request.getNumOccurrences())
                    .build()
            ),
            generatedKeyHolder
        );

        return generatedKeyHolder.getKey().longValue();
    }

    public void incrementOccurrence(long idEdge, int incrementAmount) {
        namedParameterJdbcTemplate.update(
            "UPDATE Edge SET " +
                "numOccurrences=numOccurrences + :incrementAmount " +
            "WHERE " +
                "id = :id",
            ImmutableMap.of("numOccurrencesToAdd", incrementAmount)
        );
    }
}
