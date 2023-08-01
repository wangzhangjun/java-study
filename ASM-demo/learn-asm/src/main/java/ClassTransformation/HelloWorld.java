package ClassTransformation;

public class HelloWorld {
    public int intValue;
    public String strValue;
    public String testValue;

    @TraceTest(tag = 32)
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }
}
