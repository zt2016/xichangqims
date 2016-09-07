package model.entities;

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

	@Column(name="risk_base_id")
	private int riskBaseId;

	@Column(name="task_phase_id")
	private int taskPhaseId;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_time")
	private Date updatedTime;

	@Column(name="user_id")
	private int userId;

	public RiskCheckAction() {
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

	public int getRiskBaseId() {
		return this.riskBaseId;
	}

	public void setRiskBaseId(int riskBaseId) {
		this.riskBaseId = riskBaseId;
	}

	public int getTaskPhaseId() {
		return this.taskPhaseId;
	}

	public void setTaskPhaseId(int taskPhaseId) {
		this.taskPhaseId = taskPhaseId;
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

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}