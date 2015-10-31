import App.*;
import java.util.*;
import org.omg.CORBA.ORB;

public class BankCustomerImpl extends BankCustomerPOA {

	private ArrayList<Account> accounts;
	private Bank bank;
	private int id;
	private ORB orb;

	public BankCustomerImpl(ORB orb, Bank bank) {
		this.bank = bank;
		this.id = bank.getId();
		this.orb = orb;
		accounts = new ArrayList<Account>();
	}

	public int createAccount(String accountName, int m) {
		Account account = new Account(this, accountName, m);
		accounts.add(account.getIdAccount(), account);
		return account.getIdAccount();
	}

	public void destroy(int idAccount) {
		accounts.remove(idAccount);
	}

	public boolean depositAccount(int idAccountA, int idAccountB, int idBank, int money) {
		if (idBank == this.id && idAccountA == idAccountB) {
			if (accounts.get(idAccountB) != null)
				accounts.get(idAccountB).addMoney(money);
		} else {
			if (accounts.get(idAccountA).checkWithDraw(money)) {
				if (idBank == this.id) {
					withDrawAccount(idAccountA, money);
					accounts.get(idAccountB).addMoney(money);
				} else {
					/*
					 * BankCustomer bankB =
					 * bankTransaction.askTranfert(idAccountA,idAccountB,this.id
					 * ,idBank,money); if (bankB){
					 * bankB.depositAccount(idAccountA,idAccountB,idBank,money);
					 * }else{ System.out.println("No enough money"); }
					 */
					if (bank.getBankTransaction().transfert(idAccountA, idAccountB, idBank, money)) {
						withDrawAccount(idAccountA, money);
					} else
						return false;

				}
			} else {
				return false;
			}
		}
		return true;
	}

	public Account getAccount(int idAccount) {
		return accounts.get(idAccount);
	}

	public void withDrawAccount(int idAccountA, int money) {
		accounts.get(idAccountA).withDrawMoney(money);
	}

	public int getMoney(int idAccountA) {
		return accounts.get(idAccountA).getMoney();
	}

	public void shutdown() {
		orb.shutdown(false);
	}

	@Override
	public int getId() {
		return bank.getId();
	}
	
}
