package GetMethodParameterAndReturnValue;

public class Helloworld {
    public int test(String name, int age, long idCard, Object obj, String testName) {
        int hashCode = 0;
        hashCode += name.hashCode();
        hashCode += age;
        hashCode += (int) (idCard % Integer.MAX_VALUE);
        hashCode += obj.hashCode();
        return hashCode;
    }
}
