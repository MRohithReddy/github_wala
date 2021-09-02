package rohith.techefolks.H2Assignment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rohith.techefolks.H2Assignment.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{

}
