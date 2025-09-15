package com.tacho.applacation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Iterator;

import static
        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(HomeController.class)
public class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHomePage()  {
        try {
            mockMvc.perform(get("/"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("home"))
                    .andExpect(result -> {
                        //我需要获取响应的数据
                        MockHttpServletResponse response = result.getResponse();
                        MockHttpServletRequest request = result.getRequest();
                        Iterator<String> attributeNames =
                                request.getAttributeNames().asIterator();
                        while (attributeNames.hasNext()) {
                            System.out.println("=================================");
                            System.out.println(attributeNames.next());
                            System.out.println("=================================");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
