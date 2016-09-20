package org.oc2.qmis.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the risk_check_actions database table.
 * 
 */
@Entity
@Table(name="risk_check_actions")
@NamedQuery(name="RiskCheckAction.findAll", query="SELECT r FROM RiskCheckAction r")
public class RiskCheckAction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

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

	/**/ public RiskCheckAction() {}
	
	//bi-directional many-to-one association to TaskPhas
	@ManyToOne
	@JoinColumn(name="task_phase_id",insertable=false,updatable=false)
	//@JoinColumn(name="task_phase_id")
	private TaskPhase taskPhase;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id",insertable=false,updatable=false)
	//@JoinColumn(name="user_id")
	private User user;

	//bi-directional many-to-one association to RiskBase
	@ManyToOne
	@JoinColumn(name="risk_base_id",insertable=false,updatable=false)
	//@JoinColumn(name="risk_base_id")
	private RiskBase riskBase;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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
	public TaskPhase getTaskPhase() {
		return this.taskPhase;
	}

	public void setTaskPhase(TaskPhase taskPhase) {
		this.taskPhase = taskPhase;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RiskBase getRiskBase() {
		return this.riskBase;
	}

	public void setRiskBase(RiskBase riskBase) {
		this.riskBase = riskBase;
	}

}