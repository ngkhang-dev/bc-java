package model;

import java.sql.Date;

public class Project {
	private int id;
	private String projectName;
	private Date startDate;
	private Date endDate;

	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(String projectName, Date startDate, Date endDate) {
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Project(int id, String projectName, Date startDate, Date endDate) {
		this.id = id;
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
