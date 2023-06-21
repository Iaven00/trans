package com.yufop.tran.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    // 创建 MockMvc 对象
    @Autowired
    WebApplicationContext webApplicationContext;
    MockMvc mockMvc;

    // Before 就是每次运行测试类之前就会执行下边的函数
    @BeforeEach
    void setUp(){
        //自动去查找Controller
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    void listordersp() {
        // mockMvc.perform执行一个请求
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            // MockMvcRequestBuilders.get("XXX")代表get请求指定路径xxx
                            .post("/order/selectBysp")
                            // 设置返回类型
                            .accept(MediaType.APPLICATION_JSON_VALUE)
                    // 添加请求参数
                    .param("phone","18224426057")
            )		//ResultActions.andExpect添加执行完成后的断言
                    .andExpect(MockMvcResultMatchers.status().isOk())
//                    .andExpect(MockMvcResultMatchers.content().string("Hello zxd, I'm SpringBoot!"))
                    //添加一个结果处理器，表示要对结果做点什么事情
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void listorderrp() {
        // mockMvc.perform执行一个请求
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            // MockMvcRequestBuilders.get("XXX")代表get请求指定路径xxx
                            .post("/order/selectByrp")
                            // 设置返回类型
                    .param("phone","18224426057")
                            .accept(MediaType.APPLICATION_JSON_VALUE)
                    // 添加请求参数
            )		//ResultActions.andExpect添加执行完成后的断言
                    .andExpect(MockMvcResultMatchers.status().isOk())
//                    .andExpect(MockMvcResultMatchers.content().string("Hello zxd, I'm SpringBoot!"))
                    //添加一个结果处理器，表示要对结果做点什么事情
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void listorder() {
        // mockMvc.perform执行一个请求
        try {
            mockMvc.perform(MockMvcRequestBuilders
                    // MockMvcRequestBuilders.get("XXX")代表get请求指定路径xxx
                    .post("/order/selectAll")
                    // 设置返回类型
                    .accept(MediaType.APPLICATION_JSON_VALUE)
                    // 添加请求参数
            )		//ResultActions.andExpect添加执行完成后的断言
                    .andExpect(MockMvcResultMatchers.status().isOk())
//                    .andExpect(MockMvcResultMatchers.content().string("Hello zxd, I'm SpringBoot!"))
                    //添加一个结果处理器，表示要对结果做点什么事情
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void newOrder() {
//        // mockMvc.perform执行一个请求
//        try {
//            mockMvc.perform(MockMvcRequestBuilders
//                            // MockMvcRequestBuilders.get("XXX")代表get请求指定路径xxx
//                            .post("/order/selectAll")
//                            // 设置返回类型
//                            .accept(MediaType.APPLICATION_JSON_VALUE)
//                    // 添加请求参数
//            )		//ResultActions.andExpect添加执行完成后的断言
//                    .andExpect(MockMvcResultMatchers.status().isOk())
////                    .andExpect(MockMvcResultMatchers.content().string("Hello zxd, I'm SpringBoot!"))
//                    //添加一个结果处理器，表示要对结果做点什么事情
//                    .andDo(MockMvcResultHandlers.print());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Test
    void myOrder() {
        // mockMvc.perform执行一个请求
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            // MockMvcRequestBuilders.get("XXX")代表get请求指定路径xxx
                            .post("/order/myOrder")
                            // 设置返回类型
                            .accept(MediaType.APPLICATION_JSON_VALUE)
                    // 添加请求参数
            )		//ResultActions.andExpect添加执行完成后的断言
                    .andExpect(MockMvcResultMatchers.status().isOk())
//                    .andExpect(MockMvcResultMatchers.content().string("Hello zxd, I'm SpringBoot!"))
                    //添加一个结果处理器，表示要对结果做点什么事情
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}