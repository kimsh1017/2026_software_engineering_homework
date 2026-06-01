package student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentManagerTest {

    private static StudentManager studentManager;
    private final static String testStudentName = "userA";

    // 테스트 수행 전에 실행되어야합니다.
    // 주석
    @BeforeAll
    static void beforeAll() {
        studentManager = new StudentManager();
    }

    @Test
    @Order(1)
    void testAddStudent() {
        // given

        // when
        studentManager.addStudent(testStudentName);

        // then
        assertTrue(studentManager.hasStudent(testStudentName));
    }

    @Test
    @Order(2)
    void testAddDuplicatedStudent() {
        // given

        // when & then
        assertThrows(IllegalArgumentException.class, () -> studentManager.addStudent(testStudentName));
    }

    @Test
    @Order(3)
    void testRemoveStudent() {
        // given

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
