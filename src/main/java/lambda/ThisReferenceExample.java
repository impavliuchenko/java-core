package lambda;

import lambda.interfaces.Process;

//show the difference between lambda and anonymous class by special keyword 'this'
public class ThisReferenceExample {

    public static void main(String[] args) {
        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();

        //call method by creating an anonymous class:
        thisReferenceExample.doProcess(1, new Process() {
            @Override
            public void process(int i) {
                System.out.println("i = " + i);
                System.out.println("this = " + this);
            }

            @Override
            public String toString() {
                return "anonymous class...";
            }
        });

        //call method by lambda expressions
        thisReferenceExample.doProcess(2, i -> {
            System.out.println("i = " + i);

//            Can't use 'this', because this reference is actually unmodified,
//            so the error will be like "ThisReferenceExample.this cannot be referenced from a static context" -
//            that's the difference
//
//            System.out.println("this = " + this); - not work!
        });

        //call the same from non-static method. all is ok
        thisReferenceExample.execute();


    }

    private void doProcess(int i, Process p){
        p.process(i);
    }

    private void execute(){
        doProcess(2, i -> {
            System.out.println("i = " + i);
            System.out.println("this = " + this);
        });
    }

    @Override
    public String toString() {
        return "ThisReferenceExample class instance";
    }
}
