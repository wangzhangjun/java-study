package ClassTransformation;

import org.objectweb.asm.FieldVisitor;

public class InfoFieldVisitor2 extends FieldVisitor {
    public InfoFieldVisitor2(int api, FieldVisitor fieldVisitor) {
        super(api, fieldVisitor);
    }

    @Override
    public void visitEnd() {
        String line = String.format("FieldVisitor2.visitEnd();");
        System.out.println(line);
        super.visitEnd();
    }
}
