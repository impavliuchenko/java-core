package primitives;

public class Main {

    char c;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;

    public static void main(String[] args) {
        new Main().work();
    }

    void work() {
        print();

        //byte
        b = (byte) 128; //out of range, so it's -128. be careful with casting
        System.out.println(b);
        System.out.println();


        //char
        c = 'a';
        System.out.println(c++); //the same, don't need to cast
        System.out.println(c); // + 1
        System.out.println(++c); // + 1, don't need to cast
        c += 65536; // don't need to cast
        System.out.println(c);
        c = (char) (c + 1); //need to cast
        System.out.println(c);

        char c, ch2;

        c = 65535;
        c ++; //65536 = 1 0000 0000 0000 0000 out of range, so it's cut to 0000 0000 0000 0000 - the first char!
        System.out.println(c);
        c = (char) (c + 100);
        ch2 = 100;
        System.out.println("" + c + " = " + ch2);

        c = (char) b; // can't do c = b!
    }

    void print() {
        System.out.println("char: " + c + " " +
                        "byte: " + b + " " +
                        "short: " + s + " " +
                        "int: " + i + " " +
                        "long: " + l + " " +
                        "float: " + f + " " +
                        "double: " + d);
        System.out.println();
    }
}
