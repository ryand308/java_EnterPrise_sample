package login.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import login.model.dto.JavaRoleDto;
import login.model.dto.mapper.JavaRoleMapper;
import login.model.entity.JavaRole;
import login.model.entity.JavaUser;
import login.model.entity.RoleId;
import login.repository.JavaRoleRepository;
import login.service.utility.CryptoUtility;

@ApplicationScoped
public class JavaRoleService {
	@Inject
	private JavaRoleRepository repository;
	@Inject
	private Instance<CryptoUtility> crypto;
	
	public boolean inserRole(String username, String password, String check) {
		if(Stream.of(username, password, check).anyMatch(u -> u.trim().matches("")))
			return false;
		if(!password.equals(check)) // 檢查新增密碼
			return false;
		RoleId roleId = new RoleId(username, "USER"); // 檢查使用者是否已使用		
		if(repository.findById(roleId) != null)
			return false;
		
		String hashPassword = crypto.get().hashPassword(password); // 密碼加密儲存
		JavaUser javaUser = new JavaUser();
		javaUser.setUserName(username);
		javaUser.setPassword(hashPassword);		
		
		JavaRole javaRole = new JavaRole();
		javaRole.setUserName(username);		
		
		javaRole.setJavaUser(javaUser); // add cascade
		repository.add(javaRole);
		return true;
	}
	
	public List<JavaRoleDto> findAllUser() {
		List<JavaRole> javaRoleList =  repository.findUser();
		
		List<JavaRoleDto> list = javaRoleList.stream()
											.map(javaRole -> JavaRoleMapper.javaRoleToDto(javaRole))
											.collect(Collectors.toList());		
		return list;
	}
	
	public void updateActive(String user, String active) {
		boolean isActive = Boolean.parseBoolean(active);
		
		JavaRole javaRole = repository.findById(new RoleId(user, "USER"));
		javaRole.setActive(isActive);
		
		repository.update(javaRole);
	}
	
	public boolean findUserActive(String principal) {
		JavaRole javaRole = repository.findById(new RoleId(principal, "USER"));
		if(javaRole != null && javaRole.isActive())	{
			System.out.println(JavaRoleMapper.javaRoleToDto(javaRole));
			return true;			
		}
		
		return false;
	}
}
