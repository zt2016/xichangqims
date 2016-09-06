package model.jps.entities.qmis.base;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
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

	//bi-directional many-to-one association to RolePositionRel
	@OneToMany(mappedBy="role")
	private List<RolePositionRel> rolePositionRels;

	//bi-directional many-to-one association to RolePrivilegeRel
	@OneToMany(mappedBy="role")
	private List<RolePrivilegeRel> rolePrivilegeRels;

	public Role() {
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

	public List<RolePositionRel> getRolePositionRels() {
		return this.rolePositionRels;
	}

	public void setRolePositionRels(List<RolePositionRel> rolePositionRels) {
		this.rolePositionRels = rolePositionRels;
	}

	public RolePositionRel addRolePositionRel(RolePositionRel rolePositionRel) {
		getRolePositionRels().add(rolePositionRel);
		rolePositionRel.setRole(this);

		return rolePositionRel;
	}

	public RolePositionRel removeRolePositionRel(RolePositionRel rolePositionRel) {
		getRolePositionRels().remove(rolePositionRel);
		rolePositionRel.setRole(null);

		return rolePositionRel;
	}

	public List<RolePrivilegeRel> getRolePrivilegeRels() {
		return this.rolePrivilegeRels;
	}

	public void setRolePrivilegeRels(List<RolePrivilegeRel> rolePrivilegeRels) {
		this.rolePrivilegeRels = rolePrivilegeRels;
	}

	public RolePrivilegeRel addRolePrivilegeRel(RolePrivilegeRel rolePrivilegeRel) {
		getRolePrivilegeRels().add(rolePrivilegeRel);
		rolePrivilegeRel.setRole(this);

		return rolePrivilegeRel;
	}

	public RolePrivilegeRel removeRolePrivilegeRel(RolePrivilegeRel rolePrivilegeRel) {
		getRolePrivilegeRels().remove(rolePrivilegeRel);
		rolePrivilegeRel.setRole(null);

		return rolePrivilegeRel;
	}

}