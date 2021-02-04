package com.swf.cat.test.catclient.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author weifei.song
 * @date 2021/1/17 14:42
 */
@RestController
public class ThreadPoolController {

    ThreadPoolExecutor executor=new ThreadPoolExecutor(10,10,60L, TimeUnit.SECONDS,new LinkedBlockingQueue<>(100));


    @RequestMapping("getCore")
    public String getCoreSize(){
       return String.valueOf(executor.getCorePoolSize());
    }

    @RequestMapping("setCore")
    public String setCoreSize(){
        executor.setCorePoolSize(30);
        return "success";
    }

}
