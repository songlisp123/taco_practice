package com.tacho.applacation.Base;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.Arrays;
import java.util.List;

@Repository
public class JdbcOrderRepository implements OrderRepository {
    private JdbcOperations jdbcOperations;

    public JdbcOrderRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    @Transactional
    public TacoOrder save(TacoOrder order) {
        String sql = """
                INSERT INTO taco_order(delivery_name,delivery_street,delivery_city,
                delivery_state,delivery_provice,
                delivery_zip,cc_number,cc_expiration,cc_cvv,placed_at)
                VALUES(?,?,?,?,?,?,?,?,?)
                """;
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                sql,
                Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.TIMESTAMP
        );
        pscf.setReturnGeneratedKeys(true);
        PreparedStatementCreator psc  = pscf.newPreparedStatementCreator(
                Arrays.asList(
                        order.getDeliveryName(),
                        order.getDeliveryStreet(),
                        order.getDeliveryCity(),
                        order.getDeliveryState(),
                        order.getDeliveryProvince(),
                        order.getDeliveryZip(),
                        order.getCcNumber(),
                        order.getCcExpiration(),
                        order.getCcCVV(),
                        order.getCreateTime()
                )
        );
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcOperations.update(psc,holder);
        long orderId = holder.getKey().longValue();
        order.setId(orderId);
        List<Taco> tacos = order.getTacos();
        int i = 0;
        for (Taco taco:tacos) {
            saveTaco(orderId,i++,taco);
        }
        return order;
    }

    private void saveTaco(long orderId, int i, Taco taco) {

    }
}
