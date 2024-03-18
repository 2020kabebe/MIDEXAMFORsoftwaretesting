package test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import dao.StudentRegistrationDao;
import model.Semester;
import model.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AllStudentsBySemesterTest {

    private StudentRegistrationDao studentRegistrationDao;

    @Before
    public void setUp() {
        this.studentRegistrationDao = new StudentRegistrationDao();
    }

    @Test
    public void testGetAllStudentsBySemester() {
        // Given
        Semester semester = new Semester();
        semester.setSemId("089");

        // When
        List<Student> students = this.studentRegistrationDao.getAllStudentsBySemester(semester);

        // Then
        assertNotNull("List of students should not be null", students);
        assertThat("There should be one student in the list", students.size(), is(equalTo(1)));
    }
}
