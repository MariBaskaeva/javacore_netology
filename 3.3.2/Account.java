public abstract class Account {
    private int amount;

    public Account(int amount) {
        this.amount = amount;
    }

    public abstract void pay(int amount);

    public abstract void transfer(Account account, int amount);

    public abstract void addMoney(int amount);

    public abstract String getName();

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}