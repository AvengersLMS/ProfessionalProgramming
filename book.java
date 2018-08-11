import java.io.Serializable;


@SuppressWarnings("serial")
public class Book implements Serializable {
	
	private String title;
	private String author;
	private String callNumber;
	private int bookID;
	
	private enum STATE { AVAILABLE, ON_LOAN, DAMAGED, RESERVED };
	private STATE state;
	
	
	public Book(String author, String title, String callNo, int id) {
		this.author = author;
		this.title = title;
		this.callNumber = callNo;
		this.bookID = id;
		this.state = STATE.AVAILABLE;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Book: ").append(bookID).append("\n")
		  .append("  Title:  ").append(title).append("\n")
		  .append("  Author: ").append(author).append("\n")
		  .append("  CallNo: ").append(callNumber).append("\n")
		  .append("  State:  ").append(state);
		
		return sb.toString();
	}

	public Integer bookID() {
		return bookID;
	}

	public String title() {
		return title;
	}


	
	public boolean available() {
		return state == STATE.AVAILABLE;
	}

	
	public boolean onLoan() {
		return state == STATE.ON_LOAN;
	}

	
	public boolean damaged() {
		return state == STATE.DAMAGED;
	}

	
	public void borrow() {
		if (state.equals(STATE.AVAILABLE)) {
			state = STATE.ON_LOAN;
		}
		else {
			throw new RuntimeException(String.format("Book: cannot borrow while book is in state: %s", state));
		}
		
	}


	public void returnState(boolean DAMAGED) {
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

	
	public void repair() {
		if (state.equals(STATE.DAMAGED)) {
			state = STATE.AVAILABLE;
		}
		else {
			throw new RuntimeException(String.format("Book: cannot repair while book is in state: %s", state));
		}
	}


}
