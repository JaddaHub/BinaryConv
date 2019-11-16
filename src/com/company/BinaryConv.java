package com.company;

import java.util.Scanner;

public class BinaryConv {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean again = true;
        while (again) {


            double num10; // число в 10-ной СС
            while (true) {
                System.out.println("Введите число в десятичной системе счисления");
                try {   // проверка ввода
                    num10 = Double.parseDouble(sc.next());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ввод некорректный (вещественные числа вводить через точку '.')" + "\n");
                }
            }
            boolean minus = false;
            if (num10 < 0) {
                num10 = -num10;
                minus = true;
            }

            // перевод целой части числа
            StringBuilder balance = new StringBuilder();
            int numint = (int) num10;
            do {
                balance.insert(0, numint % 2);
                numint /= 2;
            } while (numint > 0);

            // перевод дробной части числа
            StringBuilder remain = new StringBuilder();
            if (num10 % 1 != 0) {
                double frpart = num10 % 1;
                int s = 0;
                while (frpart != 0 && s != 21) {
                    if (frpart > 0) {
                        int c = (int) (frpart / 1);
                        remain.append(c);
                        frpart -= c;
                    }
                    frpart *= 2;
                    s++;
                }
                remain.deleteCharAt(0);
            }

            // если число отрицательное
            if (minus) {
                balance.insert(0, "-");
            }

            if (remain.length() != 0) {
                balance.append(".").append(remain.toString());
            }

            System.out.println("Запись числа в двоичной СС: " + balance);   // готовое число

            // ещё раз, если надо
            System.out.println("\n" + "Посчитать ещё раз? 1 - да, 0 - нет");
            int ans = sc.nextInt();
            if (ans != 1) again = false;
        }
    }
}