package com.scp.designPattern;



public class BankDesignPattern {
	public static void main(String[] args) {
		
		
		BankFactory bFactory=new HDFCFactory();
		Bank ob=BankFactoryDesign.getInstance(bFactory);
		System.out.println(ob);
		Account accob=ob.getAccount(AccType.savingAcc);
		System.out.println(accob);
		
		BankFactory bFactory1=new ICICIFactory();
		Bank ob1=BankFactoryDesign.getInstance(bFactory1);
		System.out.println(ob1);
		Account accob1=ob.getAccount(AccType.currentAcc);
		System.out.println(accob1);
	}

}
abstract class Bank{
	abstract public String getBank();
	abstract public int IFSCCode();
	abstract public Account getAccount(AccType type);
	@Override
	public String toString() {
		return "Bank [getBank()=" + getBank() + ", IFSCCode()=" + IFSCCode() + "]";
	}
	
	
}
class AdapterClass extends Bank{

	@Override
	public String getBank() {
		return null;
	}

	@Override
	public int IFSCCode() {
		return 0;
	}

	@Override
	public Account getAccount(AccType type) {
		
		Account accObj=null;
		if(type.equals(AccType.savingAcc))
			accObj= AccountFactory.getAccountInstance(AccType.savingAcc);
		else if(type.equals(AccType.currentAcc))
			accObj=AccountFactory.getAccountInstance(AccType.currentAcc);
		return accObj;
	}
	
}
class HDFCBank extends AdapterClass{

	@Override
	public String getBank() {
		return "HDFC Bank";
	}
	@Override
	public int IFSCCode() {
		return 1111;
	}
	
}
class ICICIBank extends AdapterClass{
	@Override
	public String getBank() {
		return "ICICI Bank";
	}
	@Override
	public int IFSCCode() {
		return 2222;
	}
}
interface BankFactory{
	Bank getBankInstance();
}
class HDFCFactory implements BankFactory{

	@Override
	public Bank getBankInstance() {
		return new HDFCBank();
	}
}
class ICICIFactory implements BankFactory{

	@Override
	public Bank getBankInstance() {
		return new ICICIBank();
	}
}
class BankFactoryDesign{
	public static Bank getInstance(BankFactory bFactory){
		
		return bFactory.getBankInstance();
	}
	
}
abstract class Account{
	abstract public String accountType();
	abstract public long accountNo();
	@Override
	public String toString() {
		return "Account [accountType()=" + accountType() + ", accountNo()=" + accountNo() + "]\n";
	}
	
	
	
}
class SavingAccount extends Account{

	@Override
	public String accountType() {
		return "Saving account";
	}
	@Override
	public long accountNo() {
		return 123456789;
	}
}
class CurrentAccount extends Account{

	@Override
	public String accountType() {
		return "Current account";
	}

	@Override
	public long accountNo() {
		return 387465321;
	}
}
class AccountFactory{
	public static Account getAccountInstance(AccType type){
		if(type.equals(AccType.savingAcc))
			return new SavingAccount();
		else if(type.equals(AccType.currentAcc))
			return new CurrentAccount();
		return null;
	}
	
	
}
enum AccType{
	savingAcc,
	currentAcc;
}