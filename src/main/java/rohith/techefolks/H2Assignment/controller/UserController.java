package rohith.techefolks.H2Assignment.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rohith.techefolks.H2Assignment.dao.TodoRepository;
import rohith.techefolks.H2Assignment.dao.UserRepository;
import rohith.techefolks.H2Assignment.model.Todo;
import rohith.techefolks.H2Assignment.model.User;

@RestController
public class UserController {

	@Autowired
	private UserRepository userrepository;
	@Autowired
	private TodoRepository todorepository;

	@PostMapping("/addUser")
	public String addUser(@Valid @RequestBody User user) {
		userrepository.save(user);
		return "Added user " + user.getId();
	}

	@GetMapping("/findAllUsers")
	public List<User> findAllUsers() {
		return userrepository.findAll();
	}

	@GetMapping("/findUserById/{id}")
	public Optional<User> findUserById(@PathVariable int id) {
		return userrepository.findById(id);
	}
	
	@GetMapping("/findUserByFirstName/{firstname}")
	public User findUserByFirstName(@PathVariable String firstname) {
		return userrepository.findByFirstname(firstname);
	}

	@GetMapping("/findUserByLastName/{lastname}")
	public User findUserByLasttName(@PathVariable String lastname) {
		return userrepository.findByLastname(lastname);
	}
	
	@GetMapping("/findUserByMobile/{mobile}")
	public User findUserByMobile(@PathVariable Long mobile) {
		return userrepository.findByMobile(mobile);
	}
	
	@GetMapping("/findUserByAddress/{address}")
	public User findUserByAddress(@PathVariable String address) {
		return userrepository.findByAddress(address);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
		userrepository.deleteById(id);
		return "User " + id +" deleted successfully";
	}
	
	@PutMapping("/updateUser/{id}")
	public User updateUser(@PathVariable int id,@RequestBody User user) {
//		User currentUser = userrepository.findById(user.getId()).orElse(null);
		User currentUser = new User();
		currentUser.setId(id);
		currentUser.setFirstname(user.getFirstname());
		currentUser.setLastname(user.getLastname());
		currentUser.setMobile(user.getMobile());
		currentUser.setAddress(user.getAddress());
		currentUser.setTodo(user.getTodo());
		return userrepository.save(currentUser);
	}
	
	@GetMapping("findTodosByIdCompleted/{ut_fk}")
	public List<String> findTodosByIdCompleted(@PathVariable int ut_fk){
		return userrepository.finTodosIdCompleted(ut_fk);
	}
	
	@GetMapping("findTodosByIdIncomplete/{ut_fk}")
	public List<String> findTodosByIdIncomplete(@PathVariable int ut_fk){
		return userrepository.finTodosIdIncomplete(ut_fk);
	}
	
	@GetMapping("findTodosByFavourite/{ut_fk}")
	public List<String> findTodosByFavourite(@PathVariable int ut_fk){
		return userrepository.finTodosFavourite(ut_fk);
	}
	
	@GetMapping("/findAllTodos/{offset}/{pagesize}")
	public Page<Todo> findAllTodos(@PathVariable int offset,@PathVariable int pagesize) {
		return todorepository.findAll(PageRequest.of(offset, pagesize));
	}
	
	@GetMapping("/findByTodoId/{tid}")
	public Optional<Todo> findByTodoId(@PathVariable int tid) {
		return todorepository.findById(tid);
	}
	
}
