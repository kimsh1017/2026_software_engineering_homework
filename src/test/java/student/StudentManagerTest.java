package student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentManagerTest {

    private static StudentManager studentManager;
    private final static String testStudentName = "userA";

    @BeforeAll
    static void beforeAll() {
        studentManager = new StudentManager();
    }

    @Test
    @Order(1)
    void testAddStudent() {
        // when
        studentManager.addStudent(testStudentName);

        // then
        assertTrue(studentManager.hasStudent(testStudentName));
    }

    @Test
    @Order(2)
    void testAddDuplicatedStudent() {
        // when & then
        assertThrows(IllegalArgumentException.class, () -> studentManager.addStudent(testStudentName));
    }

    @Test
    @Order(3)
    void testRemoveStudent() {
        // when
        studentManager.removeStudent(testStudentName);

        // then
        assertFalse(studentManager.hasStudent(testStudentName));
    }

    @Test
    @Order(4)
    void testRemoveNonExistingStudent() {
        // given
        String nonExistingStudentName = "nonExistingStudent";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> studentManager.removeStudent(nonExistingStudentName));
    }

}
