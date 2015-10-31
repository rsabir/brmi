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

public class ServerInterbank {

	private static Interbank interbank;

	public static void main(String args[]) {
		if (args.length < 1) {
			System.out.println("Insert a port");
			System.exit(-1);
		}
		Properties properties = System.getProperties();
		properties.put("org.omg.CORBA.ORBInitialHost", "localhost");
		properties.put("org.omg.CORBA.ORBInitialPort", args[0]);

		try {
			// Step 1: Instantiate the ORB
			ORB orb = ORB.init(args, properties);
			// getInterBank(orb);
			InterBankImpl interbankImpl = new InterBankImpl(orb);

			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

			Policy[] persistentPolicy = new Policy[1];
			persistentPolicy[0] = rootPOA.create_lifespan_policy(LifespanPolicyValue.PERSISTENT);

			POA persistentPOA = rootPOA.create_POA("childPOA", null, persistentPolicy);
			persistentPOA.the_POAManager().activate();
			persistentPOA.activate_object(interbankImpl);

			org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");
			NamingContextExt rootContext = NamingContextExtHelper.narrow(obj);

			// NameComponent[] nc =
			// rootContext.to_name("PersistentServerCustomer");
			NameComponent[] nc = rootContext.to_name("interbank");
			rootContext.rebind(nc, persistentPOA.servant_to_reference(interbankImpl));

			orb.run();
		} catch (Exception e) {
			System.err.println("Exception in Persistent Server Startup " + e);
		}
	}
}
