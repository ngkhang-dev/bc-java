package model;

import java.sql.Date;

public class Task {
	private int id;
	private String taskName;
	private Date startDate;
	private Date endDate;
	private int userId;
	private int projectId;
	private int statusId;

	public Task() {
		// TODO Auto-generated constructor stub
	}

	public Task(String taskName, Date startDate, Date endDate, int userId, int projectId, int statusId) {
		this.taskName = taskName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userId = userId;
		this.projectId = projectId;
		this.statusId = statusId;
	}

	public Task(int id, String taskName, Date startDate, Date endDate, int userId, int projectId, int statusId) {
		this.id = id;
		this.taskName = taskName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userId = userId;
		this.projectId = projectId;
		this.statusId = statusId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
}
