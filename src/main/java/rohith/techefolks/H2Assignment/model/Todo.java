package rohith.techefolks.H2Assignment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Todo_Tbl")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int tid;
	String description;
	boolean completed;
	boolean favourite;
	
	@ManyToOne
	private User user;

	public Todo(int tid, String description, boolean completed, boolean favourite) {
		super();
		this.tid = tid;
		this.description = description;
		this.completed = completed;
		this.favourite = favourite;
	}

	public Todo() {
		super();
	}

	public int geTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public boolean isFavourite() {
		return favourite;
	}

	public void setFavourite(boolean favourite) {
		this.favourite = favourite;
	}

}
