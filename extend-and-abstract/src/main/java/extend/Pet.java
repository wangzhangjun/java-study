package extend;

public class Pet {

    private String name;
    private int age;
    private String gender;
    protected String abc;

    public Pet() {
        System.out.println("Pet 无参构造");
    }

    public Pet(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void play() {
        System.out.println("pet play");
    }
    public String getAbc() {
        return abc;
    }
}
