package model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String cert;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;

	@Column(name="last_ip_address")
	private String lastIpAddress;

	private String name;

	private String nickname;

	private String password;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_time")
	private Date updatedTime;

	//bi-directional many-to-one association to RiskCtrlAction
	@OneToMany(mappedBy="user1")
	private List<RiskCtrlAction> riskCtrlActions1;

	//bi-directional many-to-one association to RiskCtrlAction
	@OneToMany(mappedBy="user2")
	private List<RiskCtrlAction> riskCtrlActions2;

	//bi-directional many-to-one association to TaskStateChangeAction
	@OneToMany(mappedBy="user")
	private List<TaskStateChangeAction> taskStateChangeActions;

	//bi-directional many-to-one association to Position
	@ManyToOne
	@JoinColumn(name="position")
	private Position positionBean;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCert() {
		return this.cert;
	}

	public void setCert(String cert) {
		this.cert = cert;
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

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		riskCtrlActions1.setUser1(this);

		return riskCtrlActions1;
	}

	public RiskCtrlAction removeRiskCtrlActions1(RiskCtrlAction riskCtrlActions1) {
		getRiskCtrlActions1().remove(riskCtrlActions1);
		riskCtrlActions1.setUser1(null);

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
		riskCtrlActions2.setUser2(this);

		return riskCtrlActions2;
	}

	public RiskCtrlAction removeRiskCtrlActions2(RiskCtrlAction riskCtrlActions2) {
		getRiskCtrlActions2().remove(riskCtrlActions2);
		riskCtrlActions2.setUser2(null);

		return riskCtrlActions2;
	}

	public List<TaskStateChangeAction> getTaskStateChangeActions() {
		return this.taskStateChangeActions;
	}

	public void setTaskStateChangeActions(List<TaskStateChangeAction> taskStateChangeActions) {
		this.taskStateChangeActions = taskStateChangeActions;
	}

	public TaskStateChangeAction addTaskStateChangeAction(TaskStateChangeAction taskStateChangeAction) {
		getTaskStateChangeActions().add(taskStateChangeAction);
		taskStateChangeAction.setUser(this);

		return taskStateChangeAction;
	}

	public TaskStateChangeAction removeTaskStateChangeAction(TaskStateChangeAction taskStateChangeAction) {
		getTaskStateChangeActions().remove(taskStateChangeAction);
		taskStateChangeAction.setUser(null);

		return taskStateChangeAction;
	}

	public Position getPositionBean() {
		return this.positionBean;
	}

	public void setPositionBean(Position positionBean) {
		this.positionBean = positionBean;
	}

}