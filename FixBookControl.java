public class FixBookControl {
	
	private FixBookUI fixBookUserInterface;//changed the variable name into meaningful name 
	private enum CONTROL_STATE { INITIALISED, READY, FIXING };
	private CONTROL_STATE state;
	
	private Library library;//class name modified "Starting with uppercase latter"
	private Book currentBook;//class name modified "Starting with uppercase latter"

   
    public void fixBookControl() {//add return type
		this.library = library.INSTANCE();
		state = CONTROL_STATE.INITIALISED;
	}
	
	
	public void setUI(FixBookUI userInterface) {//modified parameter by using meaningful name 
		if (!state.equals(CONTROL_STATE.INITIALISED)) {
			throw new RuntimeException("FixBookControl: cannot call setUI except in INITIALISED state");
		}	
		this.fixBookUserInterface = userInterface;
		userInterface.setState(FixBookUI.UI_STATE.READY);
		state = CONTROL_STATE.READY;		
	}


	public void bookScanned(int bookId) {
		if (!state.equals(CONTROL_STATE.READY)) {
			throw new RuntimeException("FixBookControl: cannot call bookScanned except in READY state");
		}	
		currentBook = library.Book(bookId);
		
		if (currentBook == null) {
			fixBookUserInterface.display("Invalid bookId");
			return;
		}
		if (!currentBook.Damaged()) {
			fixBookUserInterface.display("\"Book has not been damaged");
			return;
		}
		fixBookUserInterface.display(currentBook.toString());
		fixBookUserInterface.setState(FixBookUI.UI_STATE.FIXING);
		state = CONTROL_STATE.FIXING;		
	}


	public void fixBook(boolean fix) {
		if (!state.equals(CONTROL_STATE.FIXING)) {
			throw new RuntimeException("FixBookControl: cannot call fixBook except in FIXING state");
		}	
		if (fix) {
			library.repairBook(currentBook);
		}
		currentBook = null;
		fixBookUserInterface.setState(FixBookUI.UI_STATE.READY);
		state = CONTROL_STATE.READY;		
	}

	
	public void scanningComplete() {
		if (!state.equals(CONTROL_STATE.READY)) {
			throw new RuntimeException("FixBookControl: cannot call scanningComplete except in READY state");
		}	
		fixBookUserInterface.setState(FixBookUI.UI_STATE.COMPLETED);		
	}






}
