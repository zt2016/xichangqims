package org.oc2.qmis.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the risk_lv database table.
 * 
 */
@Entity
@Table(name="risk_lv")
@NamedQuery(name="RiskLv.findAll", query="SELECT r FROM RiskLv r")
public class RiskLv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

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
	@OneToMany(mappedBy="riskLv")
	private List<RiskBase> riskBases;

	public RiskLv() {
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
		riskBas.setRiskLv(this);

		return riskBas;
	}

	public RiskBase removeRiskBas(RiskBase riskBas) {
		getRiskBases().remove(riskBas);
		riskBas.setRiskLv(null);

		return riskBas;
	}

}