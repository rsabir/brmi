package App;


/**
* App/InterbankOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from App.idl
* Saturday, October 31, 2015 5:45:03 PM CET
*/

public interface InterbankOperations 
{
  boolean askTransfert (int idAccountA, int idAccountB, int idBankA, int idBankB, int money);
  int getNewId ();
  void addNewBank (int port, int id);
} // interface InterbankOperations