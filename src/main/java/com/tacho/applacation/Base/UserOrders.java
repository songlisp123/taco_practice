package com.tacho.applacation.Base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOrders {
    private List<User> userLists = new ArrayList<>();

    public void add(User user) {
        userLists.add(user);
    }
}
