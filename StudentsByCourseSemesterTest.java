package test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;

import dao.StudentRegistrationDao;
import model.Course;
import model.Semester;
import model.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StudentsByCourseSemesterTest {

    private StudentRegistrationDao studentDao;

    @Before
    public void setUp() {
        this.studentDao = new StudentRegistrationDao();
    }

    @Test
    public void testGetStudentsByCourseAndSemester() {
        // Given
        Course course = new Course();
        course.setCourseCode("COSC 54");

        Semester semester = new Semester();
        semester.setSemId("3");

        // When
        List<Student> students = this.studentDao.getStudentsByCourseAndSemester(course, semester);

        // Then
        assertNotNull("List of students should not be null", students);
		/*
		 * assertThat("List of students should not be empty", students,
		 * is(not(empty())));
		 */    }
}
