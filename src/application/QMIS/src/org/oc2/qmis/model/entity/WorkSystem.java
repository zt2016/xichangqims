package org.oc2.qmis.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the work_systems database table.
 * 
 */
@Entity
@Table(name="work_systems")
@NamedQuery(name="WorkSystem.findAll", query="SELECT w FROM WorkSystem w")
public class WorkSystem implements Serializable {
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

	//bi-directional many-to-one association to TaskPhaseControl
	@OneToMany(mappedBy="workSystem")
	private List<TaskPhaseControl> taskPhaseControls;

	//bi-directional many-to-one association to TaskPhas
	@OneToMany(mappedBy="workSystem")
	private List<TaskPhas> taskPhases;

	//bi-directional many-to-one association to WorkBusinessUnit
	@OneToMany(mappedBy="workSystem")
	private List<WorkBusinessUnit> workBusinessUnits;

	public WorkSystem() {
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

	public List<TaskPhaseControl> getTaskPhaseControls() {
		return this.taskPhaseControls;
	}

	public void setTaskPhaseControls(List<TaskPhaseControl> taskPhaseControls) {
		this.taskPhaseControls = taskPhaseControls;
	}

	public TaskPhaseControl addTaskPhaseControl(TaskPhaseControl taskPhaseControl) {
		getTaskPhaseControls().add(taskPhaseControl);
		taskPhaseControl.setWorkSystem(this);

		return taskPhaseControl;
	}

	public TaskPhaseControl removeTaskPhaseControl(TaskPhaseControl taskPhaseControl) {
		getTaskPhaseControls().remove(taskPhaseControl);
		taskPhaseControl.setWorkSystem(null);

		return taskPhaseControl;
	}

	public List<TaskPhas> getTaskPhases() {
		return this.taskPhases;
	}

	public void setTaskPhases(List<TaskPhas> taskPhases) {
		this.taskPhases = taskPhases;
	}

	public TaskPhas addTaskPhas(TaskPhas taskPhas) {
		getTaskPhases().add(taskPhas);
		taskPhas.setWorkSystem(this);

		return taskPhas;
	}

	public TaskPhas removeTaskPhas(TaskPhas taskPhas) {
		getTaskPhases().remove(taskPhas);
		taskPhas.setWorkSystem(null);

		return taskPhas;
	}

	public List<WorkBusinessUnit> getWorkBusinessUnits() {
		return this.workBusinessUnits;
	}

	public void setWorkBusinessUnits(List<WorkBusinessUnit> workBusinessUnits) {
		this.workBusinessUnits = workBusinessUnits;
	}

	public WorkBusinessUnit addWorkBusinessUnit(WorkBusinessUnit workBusinessUnit) {
		getWorkBusinessUnits().add(workBusinessUnit);
		workBusinessUnit.setWorkSystem(this);

		return workBusinessUnit;
	}

	public WorkBusinessUnit removeWorkBusinessUnit(WorkBusinessUnit workBusinessUnit) {
		getWorkBusinessUnits().remove(workBusinessUnit);
		workBusinessUnit.setWorkSystem(null);

		return workBusinessUnit;
	}

}