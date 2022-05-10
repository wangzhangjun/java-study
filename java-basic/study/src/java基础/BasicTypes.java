package java基础;

public class BasicTypes {
    public static void main(String[] args) {
        byte byteVar = 100;  //1个字节
        System.out.println(byteVar);

        short shortVar = 30000; //2个字节
        System.out.println(shortVar);

        int intVar = 1000000000;
        System.out.println(intVar);

//        long longVar = 80000000000;  java中整数的字面值都默认是int, 所以要想表示long，得加个L
        long longVar = 80000000000L; //8个字节
        System.out.println(longVar);

        float floatVar = 100.0000000666F;  //浮点数，有精度
        System.out.println(floatVar);

        double doubleVar = 100.0000000666; // 精度是float的一倍，8byte
        System.out.println(doubleVar);

        boolean booleanVar = true;  // 4字节
        System.out.println(booleanVar);

        char charVar = 'a';  //2字节
        System.out.println(charVar);
    }
}
