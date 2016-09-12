package org.oc2.qmis.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the risk_base database table.
 * 
 */
@Entity
@Table(name="risk_base")
@NamedQuery(name="RiskBase.findAll", query="SELECT r FROM RiskBase r")
public class RiskBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String consequence;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;

	@Column(name="last_ip_address")
	private String lastIpAddress;

	private String name;

	private String rootcause;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_time")
	private Date updatedTime;

	//bi-directional many-to-one association to WorkBusinessUnit
	@ManyToOne
	@JoinColumn(name="bu",insertable=false,updatable=false)
	private WorkBusinessUnit workBusinessUnit;

	//bi-directional many-to-one association to TaskBase
	@ManyToOne
	@JoinColumn(name="task_id",insertable=false,updatable=false)
	private TaskBase taskBase;

	//bi-directional many-to-one association to RiskType
	@ManyToOne
	@JoinColumn(name="type",insertable=false,updatable=false)
	private RiskType riskType;

	//bi-directional many-to-one association to RiskImpactLv
	@ManyToOne
	@JoinColumn(name="impactlevel",insertable=false,updatable=false)
	private RiskImpactLv riskImpactLv;

	//bi-directional many-to-one association to RiskSeverityLv
	@ManyToOne
	@JoinColumn(name="severitylevel",insertable=false,updatable=false)
	private RiskSeverityLv riskSeverityLv;

	//bi-directional many-to-one association to RiskCategory
	@ManyToOne
	@JoinColumn(name="category",insertable=false,updatable=false)
	private RiskCategory riskCategory;

	//bi-directional many-to-one association to RiskProbabilityLv
	@ManyToOne
	@JoinColumn(name="probabilitylevel",insertable=false,updatable=false)
	private RiskProbabilityLv riskProbabilityLv;

	//bi-directional many-to-one association to RiskLv
	@ManyToOne
	@JoinColumn(name="risklevel",insertable=false,updatable=false)
	private RiskLv riskLv;

	//bi-directional many-to-one association to RiskCtrlAction
	@OneToMany(mappedBy="riskBase1")
	private List<RiskCtrlAction> riskCtrlActions1;

	//bi-directional many-to-one association to RiskCtrlAction
	@OneToMany(mappedBy="riskBase2")
	private List<RiskCtrlAction> riskCtrlActions2;

	public RiskBase() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConsequence() {
		return this.consequence;
	}

	public void setConsequence(String consequence) {
		this.consequence = consequence;
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

	public String getRootcause() {
		return this.rootcause;
	}

	public void setRootcause(String rootcause) {
		this.rootcause = rootcause;
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

	public WorkBusinessUnit getWorkBusinessUnit() {
		return this.workBusinessUnit;
	}

	public void setWorkBusinessUnit(WorkBusinessUnit workBusinessUnit) {
		this.workBusinessUnit = workBusinessUnit;
	}

	public TaskBase getTaskBase() {
		return this.taskBase;
	}

	public void setTaskBase(TaskBase taskBase) {
		this.taskBase = taskBase;
	}

	public RiskType getRiskType() {
		return this.riskType;
	}

	public void setRiskType(RiskType riskType) {
		this.riskType = riskType;
	}

	public RiskImpactLv getRiskImpactLv() {
		return this.riskImpactLv;
	}

	public void setRiskImpactLv(RiskImpactLv riskImpactLv) {
		this.riskImpactLv = riskImpactLv;
	}

	public RiskSeverityLv getRiskSeverityLv() {
		return this.riskSeverityLv;
	}

	public void setRiskSeverityLv(RiskSeverityLv riskSeverityLv) {
		this.riskSeverityLv = riskSeverityLv;
	}

	public RiskCategory getRiskCategory() {
		return this.riskCategory;
	}

	public void setRiskCategory(RiskCategory riskCategory) {
		this.riskCategory = riskCategory;
	}

	public RiskProbabilityLv getRiskProbabilityLv() {
		return this.riskProbabilityLv;
	}

	public void setRiskProbabilityLv(RiskProbabilityLv riskProbabilityLv) {
		this.riskProbabilityLv = riskProbabilityLv;
	}

	public RiskLv getRiskLv() {
		return this.riskLv;
	}

	public void setRiskLv(RiskLv riskLv) {
		this.riskLv = riskLv;
	}

	public List<RiskCtrlAction> getRiskCtrlActions1() {
		return this.riskCtrlActions1;
	}

	public void setRiskCtrlActions1(List<RiskCtrlAction> riskCtrlActions1) {
		this.riskCtrlActions1 = riskCtrlActions1;
	}

	public RiskCtrlAction addRiskCtrlActions1(RiskCtrlAction riskCtrlActions1) {
		getRiskCtrlActions1().add(riskCtrlActions1);
		riskCtrlActions1.setRiskBase1(this);

		return riskCtrlActions1;
	}

	public RiskCtrlAction removeRiskCtrlActions1(RiskCtrlAction riskCtrlActions1) {
		getRiskCtrlActions1().remove(riskCtrlActions1);
		riskCtrlActions1.setRiskBase1(null);

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
		riskCtrlActions2.setRiskBase2(this);

		return riskCtrlActions2;
	}

	public RiskCtrlAction removeRiskCtrlActions2(RiskCtrlAction riskCtrlActions2) {
		getRiskCtrlActions2().remove(riskCtrlActions2);
		riskCtrlActions2.setRiskBase2(null);

		return riskCtrlActions2;
	}

}