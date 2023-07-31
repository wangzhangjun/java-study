package ClassTransformation;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import utils.FileUtils;

// 通过这个例子，来看函数的调用顺序
/*
ClassVisitor2.visit(52, [ACC_PUBLIC], ClassTransformation/HelloWorld, null, java/lang/Object, []);
ClassVisitor.visit(52, [ACC_PUBLIC], ClassTransformation/HelloWorld, null, java/lang/Object, []);
ClassVisitor2.visitField([ACC_PUBLIC], intValue, I, null, null);
ClassVisitor.visitField([ACC_PUBLIC], intValue, I, null, null);
FieldVisitor2.visitEnd();
FieldVisitor.visitEnd();
ClassVisitor2.visitField([ACC_PUBLIC], strValue, Ljava/lang/String;, null, null);
ClassVisitor.visitField([ACC_PUBLIC], strValue, Ljava/lang/String;, null, null);
FieldVisitor2.visitEnd();
FieldVisitor.visitEnd();
ClassVisitor2.visitField([ACC_PUBLIC], testValue, Ljava/lang/String;, null, null);
ClassVisitor.visitField([ACC_PUBLIC], testValue, Ljava/lang/String;, null, null);
FieldVisitor2.visitEnd();
FieldVisitor.visitEnd();
ClassVisitor2.visitMethod([ACC_PUBLIC], <init>, ()V, null, null);
ClassVisitor.visitMethod([ACC_PUBLIC], <init>, ()V, null, null);
    MethodVisitor2.visitCode();
    MethodVisitor.visitCode();
    MethodVisitor2.visitVarInsn(ALOAD, 0);
    MethodVisitor.visitVarInsn(ALOAD, 0);
    MethodVisitor2.visitMethodInsn(INVOKESPECIAL, java/lang/Object, <init>, ()V, false);
    MethodVisitor.visitMethodInsn(INVOKESPECIAL, java/lang/Object, <init>, ()V, false);
    MethodVisitor2.visitInsn(RETURN);
    MethodVisitor.visitInsn(RETURN);
    MethodVisitor2.visitMaxs(1, 1);
    MethodVisitor.visitMaxs(1, 1);
    MethodVisitor2.visitEnd();
    MethodVisitor.visitEnd();
ClassVisitor2.visitMethod([ACC_PUBLIC], add, (II)I, null, null);
ClassVisitor.visitMethod([ACC_PUBLIC], add, (II)I, null, null);
    MethodVisitor2.visitCode();
    MethodVisitor.visitCode();
    MethodVisitor2.visitVarInsn(ILOAD, 1);
    MethodVisitor.visitVarInsn(ILOAD, 1);
    MethodVisitor2.visitVarInsn(ILOAD, 2);
    MethodVisitor.visitVarInsn(ILOAD, 2);
    MethodVisitor2.visitInsn(IADD);
    MethodVisitor.visitInsn(IADD);
    MethodVisitor2.visitInsn(IRETURN);
    MethodVisitor.visitInsn(IRETURN);
    MethodVisitor2.visitMaxs(2, 3);
    MethodVisitor.visitMaxs(2, 3);
    MethodVisitor2.visitEnd();
    MethodVisitor.visitEnd();
ClassVisitor2.visitMethod([ACC_PUBLIC], sub, (II)I, null, null);
ClassVisitor.visitMethod([ACC_PUBLIC], sub, (II)I, null, null);
    MethodVisitor2.visitCode();
    MethodVisitor.visitCode();
    MethodVisitor2.visitVarInsn(ILOAD, 1);
    MethodVisitor.visitVarInsn(ILOAD, 1);
    MethodVisitor2.visitVarInsn(ILOAD, 2);
    MethodVisitor.visitVarInsn(ILOAD, 2);
    MethodVisitor2.visitInsn(ISUB);
    MethodVisitor.visitInsn(ISUB);
    MethodVisitor2.visitInsn(IRETURN);
    MethodVisitor.visitInsn(IRETURN);
    MethodVisitor2.visitMaxs(2, 3);
    MethodVisitor.visitMaxs(2, 3);
    MethodVisitor2.visitEnd();
    MethodVisitor.visitEnd();
ClassVisitor2.visitEnd();
ClassVisitor1.visitEnd();
file:///Users/zhjwang/works/study/java-study/ASM-demo/learn-asm/target/classes/ClassTransformation/HelloWorld.class
* */
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
