package fouTurfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fouTurfer.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

	UserAccount findByUserName(String userName);
}
