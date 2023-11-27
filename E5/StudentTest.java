import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("Test getId")
    void getId() {
        Student aStudent = new Student("Anna James");
        Student anotherStudent = new Student("Jason mike pohl");
        assertAll(
                () -> assertEquals("AJ10", aStudent.id),
                () -> assertEquals("JMP15", anotherStudent.id));

    }

    @Test
    @DisplayName("Test calculateAverage")
    void calculateAverage() {
        Student aStudent = new Student("Madison McDonald", new String[]{"OOP", "SWW2", "Systems Programming"}, new int[]{58, 63, 88});
        Student aSecondStudent = new Student("charlie Olsen", new String[]{"SWW2", "SWW1", "Computer Systems", "Computer Vision"}, new int[]{66, 15, 48, 75});
        Student aThirdStudent = new Student("Andrew smith");
        assertAll(
                () -> assertEquals(69.67, aStudent.average),
                () -> assertEquals(51, aSecondStudent.average),
                () -> assertEquals(0, aThirdStudent.average));
    }


    @Test
    @DisplayName("Test getAverage")
    void getAverage() {
        Student[] students = new Student[4];
        students[0] = new Student("pete park", new String[]{"OOP", "SWW1", "Computer Vision"}, new int[]{87, 16, 55});
        students[1] = new Student("Tommie coombs", new String[]{"SWW2", "Machine Learning", "Systems Programming", "Computer Vision"}, new int[]{74, 65, 44, 83});
        students[2] = new Student("Eliott Jay Norris", new String[]{"SWW1", "SWW2", "Neural Computation", "Computer Vision"}, new int[]{83, 90, 64, 71});
        students[3] = new Student("Caitlyn Willard");

        assertAll(
                () ->  assertEquals(77, Student.getAverage(students, "EJN17")),
                () ->  assertEquals(0, Student.getAverage(students, "DU56")),
                () ->  assertEquals(66.5, Student.getAverage(students, "TC13")),
                () ->  assertEquals(0, Student.getAverage(students, "CWM15")),
                () ->  assertEquals(52.67, Student.getAverage(students, "PP9")));
    }

    @Test
    @DisplayName("Test getMark")
    void getMark() {
        Student[] students = new Student[4];
        students[0] = new Student("andrea Solomon", new String[]{"OOP", "Neural Computation", "Computer Vision"}, new int[]{58, 46, 22});
        students[1] = new Student("Fox atterberry", new String[]{"SWW2", "SWW1", "Systems Programming", "OOP"}, new int[]{66, 48, 52, 79});
        students[2] = new Student("Kason Salvage", new String[]{"SWW1", "Neural Computation", "OOP", "Computer Vision"}, new int[]{89, 46, 27, 15});
        students[3] = new Student("Ada norman");
        assertAll(
                () ->  assertEquals(89, Student.getMark(students, "KS13", "SWW1")),
                () ->  assertEquals(0, Student.getMark(students, "AN10","OOP")),
                () ->  assertEquals(0, Student.getMark(students, "LO17","SWW2")),
                () ->  assertEquals(46, Student.getMark(students, "AS14","Neural Computation")),
                () ->  assertEquals(79, Student.getMark(students, "FA14","OOP")));
    }

}