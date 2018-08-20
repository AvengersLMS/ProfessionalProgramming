import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Member implements Serializable {

	private String lastName;
	private String firstName;
	private String email;
	private int phoneNumber;
	private int memberID;
	private double fine; 
        private Map<Integer, Loan> loans;
// above private variables are changed by replacing proper meaninful names
	
	public Member(String lastName, String firstName, String email, int phoneNo, int id) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phoneNumber = phoneNo;
		this.memberID = id;
		
		this.loans = new HashMap<>();
                //modified variables are used in above scope
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Member:  ").append(memberID).append("\n")
		  .append("  Name:  ").append(lastName).append(", ").append(firstName).append("\n")
		  .append("  Email: ").append(email).append("\n")
		  .append("  Phone: ").append(phoneNumber)
		  .append("\n")
		  .append(String.format("  Fines Owed :  $%.2f", fine))
		  .append("\n");
                //modifed variables are put in parameters 
		
		for (Loan loan : loans.values()) {
			sb.append(loan).append("\n");
		}		  
		return sb.toString();
	}

	
	public int getMemeberId() { //method name is changed to meaningful and used camel case
		return memberID;
	}

	
	public List<Loan> getLoans() {
		return new ArrayList<Loan>(loans.values());
	}

	
	public int getNumberOfCurrentLoans() {
		return loans.size();
	}

	
	public double getFinesOwed() {
		return fine;
	}

	
	public void takeOutLoan(Loan loan) {
		if (!loans.containsKey(loan.getId())) {
			loans.put(loan.getId(), loan);
		}
		else {
			throw new RuntimeException("Duplicate loan added to member");
		}		
	}
            // above return value names are changed according to modifications 
	
	public String getLastName() {
		return lastName;
	}

	
	public String getFirstName() {
		return firstName;
	}


	public void addFine(double fine) {
		this.fine += fine;
	}
	
	public double payFine(double amount) {
		if (amount < 0) {
			throw new RuntimeException("Member.payFine: amount must be positive");
		}
		double change = 0;
		if (amount > fine) {
			change = amount - fine;
			fine = 0;
		}
		else {
			fine = amount;
		}
		return change;
	}


	public void dischargeLoan(Loan loan) {
		if (loans.containsKey(loan.getId())) {
			loans.remove(loan.getId());
		}
		else {
			throw new RuntimeException("No such loan held by member");
		}		
	}
            // above return value names are changed according to modifications 

}
