package com.company;

public class Main {

    public static void main(String[] args) {
        // a)  Написать класс проверяемого исключения LimitException, с конструктором
        // LimitException(String message, double remainingAmount) и методом  .
        //b)  Написать класс BankAccount с 1 полем double amount - остаток
        // на счете и методами getAmount() - возвращает текущий остаток
        // на счете, deposit(double sum) - положить деньги на счет, withDraw(int sum) - снимает указанную сумму со счета.
        //c)  Также метод withDraw() может сгенерировать
        // исключение в том случае если запрашиваемая сумма на снятие больше чем остаток денег на счете.
        //d)  Написать Main класс где бы создавался счет клиента. Положить 20 000 сом на счет.
        //e)  Затем попытаться снять через бесконечный цикл, каждую итерацию по 6000 сом, при этом
        // отлавливать исключение LimitException и при возникновении такого исключения снимать только ту сумму,
        // которая осталась на счете и завершать бесконечный цикл
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(20000);
        while (true) {
            try {
                System.out.println("Ваш счет:" + bankAccount.getAmount());
                bankAccount.withDraw(6000);
            }
            catch (LimitException a){
                System.out.println(a.getMessage());
                try {
                    bankAccount.withDraw((int)bankAccount.getAmount() );
                    System.out.println("Остаток счета"+bankAccount.getAmount());
                } catch (LimitException e) {
                    e.printStackTrace();
                }
                break;
            }
        }

    }

}
