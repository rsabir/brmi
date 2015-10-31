import java.util.Properties;
import org.omg.CORBA.Object;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CORBA.Policy;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.*;
import org.omg.PortableServer.Servant;
import App.*;

import java.lang.*;

public class ServerBankClient {

	private static Interbank interbank;

	private static Interbank getInterBank(ORB orb) {
		org.omg.CORBA.Object obj = orb.string_to_object("corbaname::localhost:2000#interbank");

		return interbank = InterbankHelper.narrow(obj);
	}

	public static void main(String args[]) {
		if (args.length < 1) {
			System.out.println("Insert a port");
			System.exit(-1);
		}
		Properties properties = System.getProperties();
		properties.put("org.omg.CORBA.ORBInitialHost", "localhost");
		int port = Integer.parseInt(args[0]);
		properties.put("org.omg.CORBA.ORBInitialPort", String.valueOf(port));

		try {
			// Step 1: Instantiate the ORB
			ORB orb = ORB.init(args, properties);
			getInterBank(orb);
			Bank bank = new Bank(orb, interbank, port);
			// Step 2: Instantiate the servant
			BankCustomerImpl bankCustomer = bank.getBankCustomer();
			BankTransactionImpl bankTransaction = bank.getBankTransaction();

			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

			Policy[] persistentPolicy = new Policy[1];
			persistentPolicy[0] = rootPOA.create_lifespan_policy(LifespanPolicyValue.PERSISTENT);

			POA persistentPOA = rootPOA.create_POA("childPOA", null, persistentPolicy);
			persistentPOA.the_POAManager().activate();
			persistentPOA.activate_object(bankCustomer);
			persistentPOA.activate_object(bankTransaction);

			org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");
			NamingContextExt rootContext = NamingContextExtHelper.narrow(obj);

			// NameComponent[] nc =
			// rootContext.to_name("PersistentServerCustomer");
			NameComponent[] nc = rootContext.to_name("BankCustomer");
			rootContext.rebind(nc, persistentPOA.servant_to_reference(bankCustomer));

			NameComponent[] na = rootContext.to_name("BankTransaction");
			rootContext.rebind(na, persistentPOA.servant_to_reference(bankTransaction));

			orb.run();
		} catch (Exception e) {
			System.err.println("Exception in Persistent Server Startup " + e);
		}
	}
	/*
	 * public class ThreadServerCustomer extends Thread{ private ORB orb;
	 * private Bank bank; ThreadServerCustomer(ORB orb,Bank bank){ this.orb =
	 * orb; this.bank = bank; } public void run() {
	 * 
	 * try { BankCustomerImpl server = bank.getBankCustomer(); POA rootPOA =
	 * POAHelper.narrow(orb.resolve_initial_references("RootPOA")); Policy[]
	 * persistentPolicy = new Policy[1]; persistentPolicy[0] =
	 * rootPOA.create_lifespan_policy( LifespanPolicyValue.PERSISTENT); POA
	 * persistentPOA = rootPOA.create_POA("childPOA", null, persistentPolicy );
	 * persistentPOA.the_POAManager().activate( );
	 * persistentPOA.activate_object( server );
	 * 
	 * org.omg.CORBA.Object obj = orb.resolve_initial_references( "NameService"
	 * ); NamingContextExt rootContext = NamingContextExtHelper.narrow( obj );
	 * 
	 * NameComponent[] nc = rootContext.to_name("PersistentServerTutorial");
	 * rootContext.rebind( nc, persistentPOA.servant_to_reference( server ) );
	 * NameComponent[] na = rootContext.to_name("PersistentServerTransaction");
	 * rootContext.rebind( na,
	 * persistentPOA.servant_to_reference(bank.getBankTransaction() ) );
	 * 
	 * 
	 * orb.run(); } catch ( Exception e ) { System.err.println(
	 * "Exception in Persistent Server Startup " + e ); } } }
	 */
}
