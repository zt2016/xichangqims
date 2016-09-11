package org.oc2.qmis.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the task_state_change_details database table.
 * 
 */
@Entity
@Table(name="task_state_change_details")
@NamedQuery(name="TaskStateChangeDetail.findAll", query="SELECT t FROM TaskStateChangeDetail t")
public class TaskStateChangeDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="baseline_factor")
	private String baselineFactor;

	@Column(name="baseline_task_state")
	private String baselineTaskState;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;

	@Column(name="current_task_state")
	private String currentTaskState;

	@Column(name="domain_impact_analysis")
	private String domainImpactAnalysis;

	@Column(name="last_ip_address")
	private String lastIpAddress;

	private String reason;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_time")
	private Date updatedTime;

	//bi-directional many-to-one association to TaskStateChangeAction
	@OneToMany(mappedBy="taskStateChangeDetail")
	private List<TaskStateChangeAction> taskStateChangeActions;

	//bi-directional many-to-one association to TaskBaseline
	@ManyToOne
	@JoinColumn(name="baseline_id",insertable=false,updatable=false)
	private TaskBaseline taskBaseline;

	//bi-directional many-to-one association to TaskStateChangeCategory
	@ManyToOne
	@JoinColumn(name="state_change_category",insertable=false,updatable=false)
	private TaskStateChangeCategory taskStateChangeCategory;

	//bi-directional many-to-one association to TaskStateChangeImpactLv
	@ManyToOne
	@JoinColumn(name="state_change_lv",insertable=false,updatable=false)
	private TaskStateChangeImpactLv taskStateChangeImpactLv;

	public TaskStateChangeDetail() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBaselineFactor() {
		return this.baselineFactor;
	}

	public void setBaselineFactor(String baselineFactor) {
		this.baselineFactor = baselineFactor;
	}

	public String getBaselineTaskState() {
		return this.baselineTaskState;
	}

	public void setBaselineTaskState(String baselineTaskState) {
		this.baselineTaskState = baselineTaskState;
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

	public String getCurrentTaskState() {
		return this.currentTaskState;
	}

	public void setCurrentTaskState(String currentTaskState) {
		this.currentTaskState = currentTaskState;
	}

	public String getDomainImpactAnalysis() {
		return this.domainImpactAnalysis;
	}

	public void setDomainImpactAnalysis(String domainImpactAnalysis) {
		this.domainImpactAnalysis = domainImpactAnalysis;
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

	public List<TaskStateChangeAction> getTaskStateChangeActions() {
		return this.taskStateChangeActions;
	}

	public void setTaskStateChangeActions(List<TaskStateChangeAction> taskStateChangeActions) {
		this.taskStateChangeActions = taskStateChangeActions;
	}

	public TaskStateChangeAction addTaskStateChangeAction(TaskStateChangeAction taskStateChangeAction) {
		getTaskStateChangeActions().add(taskStateChangeAction);
		taskStateChangeAction.setTaskStateChangeDetail(this);

		return taskStateChangeAction;
	}

	public TaskStateChangeAction removeTaskStateChangeAction(TaskStateChangeAction taskStateChangeAction) {
		getTaskStateChangeActions().remove(taskStateChangeAction);
		taskStateChangeAction.setTaskStateChangeDetail(null);

		return taskStateChangeAction;
	}

	public TaskBaseline getTaskBaseline() {
		return this.taskBaseline;
	}

	public void setTaskBaseline(TaskBaseline taskBaseline) {
		this.taskBaseline = taskBaseline;
	}

	public TaskStateChangeCategory getTaskStateChangeCategory() {
		return this.taskStateChangeCategory;
	}

	public void setTaskStateChangeCategory(TaskStateChangeCategory taskStateChangeCategory) {
		this.taskStateChangeCategory = taskStateChangeCategory;
	}

	public TaskStateChangeImpactLv getTaskStateChangeImpactLv() {
		return this.taskStateChangeImpactLv;
	}

	public void setTaskStateChangeImpactLv(TaskStateChangeImpactLv taskStateChangeImpactLv) {
		this.taskStateChangeImpactLv = taskStateChangeImpactLv;
	}

}