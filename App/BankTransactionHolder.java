package App;

/**
* App/BankTransactionHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Final.idl
* Friday, October 30, 2015 5:49:59 PM CET
*/

public final class BankTransactionHolder implements org.omg.CORBA.portable.Streamable
{
  public App.BankTransaction value = null;

  public BankTransactionHolder ()
  {
  }

  public BankTransactionHolder (App.BankTransaction initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = App.BankTransactionHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    App.BankTransactionHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return App.BankTransactionHelper.type ();
  }

}
