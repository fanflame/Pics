package com.ran.pics.activity.task;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by fanyiran on 15/5/14.
 */
public class ExecutorUtils {
    public static Executor getDefaultExecutor(){
        Executor executor = Executors.newCachedThreadPool();
        return executor;
    }
}
