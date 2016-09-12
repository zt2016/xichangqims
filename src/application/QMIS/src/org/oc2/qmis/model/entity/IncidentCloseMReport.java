package org.oc2.qmis.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the incident_close_m_reports database table.
 * 
 */
@Entity
@Table(name="incident_close_m_reports")
@NamedQuery(name="IncidentCloseMReport.findAll", query="SELECT i FROM IncidentCloseMReport i")
public class IncidentCloseMReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String actions;

	private String conclusion;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;

	private String improvements;

	@Column(name="last_ip_address")
	private String lastIpAddress;

	private String name;

	@Column(name="process_overview")
	private String processOverview;

	private String recap;

	private String responsibilities;

	private String treatments;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_time")
	private Date updatedTime;

	//bi-directional many-to-one association to IncidentBase
	@OneToMany(mappedBy="incidentCloseMReport")
	private List<IncidentBase> incidentBases;

	public IncidentCloseMReport() {
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

	public String getImprovements() {
		return this.improvements;
	}

	public void setImprovements(String improvements) {
		this.improvements = improvements;
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

	public String getProcessOverview() {
		return this.processOverview;
	}

	public void setProcessOverview(String processOverview) {
		this.processOverview = processOverview;
	}

	public String getRecap() {
		return this.recap;
	}

	public void setRecap(String recap) {
		this.recap = recap;
	}

	public String getResponsibilities() {
		return this.responsibilities;
	}

	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}

	public String getTreatments() {
		return this.treatments;
	}

	public void setTreatments(String treatments) {
		this.treatments = treatments;
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
		incidentBas.setIncidentCloseMReport(this);

		return incidentBas;
	}

	public IncidentBase removeIncidentBas(IncidentBase incidentBas) {
		getIncidentBases().remove(incidentBas);
		incidentBas.setIncidentCloseMReport(null);

		return incidentBas;
	}

}