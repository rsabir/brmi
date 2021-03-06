package App;


/**
* App/BankTransactionHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from App.idl
* Sunday, November 1, 2015 12:06:39 PM CET
*/

abstract public class BankTransactionHelper
{
  private static String  _id = "IDL:App/BankTransaction:1.0";

  public static void insert (org.omg.CORBA.Any a, App.BankTransaction that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static App.BankTransaction extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (App.BankTransactionHelper.id (), "BankTransaction");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static App.BankTransaction read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_BankTransactionStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, App.BankTransaction value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static App.BankTransaction narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof App.BankTransaction)
      return (App.BankTransaction)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      App._BankTransactionStub stub = new App._BankTransactionStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static App.BankTransaction unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof App.BankTransaction)
      return (App.BankTransaction)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      App._BankTransactionStub stub = new App._BankTransactionStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
