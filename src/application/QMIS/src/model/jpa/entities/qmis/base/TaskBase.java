package model.jpa.entities.qmis.base;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the task_base database table.
 * 
 */
@Entity
@Table(name="task_base")
@NamedQuery(name="TaskBase.findAll", query="SELECT t FROM TaskBase t")
public class TaskBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int category;

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

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_time")
	private Date startTime;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_time")
	private Date updatedTime;

	//bi-directional many-to-one association to IncidentBase
	@OneToMany(mappedBy="taskBase")
	private List<IncidentBase> incidentBases;

	//bi-directional many-to-one association to RiskBase
	@OneToMany(mappedBy="taskBase")
	private List<RiskBase> riskBases;

	//bi-directional many-to-one association to TaskBaseline
	@OneToMany(mappedBy="taskBase1")
	private List<TaskBaseline> taskBaselines1;

	//bi-directional many-to-one association to TaskBaseline
	@OneToMany(mappedBy="taskBase2")
	private List<TaskBaseline> taskBaselines2;

	//bi-directional many-to-one association to TaskPhaseControl
	@OneToMany(mappedBy="taskBase")
	private List<TaskPhaseControl> taskPhaseControls;

	public TaskBase() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategory() {
		return this.category;
	}

	public void setCategory(int category) {
		this.category = category;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<IncidentBase> getIncidentBases() {
		return this.incidentBases;
	}

	public void setIncidentBases(List<IncidentBase> incidentBases) {
		this.incidentBases = incidentBases;
	}

	public IncidentBase addIncidentBas(IncidentBase incidentBas) {
		getIncidentBases().add(incidentBas);
		incidentBas.setTaskBase(this);

		return incidentBas;
	}

	public IncidentBase removeIncidentBas(IncidentBase incidentBas) {
		getIncidentBases().remove(incidentBas);
		incidentBas.setTaskBase(null);

		return incidentBas;
	}

	public List<RiskBase> getRiskBases() {
		return this.riskBases;
	}

	public void setRiskBases(List<RiskBase> riskBases) {
		this.riskBases = riskBases;
	}

	public RiskBase addRiskBas(RiskBase riskBas) {
		getRiskBases().add(riskBas);
		riskBas.setTaskBase(this);

		return riskBas;
	}

	public RiskBase removeRiskBas(RiskBase riskBas) {
		getRiskBases().remove(riskBas);
		riskBas.setTaskBase(null);

		return riskBas;
	}

	public List<TaskBaseline> getTaskBaselines1() {
		return this.taskBaselines1;
	}

	public void setTaskBaselines1(List<TaskBaseline> taskBaselines1) {
		this.taskBaselines1 = taskBaselines1;
	}

	public TaskBaseline addTaskBaselines1(TaskBaseline taskBaselines1) {
		getTaskBaselines1().add(taskBaselines1);
		taskBaselines1.setTaskBase1(this);

		return taskBaselines1;
	}

	public TaskBaseline removeTaskBaselines1(TaskBaseline taskBaselines1) {
		getTaskBaselines1().remove(taskBaselines1);
		taskBaselines1.setTaskBase1(null);

		return taskBaselines1;
	}

	public List<TaskBaseline> getTaskBaselines2() {
		return this.taskBaselines2;
	}

	public void setTaskBaselines2(List<TaskBaseline> taskBaselines2) {
		this.taskBaselines2 = taskBaselines2;
	}

	public TaskBaseline addTaskBaselines2(TaskBaseline taskBaselines2) {
		getTaskBaselines2().add(taskBaselines2);
		taskBaselines2.setTaskBase2(this);

		return taskBaselines2;
	}

	public TaskBaseline removeTaskBaselines2(TaskBaseline taskBaselines2) {
		getTaskBaselines2().remove(taskBaselines2);
		taskBaselines2.setTaskBase2(null);

		return taskBaselines2;
	}

	public List<TaskPhaseControl> getTaskPhaseControls() {
		return this.taskPhaseControls;
	}

	public void setTaskPhaseControls(List<TaskPhaseControl> taskPhaseControls) {
		this.taskPhaseControls = taskPhaseControls;
	}

	public TaskPhaseControl addTaskPhaseControl(TaskPhaseControl taskPhaseControl) {
		getTaskPhaseControls().add(taskPhaseControl);
		taskPhaseControl.setTaskBase(this);

		return taskPhaseControl;
	}

	public TaskPhaseControl removeTaskPhaseControl(TaskPhaseControl taskPhaseControl) {
		getTaskPhaseControls().remove(taskPhaseControl);
		taskPhaseControl.setTaskBase(null);

		return taskPhaseControl;
	}

}