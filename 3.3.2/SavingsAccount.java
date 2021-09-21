public class SavingsAccount extends Account {

    public SavingsAccount(int amount) {
        super(amount);
    }

    @Override
    public void pay(int amount) {
        System.out.println("You can't pay from savings account");
    }

    @Override
    public void transfer(Account account, int amount) {
        if (getAmount() - amount < 0) {
            System.out.println(getName() + " can't be below zero. Transfer hasn't been carried out");
            return;
        }
        setAmount(getAmount() - amount);
        account.setAmount(account.getAmount() + amount);
        System.out.println(amount + "$ were successfully transfered to " + account.getName());
    }

    @Override
    public String getName() {
        return "Savings Account";
    }

    @Override
    public void addMoney(int amount) {
        setAmount(getAmount() + amount);
        System.out.println(amount + "$ were added to " + getName());
    }

    @Override
    public int getAmount() {
        return super.getAmount();
    }

    @Override
    public void setAmount(int amount) {
        super.setAmount(amount);
    }
}