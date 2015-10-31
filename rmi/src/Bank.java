import App.*;
import org.omg.CORBA.ORB;

class Bank {
	private int id;
	private int port;
	private BankCustomerImpl bankCustomer;
	private BankTransactionImpl bankTransaction;
	private static Interbank interBank;

	Bank(ORB orb, Interbank interbank,int port) {
		if (interbank != null) {
			id = interbank.getNewId();
			this.bankCustomer = new BankCustomerImpl(orb, this);
			this.bankTransaction = new BankTransactionImpl(orb, this);
			interbank.addNewBank(port,id);
		}else{
			System.out.println("Problem while trying to connect to interbank");
			System.exit(-1);
		}
		this.interBank = interbank;
		this.port = port;
	}

	int createAccount(String accountName, int money) {
		return this.bankCustomer.createAccount(accountName, money);
	}

	void destroy(int idAccount) {
		this.bankCustomer.destroy(idAccount);
	}

	void depositAccount(int idAccountA, int idAccountB, int idBank, int money) {
		this.bankCustomer.depositAccount(idAccountA, idAccountB, idBank, money);
	}

	boolean askConfirm(int idAccountA, int idAccountB, int idBankA, int money) {
		return true;
	}

	/**
	 ** Should be deleted
	 **/
	public BankCustomerImpl getBankCustomer() {
		return bankCustomer;
	}

	public BankTransactionImpl getBankTransaction() {
		return bankTransaction;
	}

	public Interbank getInterBank() {
		return interBank;
	}

	public int getId() {
		return id;
	}

}
