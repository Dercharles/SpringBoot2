package com.example.springboot2.yang.demo;

import com.example.springboot2.yang.config.TaskExecutorConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Thread1 extends Thread {
    private String name;

    public Thread1 (String name){
        this.name = name;
    }

    public void run(){
        for (int i = 0;i < 5;i++){
            System.out.println(name + "运行：" + i + name);
            try {
                sleep((int)Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);

        for (int i=0;i<100;i++){
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }
        context.close();

    }

}
