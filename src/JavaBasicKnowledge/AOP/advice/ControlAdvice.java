package JavaBasicKnowledge.AOP.advice;

public class ControlAdvice implements Advice {
    @Override
    public void before() {
        System.out.println("增强控制条件 before");
    }

    @Override
    public void after() {
        System.out.println("增强控制条件 after");
    }
}