package model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the incident_base database table.
 * 
 */
@Entity
@Table(name="incident_base")
@NamedQuery(name="IncidentBase.findAll", query="SELECT i FROM IncidentBase i")
public class IncidentBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="close_state")
	private String closeState;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="close_time")
	private Date closeTime;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;

	@Column(name="last_ip_address")
	private String lastIpAddress;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="open_time")
	private Date openTime;

	private Object overview;

	private String type;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_time")
	private Date updatedTime;

	//bi-directional many-to-one association to WorkBusinessUnit
	@ManyToOne
	@JoinColumn(name="bu")
	private WorkBusinessUnit workBusinessUnit;

	//bi-directional many-to-one association to TaskBase
	@ManyToOne
	@JoinColumn(name="task_id")
	private TaskBase taskBase;

	//bi-directional many-to-one association to IncidentType
	@ManyToOne
	@JoinColumn(name="type_id")
	private IncidentType incidentType;

	//bi-directional many-to-one association to IncidentLv
	@ManyToOne
	@JoinColumn(name="lv_id")
	private IncidentLv incidentLv;

	//bi-directional many-to-one association to IncidentDiagnosisReport
	@ManyToOne
	@JoinColumn(name="diagnosis_report_id")
	private IncidentDiagnosisReport incidentDiagnosisReport;

	//bi-directional many-to-one association to IncidentCloseTReport
	@ManyToOne
	@JoinColumn(name="close_t_report_id")
	private IncidentCloseTReport incidentCloseTReport;

	//bi-directional many-to-one association to IncidentCloseMReport
	@ManyToOne
	@JoinColumn(name="close_m_report_id")
	private IncidentCloseMReport incidentCloseMReport;

	public IncidentBase() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCloseState() {
		return this.closeState;
	}

	public void setCloseState(String closeState) {
		this.closeState = closeState;
	}

	public Date getCloseTime() {
		return this.closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
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

	public Date getOpenTime() {
		return this.openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	public Object getOverview() {
		return this.overview;
	}

	public void setOverview(Object overview) {
		this.overview = overview;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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

	public IncidentType getIncidentType() {
		return this.incidentType;
	}

	public void setIncidentType(IncidentType incidentType) {
		this.incidentType = incidentType;
	}

	public IncidentLv getIncidentLv() {
		return this.incidentLv;
	}

	public void setIncidentLv(IncidentLv incidentLv) {
		this.incidentLv = incidentLv;
	}

	public IncidentDiagnosisReport getIncidentDiagnosisReport() {
		return this.incidentDiagnosisReport;
	}

	public void setIncidentDiagnosisReport(IncidentDiagnosisReport incidentDiagnosisReport) {
		this.incidentDiagnosisReport = incidentDiagnosisReport;
	}

	public IncidentCloseTReport getIncidentCloseTReport() {
		return this.incidentCloseTReport;
	}

	public void setIncidentCloseTReport(IncidentCloseTReport incidentCloseTReport) {
		this.incidentCloseTReport = incidentCloseTReport;
	}

	public IncidentCloseMReport getIncidentCloseMReport() {
		return this.incidentCloseMReport;
	}

	public void setIncidentCloseMReport(IncidentCloseMReport incidentCloseMReport) {
		this.incidentCloseMReport = incidentCloseMReport;
	}

}