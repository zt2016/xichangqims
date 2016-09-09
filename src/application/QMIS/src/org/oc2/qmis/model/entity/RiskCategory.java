package org.oc2.qmis.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the risk_categories database table.
 * 
 */
@Entity
@Table(name="risk_categories")
@NamedQuery(name="RiskCategory.findAll", query="SELECT r FROM RiskCategory r")
public class RiskCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String code;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;

	@Column(name="is_temporary")
	private String isTemporary;

	@Column(name="last_ip_address")
	private String lastIpAddress;

	private String level;

	private String name;

	private int parent;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_time")
	private Date updatedTime;

	//bi-directional many-to-one association to RiskBase
	@OneToMany(mappedBy="riskCategory")
	private List<RiskBase> riskBases;

	public RiskCategory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getIsTemporary() {
		return this.isTemporary;
	}

	public void setIsTemporary(String isTemporary) {
		this.isTemporary = isTemporary;
	}

	public String getLastIpAddress() {
		return this.lastIpAddress;
	}

	public void setLastIpAddress(String lastIpAddress) {
		this.lastIpAddress = lastIpAddress;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParent() {
		return this.parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
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

	public List<RiskBase> getRiskBases() {
		return this.riskBases;
	}

	public void setRiskBases(List<RiskBase> riskBases) {
		this.riskBases = riskBases;
	}

	public RiskBase addRiskBas(RiskBase riskBas) {
		getRiskBases().add(riskBas);
		riskBas.setRiskCategory(this);

		return riskBas;
	}

	public RiskBase removeRiskBas(RiskBase riskBas) {
		getRiskBases().remove(riskBas);
		riskBas.setRiskCategory(null);

		return riskBas;
	}

}