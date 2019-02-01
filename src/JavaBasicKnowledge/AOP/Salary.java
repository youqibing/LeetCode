package JavaBasicKnowledge.AOP;

/**
 * 要代理的类
 */
public class Salary implements SalaryInterface {

    public void doSalary() {
        System.out.println("doSalary");
    }
}
