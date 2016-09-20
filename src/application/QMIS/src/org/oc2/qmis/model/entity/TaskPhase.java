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
	@OneToMany(mappedBy="taskPhase")
	private List<RiskCtrlAction> riskCtrlActions;

	//bi-directional many-to-one association to RiskCheckAction
	@OneToMany(mappedBy="taskPhase")
	private List<RiskCheckAction> riskCheckActions;

	//bi-directional many-to-one association to TaskPhaseControl
	@OneToMany(mappedBy="taskPhase")
	private List<TaskPhaseControl> taskPhaseControls;

	//bi-directional many-to-one association to TaskPhase
	@ManyToOne
	//@JoinColumn(name="previous",insertable=false,updatable=false)
	@JoinColumn(name="previous")
	private TaskPhase taskPhase;

	//bi-directional many-to-one association to TaskPhase
	@OneToMany(mappedBy="taskPhase")
	private List<TaskPhase> taskPhases;

	//bi-directional many-to-one association to WorkSystem
	@ManyToOne
	//@JoinColumn(name="worksystem",insertable=false,updatable=false)
	@JoinColumn(name="worksystem")
	private WorkSystem workSystem;

	//bi-directional many-to-one association to TaskStateChangeAction
	@OneToMany(mappedBy="taskPhase")
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

	public List<RiskCtrlAction> getRiskCtrlActions() {
		return this.riskCtrlActions;
	}

	public void setRiskCtrlActions(List<RiskCtrlAction> riskCtrlActions) {
		this.riskCtrlActions = riskCtrlActions;
	}

	public RiskCtrlAction addRiskCtrlActions(RiskCtrlAction riskCtrlActions) {
		getRiskCtrlActions().add(riskCtrlActions);
		riskCtrlActions.setTaskPhase(this);

		return riskCtrlActions;
	}

	public RiskCtrlAction removeRiskCtrlActions(RiskCtrlAction riskCtrlActions) {
		getRiskCtrlActions().remove(riskCtrlActions);
		riskCtrlActions.setTaskPhase(null);

		return riskCtrlActions;
	}

	public List<RiskCheckAction> getRiskCheckActions() {
		return this.riskCheckActions;
	}

	public void setRiskCheckActions(List<RiskCheckAction> riskCheckActions) {
		this.riskCheckActions = riskCheckActions;
	}

	public RiskCheckAction addRiskCheckActions(RiskCheckAction riskCheckActions) {
		getRiskCheckActions().add(riskCheckActions);
		riskCheckActions.setTaskPhase(this);

		return riskCheckActions;
	}

	public RiskCheckAction removeRiskCheckActions(RiskCheckAction riskCheckActions) {
		getRiskCheckActions().remove(riskCheckActions);
		riskCheckActions.setTaskPhase(null);

		return riskCheckActions;
	}

	public List<TaskPhaseControl> getTaskPhaseControls() {
		return this.taskPhaseControls;
	}

	public void setTaskPhaseControls(List<TaskPhaseControl> taskPhaseControls) {
		this.taskPhaseControls = taskPhaseControls;
	}

	public TaskPhaseControl addTaskPhaseControl(TaskPhaseControl taskPhaseControl) {
		getTaskPhaseControls().add(taskPhaseControl);
		taskPhaseControl.setTaskPhase(this);

		return taskPhaseControl;
	}

	public TaskPhaseControl removeTaskPhaseControl(TaskPhaseControl taskPhaseControl) {
		getTaskPhaseControls().remove(taskPhaseControl);
		taskPhaseControl.setTaskPhase(null);

		return taskPhaseControl;
	}

	public TaskPhase getTaskPhase() {
		return this.taskPhase;
	}

	public void setTaskPhase(TaskPhase taskPhase) {
		this.taskPhase = taskPhase;
	}

	public List<TaskPhase> getTaskPhases() {
		return this.taskPhases;
	}

	public void setTaskPhases(List<TaskPhase> taskPhases) {
		this.taskPhases = taskPhases;
	}

	public TaskPhase addTaskPhas(TaskPhase taskPhase) {
		getTaskPhases().add(taskPhase);
		taskPhase.setTaskPhase(this);

		return taskPhase;
	}

	public TaskPhase removeTaskPhas(TaskPhase taskPhase) {
		getTaskPhases().remove(taskPhase);
		taskPhase.setTaskPhase(null);

		return taskPhase;
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