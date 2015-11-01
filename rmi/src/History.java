import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import  App.*;

class History{
    private int idBankA;
    private  int idBankB;
    private int idAccountA;
    private int idAccountB;
    private int money;
    private String date;
    
    History(int idBankA, int idBankB, int idAccountA, int idAccountB, int money){
		this.idBankA = idBankA;
		this.idBankB = idBankB;
		this.idAccountA = idAccountA;
		this.idAccountB = idAccountB;
		this.money = money;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();        
		date= df.format(today);
    }

	public int getIdBankA() {
		return idBankA;
	}

	public int getIdBankB() {
		return idBankB;
	}

	public int getIdAccountA() {
		return idAccountA;
	}

	public int getIdAccountB() {
		return idAccountB;
	}

	public int getMoney() {
		return money;
	}

	public String getDate() {
		return date;
	}
    
}
