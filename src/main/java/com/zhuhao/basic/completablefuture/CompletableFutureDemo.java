package com.zhuhao.basic.completablefuture;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author zhuhao
 * @Date 2021/7/5 21:32
 * @desc
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.completedFuture("a future value");

        System.out.println(future.get());
    }

    /**
     * 创建一个已经有结果值的CompletableFuture。
     * <p>
     * get方法：阻塞获取CompletableFuture的结果值，另外可以设置该方法的阻塞时间。
     * getNow方法：如果结果已经计算完则返回结果或者抛出异常，否则返回给定的valueIfAbsent值。
     * join方法：返回计算的结果或者抛出一个unchecked异常(CompletionException)。
     */
    @Test
    public void test01() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.completedFuture("a future value");
        System.out.println(future.get());
        System.out.println(future.join());
        System.out.println(future.getNow("123"));
    }

    /**
     * 异步执行不带返回值的异步任务
     * <p>
     * 异步执行带返回值的异步任务。
     */
    @Test
    public void test02() {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("不带返回值的异步任务");
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("带有返回值的异步任务");
            return "a future value";
        });
    }

    /**
     * // thenRun 处理 Runnable
     * public CompletableFuture<Void> thenRun(Runnable action);
     * public CompletableFuture<Void> thenRunAsync(Runnable action);
     * public CompletableFuture<Void> thenRunAsync(Runnable action, Executor executor);
     * <p>
     * // thenAccept 处理 Consumer
     * public CompletableFuture<Void> thenAccept(Consumer<? super T> action);
     * public CompletableFuture<Void> thenAcceptAsync(Consumer<? super T> action);
     * public CompletableFuture<Void> thenAcceptAsync(Consumer<? super T> action, Executor executor);
     * <p>
     * // thenApply 处理 Function
     * public <U> CompletableFuture<U> thenApply(Function<? super T,? extends U> fn);
     * public <U> CompletableFuture<U> thenApplyAsync(Function<? super T,? extends U> fn);
     * public <U> CompletableFuture<U> thenApplyAsync(Function<? super T,? extends U> fn, Executor executor);
     * <p>
     * // handle 处理 BiFunction
     * public <U> CompletableFuture<U> handle(BiFunction<? super T, Throwable, ? extends U> fn);
     * public <U> CompletableFuture<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn);
     * public <U> CompletableFuture<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn, Executor executor);
     */
    @Test
    public void test03() {
        //thenRun方法。执行异步任务，执行完后再接一个异步任务。
        CompletableFuture.runAsync(() -> {
            System.out.println("不带返回值的异步任务");
        }).thenRunAsync(() -> {
            System.out.println("前一个future后，再异步执行任务。");
        });


        //执行异步任务，并将结果给下一个异步任务，最后再返回结果值。
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("a future value");
            return "a future value";
        }).thenApplyAsync((String str) -> {
            return str.length();
        });
        System.out.println(future.join());
    }

    /**
     * 执行异步任务，并将结果给下一个异步任务，最后不返回结果值。
     */
    @Test
    public void test04() {
        CompletableFuture<Void> future = CompletableFuture
                .completedFuture("a future value")
                .thenAcceptAsync((String str) -> {
                    System.out.println("没有返回值，消费了字符串： " + str);
                });

        System.out.println(future.join());
    }
}
