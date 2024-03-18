package test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;

import dao.CourseDao;
import model.Course;
import model.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CoursesByStudentTest {

    private CourseDao courseDao;

    @Before
    public void setUp() {
        this.courseDao = new CourseDao();
    }

    @Test
    public void testGetCoursesByStudent() {
        // Given
        Student student = new Student();
        student.setRegNo("oo5");

        // When
        List<Course> courses = this.courseDao.getCoursesByStudent(student);

        // Then
        assertNotNull("List of courses should not be null", courses);
		/*
		 * assertThat("There should be one course in the list", courses.size(),
		 * is(equalTo(1)));
		 */    }
}
