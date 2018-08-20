import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class Loan implements Serializable { //class name is modified by starting from uppercase letter
	
	public static enum LOAN_STATE { CURRENT, OVER_DUE, DISCHARGED };
	
	private int bookID;
	private Book bookName;
	private Member memberID;
	private Date date;      
	private LOAN_STATE state; // changed all variables using proper meaningful names 

	
	public Loan(int loanId, Book book, Member member, Date dueDate) {
		this.bookID = loanId;
		this.bookName = book;
		this.memberID = member;
		this.date = dueDate;
		this.state = LOAN_STATE.CURRENT; //updated those modified variable details here as well
	}

	
	public void checkOverDue() { 
		if (state == LOAN_STATE.CURRENT &&
			Calendar.getInstance().Date().after(date)) { //modified variable is used in the parameter
			this.state = LOAN_STATE.OVER_DUE;			
		}
	}

	
	public boolean isOverDue() {
		return state == LOAN_STATE.OVER_DUE;
	}

	
	public Integer getId() {
		return bookID; // return value is changes according to changes of varible names
	}


	public Date getDueDate() {
		return date; // return value is changes according to changes of varible names
	}
	
	
	public String toString() {
		SimpleDateFormat simpleDateFromat = new SimpleDateFormat("dd/MM/yyyy"); // object name is modifed from abbreviation 

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Loan:  ").append(bookID).append("\n")
		  .append("  Borrower ").append(member().getId()).append(" : ")
		  .append(member().getLastName()).append(", ").append(member().getFirstName()).append("\n")
		  .append("  Book ").append(book().bookID()).append(" : " )
		  .append(book().title()).append("\n")
		  .append("  DueDate: ").append(simpleDateFromat.format(date)).append("\n")
		  .append("  State: ").append(state);		
		return stringBuilder.toString();
	}


	public Member member() {
		return memberID; // return value is changes according to changes of varible names
	}


	public Book book() {
		return bookName; // return value is changes according to changes of varible names
	}


	public void loan() {
		state = LOAN_STATE.DISCHARGED;		
	}

}
