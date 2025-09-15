package com.tacho.applacation.Base;

//import lombok.Data;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TacoOrder implements Serializable {
    private static final Long serialVersionId = 1L;
    private Date createTime = new Date();
    private Long id;

    @NotBlank(message = "发送人不能为空")
    private String deliveryName;

    @NotBlank(message = "收货地址不能为空")
    private String deliveryStreet;

    @NotBlank(message = "送达城市不能为空")
    private String deliveryCity;

    @NotBlank(message = "送达市不能为空")
    private String deliveryState;

    @NotBlank(message = "送达省不能为空")
    private String deliveryProvince;

    @NotBlank(message = "邮政编码不能为空")
    private String deliveryZip;

//    @CreditCardNumber(message = "银行卡号不能为空")
    private String ccNumber;

    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();
    public void addTaco(Taco taco) {
        tacos.add(taco);
    }

}
