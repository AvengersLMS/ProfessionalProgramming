import java.io.Serializable;

//testing version control
@SuppressWarnings("serial")
public class Book implements Serializable { //changed book name as Book 
	
	private String title; 
	private String author;
	private String callNumber;
	private int bookID;  //changed variable names by using proper names


	
	private enum STATE { AVAILABLE, ON_LOAN, DAMAGED, RESERVED };
	private STATE state;
	
	
	public Book(String author, String title, String callNo, int id) { 
		this.author = author;
		this.title = title;
		this.callNumber = callNo;
		this.bookID = id;
		this.state = STATE.AVAILABLE; //changed those variables here as well
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Book: ").append(bookID).append("\n")
		  .append("  Title:  ").append(title).append("\n")
		  .append("  Author: ").append(author).append("\n")
		  .append("  CallNo: ").append(callNumber).append("\n")
		  .append("  State:  ").append(state); //changed variables in parameters
		
		return sb.toString();
	}

	public Integer bookID() { //changed method name as meaninfull one and start from lower case letter.
		return bookID;
	}

	public String title() { //changed method name as meaninfull one and start from lower case letter.
		return title;
	}


	
	public boolean available() { //changed method name as meaninfull one and start from lower case letter.
		return state == STATE.AVAILABLE;
	}

	
	public boolean onLoan() { //changed method name as meaninfull one and start from lower case letter.
		return state == STATE.ON_LOAN;
	}

	
	public boolean damaged() { //changed method name as meaninfull one and start from lower case letter.
		return state == STATE.DAMAGED;
	}

	
	public void borrow() { //changed method name as meaninfull one and start from lower case letter.
		if (state.equals(STATE.AVAILABLE)) {
			state = STATE.ON_LOAN;
		}
		else {
			throw new RuntimeException(String.format("Book: cannot borrow while book is in state: %s", state));
		}
		
	}


	public void returnState(boolean DAMAGED) { //changed method name as meaninfull one and start from lower case letter.
		if (state.equals(STATE.ON_LOAN)) {
			if (DAMAGED) {
				state = STATE.DAMAGED;
			}
			else {
				state = STATE.AVAILABLE;
			}
		}
		else {
			throw new RuntimeException(String.format("Book: cannot Return while book is in state: %s", state));
		}		
	}

	
	public void repair() { //modified method name start from lower case letter.
		if (state.equals(STATE.DAMAGED)) {
			state = STATE.AVAILABLE;
		}
		else {
			throw new RuntimeException(String.format("Book: cannot repair while book is in state: %s", state));
		}
	}


}
