package JavaBasicKnowledge.AOP.advice;

import JavaBasicKnowledge.AOP.advice.Advice;

public class TimeAdvice implements Advice {
    long startTime;
    long endTime;

    @Override
    public void before() {
        startTime = System.nanoTime(); // 获取开始时间
        System.out.println(startTime+"");
    }

    @Override
    public void after() {
        endTime = System.nanoTime(); // 获取结束时间
        System.out.println(endTime+"");
    }
}