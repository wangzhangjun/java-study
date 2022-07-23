package fanxing.通配符;

public class Main {
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.setFirst("zhjwang");
        showBox(box);

        //再来看这种类型
        Box<Integer> box1 = new Box<>();
        box1.setFirst(200);
        showBox(box1);  //这就出错了，你可能想到再定一个方法,有没有更好的办法
    }
    //注释的这两个方法是Ok的，把这两个用一个类型通配符来统一处理
//    public static void showBox(Box<String> box) {
//        String first = box.getFirst();
//        System.out.println(first);
//    }
//
//    public static void showBoxIn(Box<Integer> box) {
//        Integer first = box.getFirst();
//        System.out.println(first);
//    }

    // ? 就代表通配符
    public static void showBox(Box<?> box) {
        Object firset = box.getFirst();
        System.out.println(firset);
    }
}
