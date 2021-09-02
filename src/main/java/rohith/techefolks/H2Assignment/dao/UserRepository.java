package rohith.techefolks.H2Assignment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rohith.techefolks.H2Assignment.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByMobile(Long mobile);

	User findByFirstname(String firstname);

	User findByLastname(String lastname);

	User findByAddress(String address);
	
	

	@Query("SELECT description FROM Todo WHERE (ut_fk = ?1) and completed = false")
	List<String> finTodosIdIncomplete(int ut_fk);

	@Query("SELECT description FROM Todo WHERE (ut_fk = ?1) and favourite = true")
	List<String> finTodosFavourite(int ut_fk);

	@Query("SELECT description FROM Todo WHERE (ut_fk = ?1) and completed = true")
	List<String> finTodosIdCompleted(int ut_fk);
}
