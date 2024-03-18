package test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;

import dao.StudentRegistrationDao;
import model.AcademicUnit;
import model.Course;
import model.Semester;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CoursesByDepartmentAndBySemesterTest {

    private StudentRegistrationDao courseDao;

    @Before
    public void setUp() {
        this.courseDao = new StudentRegistrationDao();
    }

    @Test
    public void testGetCoursesByDepartmentAndSemester() {
        // Given
        AcademicUnit department = new AcademicUnit();
        department.setUnitCode("1");

        Semester semester = new Semester();
        semester.setSemId("089");

        // When
        List<Course> courses = this.courseDao.getCoursesByDepartmentAndSemester(department, semester);

        // Then
        assertNotNull("List of courses should not be null", courses);
		/*
		 * assertThat("List of courses should not be empty", courses, is(not(empty())));
		 */    }
}
