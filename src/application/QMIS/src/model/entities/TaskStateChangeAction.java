package model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the task_state_change_actions database table.
 * 
 */
@Entity
@Table(name="task_state_change_actions")
@NamedQuery(name="TaskStateChangeAction.findAll", query="SELECT t FROM TaskStateChangeAction t")
public class TaskStateChangeAction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String action;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;

	@Column(name="domain_impact_analysis")
	private String domainImpactAnalysis;

	@Column(name="is_completed")
	private String isCompleted;

	@Column(name="last_ip_address")
	private String lastIpAddress;

	private String result;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_time")
	private Date updatedTime;

	//bi-directional many-to-one association to TaskStateChangeDetail
	@ManyToOne
	@JoinColumn(name="state_change_details_id")
	private TaskStateChangeDetail taskStateChangeDetail;

	//bi-directional many-to-one association to TaskPhas
	@ManyToOne
	@JoinColumn(name="task_phase_id")
	private TaskPhas taskPhas;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public TaskStateChangeAction() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
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

	public String getDomainImpactAnalysis() {
		return this.domainImpactAnalysis;
	}

	public void setDomainImpactAnalysis(String domainImpactAnalysis) {
		this.domainImpactAnalysis = domainImpactAnalysis;
	}

	public String getIsCompleted() {
		return this.isCompleted;
	}

	public void setIsCompleted(String isCompleted) {
		this.isCompleted = isCompleted;
	}

	public String getLastIpAddress() {
		return this.lastIpAddress;
	}

	public void setLastIpAddress(String lastIpAddress) {
		this.lastIpAddress = lastIpAddress;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
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

	public TaskStateChangeDetail getTaskStateChangeDetail() {
		return this.taskStateChangeDetail;
	}

	public void setTaskStateChangeDetail(TaskStateChangeDetail taskStateChangeDetail) {
		this.taskStateChangeDetail = taskStateChangeDetail;
	}

	public TaskPhas getTaskPhas() {
		return this.taskPhas;
	}

	public void setTaskPhas(TaskPhas taskPhas) {
		this.taskPhas = taskPhas;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}