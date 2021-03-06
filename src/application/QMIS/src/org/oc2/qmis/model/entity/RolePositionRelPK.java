package org.oc2.qmis.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the role_position_rel database table.
 * 
 */
@Embeddable
public class RolePositionRelPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="role_id", insertable=false, updatable=false)
	private Integer roleId;

	@Column(name="position_id", insertable=false, updatable=false)
	private Integer positionId;

	public RolePositionRelPK() {
	}
	public Integer getRoleId() {
		return this.roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getPositionId() {
		return this.positionId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RolePositionRelPK)) {
			return false;
		}
		RolePositionRelPK castOther = (RolePositionRelPK)other;
		return 
			(this.roleId == castOther.roleId)
			&& (this.positionId == castOther.positionId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.roleId;
		hash = hash * prime + this.positionId;
		
		return hash;
	}
}