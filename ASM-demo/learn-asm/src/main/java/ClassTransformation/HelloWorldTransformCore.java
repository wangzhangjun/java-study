package ClassTransformation;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import utils.FileUtils;

// 通过这个例子，来看函数的调用顺序
public class HelloWorldTransformCore {
    public static void main(String[] args) {
        String relative_path = "ClassTransformation/HelloWorld.class";
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes1 = FileUtils.readBytes(filepath);

        //（1）构建ClassReader
        ClassReader cr = new ClassReader(bytes1);

        //（2）构建ClassWriter
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);

        //（3）串连ClassVisitor
        int api = Opcodes.ASM9;
        //ClassVisitor cv = new ClassChangeVersionVisitor(api, cw);
        ClassVisitor cv = new InfoClassVisitor(api, cw);
        ClassVisitor cv2 = new InfoClassVisitor2(api, cv); // 跟后面的调用顺序相关。都是先调用2的，再调用1的

        //（4）结合ClassReader和ClassVisitor
        int parsingOptions = ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES;
        cr.accept(cv2, parsingOptions);

        //（5）生成byte[]
        byte[] bytes2 = cw.toByteArray();

        FileUtils.writeBytes(filepath, bytes2);
    }
}
