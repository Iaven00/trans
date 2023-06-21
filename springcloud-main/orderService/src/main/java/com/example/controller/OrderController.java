package com.example.controller;



import com.example.pojo.Order;
import com.example.pojo.Records;
import com.example.service.RecordService;
import com.example.service.TransunitFeign;
import com.example.service.orderService;
import com.example.utils.StreamClient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.example.utils.Global.FINISH;
import static com.example.utils.Global.Shipped;

@RestController
@RequestMapping("/order")
@EnableBinding(StreamClient.class)
public class OrderController {


    @Autowired
    orderService orderservice;


    @Autowired
    RecordService recordService;

    @Resource
    StreamClient streamClient;



    /**
     * 列出用户的所有订单
     * @param pageNum
     * @param pageSize
     * @param userid
     * @return
     */
    @GetMapping("/list_order")
    @ResponseBody
    public List<Order> get_allrecords(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize, int userid){

        return orderservice.list_orders(userid);
    }




    /**
     * 根据收件人姓名查询订单
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/search_orderbyname")
    @ResponseBody
    public List<Order> get_recordsbyname(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize,int userid,String name){

        return orderservice.listbyrename(userid,name);
    }


    /**
     * 根据收获地址查询
     * @param pageNum
     * @param pageSize
     * @param userid
     * @param address
     * @return
     */
    @GetMapping("/search_orderbyaddress")
    @ResponseBody
    public List<Order> get_recordsbyaddress(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize,int userid,String address){

        return orderservice.listbyaddress(userid,address);
    }



    /**
     * 选择物流公司提交订单
     * @param order
     * @return
     */
    @PostMapping("/submit_order")
    @ResponseBody
    public int order(Order order){


        return orderservice.submit_order(order);
    }


    /**
     * 撤销订单（退款）
     * @param orderid
     * @return
     */
    @PostMapping("/revoke_order")
    @ResponseBody
    public int revoke(int orderid){

        return orderservice.delete_bill(orderid);
    }

    /**
     * 查看用户账单
     * @param userid
     * @return
     */
    @GetMapping("/search_bill")
    @ResponseBody
    public List<Order> search_bill(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize,int userid){

        return orderservice.search_bill(userid);
    }


    /**
     * 删除账单
     * @param orderid
     * @return
     */
    @PostMapping("/delete_bill")
    @ResponseBody
    public int delete_bill(int orderid){
        return orderservice.delete_bill(orderid);
    }


    /**
     * 物流员分配包裹
     * @param transunitid
     * @param orderid
     * @param rest
     * @return
     */
    @PostMapping("/allocation")
    @ResponseBody
    public int allocation(Integer transunitid,Integer orderid, Integer rest){


        if(transunitid<=0 || orderid<=0|| rest<=0){
            return 0;
        }
        String mes = ""+transunitid+"%"+rest;
        streamClient.streamDateOut().send(MessageBuilder.withPayload(mes).build());
        if(
                orderservice.update_trans(transunitid,orderid)>0 &&
                orderservice.update_state(orderid,Shipped) > 0 &&
                recordService.insert(orderid,Shipped) > 0
        ){
            return 1;
        }
        return 0;

    }

    /**
     * 根据时间顺序获取该订单的所有记录
     * @param orderid
     * @return
     */
    @GetMapping("/get_records")
    @ResponseBody
    public List<Records> get_records(int orderid){

        return recordService.getRecList(orderid);
    }


    /**
     * 接收包裹，对订单状态的更新
     * 以及对records的更新
     * @param orderid
     * @return
     */
    @PostMapping("/receive")
    @ResponseBody
    public int receive(int orderid){

        if(orderservice.update_state(orderid,FINISH)>0&&recordService.insert(orderid,FINISH)>0){
            return 1;
        }
        return 0;
    }

    @GetMapping("/selectAll")
    @ResponseBody
    public List<Order> selectall(){
        return orderservice.list_all();
    }


    @GetMapping("/selectBysp")
    @ResponseBody
    public List<Order> selectsp(String phone){
        return orderservice.listBysp(phone);
    }


    @GetMapping("/selectByrp")
    @ResponseBody
    public List<Order> selectByrp(String phone){
        return orderservice.listByrp(phone);
    }


    @PostMapping("/insertRecords")
    @ResponseBody
    public int insertRec(int orderid,String content){
        return recordService.insertBycontent(orderid,content);
    }



    @GetMapping("/produce")
    public void produce(int id,int rest) {
//        for (int i = 0; i < 100; i++) {
//            streamClient.streamDateOut().send(MessageBuilder.withPayload("aaaaaa" + i).build());
//        }
        String mes = ""+id+"%"+rest;
        streamClient.streamDateOut().send(MessageBuilder.withPayload(mes).build());
    }



}
