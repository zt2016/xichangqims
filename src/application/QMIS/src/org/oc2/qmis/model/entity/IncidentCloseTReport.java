package org.oc2.qmis.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the incident_close_t_reports database table.
 * 
 */
@Entity
@Table(name="incident_close_t_reports")
@NamedQuery(name="IncidentCloseTReport.findAll", query="SELECT i FROM IncidentCloseTReport i")
public class IncidentCloseTReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String actions;

	private String appearance;

	private String conclusion;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;

	private String inference;

	private String investigation;

	@Column(name="last_ip_address")
	private String lastIpAddress;

	@Column(name="mechanism_analysis")
	private String mechanismAnalysis;

	private String name;

	private String recap;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_time")
	private Date updatedTime;

	//bi-directional many-to-one association to IncidentBase
	@OneToMany(mappedBy="incidentCloseTReport")
	private List<IncidentBase> incidentBases;

	public IncidentCloseTReport() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActions() {
		return this.actions;
	}

	public void setActions(String actions) {
		this.actions = actions;
	}

	public String getAppearance() {
		return this.appearance;
	}

	public void setAppearance(String appearance) {
		this.appearance = appearance;
	}

	public String getConclusion() {
		return this.conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
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

	public String getInference() {
		return this.inference;
	}

	public void setInference(String inference) {
		this.inference = inference;
	}

	public String getInvestigation() {
		return this.investigation;
	}

	public void setInvestigation(String investigation) {
		this.investigation = investigation;
	}

	public String getLastIpAddress() {
		return this.lastIpAddress;
	}

	public void setLastIpAddress(String lastIpAddress) {
		this.lastIpAddress = lastIpAddress;
	}

	public String getMechanismAnalysis() {
		return this.mechanismAnalysis;
	}

	public void setMechanismAnalysis(String mechanismAnalysis) {
		this.mechanismAnalysis = mechanismAnalysis;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRecap() {
		return this.recap;
	}

	public void setRecap(String recap) {
		this.recap = recap;
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
		incidentBas.setIncidentCloseTReport(this);

		return incidentBas;
	}

	public IncidentBase removeIncidentBas(IncidentBase incidentBas) {
		getIncidentBases().remove(incidentBas);
		incidentBas.setIncidentCloseTReport(null);

		return incidentBas;
	}

}