import App.*;
import java.util.*;
import org.omg.CORBA.ORB;

class InterBankImpl extends InterbankPOA {

	private ArrayList<History> historyList;
	private ArrayList<ArrayList<Object>> bankList;
	private ORB orb;
	private static int compteur;

	public InterBankImpl(ORB orb) {
		historyList = new ArrayList<History>();
		this.orb = orb;
		bankList = new ArrayList<ArrayList<Object>>();
	}

	ArrayList<History> getHistory(int idBank) {
		// TODO
		return null;
	}

	// BankCustomerProxy instanceBankProxy(int idBankB){
	// return new BankCustomerProxy(bankList.get(idBankB).getBankCustomer());
	// }

	void addEntryHistory(int idBankA, int idBankB, int idAccountA, int idAccountB, int moneyTransaction) {
		History history = new History(idBankA, idBankB, idAccountA, idAccountB, moneyTransaction);
		historyList.add(history);
	}

	public boolean askTransfert(int idAccountA, int idAccountB, int idBankA, int idBankB, int money) {
		// if
		// (bankList.get(idAccountB).askConfirm(idAccountA,idAccountB,idBankA,money)==false)
		// return null;
		// else {
		// return (BankCustomer)instanceBankProxy(idBankB);
		// }
		if (bankList.get(idBankB).size()<2){
			initiateBankTransaction(idBankB);
		}
		return ((BankTransaction)bankList.get(idBankB).get(1)).askConfirm(idAccountA, idAccountB, idBankA, money);
	}

	public void addNewBank(int portBank,int id) {
		ArrayList<Object> tmp = new ArrayList<Object>();
		tmp.add(0,portBank);
		bankList.add(id,tmp);
		bankList.get(id);
	}
	
	private void initiateBankTransaction(int index){
		ArrayList<Object> bankTransaction = bankList.get(index);
		System.out.println(bankTransaction.get(0));
		org.omg.CORBA.Object obj = orb.string_to_object("corbaname::localhost:"+bankTransaction.get(0)+"#BankTransaction");
		App.BankTransaction banktransaction = BankTransactionHelper.narrow( obj );
		bankTransaction.add(1,banktransaction);
	}

	public int getNewId() {
		return compteur++;
	}



}
