package com.company;

public class BankAccount {
    double amount;

    public double getAmount() {
        return amount;
    }

    public void deposit(double sum) {
        amount += sum;

    }

    public double withDraw(int sum) throws LimitException {
        if (sum > amount) {
            throw new LimitException("Снимаем остаток..." , getAmount());
        }
        amount -= sum;
        System.out.println("Снимаем счет:" + sum);


        return amount;

    }
}

