package App;


/**
* App/InterbankOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Final.idl
* Friday, October 30, 2015 5:49:59 PM CET
*/

public interface InterbankOperations 
{
  boolean askTransfert (int idAccountA, int idAccountB, int idBankA, int idBankB, int money);
  int getNewId ();
  void addNewBank (App.BankTransaction bankTransaction);
} // interface InterbankOperations