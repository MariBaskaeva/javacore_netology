public class CreditAccount extends Account {
    public CreditAccount() {
        super(0);
    }

    @Override
    public void pay(int amount) {
        setAmount(getAmount() - amount);
        System.out.println("An amount of " + amount + "$ has been successfully paid from " + getName());
    }

    @Override
    public void transfer(Account account, int amount) {
        setAmount(getAmount() - amount);
        account.setAmount(account.getAmount() + amount);
        System.out.println(amount + "$ were successfully transfered to " + account.getName());
    }

    @Override
    public String getName() {
        return "checking account";
    }

    @Override
    public void addMoney(int amount) {
        if (getAmount() + amount > 0) {
            System.out.println("You can't pay more than your loan");
            return;
        }
        setAmount(getAmount() + amount);
        System.out.println(amount + "$ were added to " + getName());
    }

    @Override
    public int getAmount() {
        return super.getAmount();
    }

    @Override
    public void setAmount(int amount) {
        if (!(amount > 0)) {
            super.setAmount(amount);
        } else {
            System.out.println("You can't pay more than your loan");
        }
    }
}