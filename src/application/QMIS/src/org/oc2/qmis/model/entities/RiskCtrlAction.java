package org.oc2.qmis.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the risk_ctrl_actions database table.
 * 
 */
@Entity
@Table(name="risk_ctrl_actions")
@NamedQuery(name="RiskCtrlAction.findAll", query="SELECT r FROM RiskCtrlAction r")
public class RiskCtrlAction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String action;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="completion_time")
	private Date completionTime;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;

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

	//bi-directional many-to-one association to TaskPhas
	@ManyToOne
	@JoinColumn(name="task_phase_id")
	private TaskPhas taskPhas1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user1;

	//bi-directional many-to-one association to RiskBase
	@ManyToOne
	@JoinColumn(name="risk_base_id")
	private RiskBase riskBase1;

	//bi-directional many-to-one association to TaskPhas
	@ManyToOne
	@JoinColumn(name="task_phase_id")
	private TaskPhas taskPhas2;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user2;

	//bi-directional many-to-one association to RiskBase
	@ManyToOne
	@JoinColumn(name="risk_base_id")
	private RiskBase riskBase2;

	public RiskCtrlAction() {
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

	public Date getCompletionTime() {
		return this.completionTime;
	}

	public void setCompletionTime(Date completionTime) {
		this.completionTime = completionTime;
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

	public TaskPhas getTaskPhas1() {
		return this.taskPhas1;
	}

	public void setTaskPhas1(TaskPhas taskPhas1) {
		this.taskPhas1 = taskPhas1;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public RiskBase getRiskBase1() {
		return this.riskBase1;
	}

	public void setRiskBase1(RiskBase riskBase1) {
		this.riskBase1 = riskBase1;
	}

	public TaskPhas getTaskPhas2() {
		return this.taskPhas2;
	}

	public void setTaskPhas2(TaskPhas taskPhas2) {
		this.taskPhas2 = taskPhas2;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public RiskBase getRiskBase2() {
		return this.riskBase2;
	}

	public void setRiskBase2(RiskBase riskBase2) {
		this.riskBase2 = riskBase2;
	}

}