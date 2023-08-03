package GetMethodParameterAndReturnValue;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import static org.objectweb.asm.Opcodes.*;

public class MethodParameterVisitor extends ClassVisitor {
    public MethodParameterVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }
    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
        if (mv != null && !name.equals("<init>")) {
            boolean isAbstractMethod = (access & ACC_ABSTRACT) != 0;
            boolean isNativeMethod = (access & ACC_NATIVE) != 0;
            if (!isAbstractMethod && !isNativeMethod) {
                mv = new MethodParameterAdapter(api, mv, access, name, descriptor);
            }
        }
        return mv;
    }

    private static class MethodParameterAdapter extends MethodVisitor {
        private final int methodAccess;
        private final String methodName;
        private final String methodDesc;
        public MethodParameterAdapter(int api, MethodVisitor mv, int methodAccess, String methodName, String methodDesc) {
            super(api, mv);
            this.methodAccess = methodAccess;
            this.methodName = methodName;
            this.methodDesc = methodDesc;
        }
        @Override
        public void visitCode() {
            // 首先，处理自己的代码逻辑
            boolean isStatic = ((methodAccess & ACC_STATIC) != 0);
            int slotIndex = isStatic ? 0 : 1; // staic 在local varibale 中的slot不一样，非static的第一个slot存this

            printMessage("Method Enter methodName : " + methodName);
            printMessage("Method Enter methodDesc : " + methodDesc);

            Type methodType = Type.getMethodType(methodDesc);  // 获取方法的描述
            Type[] argumentTypes = methodType.getArgumentTypes();  // 用于获取“方法”接收的参数类型
            for (Type t : argumentTypes) {
                int sort = t.getSort(); // 得到参数的类别
                int size = t.getSize(); // 用于返回某一个类型所占用的 slot 空间的大小
                String descriptor = t.getDescriptor();

                int opcode = t.getOpcode(ILOAD);  // 传入ILOAD指令，会根据t的类型返回一个合适的加载t的指令
                super.visitVarInsn(opcode, slotIndex); // 把这个opcode加载到frame的stack中，因为println是从栈上取
                if (sort == Type.BOOLEAN) {
                    printBoolean();
                }
                else if (sort == Type.CHAR) {
                    printChar();
                }
                else if (sort == Type.BYTE || sort == Type.SHORT || sort == Type.INT) {
                    // 这么调用并传参是OK的，因为还要给后面用，所有要先把栈顶的元素用DUP搞一份
                    // 为什么要DUP两次，因为printInt用一次，本身往下传还要用一次
                    super.visitInsn(DUP);
                    super.visitInsn(DUP);
                    super.visitMethodInsn(INVOKESTATIC, "GetMethodParameterAndReturnValue/TestCall", "testcall", "(I)V", false);
                    printInt();
                }
                else if (sort == Type.FLOAT) {
                    printFloat();
                }
                else if (sort == Type.LONG) {
                    super.visitInsn(DUP2);
                    super.visitInsn(DUP2);
                    super.visitMethodInsn(INVOKESTATIC, "GetMethodParameterAndReturnValue/TestCall", "testcalllong", "(J)V", false);
                    printLong();
                }
                else if (sort == Type.DOUBLE) {
                    printDouble();
                }
                else if (sort == Type.OBJECT && "Ljava/lang/String;".equals(descriptor)) {
                    super.visitInsn(DUP);
                    super.visitInsn(DUP);
                    super.visitMethodInsn(INVOKESTATIC, "GetMethodParameterAndReturnValue/TestCall", "testcallstring", "(Ljava/lang/String;)V", false);
                    printString();
                }
                else if (sort == Type.OBJECT) {
                    printObject();
                }
                else {
                    printMessage("No Support");
                    if (size == 1) {
                        super.visitInsn(Opcodes.POP);
                    }
                    else {
                        super.visitInsn(Opcodes.POP2);
                    }
                }
                slotIndex += size; //下一个参数的循环开始
            }
            // 其次，调用父类的方法实现
            super.visitCode();
        }
        @Override
        public void visitInsn(int opcode) {
            // 首先，处理自己的代码逻辑
            if ((opcode >= IRETURN && opcode <= RETURN) || opcode == ATHROW) {
                printMessage("Method Exit:");
                if (opcode == IRETURN) {
                    super.visitInsn(DUP);  // 因为打印会消耗frame栈上的一个值，所以要先dup一份，在栈上复制一份，打印消耗一份，原有的一份用于返回
                    Type methodType = Type.getMethodType(methodDesc);
                    Type returnType = methodType.getReturnType();
                    if (returnType == Type.BOOLEAN_TYPE) {
                        printBoolean();
                    }
                    else if (returnType == Type.CHAR_TYPE) {
                        printChar();
                    }
                    else {
                        printInt();
                    }
                }
                else if (opcode == FRETURN) {
                    super.visitInsn(DUP);
                    printFloat();
                }
                else if (opcode == LRETURN) {  // 返回Long,参考frame的学习，是占用2个slot的，所有要使用DUP2
                    super.visitInsn(DUP2);
                    printLong();
                }
                else if (opcode == DRETURN) {
                    super.visitInsn(DUP2);
                    printDouble();
                }
                else if (opcode == ARETURN) {  // 返回object
                    super.visitInsn(DUP);
                    printObject();
                }
                else if (opcode == RETURN) {  // 返回void
                    printMessage("    return void");
                }
                else {
                    printMessage("    abnormal return");
                }
            }

            // 其次，调用父类的方法实现
            super.visitInsn(opcode);
        }
        private void printBoolean() {
            super.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            super.visitInsn(SWAP);
            super.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Z)V", false);
        }

        private void printChar() {
            super.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            super.visitInsn(SWAP);
            super.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(C)V", false);
        }

        private void printInt() {
            super.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            super.visitInsn(SWAP);
            super.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
        }

        private void printFloat() {
            super.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            super.visitInsn(SWAP);
            super.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);
        }

        private void printLong() {
            super.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            super.visitInsn(DUP_X2);
            super.visitInsn(POP);
            super.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
        }

        private void printDouble() {
            super.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            super.visitInsn(DUP_X2);
            super.visitInsn(POP);
            super.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);
        }

        private void printString() {
            super.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            super.visitInsn(SWAP);
            super.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        }

        private void printObject() {
            super.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            super.visitInsn(SWAP);
            super.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/Object;)V", false);
        }

        private void printMessage(String str) {
            super.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            super.visitLdcInsn(str);
            super.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        }
    }
}
