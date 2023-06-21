package com.example.utils;



import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;


public interface StreamClient {
    String STREAM_DEMO = "stream-demo";

    @Output(StreamClient.STREAM_DEMO)
    MessageChannel streamDateOut();
}
