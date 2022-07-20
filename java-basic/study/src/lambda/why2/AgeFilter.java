package lambda.why2;

import lambda.why.Student;

public class AgeFilter implements StudentFilter {

    @Override
    public boolean compare(Student student) {
        return student.getAge() > 14;
    }
}
