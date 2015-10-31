import static org.junit.Assert.*;

import org.junit.Test;
import org.omg.CORBA.ORB;

public class interbankTest {

	@Test
	public void testInterbank() {
		 ORB orb = ORB.init(new String[0], null);
		 InterBankImpl interbank = new  InterBankImpl(orb);
		 int idA = interbank.getNewId();
		 int idB = interbank.getNewId();
		 interbank.addNewBank(1500,idA);
		 interbank.addNewBank(1540,idB);
		 interbank.askTransfert(0, 0, idA, idB, 100);
	}

}
