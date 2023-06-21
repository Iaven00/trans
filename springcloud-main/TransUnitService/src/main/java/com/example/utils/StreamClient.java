package com.example.utils;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;




public interface StreamClient {
    String STREAM_DEMO = "stream-demo";

    @Input(StreamClient.STREAM_DEMO)
    SubscribableChannel streamDateInput();	//SubscribableChannel与生产者处写的不一样，此处为接收信息
}