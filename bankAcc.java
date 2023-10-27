import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.Console;

public class BankAcc {
    //these are members
    private String accountName;
    private String accountNumber;
    private Float balance;
    private List<String> transactions;
    private boolean isOpen;
    private String openDate;
    private String closeDate;

    public BankAcc (String name) { //constructor
        accountNumber = "2904827190";
        accountName = name;
        this.balance = 0.0f;
        this.transactions = new LinkedList<>();
        this.isOpen = true;
        this.openDate = "23/10/2023";
        this.closeDate = "";
    }

    public BankAcc (String name, Float bal) { //constructor
        this(name);
        this.accountNumber = "2904827190";
        this.balance = bal;
        this.transactions = new LinkedList<>();
        this.isOpen = true;
        this.openDate = "23/10/2023";
        this.closeDate = "";
    }

    public void deposit(float amount) throws IllegalArgumentException{ //method
        if(amount <=0){
            throw new IllegalArgumentException("Amount should be positive");
        }
        if(isOpen == false){
            throw new IllegalArgumentException("Account is closed.");
        }
        this.balance += amount;
        String transaction = String.format("%s added on 25/10/2023",amount);
        transactions.add(transaction);
    }

    public void withdraw(float amount) throws IllegalArgumentException{ //method
        if(amount <=0){
            throw new IllegalArgumentException("Amount should be positive");
        }
        if(isOpen == false){
            throw new IllegalArgumentException("Account is closed.");
        }
        this.balance -= amount;
        String transaction = String.format("%s deducted on 25/10/2023",amount);
        transactions.add(transaction);
    }


    public static void main(String[] args){
        BankAcc account1 = new BankAcc("sjdadklsajd");
        BankAcc account2 = new BankAcc("slflkj");
        try{
            account1.deposit(500);
            account2.deposit(1000);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        //System.out.println(account1.accountNumber);

    }

}