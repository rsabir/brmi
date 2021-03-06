package App;


/**
* App/InterbankPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from App.idl
* Sunday, November 1, 2015 12:06:39 PM CET
*/

public abstract class InterbankPOA extends org.omg.PortableServer.Servant
 implements App.InterbankOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("askTransfert", new java.lang.Integer (0));
    _methods.put ("getNewId", new java.lang.Integer (1));
    _methods.put ("addNewBank", new java.lang.Integer (2));
    _methods.put ("getHistory", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // App/Interbank/askTransfert
       {
         int idAccountA = in.read_long ();
         int idAccountB = in.read_long ();
         int idBankA = in.read_long ();
         int idBankB = in.read_long ();
         int money = in.read_long ();
         boolean $result = false;
         $result = this.askTransfert (idAccountA, idAccountB, idBankA, idBankB, money);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // App/Interbank/getNewId
       {
         int $result = (int)0;
         $result = this.getNewId ();
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 2:  // App/Interbank/addNewBank
       {
         int port = in.read_long ();
         int id = in.read_long ();
         this.addNewBank (port, id);
         out = $rh.createReply();
         break;
       }

       case 3:  // App/Interbank/getHistory
       {
         int idBank = in.read_long ();
         int idAccount = in.read_long ();
         String $result[] = null;
         $result = this.getHistory (idBank, idAccount);
         out = $rh.createReply();
         App.arrayStringHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:App/Interbank:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Interbank _this() 
  {
    return InterbankHelper.narrow(
    super._this_object());
  }

  public Interbank _this(org.omg.CORBA.ORB orb) 
  {
    return InterbankHelper.narrow(
    super._this_object(orb));
  }


} // class InterbankPOA
