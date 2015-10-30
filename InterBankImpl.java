import App.*;
import java.util.*;
import org.omg.CORBA.ORB;

class InterBankImpl extends InterbankPOA{

    private ArrayList <History> historyList;
    private ArrayList <BankTransaction> bankList;
    private ORB orb;
    private static int compteur;

    public InterBankImpl(ORB orb){
	historyList = new ArrayList <History>();
	bankList =  new ArrayList <BankTransaction> ();
    }


    ArrayList<History> getHistory(int idBank){
	//TODO
	return null;
    }

    // BankCustomerProxy instanceBankProxy(int idBankB){
    // 	return new BankCustomerProxy(bankList.get(idBankB).getBankCustomer());
    // }
    
    void addEntryHistory (int idBankA, int idBankB, int idAccountA, int idAccountB, int moneyTransaction){
	History history = new History (idBankA, idBankB, idAccountA, idAccountB, moneyTransaction);
	historyList.add(history);
    }

    public boolean  askTransfert(int idAccountA, int idAccountB,int idBankA, int idBankB, int money){
	// if (bankList.get(idAccountB).askConfirm(idAccountA,idAccountB,idBankA,money)==false)
	//     return null;
	// else   {
	//     return (BankCustomer)instanceBankProxy(idBankB);
	// }
	return bankList.get(idAccountB).askConfirm(idAccountA,idAccountB,idBankA,money);
    }

    public void addNewBank (App.BankTransaction bankTransaction){
	bankList.add(bankTransaction.getId(),bankTransaction);
    }

    public int getNewId(){
	return compteur++;
    }
    
}
