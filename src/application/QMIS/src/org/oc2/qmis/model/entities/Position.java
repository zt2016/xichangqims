package org.oc2.qmis.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the positions database table.
 * 
 */
@Entity
@Table(name="positions")
@NamedQuery(name="Position.findAll", query="SELECT p FROM Position p")
public class Position implements Serializable {
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

	//bi-directional many-to-one association to WorkBusinessUnit
	@ManyToOne
	@JoinColumn(name="bu")
	private WorkBusinessUnit workBusinessUnit;

	//bi-directional many-to-one association to RolePositionRel
	@OneToMany(mappedBy="position")
	private List<RolePositionRel> rolePositionRels;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="positionBean")
	private List<User> users;

	public Position() {
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

	public WorkBusinessUnit getWorkBusinessUnit() {
		return this.workBusinessUnit;
	}

	public void setWorkBusinessUnit(WorkBusinessUnit workBusinessUnit) {
		this.workBusinessUnit = workBusinessUnit;
	}

	public List<RolePositionRel> getRolePositionRels() {
		return this.rolePositionRels;
	}

	public void setRolePositionRels(List<RolePositionRel> rolePositionRels) {
		this.rolePositionRels = rolePositionRels;
	}

	public RolePositionRel addRolePositionRel(RolePositionRel rolePositionRel) {
		getRolePositionRels().add(rolePositionRel);
		rolePositionRel.setPosition(this);

		return rolePositionRel;
	}

	public RolePositionRel removeRolePositionRel(RolePositionRel rolePositionRel) {
		getRolePositionRels().remove(rolePositionRel);
		rolePositionRel.setPosition(null);

		return rolePositionRel;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setPositionBean(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setPositionBean(null);

		return user;
	}

}