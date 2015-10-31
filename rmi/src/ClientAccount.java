import java.util.Properties;
import org.omg.CORBA.ORB;
import org.omg.CORBA.OBJ_ADAPTER;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NameComponent;
import org.omg.PortableServer.POA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import App.*;

public class ClientAccount {

    private static int  idAccount;
    private Account account;
    
    public static void main(String args[]) {

	try {
	    // Step 1: Instantiate the ORB
	    ORB orb = ORB.init(args, null);

	    // Step 2: Resolve the PersistentHelloServant by using INS's
	    // corbaname url. The URL locates the NameService running on
	    // localhost and listening on 1050 and resolve
	    // 'PersistentServerTutorial' from that NameService
	    //	    org.omg.CORBA.Object obj = orb.string_to_object(						    "corbaname::localhost:1050#PersistentServerCustomer");
	    if (args.length<1){
	    	System.out.println("Error in the command : java ClientAccount port");
	    	System.exit(-1);
	    }
	    org.omg.CORBA.Object obj = orb.string_to_object(
							    "corbaname::localhost:"+args[0]+"#BankCustomer");
	    BankCustomer bankCustomer = BankCustomerHelper.narrow( obj );
	    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	    boolean error = true;
	    int choix = 0;
	    while (error){
			System.out.println("Select an option");
			System.out.println("1  : authentificate");
			System.out.println("2  : create Account");
			System.out.print("Your Option: ");
			choix = Integer.parseInt(bufferRead.readLine());
			if (choix !=1 && choix !=2){
		       	    System.out.println("Unknown Choice");
			}else
			    error = false;
	    }
	
	    switch(choix){
		    case 1:
				System.out.print("Tape the id Account: ");
				int idAccountSelected = Integer.parseInt(bufferRead.readLine());
				idAccount = idAccountSelected;
			break;
		    case 2 :
				System.out.print("Tape the name of the Account: ");
			        String nameAccount = bufferRead.readLine();
				idAccount = bankCustomer.createAccount(nameAccount,0);
			break;
	    }
	    // Step 3: Call the sayHello() method every 60 seconds and shutdown
	    // the server. Next call from the client will restart the server,
	    // because it is persistent in nature.
	    while( true ) {
			System.out.print("\033[H\033[2J");
			System.out.flush();
			System.out.println("Veuillez saisir le numero d'opperation");
			System.out.println("1  : Deposit Money");
			System.out.println("2  : WithDraw Money");
			System.out.println("3  : Transfer Money to an other Account");
			System.out.println("4  : The id of the bank");
			System.out.println("0  : Show Money");
			System.out.println("-1 : Quit ");
			System.out.println("----------------------------------------");
			System.out.print("your choice : ");
			choix = Integer.parseInt(bufferRead.readLine());	
			switch(choix){
			case 1 :
				System.out.print("Veuillez saisir l'argent à ajouter: ");
			    int money = Integer.parseInt(bufferRead.readLine());
			    bankCustomer.depositAccount(idAccount,idAccount,bankCustomer.getId(),money);
			    break;
			case 2 :
			    System.out.print("Veuillez saisir l'argent à enlever: ");
			    money = Integer.parseInt(bufferRead.readLine());
			     bankCustomer.withDrawAccount(idAccount,money);
			    break;
			case 0 :
			    System.out.println("Money: "+String.valueOf(bankCustomer.getMoney(idAccount)));
			    break;
			case 3 :
			    System.out.print("Insert the id of the account of destination: ");
			    int idAccountB = Integer.parseInt(bufferRead.readLine());
			    System.out.print("Insert the id of the bank of destination: ");
			    int idBankB = Integer.parseInt(bufferRead.readLine());
			    System.out.print("Insert the money that you want to send: ");
			    money = Integer.parseInt(bufferRead.readLine());
			    bankCustomer.depositAccount(idAccount,idAccountB,idBankB,money);
			    break;
			case 4 : 
				System.out.println("The id of your bank is : "+bankCustomer.getId());
				break;
			case -1 :
			    return;
	
			default:
			    System.out.println("Error: choice unrecognized");
			    Integer.parseInt(bufferRead.readLine());
			    break;
			}
			System.out.print("DONE");
			bufferRead.readLine();
	    }
	} catch ( Exception e ) {
	    System.err.println( "Exception in PersistentClient.java..." + e );
	    e.printStackTrace( );
	}
    }
}
