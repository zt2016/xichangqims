package org.oc2.qmis.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the risk_types database table.
 * 
 */
@Entity
@Table(name="risk_types")
@NamedQuery(name="RiskType.findAll", query="SELECT r FROM RiskType r")
public class RiskType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;

	@Column(name="last_ip_address")
	private String lastIpAddress;

	private String name;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_time")
	private Date updatedTime;

	//bi-directional many-to-one association to RiskBase
	@OneToMany(mappedBy="riskType")
	private List<RiskBase> riskBases;

	public RiskType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	public List<RiskBase> getRiskBases() {
		return this.riskBases;
	}

	public void setRiskBases(List<RiskBase> riskBases) {
		this.riskBases = riskBases;
	}

	public RiskBase addRiskBas(RiskBase riskBas) {
		getRiskBases().add(riskBas);
		riskBas.setRiskType(this);

		return riskBas;
	}

	public RiskBase removeRiskBas(RiskBase riskBas) {
		getRiskBases().remove(riskBas);
		riskBas.setRiskType(null);

		return riskBas;
	}

}