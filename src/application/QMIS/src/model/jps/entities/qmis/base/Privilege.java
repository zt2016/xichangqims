package model.jps.entities.qmis.base;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the privileges database table.
 * 
 */
@Entity
@Table(name="privileges")
@NamedQuery(name="Privilege.findAll", query="SELECT p FROM Privilege p")
public class Privilege implements Serializable {
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

	@Column(name="p_status")
	private String pStatus;

	@Column(name="resource_path")
	private String resourcePath;

	@Column(name="resource_type")
	private String resourceType;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_time")
	private Date updatedTime;

	//bi-directional many-to-one association to Privilege
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Privilege privilege;

	//bi-directional many-to-one association to Privilege
	@OneToMany(mappedBy="privilege")
	private List<Privilege> privileges;

	//bi-directional many-to-one association to RolePrivilegeRel
	@OneToMany(mappedBy="privilege")
	private List<RolePrivilegeRel> rolePrivilegeRels;

	public Privilege() {
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

	public String getPStatus() {
		return this.pStatus;
	}

	public void setPStatus(String pStatus) {
		this.pStatus = pStatus;
	}

	public String getResourcePath() {
		return this.resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	public String getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
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

	public Privilege getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	public List<Privilege> getPrivileges() {
		return this.privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}

	public Privilege addPrivilege(Privilege privilege) {
		getPrivileges().add(privilege);
		privilege.setPrivilege(this);

		return privilege;
	}

	public Privilege removePrivilege(Privilege privilege) {
		getPrivileges().remove(privilege);
		privilege.setPrivilege(null);

		return privilege;
	}

	public List<RolePrivilegeRel> getRolePrivilegeRels() {
		return this.rolePrivilegeRels;
	}

	public void setRolePrivilegeRels(List<RolePrivilegeRel> rolePrivilegeRels) {
		this.rolePrivilegeRels = rolePrivilegeRels;
	}

	public RolePrivilegeRel addRolePrivilegeRel(RolePrivilegeRel rolePrivilegeRel) {
		getRolePrivilegeRels().add(rolePrivilegeRel);
		rolePrivilegeRel.setPrivilege(this);

		return rolePrivilegeRel;
	}

	public RolePrivilegeRel removeRolePrivilegeRel(RolePrivilegeRel rolePrivilegeRel) {
		getRolePrivilegeRels().remove(rolePrivilegeRel);
		rolePrivilegeRel.setPrivilege(null);

		return rolePrivilegeRel;
	}

}