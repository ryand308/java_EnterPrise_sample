package login.model.entity;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;
@Data
public class RoleId implements Serializable{

	private String userName;
	private String roleName;
	
	public RoleId() {
		
	}
	
	public RoleId(String userName, String roleName) {
		this.userName = userName;
		this.roleName = roleName;
	}

	@Override
	public boolean equals(Object obj) {
		if( this == obj)
			return true;
		else if( obj instanceof RoleId)
			return this.userName.equals(((RoleId)obj).userName) && this.roleName.equals(((RoleId)obj).roleName);
		else
			return false;
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(userName, roleName);
	}
	
}
