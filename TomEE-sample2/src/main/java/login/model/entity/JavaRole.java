package login.model.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(RoleId.class)
@Table( name = "j_roles")
public class JavaRole implements Serializable{

	@Id
	@Column( name = "user_name", length = 30)	
	private String userName;
	@Id
	@Column( name = "role_name", length = 20)
	private String roleName = "USER"; // 網頁新增統一配置在 role: USER
	@Column( name = "active", columnDefinition = "TINYINT DEFAULT 0")
	private boolean active;	 // 交給 role:Admin 在網頁開啟認證
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_name", referencedColumnName = "user_name")
	private JavaUser javaUser;
	
	
}

