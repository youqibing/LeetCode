package JavaBasicKnowledge;

public class OverrideTest {
    public static void main (String[] args) {
        Animal h = new Horse();
        h.eat();

        Opertion o = new Horse();
        o.run(30);

    }
}

class Animal {
    public void eat(){
        System.out.println ("Animal is eating.");
    }
}

class Horse extends Animal implements Opertion{
    public void eat(){
        System.out.println ("Horse is eating.");
    }

    public void buck(){
    }


    @Override
    public void run(int time) {
        System.out.println ("Horse is run: "+ time +"s");
    }
}





