package App;


/**
* App/BankTransactionPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from App.idl
* Sunday, November 1, 2015 12:06:39 PM CET
*/

public abstract class BankTransactionPOA extends org.omg.PortableServer.Servant
 implements App.BankTransactionOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("askConfirm", new java.lang.Integer (0));
    _methods.put ("getId", new java.lang.Integer (1));
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
       case 0:  // App/BankTransaction/askConfirm
       {
         int idAccountA = in.read_long ();
         int idAccountB = in.read_long ();
         int idBankA = in.read_long ();
         int money = in.read_long ();
         boolean $result = false;
         $result = this.askConfirm (idAccountA, idAccountB, idBankA, money);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // App/BankTransaction/getId
       {
         int $result = (int)0;
         $result = this.getId ();
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:App/BankTransaction:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public BankTransaction _this() 
  {
    return BankTransactionHelper.narrow(
    super._this_object());
  }

  public BankTransaction _this(org.omg.CORBA.ORB orb) 
  {
    return BankTransactionHelper.narrow(
    super._this_object(orb));
  }


} // class BankTransactionPOA
