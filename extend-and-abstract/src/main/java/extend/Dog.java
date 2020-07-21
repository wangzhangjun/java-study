package extend;

public class Dog extends Pet {
    private String sound;

    public Dog(){
        System.out.println("dog 无参构造");
    }

    public Dog(String name, int age, String gender, String sound) {
        super(name, age, gender);
        //this();//在构造方法中super关键字和this关键字不能同时出现,下面的方法是可以同时出现的
        this.sound = sound;
    }
    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void play(){
        System.out.println("dog is playing ball");
        super.play(); //可以在子类中调用父类中被子类覆盖的方法  super.父类方法名称
    }


    public String toString(){
        return super.toString()+",my sound is"+this.sound;
    }

}
