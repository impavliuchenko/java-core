package bitwise_operations;

public class Operations {

    public static void main(String[] args) {
//        unaryOperations();
//        bitwiseLeftShiftsSimple();
//        bitwiseLeftShiftsToNegative();
//        bitwiseRightShiftsSimple();
        unsignedRightShifts();
    }

    private static void unaryOperations(){
        String binary[] = {
                "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111",
                "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"
        };

        int a = 3; //0011
        int b = 6; //0110
        int c = a | b; //0111
        int d = a & b; //0010
        int e = a ^ b; //0101
        int f = (~a & b) | (a & ~b); // 0101
        int g = ~a & 0x0f; //00001111 & 1100 = 1100

        System.out.println(binary[a]);
        System.out.println(binary[b]);
        System.out.println(binary[c]);
        System.out.println(binary[d]);
        System.out.println(binary[e]);
        System.out.println(binary[f]);
        System.out.println(binary[g]);
    }

    private static void bitwiseLeftShiftsSimple(){
        byte a = 64, b;
        int i;

        i =  a << 2; //256
        System.out.println(i);
        //every <<1 is multiplication by 2. be careful with border (see ..toNegative(){..})
        b = (byte) (a<<2); //0
        System.out.println(b);
    }

    private static void bitwiseLeftShiftsToNegative(){
        int i;
        int num = 0xFFFFFFE;

        System.out.println("Primary: " + num);

        for (i = 0; i < 4; i++){
            num = num << 1;
            System.out.println(num);
        }
    }

    private static void bitwiseRightShiftsSimple(){
        int i = 35; //00100011
        i = i >> 2; //00001000
        //every >> 1 is dividing by 2 without remainder (%)
        System.out.println(i);
    }

    private static void unsignedRightShifts(){
        int a = -1; //11111111 11111111 11111111 11111111
        a = a>>>24; //00000000 00000000 00000000 11111111
        System.out.println(a);

        char hex[] = {
                '0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
        };

        byte b = (byte) 0xf1;
        byte c = (byte) (b >> 4);
        byte d = (byte) (b >>> 4);
        byte e = (byte) ((b & 0xff) >> 4);

        System.out.println("b = 0х" + hex[(b >> 4) & 0x0f] + hex[b & 0x0f]);
        System.out.println("b >> 4 = 0х" + hex[(c >> 4) & 0x0f] + hex[c & 0x0f]);
        System.out.println("b >>> 4 = 0х" + hex[(d >> 4) & 0x0f] + hex[d & 0x0f]);
        System.out.println("(b & 0xff) >> 4 = 0х" + hex[(e >> 4) & 0x0f] + hex[e & 0x0f]);
    }
}
