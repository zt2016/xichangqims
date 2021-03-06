package org.oc2.qmis.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the task_phase_controls database table.
 * 
 */
@Entity
@Table(name="task_phase_controls")
@NamedQuery(name="TaskPhaseControl.findAll", query="SELECT t FROM TaskPhaseControl t")
public class TaskPhaseControl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_time")
	private Date endTime;

	@Column(name="last_ip_address")
	private String lastIpAddress;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_time")
	private Date startTime;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_time")
	private Date updatedTime;

	//bi-directional many-to-one association to TaskBase
	@ManyToOne
	//@JoinColumn(name="task_id",insertable=false,updatable=false)
	@JoinColumn(name="task_id")
	//@PrimaryKeyJoinColumn(name="task_id",referencedColumnName="id")
	private TaskBase taskBase;

	//bi-directional many-to-one association to TaskPhas
	@ManyToOne
	//@JoinColumn(name="task_phase_id",insertable=false,updatable=false)
	@JoinColumn(name="task_phase_id")
	//@PrimaryKeyJoinColumn(name="task_phase_id",referencedColumnName="id")
	private TaskPhase taskPhase;

	//bi-directional many-to-one association to WorkSystem
	@ManyToOne
	//@JoinColumn(name="worksystem",insertable=false,updatable=false)
	@JoinColumn(name="worksystem")
	//@PrimaryKeyJoinColumn(name="worksystem",referencedColumnName="id")
	private WorkSystem workSystem;

	public TaskPhaseControl() {
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

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getLastIpAddress() {
		return this.lastIpAddress;
	}

	public void setLastIpAddress(String lastIpAddress) {
		this.lastIpAddress = lastIpAddress;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
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

	public TaskBase getTaskBase() {
		return this.taskBase;
	}

	public void setTaskBase(TaskBase taskBase) {
		this.taskBase = taskBase;
	}

	public TaskPhase getTaskPhase() {
		return this.taskPhase;
	}

	public void setTaskPhase(TaskPhase taskPhase) {
		this.taskPhase = taskPhase;
	}

	public WorkSystem getWorkSystem() {
		return this.workSystem;
	}

	public void setWorkSystem(WorkSystem workSystem) {
		this.workSystem = workSystem;
	}

}