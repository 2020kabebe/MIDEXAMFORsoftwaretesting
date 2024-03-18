package view;

import model.*;
import repo.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import dao.*;

public class RegistrationManagementSystem {
	
	public static void  main(String[] args) {
		boolean cond = true;
		String studentId;
		String names, answer;
		LocalDate dob;
		String departe;
		
		double results;
		String num, coId;
		
		String unitCode, academicUnit, unitName, facultUnCode, progUnCode;
		String semId, semName;
		LocalDate startDate, endDate;
		
		String courseCode, courseName, courseDescription, department;
		
		String regNo, semID, studId;
		LocalDate regDate;
		
		String teacherCode, teacherName, qualification;
		
		Student stud = new Student();
		AcademicUnit acUnit = new AcademicUnit();
		AcademicUnitDao acDao = new AcademicUnitDao();
		Semester sem = new Semester();
		Course course = new Course();
		Teacher teacher = new Teacher();
		StudentRegistration studReg = new StudentRegistration();
		
		while(cond) {
			
			System.out.println(" 1. Register Student                       ");
			System.out.println(" 2. Register Semester                      ");
			System.out.println(" 3. Register Course                        ");
			System.out.println(" 4. Register Teacher                       ");
			System.out.println(" 5. Student Registration                   ");
			System.out.println(" 6. Add Course to Semester                 ");
			System.out.println(" 7. Add Teacher to Course                  ");
			System.out.println(" 8. Students Courses Results               ");
			System.out.println(" 9. Display Students registered in a given Semester ");
			System.out.println(" 10. Display Students registered in a given Department and Semester ");
			System.out.println(" 11. Display Students registered in a given Course and Semester ");
			System.out.println(" 12. Display Courses that belong to a given department and Semester ");
			System.out.println(" 13. All courses per student               ");
			System.out.println(" 0. Exit                                   ");
			System.out.print("Choose: ");

			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Student ID");
				studentId = input.next();
				input.nextLine();
				System.out.println("Enter Names");
				names = input.nextLine().trim();
				System.out.println("Enter Date of birth");
				String dobirth = input.next();
				dob = LocalDate.parse(dobirth);
				
				
				stud.setRegNo(studentId);  
				stud.setNames(names);   
				stud.setDateOfBirth(dob);  
				
				
				StudentDao dao = new StudentDao();
				dao.saveStudent(stud);
				System.out.println("Student registered successfully.");
				System.out.println("Do you wish to continue?, yes or no ");
				answer = input.next();
				if(answer.equalsIgnoreCase("yes")) {
					cond = true;
				}else {
					System.out.println("Thank you for using our system");
					cond = false;
				}
				break;
				
			
			
				
			case 2:
				System.out.println("Enter Semester ID");
				semId = input.next();
				System.out.println("Enter semester name");
				semName = input.next();
				System.out.println("Enter start date");
				String start = input.next();
				startDate = LocalDate.parse(start);
				System.out.println("Enter end date");
				String end = input.next();
				endDate = LocalDate.parse(end);
				
				sem.setSemId(semId);
				sem.setSemName(semName);
				sem.setStartDate(startDate);
				sem.setEndDate(endDate);
				
				SemesterDao semDao = new SemesterDao();
				semDao.saveSemester(sem);
				System.out.println("Semester registered successfully.");
				System.out.println("Do you wish to continue?, yes or no ");
				answer = input.next();
				if(answer.equalsIgnoreCase("yes")) {
					cond = true;
				}else {
					System.out.println("Thank you for using our system");
					cond = false;
				}
				break;
				
			case 3:
				System.out.println("Enter course ID");
				courseCode = input.next();
				input.nextLine();
				System.out.println("Enter course name");
				courseName = input.nextLine().trim();
				input.nextLine();
				System.out.println("Enter course description");
				courseDescription = input.nextLine().trim();
				System.out.println("Enter Department");
				department = input.next();
				
				course.setCourseCode(courseCode);
				course.setCourseName(courseName);
				course.setDescription(courseDescription);
				AcademicUnit dep = acDao.searchUnitById(department);
				course.setDepartment(dep);
				
				CourseDao courseDao = new CourseDao();
				courseDao.saveCourse(course);
				System.out.println("Course registered successfully.");
				System.out.println("Do you wish to continue?, yes or no ");
				answer = input.next();
				if(answer.equalsIgnoreCase("yes")) {
					cond = true;
				}else {
					System.out.println("Thank you for using our system");
					cond = false;
				}
				break;
				
			case 4:
				System.out.println("Enter teacher ID");
				teacherCode = input.next();
				input.nextLine();
				System.out.println("Enter teacher name");
				teacherName = input.nextLine().trim();
				System.out.println("Enter teacher qualifation");
				qualification = input.next();
				
				teacher.setTeacherCode(teacherCode);
				teacher.setNames(teacherName);
				teacher.setQualification(TeacherEnum.PHD);
				
				TeacherDao tDao = new TeacherDao();
				tDao.saveTeacher(teacher);
				System.out.println("Teacher registered successfully.");
				System.out.println("Do you wish to continue?, yes or no ");
				answer = input.next();
				if(answer.equalsIgnoreCase("yes")) {
					cond = true;
				}else {
					System.out.println("Thank you for using our system");
					cond = false;
				}
				break;
				
			case 5:
				System.out.println("Enter Registration number");
				regNo = input.next();
				input.nextLine();
			
				System.out.println("Enter the registration date");
				String reg = input.next();
				regDate = LocalDate.parse(reg);
				System.out.println("Enter Semester Id");
				semID = input.next();
				System.out.println("Enter Student Id");
				studId = input.next();
				
				studReg.setRegId(regNo);
				studReg.setRegDate(regDate);
				SemesterDao semDaos = new SemesterDao();
				Semester sems = semDaos.searchSemesterById(semID);
				studReg.setSemester(sems);
				StudentDao daoss = new StudentDao();
				Student students = daoss.searchStudentById(studId);
				studReg.setStudent(students);
				
				StudentRegistrationDao regStudDao = new StudentRegistrationDao();
				regStudDao.saveRegistration(studReg);
				System.out.println("Student Registration saved successfully.");
				System.out.println("Do you wish to continue?, yes or no ");
				answer = input.next();
				if(answer.equalsIgnoreCase("yes")) {
					cond = true;
				}else {
					System.out.println("Thank you for using our system");
					cond = false;
				}
				break;
				
			case 6:
			    System.out.println("Enter course code:");
			    courseCode = input.next();
			    System.out.println("Enter semester ID:");
			    String semesterId = input.next();
			    CourseDao courseDaos = new CourseDao();
			    SemesterDao semesterDao = new SemesterDao();
			    Course courses = null;
			    Semester semester = semesterDao.searchSemesterById(semesterId);
			    if (semester != null) {
			        courses = courseDaos.searchCourseById(courseCode).get();
			        if (courses != null) {
			            courseDaos.addCourseToSemester(courses, semester);
			            System.out.println("Course added to semester successfully.");
			        } else {
			            System.out.println("Course not found.");
			        }
			    } else {
			        System.out.println("Semester not found.");
			    }
			    System.out.println("Do you wish to continue?, yes or no ");
			    answer = input.next();
			    if (answer.equalsIgnoreCase("yes")) {
			        cond = true;
			    } else {
			        System.out.println("Thank you for using the system");
			        cond = false;
			    }
			    break;
			    
			case 7:
			    System.out.println("Enter course code:");
			    courseCode = input.next();
			    System.out.println("Enter teacher ID:");
			    teacherCode = input.next();
			    CourseDao courseDaoss = new CourseDao();
			    TeacherDao teacherDao = new TeacherDao();
			    Course coursess = courseDaoss.searchCourseById(courseCode).get();
			    Teacher teachers = teacherDao.searchTeacherById(teacherCode).get();
			    if (coursess != null && teachers != null) {
			        courseDaoss.addTeacherToCourse(teachers, coursess);
			        System.out.println("Teacher added to course successfully.");
			    } else {
			        System.out.println("Course or teacher not found.");
			    }
			    System.out.println("Do you wish to continue?, yes or no ");
			    answer = input.next();
			    if (answer.equalsIgnoreCase("yes")) {
			        cond = true;
			    } else {
			        System.out.println("Thank you for using the system");
			        cond = false;
			    }
			    break;
			    
			case 8:
				System.out.println("Enter Student Id:");
			    reg = input.next();
			    System.out.println("Enter course code:");
			    coId = input.next();
			    System.out.println("Enter Results:");
			    results = input.nextDouble();
			    
			    StudentCourseDao studCourDao = new StudentCourseDao();
			    StudentCourse studC = new StudentCourse();
			    StudentDao sDao = new StudentDao();
			    stud = sDao.searchStudentById(reg);
			    CourseDao cDao = new CourseDao();
			    try {
			        course = cDao.searchCourseById(coId).orElseThrow(() -> new NoSuchElementException("Course not found."));
			    } catch (NoSuchElementException e) {
			        System.out.println("Course not found.");
			        return;
			    }
			    
			    studC.setStudent(stud);
			    studC.setCourse(course);
			    studC.setResults(results);
			    
			    studCourDao.saveStudentCourse(studC);
				System.out.println("Student marks saved successfully.");
				System.out.println("Do you wish to continue?, yes or no ");
				answer = input.next();
				if(answer.equalsIgnoreCase("yes")) {
					cond = true;
				}else {
					System.out.println("Thank you for using the system");
					cond = false;
				}
			    
				break;
			    
			case 9:
			    System.out.println("Enter Semester ID");
			    semID = input.next();

			    SemesterDao semeDao = new SemesterDao();
			    Semester semes = semeDao.searchSemesterById(semID);

			    if (semes != null) {
			        StudentRegistrationDao regStudDaos = new StudentRegistrationDao();
			        List<Student> studentss = regStudDaos.getAllStudentsBySemester(semes);

			        if (!studentss.isEmpty()) {
			            System.out.println("Students enrolled in semester " + semes.getSemName() + ":");
			            for (Student student : studentss) {
			                System.out.println("- " + student.getNames() + " (" + student.getRegNo() + ")");
			            }
			        } else {
			            System.out.println("No students enrolled in this semester.");
			        }
			    } else {
			        System.out.println("Semester not found.");
			    }

			    System.out.println("Do you wish to continue?, yes or no ");
			    answer = input.next();
			    if (answer.equalsIgnoreCase("yes")) {
			        cond = true;
			    } else {
			        System.out.println("Thank you for using the system");
			        cond = false;
			    }
			    break;
			    
			case 10:
			    System.out.println("Enter Department Code:");
			    String departmentCode = input.next();
			    System.out.println("Enter Semester ID:");
			    semID = input.next();

			   
			    AcademicUnit departments = acDao.searchUnitById(departmentCode);
			    SemesterDao semsDaos = new SemesterDao();
			    Semester semesters = semsDaos.searchSemesterById(semID);

			    if (departments != null && semesters != null) {
			        StudentRegistrationDao regStudDaos = new StudentRegistrationDao();
			        List<Student> studentes = regStudDaos.getAllStudentsByDepartmentAndSemester(departments, semesters);

			        if (!studentes.isEmpty()) {
			            System.out.println("Students enrolled in " + departments.getUnitName() + " department for semester " + semesters.getSemName() + ":");
			            for (Student student : studentes) {
			                System.out.println("- " + student.getNames() + " (" + student.getRegNo() + ")");
			            }
			        } else {
			            System.out.println("No students enrolled in this department and semester combination.");
			        }
			    } else {
			        System.out.println("Department or semester not found.");
			    }

			    System.out.println("Do you wish to continue?, yes or no ");
			    answer = input.next();
			    if (answer.equalsIgnoreCase("yes")) {
			        cond = true;
			    } else {
			        System.out.println("Thank you for using registring to our system");
			        cond = false;
			    }
			    break;
			    
			case 11:
			    System.out.println("Enter Course Code:");
			    courseCode = input.next();
			    System.out.println("Enter Semester ID:");
			    semID = input.next();

			    CourseDao coursesDao = new CourseDao();
			    SemesterDao semestersDao = new SemesterDao();

			    Course coursee = coursesDao.searchCourseById(courseCode).orElse(null);
			    Semester semesteer = semestersDao.searchSemesterById(semID);

			    if (coursee != null && semesteer != null) {
			        StudentRegistrationDao regStudDaos = new StudentRegistrationDao();
			        List<Student> studentees = regStudDaos.getStudentsByCourseAndSemester(coursee, semesteer);

			        if (!studentees.isEmpty()) {
			            System.out.println("Students enrolled in " + coursee.getCourseName() + " for semester " + semesteer.getSemName() + ":");
			            for (Student student : studentees) {
			                System.out.println("- " + student.getNames() + " (" + student.getRegNo() + ")");
			            }
			        } else {
			            System.out.println("No students enrolled in this course and semester combination.");
			        }
			    } else {
			        System.out.println("Course or semester not found.");
			    }

			    System.out.println("Do you wish to continue?, yes or no ");
			    answer = input.next();
			    if (answer.equalsIgnoreCase("yes")) {
			        cond = true;
			    } else {
			        System.out.println("Thank you for using the system");
			        cond = false;
			    }
			    break;
			    
			case 12:
			    System.out.println("Enter Department Code:");
			    departmentCode = input.next();
			    System.out.println("Enter Semester ID:");
			    semID = input.next();

			 
			    AcademicUnit departmentss = acDao.searchUnitById(departmentCode);
			    SemesterDao semestersDaos = new SemesterDao();
			    Semester semesterss = semestersDaos.searchSemesterById(semID);

			    if (departmentss != null && semesterss != null) {
			        CourseDao coursesDaos = new CourseDao();
			        List<Course> coursees = coursesDaos.getCoursesByDepartmentAndSemester(departmentss, semesterss);

			        if (!coursees.isEmpty()) {
			            System.out.println("Courses offered by " + departmentss.getUnitName() + " department for semester " + semesterss.getSemName() + ":");
			            for (Course coursed : coursees) {
			                System.out.println("- " + coursed.getCourseName() + " (" + coursed.getCourseCode() + ")");
			            }
			        } else {
			            System.out.println("No courses found for this department and semester combination.");
			        }
			    } else {
			        System.out.println("Department or semester not found.");
			    }

			    System.out.println("Do you wish to continue?, yes or no ");
			    answer = input.next();
			    if (answer.equalsIgnoreCase("yes")) {
			        cond = true;
			    } else {
			        System.out.println("Thank you for using the system");
			        cond = false;
			    }
			    break;
			    
			case 13:
			    System.out.println("Enter Student ID: ");
			    studentId = input.next();

			    StudentDao studentDao = new StudentDao();
			    Student student = studentDao.searchStudentById(studentId);

			    if (student != null) {
			        CourseDao coursesDaot = new CourseDao();
			        List<Course> coursesd = coursesDaot.getCoursesByStudent(student);

			        if (!coursesd.isEmpty()) {
			            System.out.println("Courses for student " + student.getNames() + " (" + student.getRegNo() + "):");
			            for (Course coursed : coursesd) {
			                System.out.println("- " + coursed.getCourseName() + " (" + coursed.getCourseCode() + ")");
			            }
			        } else {
			            System.out.println("No courses found for the given student ID.");
			        }
			    } else {
			        System.out.println("Student not found.");
			    }

			    System.out.println("Do you wish to continue?, yes or no ");
			    answer = input.next();
			    if (answer.equalsIgnoreCase("yes")) {
			        cond = true;
			    } else {
			        System.out.println("Thank you for using the system");
			        cond = false;
			    }
			    break;
             case 0:
                 System.out.println("Thank you for using our  system");
                 cond = false;
                 break;
				
			}
		}
		

		
	}

}
