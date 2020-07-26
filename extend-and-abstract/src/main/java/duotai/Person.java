package duotai;

public class Person {

    //多态的第一种方式：参数
    public void feed(Pet pet){
        pet.feed();
    }

    //多态的第二种方式：返回值
    public Pet butPet(int type){
        if(type == 1){
            return new Dog();
        }else{
            return new Cat();
        }
    }

    public static void main(String[] args) {
        //思考一个问题，Java为啥可以在自己类的内部定义自己的对象呢？
        Person person = new Person();
        Dog dog = new Dog();
        Cat cat  = new Cat();

        person.feed(dog);
        person.feed(cat);

        Pet pet = person.butPet(2);
        if(pet instanceof Dog){
            System.out.println("买了一个dog");
        }
        if(pet instanceof Cat){
            System.out.println("buy a cat");
        }
    }
}
