package JavaBasicKnowledge.AOP;

import JavaBasicKnowledge.AOP.advice.ControlAdvice;
import JavaBasicKnowledge.AOP.advice.TimeAdvice;
import JavaBasicKnowledge.AOP.proxy.SimpleProxy;

public class Client {
    public static void main(String[] args) {
        SimpleProxy simpleProxy = new SimpleProxy();
        //SalaryInterface salaryInterface = (SalaryInterface) simpleProxy.bind(new Salary(), new TimeAdvice());
        SalaryInterface salaryInterface = (SalaryInterface) simpleProxy.bind(new Salary(), new ControlAdvice());
        salaryInterface.doSalary();
    }
}
