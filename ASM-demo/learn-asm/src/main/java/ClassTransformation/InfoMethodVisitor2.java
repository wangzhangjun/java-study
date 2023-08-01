package ClassTransformation;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.util.Printer;

public class InfoMethodVisitor2 extends MethodVisitor {
    public InfoMethodVisitor2(int api, MethodVisitor methodVisitor) {
        super(api, methodVisitor);
    }

    @Override
    public void visitCode() {
        String line = String.format("    MethodVisitor2.visitCode();");
        System.out.println(line);
        super.visitCode();
    }

    @Override
    public void visitInsn(int opcode) {
        String line = String.format("    MethodVisitor2.visitInsn(%s);", Printer.OPCODES[opcode]);
        System.out.println(line);
        super.visitInsn(opcode);
    }

    @Override
    public void visitIntInsn(int opcode, int operand) {
        String line = String.format("    MethodVisitor2.visitIntInsn(%s, %s);", Printer.OPCODES[opcode], operand);
        System.out.println(line);
        super.visitIntInsn(opcode, operand);
    }

    @Override
    public void visitVarInsn(int opcode, int var) {
        String line = String.format("    MethodVisitor2.visitVarInsn(%s, %s);", Printer.OPCODES[opcode], var);
        System.out.println(line);
        super.visitVarInsn(opcode, var);
    }

    @Override
    public void visitTypeInsn(int opcode, String type) {
        String line = String.format("    MethodVisitor2.visitTypeInsn(%s, %s);", Printer.OPCODES[opcode], type);
        System.out.println(line);
        super.visitTypeInsn(opcode, type);
    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name, String descriptor) {
        String line = String.format("    MethodVisitor2.visitFieldInsn(%s, %s, %s, %s);", Printer.OPCODES[opcode], owner, name, descriptor);
        System.out.println(line);
        super.visitFieldInsn(opcode, owner, name, descriptor);
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        String line = String.format("    MethodVisitor2.visitMethodInsn(%s, %s, %s, %s, %s);", Printer.OPCODES[opcode], owner, name, descriptor, isInterface);
        System.out.println(line);
        super.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
    }

    @Override
    public void visitJumpInsn(int opcode, Label label) {
        String line = String.format("    MethodVisitor2.visitJumpInsn(%s, %s);", Printer.OPCODES[opcode], label);
        System.out.println(line);
        super.visitJumpInsn(opcode, label);
    }

    @Override
    public void visitLabel(Label label) {
        String line = String.format("    MethodVisitor2.visitLabel(%s);", label);
        System.out.println(line);
        super.visitLabel(label);
    }

    @Override
    public void visitLdcInsn(Object value) {
        String line = String.format("    MethodVisitor2.visitLdcInsn(%s);", value);
        System.out.println(line);
        super.visitLdcInsn(value);
    }

    @Override
    public void visitIincInsn(int var, int increment) {
        String line = String.format("    MethodVisitor2.visitIincInsn(%s, %s);", var, increment);
        System.out.println(line);
        super.visitIincInsn(var, increment);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        System.out.println("    MethodVisitor2 visitAnnotation: " + descriptor);  // 作用在方法上的annotation只有在这里才会被调用
        return super.visitAnnotation(descriptor,visible);
    }

    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        String line = String.format("    MethodVisitor2.visitMaxs(%s, %s);", maxStack, maxLocals);
        System.out.println(line);
        super.visitMaxs(maxStack, maxLocals);
    }

    @Override
    public void visitEnd() {
        String line = String.format("    MethodVisitor2.visitEnd();");
        System.out.println(line);
        super.visitEnd();
    }
}
