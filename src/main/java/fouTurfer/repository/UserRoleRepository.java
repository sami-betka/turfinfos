package fouTurfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fouTurfer.model.UserAccount;
import fouTurfer.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{
	
	List<UserRole> findByUser(UserAccount user);
	
	List<UserRole> deleteByUser (UserAccount user);

}
