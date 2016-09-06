package model.jps.entities.qmis.base;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the incident_diagnosis_reports database table.
 * 
 */
@Entity
@Table(name="incident_diagnosis_reports")
@NamedQuery(name="IncidentDiagnosisReport.findAll", query="SELECT i FROM IncidentDiagnosisReport i")
public class IncidentDiagnosisReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private Object actions;

	private Object appearance;

	private Object conclusion;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;

	private Object investigation;

	@Column(name="last_ip_address")
	private String lastIpAddress;

	@Column(name="mechanism_analysis")
	private Object mechanismAnalysis;

	private String name;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_time")
	private Date updatedTime;

	//bi-directional many-to-one association to IncidentBase
	@OneToMany(mappedBy="incidentDiagnosisReport")
	private List<IncidentBase> incidentBases;

	public IncidentDiagnosisReport() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Object getActions() {
		return this.actions;
	}

	public void setActions(Object actions) {
		this.actions = actions;
	}

	public Object getAppearance() {
		return this.appearance;
	}

	public void setAppearance(Object appearance) {
		this.appearance = appearance;
	}

	public Object getConclusion() {
		return this.conclusion;
	}

	public void setConclusion(Object conclusion) {
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

	public Object getInvestigation() {
		return this.investigation;
	}

	public void setInvestigation(Object investigation) {
		this.investigation = investigation;
	}

	public String getLastIpAddress() {
		return this.lastIpAddress;
	}

	public void setLastIpAddress(String lastIpAddress) {
		this.lastIpAddress = lastIpAddress;
	}

	public Object getMechanismAnalysis() {
		return this.mechanismAnalysis;
	}

	public void setMechanismAnalysis(Object mechanismAnalysis) {
		this.mechanismAnalysis = mechanismAnalysis;
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
		incidentBas.setIncidentDiagnosisReport(this);

		return incidentBas;
	}

	public IncidentBase removeIncidentBas(IncidentBase incidentBas) {
		getIncidentBases().remove(incidentBas);
		incidentBas.setIncidentDiagnosisReport(null);

		return incidentBas;
	}

}