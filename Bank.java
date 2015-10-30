import App.*;
import org.omg.CORBA.ORB;

class Bank{
    private int id;
    private BankCustomerImpl bankCustomer;
    private BankTransactionImpl bankTransaction;
    private static Interbank interBank;

    Bank(ORB orb,Interbank interbank){
	id = interBank.getNewId();
	this.bankCustomer = new BankCustomerImpl(orb,this);
	this.bankTransaction = new BankTransactionImpl(orb,this);
	this.interBank = interbank;
	interBank.addNewBank((BankTransaction)this.bankTransaction);
    }
    int createAccount (String accountName, int money){
	return this.bankCustomer.createAccount(accountName,money);
    }
    void destroy(int idAccount){
	this.bankCustomer.destroy(idAccount);
    }
    void depositAccount(int idAccountA, int idAccountB, int idBank, int money){
	this.bankCustomer.depositAccount(idAccountA,idAccountB,idBank,money);
    }
    boolean askConfirm(int idAccountA,int idAccountB,int idBankA,int money){
	return true;
    }
        /**
     ** Should be deleted 
     **/
    public BankCustomerImpl getBankCustomer(){
	return bankCustomer;
    }
    public BankTransactionImpl getBankTransaction(){
	return bankTransaction;
    }

    
    public Interbank getInterBank(){
	return interBank;
    }

    public int getId(){
	return id;
    }
    
}
