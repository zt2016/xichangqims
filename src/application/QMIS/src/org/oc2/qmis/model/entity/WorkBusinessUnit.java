package org.oc2.qmis.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the work_business_units database table.
 * 
 */
@Entity
@Table(name="work_business_units")
@NamedQuery(name="WorkBusinessUnit.findAll", query="SELECT w FROM WorkBusinessUnit w")
public class WorkBusinessUnit implements Serializable {
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

	private Integer level;

	private String name;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_time")
	private Date updatedTime;

	//bi-directional many-to-one association to IncidentBase
	@OneToMany(mappedBy="workBusinessUnit")
	private List<IncidentBase> incidentBases;

	//bi-directional many-to-one association to Position
	@OneToMany(mappedBy="workBusinessUnit")
	private List<Position> positions;

	//bi-directional many-to-one association to RiskBase
	@OneToMany(mappedBy="workBusinessUnit")
	private List<RiskBase> riskBases;

	//bi-directional many-to-one association to TaskBaseline
	@OneToMany(mappedBy="workBusinessUnit")
	private List<TaskBaseline> taskBaselines;

	//bi-directional many-to-one association to WorkBusinessUnit
	@ManyToOne
	@JoinColumn(name="parent_bu",insertable=false,updatable=false)
	private WorkBusinessUnit workBusinessUnit;

	//bi-directional many-to-one association to WorkBusinessUnit
	@OneToMany(mappedBy="workBusinessUnit")
	private List<WorkBusinessUnit> workBusinessUnits;

	//bi-directional many-to-one association to WorkSystem
	@ManyToOne
	@JoinColumn(name="worksystem",insertable=false,updatable=false)
	private WorkSystem workSystem;

	public WorkBusinessUnit() {
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

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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

	public List<IncidentBase> getIncidentBases() {
		return this.incidentBases;
	}

	public void setIncidentBases(List<IncidentBase> incidentBases) {
		this.incidentBases = incidentBases;
	}

	public IncidentBase addIncidentBas(IncidentBase incidentBas) {
		getIncidentBases().add(incidentBas);
		incidentBas.setWorkBusinessUnit(this);

		return incidentBas;
	}

	public IncidentBase removeIncidentBas(IncidentBase incidentBas) {
		getIncidentBases().remove(incidentBas);
		incidentBas.setWorkBusinessUnit(null);

		return incidentBas;
	}

	public List<Position> getPositions() {
		return this.positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	public Position addPosition(Position position) {
		getPositions().add(position);
		position.setWorkBusinessUnit(this);

		return position;
	}

	public Position removePosition(Position position) {
		getPositions().remove(position);
		position.setWorkBusinessUnit(null);

		return position;
	}

	public List<RiskBase> getRiskBases() {
		return this.riskBases;
	}

	public void setRiskBases(List<RiskBase> riskBases) {
		this.riskBases = riskBases;
	}

	public RiskBase addRiskBas(RiskBase riskBas) {
		getRiskBases().add(riskBas);
		riskBas.setWorkBusinessUnit(this);

		return riskBas;
	}

	public RiskBase removeRiskBas(RiskBase riskBas) {
		getRiskBases().remove(riskBas);
		riskBas.setWorkBusinessUnit(null);

		return riskBas;
	}

	public List<TaskBaseline> getTaskBaselines() {
		return this.taskBaselines;
	}

	public void setTaskBaselines(List<TaskBaseline> taskBaselines) {
		this.taskBaselines = taskBaselines;
	}

	public TaskBaseline addTaskBaseline(TaskBaseline taskBaseline) {
		getTaskBaselines().add(taskBaseline);
		taskBaseline.setWorkBusinessUnit(this);

		return taskBaseline;
	}

	public TaskBaseline removeTaskBaseline(TaskBaseline taskBaseline) {
		getTaskBaselines().remove(taskBaseline);
		taskBaseline.setWorkBusinessUnit(null);

		return taskBaseline;
	}

	public WorkBusinessUnit getWorkBusinessUnit() {
		return this.workBusinessUnit;
	}

	public void setWorkBusinessUnit(WorkBusinessUnit workBusinessUnit) {
		this.workBusinessUnit = workBusinessUnit;
	}

	public List<WorkBusinessUnit> getWorkBusinessUnits() {
		return this.workBusinessUnits;
	}

	public void setWorkBusinessUnits(List<WorkBusinessUnit> workBusinessUnits) {
		this.workBusinessUnits = workBusinessUnits;
	}

	public WorkBusinessUnit addWorkBusinessUnit(WorkBusinessUnit workBusinessUnit) {
		getWorkBusinessUnits().add(workBusinessUnit);
		workBusinessUnit.setWorkBusinessUnit(this);

		return workBusinessUnit;
	}

	public WorkBusinessUnit removeWorkBusinessUnit(WorkBusinessUnit workBusinessUnit) {
		getWorkBusinessUnits().remove(workBusinessUnit);
		workBusinessUnit.setWorkBusinessUnit(null);

		return workBusinessUnit;
	}

	public WorkSystem getWorkSystem() {
		return this.workSystem;
	}

	public void setWorkSystem(WorkSystem workSystem) {
		this.workSystem = workSystem;
	}

}