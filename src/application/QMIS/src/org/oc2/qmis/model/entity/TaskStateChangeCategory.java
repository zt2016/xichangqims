package org.oc2.qmis.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the task_state_change_categories database table.
 * 
 */
@Entity
@Table(name="task_state_change_categories")
@NamedQuery(name="TaskStateChangeCategory.findAll", query="SELECT t FROM TaskStateChangeCategory t")
public class TaskStateChangeCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;

	@Column(name="last_ip_address")
	private String lastIpAddress;

	private String name;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_time")
	private Date updatedTime;

	//bi-directional many-to-one association to TaskStateChangeDetail
	@OneToMany(mappedBy="taskStateChangeCategory")
	private List<TaskStateChangeDetail> taskStateChangeDetails;

	public TaskStateChangeCategory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getLastIpAddress() {
		return this.lastIpAddress;
	}

	public void setLastIpAddress(String lastIpAddress) {
		this.lastIpAddress = lastIpAddress;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedTime() {
		return this.updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public List<TaskStateChangeDetail> getTaskStateChangeDetails() {
		return this.taskStateChangeDetails;
	}

	public void setTaskStateChangeDetails(List<TaskStateChangeDetail> taskStateChangeDetails) {
		this.taskStateChangeDetails = taskStateChangeDetails;
	}

	public TaskStateChangeDetail addTaskStateChangeDetail(TaskStateChangeDetail taskStateChangeDetail) {
		getTaskStateChangeDetails().add(taskStateChangeDetail);
		taskStateChangeDetail.setTaskStateChangeCategory(this);

		return taskStateChangeDetail;
	}

	public TaskStateChangeDetail removeTaskStateChangeDetail(TaskStateChangeDetail taskStateChangeDetail) {
		getTaskStateChangeDetails().remove(taskStateChangeDetail);
		taskStateChangeDetail.setTaskStateChangeCategory(null);

		return taskStateChangeDetail;
	}

}