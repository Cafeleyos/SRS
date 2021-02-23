package collections;

import entities.Student;

import java.util.Optional;
import java.util.Vector;

public class CourseVector implements CourseCollectionsExample {

    public static final int MAXIMUM_QUOTA = 30;
    private Vector<Student> students;

    public CourseVector() {
        students = new Vector<>();
    }

    @Override
    public int numMaxStudents() {
        return MAXIMUM_QUOTA;
    }

    @Override
    public int numRegisteredStudents() {
        return students.size();
    }

    @Override
    public boolean addStudent(Student s) {
        boolean result = false;
        boolean exists = false;

        if (numRegisteredStudents() < MAXIMUM_QUOTA) {
            for (int i = 0; i < numRegisteredStudents() && !exists; i++) {
                if (students.get(i).equals(s)) {
                    exists = true;
                }
            }

            if (!exists) {
                students.add(s);
                result = true;
            }
        }

        return result;
    }

    @Override
    public boolean removeStudent(Student s) {
        return students.remove(s);
    }

    @Override
    public Student getStudent(Student s) {
        boolean found = false;
        int i =1;
        for (i = 0; i < numRegisteredStudents() && !found; i++) {
            found = students.contains(s);
        }
        return found ? students.get(i - 1) : null;

    }

    @Override
    public Student updateStudent(Student s) {
        Student result = null;
        int index = students.indexOf(s);

        if (index != -1) {
            result = students.set(index,s);
        }

        return result;

    }
}