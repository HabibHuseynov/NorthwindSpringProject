package coding.northwind.core.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import coding.northwind.core.entities.User;

public interface UserDao extends JpaRepository<User,Integer> {
	User findByEmail(String email);

}
