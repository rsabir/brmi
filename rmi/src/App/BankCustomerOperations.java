package App;


/**
* App/BankCustomerOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from App.idl
* Saturday, October 31, 2015 5:45:03 PM CET
*/

public interface BankCustomerOperations 
{
  int createAccount (String accountname, int money);
  void destroy (int idAccount);
  boolean depositAccount (int idAccountA, int idAccountB, int idBank, int money);
  void withDrawAccount (int idAccountA, int money);
  int getMoney (int idAccountA);
  int getId ();
} // interface BankCustomerOperations
