package login.model.dto.mapper;

import login.model.dto.JavaRoleDto;
import login.model.entity.JavaRole;

public class JavaRoleMapper {

	/**@value 
	 * field欄位: <br/>
	 * String userName<br/>
	 * boolean active   
	 * */
	public static JavaRole dtoToJavaRole(JavaRoleDto dto) {
		JavaRole javaRole = new JavaRole();
		javaRole.setUserName(dto.getUserName());
		javaRole.setActive(dto.isActive());
		return javaRole;
	}
	
	public static JavaRoleDto javaRoleToDto(JavaRole javaRole) {
		JavaRoleDto dto = new JavaRoleDto();
		dto.setUserName(javaRole.getUserName());
		dto.setActive(javaRole.isActive());
		return dto;
	}
}
