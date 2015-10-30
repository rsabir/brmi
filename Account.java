import App.*;

public class Account{
    private int idAccount;
    private BankCustomerImpl a; 
    private String nameAccount;
    private int money;
    private static int compteur=0; 

    Account(BankCustomerImpl a, String nameAccount, int money){
	this.idAccount = compteur;
	this.nameAccount = nameAccount;
	this.money = money;
	this.a = a;	
	compteur++;
    }

    public void addMoney(int moneyToAdd){
	money += moneyToAdd;
    }
    
    public boolean checkWithDraw(int moneyToDraw){
	return (money-moneyToDraw>=0);
    }
    
    public boolean withDrawMoney(int moneyToDraw){
	if (checkWithDraw(moneyToDraw)){
	    money -= moneyToDraw;
	    return true;
	}
	return false;
    }

    /*    public boolean sendMoney(int idAccountB,int idBankB,int moneyToDraw){
	if (checkWithDraw(moneyToDraw)){
	    return a.sendMoney(this.idAccount,idAccountB,idBankB,moneyToDraw);
	}
	return false;
    }
    */
    public int getMoney(){
	return money;
    }

    public String getNameAccount(){
	return nameAccount;
    }
    
    public int getIdAccount(){
	return idAccount;
    }
}
