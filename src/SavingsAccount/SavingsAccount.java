package SavingsAccount;

public class SavingsAccount {
    public static double annualInterestRate;
    private double savingBalance;

    public SavingsAccount(double savingsBalance) {
        this.savingBalance = savingsBalance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        SavingsAccount.annualInterestRate = annualInterestRate;
    }

    public double getSavingsBalance() {
        return savingBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingBalance = savingsBalance;
    }

    public static void modifyInterestRate(double interestRate) {
        annualInterestRate = interestRate;
        System.out.println("Annual Interest rate is modified in " +annualInterestRate);
    }

    public double calculateMonthlyRate() {
        double monthlyRate = ((annualInterestRate / 100) * savingBalance) / 12;
        this.savingBalance += monthlyRate;
        return monthlyRate;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "savingsBalance=" + savingBalance +
                '}';
    }
}
