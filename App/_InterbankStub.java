package App;


/**
* App/_InterbankStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Final.idl
* Friday, October 30, 2015 5:49:59 PM CET
*/

public class _InterbankStub extends org.omg.CORBA.portable.ObjectImpl implements App.Interbank
{

  public boolean askTransfert (int idAccountA, int idAccountB, int idBankA, int idBankB, int money)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("askTransfert", true);
                $out.write_long (idAccountA);
                $out.write_long (idAccountB);
                $out.write_long (idBankA);
                $out.write_long (idBankB);
                $out.write_long (money);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return askTransfert (idAccountA, idAccountB, idBankA, idBankB, money        );
            } finally {
                _releaseReply ($in);
            }
  } // askTransfert

  public int getNewId ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getNewId", true);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getNewId (        );
            } finally {
                _releaseReply ($in);
            }
  } // getNewId

  public void addNewBank (App.BankTransaction bankTransaction)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("addNewBank", true);
                App.BankTransactionHelper.write ($out, bankTransaction);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                addNewBank (bankTransaction        );
            } finally {
                _releaseReply ($in);
            }
  } // addNewBank

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:App/Interbank:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _InterbankStub
