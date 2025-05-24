package login.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "j_users")
public class JavaUser implements Serializable{

	@Id
	@Column( name = "user_name", length = 30)
	private String userName;
	@Column( name = "password", length = 250, nullable = false)
	private String password;

}
