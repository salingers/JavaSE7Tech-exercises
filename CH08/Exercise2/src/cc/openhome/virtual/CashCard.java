package cc.openhome.virtual;

public class CashCard {
    private String number;
    private int balance;
    private int bonus;
    public CashCard(String number, int balance, int bonus) {
        this.number = number;
        this.balance = balance;
        this.bonus = bonus;
    }
    
    public void store(int money) {
        if(money > 0) {
            this.balance += money;
            if(money >= 1000) {
                this.bonus++;
            }
        }
        else {
            throw new IllegalArgumentException("儲值是負的？你是來亂的嗎？");
        }
    }
    
    public void charge(int money) throws InsufficientException {
        if(money > 0) {
            if(money <= this.balance) {
                this.balance -= money;
            }
            else {
                throw new InsufficientException("錢不夠啦！", balance);
            }
        }
        else {
            throw new IllegalArgumentException("扣負數？這不是叫我儲值嗎？");
        }
    }
    
    public int exchange(int bonus) throws InsufficientException {
        if(bonus > 0) {
            this.bonus -= bonus;
        }
        else {
            throw new InsufficientException("沒有點數囉", 0);
        }
        return this.bonus;
    }

    public int getBalance() {
        return balance;
    }

    public int getBonus() {
        return bonus;
    }

    public String getNumber() {
        return number;
    }
}
