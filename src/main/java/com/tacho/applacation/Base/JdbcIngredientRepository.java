package com.tacho.applacation.Base;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Iterable<Ingredient> findAll() {
        String sql = """
                SELECT id,name,type FROM ingredient
                """;
        return jdbcTemplate.query(sql,this::mapRowToIngredient);
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        String sql = """
                SELECT id,name,type FROM ingredient WHERE id=?
                """;
        List<Ingredient> results =
                jdbcTemplate.query(sql,this::mapRowToIngredient,id);
        return results.isEmpty() ?
                Optional.empty():Optional.of(results.getFirst());
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        String sql = """
                INSERT INTO ingredient(id,name,type) VALUES(?,?,?)
                """;
        jdbcTemplate.update(sql,
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet row,int rowNumber) throws SQLException {
        return new Ingredient(
                row.getString("id"),
                row.getString("name"),
                Ingredient.Type.valueOf(row.getString("type"))
        );
    }
}
