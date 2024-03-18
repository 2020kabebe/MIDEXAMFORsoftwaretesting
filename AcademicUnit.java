package model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name="academic_unit")
public class AcademicUnit {
	@Id
	private String unitCode;
	
	private String unitName;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "academic_unit")
	private EAcademicUnit academicUnit;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private AcademicUnit program;
	
	

	public AcademicUnit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AcademicUnit(String unitCode) {
		super();
		this.unitCode = unitCode;
	}

	public AcademicUnit(String unitCode, String unitName, EAcademicUnit academicUnit, AcademicUnit program,
			List<AcademicUnit> faculties, AcademicUnit faculty, List<AcademicUnit> departments, List<Student> students,
			List<Course> courses) {
		super();
		this.unitCode = unitCode;
		this.unitName = unitName;
		this.academicUnit = academicUnit;
		this.program = program;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public EAcademicUnit getAcademicUnit() {
		return academicUnit;
	}

	public void setAcademicUnit(EAcademicUnit academicUnit) {
		this.academicUnit = academicUnit;
	}

	public AcademicUnit getProgram() {
		return program;
	}

	public void setProgram(AcademicUnit program) {
		this.program = program;
	}

	
	
	@Override
	public String toString() {
		return "AcademicUnitModel [unitCode=" + unitCode + ", unitName=" + unitName + ", academicUnit=" + academicUnit + ", program="
				+ program + ",  ]";
	}

}
