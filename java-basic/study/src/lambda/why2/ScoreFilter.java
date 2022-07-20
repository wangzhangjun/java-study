package lambda.why2;

import lambda.why.Student;

public class ScoreFilter implements  StudentFilter{

    @Override
    public boolean compare(Student student) {
        return student.getScore() > 75;
    }
}
