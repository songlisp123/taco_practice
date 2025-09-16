package com.tacho.applacation.Base;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
                VALUES(?,?,?,?,?,?,?,?,?,?)
                """;
        //PreparedStatementCreatorFactory类执行sql语句，并期望一个数据表的类型的列表
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                sql,
                Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.TIMESTAMP
        );
        //setReturnGeneratedKeys方法要求返回自主生成的键
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
        //holder方法将保留自动生成的id键，并将id键与模型字段id一一映射,在此事例中蒋返回taco订单id键
        //稍后将提取id键用来向taco表中建立联系。
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        //jdbcoperation的工作原理：创建连接，创建语句，执行sql
        jdbcOperations.update(psc,holder);
        //订单id号
        long orderId = holder.getKey().longValue();
        //设置实体类型的订单id号，为什么要这样子做?因为在表单中并没有对order对象绑定id字段
        order.setId(orderId);
        List<Taco> tacos = order.getTacos();
        int i = 0;
        for (Taco taco:tacos) {
            saveTaco(orderId,i++,taco);
        }
        return order;
    }

    private long saveTaco(long orderId, int orderKey, Taco taco) {

        String sql = """
                INSERT INTO taco(name,taco_order,taco_order_key,created_at)
                VALUES(?,?,?,?)
                """;

        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                sql,Types.VARCHAR,Types.BIGINT,Types.BIGINT,Types.TIMESTAMP);
        pscf.setReturnGeneratedKeys(true);
        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(
                        taco.getName(),
                        orderId,
                        orderKey,
                        taco.getCreateTime()
                )
        );

        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcOperations.update(psc,holder);
        long tacoId = holder.getKey().longValue();
        taco.setId(tacoId);
        saveIngredientRefs(tacoId,taco.getIngredients());
        return tacoId;

    }

    private void saveIngredientRefs(long tacoId,List<Ingredient> ingredients) {
        int key = 0;
        for (Ingredient ingredient : ingredients) {
            jdbcOperations.update("""
                    INSERT INTO Ingredient_Ref(ingredient,taco,taco_key)
                    VALUES(?,?,?)
                    """,ingredient.getId(),tacoId,key++);
        }
    }
}
