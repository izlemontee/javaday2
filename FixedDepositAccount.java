class FixedDepositAccount extends BankAcc{
    float interest = 3.0f;
    Integer duration = 6;
    boolean interestChanged = false;
    boolean monthsChanged = false;
    public FixedDepositAccount(String accountName){
        super(accountName);
    }

    @Override() public void deposit(float amount) throws IllegalArgumentException{
     //does nothing (NOP)
    }
    @Override() public void withdraw(float amount) throws IllegalArgumentException{
     //does nothing (NOP)
    }

    private float changeInterest(boolean interestChanged, float interest) throws IllegalArgumentException{
        if (interestChanged){
            throw new IllegalArgumentException("Interest has been changed.");
        }
        else{
            float newInterest = 4.0f;
            interest = newInterest;
            interestChanged = true;
            return newInterest;
        }
    }

    private Integer changeDuration(boolean monthsChanged, Integer duration) throws IllegalArgumentException{
        if (monthsChanged){
            throw new IllegalArgumentException("Interest has been changed.");
        }
        else{
            Integer durationNew = 10;
            duration = durationNew;
            monthsChanged = true;
            return duration;
        }
    }

    public float getBalance(float interest, float balance){
        balance = balance + interest;
        interestChanged = true;
        monthsChanged = true;
        return balance;
    }

    public FixedDepositAccount(String name, Float balance){
        super(name, balance);
        balance = getBalance(interest, balance);

    }
    public FixedDepositAccount(String name, Float balance, Float interest){
        super(name, balance);
        this.interest = changeInterest(interestChanged,interest);
        balance = getBalance(interest, balance);
    

    }
    public FixedDepositAccount(String name, Float balance, Float interest, Integer duration){
        super(name, balance);
        this.interest = changeInterest(interestChanged,interest);
        this.duration = changeDuration(monthsChanged, duration);
        balance = getBalance(interest, balance);

    }
}