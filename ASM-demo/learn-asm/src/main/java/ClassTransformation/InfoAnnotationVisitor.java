package ClassTransformation;

import org.objectweb.asm.AnnotationVisitor;

public class InfoAnnotationVisitor extends AnnotationVisitor {

    public InfoAnnotationVisitor(int api, AnnotationVisitor annotationVisitor) {
        super(api, annotationVisitor);
    }

    @Override
    public void visit(String name, Object value) {
        // (1) 添加自己的代码逻辑
        String info = String.format("    %s: %s", name, value);
        System.out.println(info);

        // (2) 调用父类的实现
        super.visit(name, value);
    }

    @Override
    public void visitEnum(String name, String descriptor, String value) {
        // (1) 添加自己的代码逻辑
        String info = String.format("    %s: %s %s", name, descriptor, value);
        System.out.println(info);

        // (2) 调用父类的实现
        super.visitEnum(name, descriptor, value);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String name, String descriptor) {
        // (1) 添加自己的代码逻辑
        String info = String.format("    %s: %s", name, descriptor);
        System.out.println(info);

        // (2) 调用父类的实现
        return super.visitAnnotation(name, descriptor);
    }

    @Override
    public AnnotationVisitor visitArray(String name) {
        // (1) 添加自己的代码逻辑
        String info = String.format("    %s", name);
        System.out.println(info);

        // (2) 调用父类的实现
        return super.visitArray(name);
    }
}
