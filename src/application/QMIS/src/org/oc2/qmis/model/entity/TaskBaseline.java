package org.oc2.qmis.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the task_baselines database table.
 * 
 */
@Entity
@Table(name="task_baselines")
@NamedQuery(name="TaskBaseline.findAll", query="SELECT t FROM TaskBaseline t")
public class TaskBaseline implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;

	@Column(name="last_ip_address")
	private String lastIpAddress;

	private String reason;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_time")
	private Date updatedTime;

	//bi-directional many-to-one association to TaskBase
	@ManyToOne
	@JoinColumn(name="current_task",insertable=false,updatable=false)
	private TaskBase taskBase1;

	//bi-directional many-to-one association to TaskBase
	@ManyToOne
	@JoinColumn(name="baseline_task",insertable=false,updatable=false)
	private TaskBase taskBase2;

	//bi-directional many-to-one association to WorkBusinessUnit
	@ManyToOne
	@JoinColumn(name="bu",insertable=false,updatable=false)
	private WorkBusinessUnit workBusinessUnit;

	//bi-directional many-to-one association to TaskStateChangeDetail
	@OneToMany(mappedBy="taskBaseline")
	private List<TaskStateChangeDetail> taskStateChangeDetails;

	public TaskBaseline() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public TaskBase getTaskBase1() {
		return this.taskBase1;
	}

	public void setTaskBase1(TaskBase taskBase1) {
		this.taskBase1 = taskBase1;
	}

	public TaskBase getTaskBase2() {
		return this.taskBase2;
	}

	public void setTaskBase2(TaskBase taskBase2) {
		this.taskBase2 = taskBase2;
	}

	public WorkBusinessUnit getWorkBusinessUnit() {
		return this.workBusinessUnit;
	}

	public void setWorkBusinessUnit(WorkBusinessUnit workBusinessUnit) {
		this.workBusinessUnit = workBusinessUnit;
	}

	public List<TaskStateChangeDetail> getTaskStateChangeDetails() {
		return this.taskStateChangeDetails;
	}

	public void setTaskStateChangeDetails(List<TaskStateChangeDetail> taskStateChangeDetails) {
		this.taskStateChangeDetails = taskStateChangeDetails;
	}

	public TaskStateChangeDetail addTaskStateChangeDetail(TaskStateChangeDetail taskStateChangeDetail) {
		getTaskStateChangeDetails().add(taskStateChangeDetail);
		taskStateChangeDetail.setTaskBaseline(this);

		return taskStateChangeDetail;
	}

	public TaskStateChangeDetail removeTaskStateChangeDetail(TaskStateChangeDetail taskStateChangeDetail) {
		getTaskStateChangeDetails().remove(taskStateChangeDetail);
		taskStateChangeDetail.setTaskBaseline(null);

		return taskStateChangeDetail;
	}

}