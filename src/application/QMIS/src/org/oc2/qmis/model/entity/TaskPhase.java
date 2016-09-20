package org.oc2.qmis.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the task_phases database table.
 * 
 */
@Entity
@Table(name="task_phases")
@NamedQuery(name="TaskPhase.findAll", query="SELECT t FROM TaskPhase t")
public class TaskPhase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

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

	//bi-directional many-to-one association to RiskCtrlAction
	@OneToMany(mappedBy="taskPhas1")
	private List<RiskCtrlAction> riskCtrlActions1;

	//bi-directional many-to-one association to RiskCtrlAction
	@OneToMany(mappedBy="taskPhas2")
	private List<RiskCtrlAction> riskCtrlActions2;

	//bi-directional many-to-one association to TaskPhaseControl
	@OneToMany(mappedBy="taskPhas")
	private List<TaskPhaseControl> taskPhaseControls;

	//bi-directional many-to-one association to TaskPhas
	@ManyToOne
	@JoinColumn(name="previous",insertable=false,updatable=false)
	private TaskPhase taskPhas;

	//bi-directional many-to-one association to TaskPhas
	@OneToMany(mappedBy="taskPhas")
	private List<TaskPhase> taskPhases;

	//bi-directional many-to-one association to WorkSystem
	@ManyToOne
	@JoinColumn(name="worksystem",insertable=false,updatable=false)
	private WorkSystem workSystem;

	//bi-directional many-to-one association to TaskStateChangeAction
	@OneToMany(mappedBy="taskPhas")
	private List<TaskStateChangeAction> taskStateChangeActions;

	public TaskPhase() {
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

	public List<RiskCtrlAction> getRiskCtrlActions1() {
		return this.riskCtrlActions1;
	}

	public void setRiskCtrlActions1(List<RiskCtrlAction> riskCtrlActions1) {
		this.riskCtrlActions1 = riskCtrlActions1;
	}

	public RiskCtrlAction addRiskCtrlActions1(RiskCtrlAction riskCtrlActions1) {
		getRiskCtrlActions1().add(riskCtrlActions1);
		riskCtrlActions1.setTaskPhas1(this);

		return riskCtrlActions1;
	}

	public RiskCtrlAction removeRiskCtrlActions1(RiskCtrlAction riskCtrlActions1) {
		getRiskCtrlActions1().remove(riskCtrlActions1);
		riskCtrlActions1.setTaskPhas1(null);

		return riskCtrlActions1;
	}

	public List<RiskCtrlAction> getRiskCtrlActions2() {
		return this.riskCtrlActions2;
	}

	public void setRiskCtrlActions2(List<RiskCtrlAction> riskCtrlActions2) {
		this.riskCtrlActions2 = riskCtrlActions2;
	}

	public RiskCtrlAction addRiskCtrlActions2(RiskCtrlAction riskCtrlActions2) {
		getRiskCtrlActions2().add(riskCtrlActions2);
		riskCtrlActions2.setTaskPhas2(this);

		return riskCtrlActions2;
	}

	public RiskCtrlAction removeRiskCtrlActions2(RiskCtrlAction riskCtrlActions2) {
		getRiskCtrlActions2().remove(riskCtrlActions2);
		riskCtrlActions2.setTaskPhas2(null);

		return riskCtrlActions2;
	}

	public List<TaskPhaseControl> getTaskPhaseControls() {
		return this.taskPhaseControls;
	}

	public void setTaskPhaseControls(List<TaskPhaseControl> taskPhaseControls) {
		this.taskPhaseControls = taskPhaseControls;
	}

	public TaskPhaseControl addTaskPhaseControl(TaskPhaseControl taskPhaseControl) {
		getTaskPhaseControls().add(taskPhaseControl);
		taskPhaseControl.setTaskPhas(this);

		return taskPhaseControl;
	}

	public TaskPhaseControl removeTaskPhaseControl(TaskPhaseControl taskPhaseControl) {
		getTaskPhaseControls().remove(taskPhaseControl);
		taskPhaseControl.setTaskPhas(null);

		return taskPhaseControl;
	}

	public TaskPhase getTaskPhas() {
		return this.taskPhas;
	}

	public void setTaskPhas(TaskPhase taskPhas) {
		this.taskPhas = taskPhas;
	}

	public List<TaskPhase> getTaskPhases() {
		return this.taskPhases;
	}

	public void setTaskPhases(List<TaskPhase> taskPhases) {
		this.taskPhases = taskPhases;
	}

	public TaskPhase addTaskPhas(TaskPhase taskPhas) {
		getTaskPhases().add(taskPhas);
		taskPhas.setTaskPhas(this);

		return taskPhas;
	}

	public TaskPhase removeTaskPhas(TaskPhase taskPhas) {
		getTaskPhases().remove(taskPhas);
		taskPhas.setTaskPhas(null);

		return taskPhas;
	}

	public WorkSystem getWorkSystem() {
		return this.workSystem;
	}

	public void setWorkSystem(WorkSystem workSystem) {
		this.workSystem = workSystem;
	}

	public List<TaskStateChangeAction> getTaskStateChangeActions() {
		return this.taskStateChangeActions;
	}

	public void setTaskStateChangeActions(List<TaskStateChangeAction> taskStateChangeActions) {
		this.taskStateChangeActions = taskStateChangeActions;
	}

	public TaskStateChangeAction addTaskStateChangeAction(TaskStateChangeAction taskStateChangeAction) {
		getTaskStateChangeActions().add(taskStateChangeAction);
		taskStateChangeAction.setTaskPhas(this);

		return taskStateChangeAction;
	}

	public TaskStateChangeAction removeTaskStateChangeAction(TaskStateChangeAction taskStateChangeAction) {
		getTaskStateChangeActions().remove(taskStateChangeAction);
		taskStateChangeAction.setTaskPhas(null);

		return taskStateChangeAction;
	}

}