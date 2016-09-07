package org.oc2.qmis.model.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the role_privilege_rel database table.
 * 
 */
@Embeddable
public class RolePrivilegeRelPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="role_id", insertable=false, updatable=false)
	private int roleId;

	@Column(name="privilege_id", insertable=false, updatable=false)
	private int privilegeId;

	public RolePrivilegeRelPK() {
	}
	public int getRoleId() {
		return this.roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getPrivilegeId() {
		return this.privilegeId;
	}
	public void setPrivilegeId(int privilegeId) {
		this.privilegeId = privilegeId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RolePrivilegeRelPK)) {
			return false;
		}
		RolePrivilegeRelPK castOther = (RolePrivilegeRelPK)other;
		return 
			(this.roleId == castOther.roleId)
			&& (this.privilegeId == castOther.privilegeId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.roleId;
		hash = hash * prime + this.privilegeId;
		
		return hash;
	}
}