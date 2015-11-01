import App.*;
import org.omg.CORBA.ORB;

class BankTransactionImpl extends BankTransactionPOA{
    private Bank bank;
    private ORB orb;
    
    BankTransactionImpl(ORB orb, Bank b){
	this.orb = orb;
	this.bank = b;
    }

    public boolean askConfirm (int idAccountA, int idAccountB, int idBankA, int money){
    	bank.depositAccount(idAccountB, idAccountB, bank.getId(), money);
	return true;
    }

    public int getId (){
	return bank.getId();
    }

    public boolean transfert(int idAccountA, int idAccountB,int idBankB, int money){
	return bank.getInterBank().askTransfert(idAccountA, idAccountB,bank.getId(), idBankB, money);
    }
    public String[] getHistory(int idAccount){
    	return bank.getInterBank().getHistory(bank.getId(), idAccount);
    }
}
