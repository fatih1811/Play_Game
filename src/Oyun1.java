

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author ahmet
 */
import java.util.Random;
import java.util.Scanner;

public class Oyun1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean devam = true;
        while (devam) {
            System.out.println("Please select a difficulty level:");
            System.out.println("-------------------------------");
            System.out.println("1) Easy");
            System.out.println("2) Medium");
            System.out.println("3) Hard");
            System.out.println("4) Return to Main Menu");
            System.out.print("Enter your choice: ");
            int seviye = scanner.nextInt();
            char[] harfler = {};
            int denemeSayisi = 0;
            switch (seviye) {
                case 1:
                    System.out.println("\nEasy Seviyesi: Sesli Harf Tahmini");
                    harfler = new char[]{'a', 'e', 'i', 'o', 'u'};
                    denemeSayisi = 2;
                    break;
                case 2:
                    System.out.println("\nMedium Seviyesi: Sessiz Harf Tahmini");
                    harfler = new char[]{'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
                    denemeSayisi = 4;
                    break;
                case 3:
                    System.out.println("\nHard Seviyesi: Harf Tahmini");
                    harfler = new char[26];
                    for (int i = 0; i < 26; i++) {
                        harfler[i] = (char) ('a' + i);
                    }
                    denemeSayisi = 5;
                    break;
                case 4:
                    System.out.println("Ana Menüye dönülüyor.");
                    return;
                default:
                    System.out.println("Geçersiz seviye girdiniz. Oyun bitti!");
                    return;
            }

            char dogruHarf = harfler[random.nextInt(harfler.length)];
            char tahmin = '-';
            while (denemeSayisi > 0 && tahmin != dogruHarf) {
                System.out.println("Bir harf tahmin edin:");
                tahmin = scanner.next().charAt(0);
                if (tahmin == dogruHarf) {
                    System.out.println("Tebrikler, doğru tahmin ettiniz!");
                } else if (contains(harfler, tahmin)) {
                    denemeSayisi--;
                    System.out.println("Maalesef yanlış tahmin ettiniz. Kalan deneme hakkınız: " + denemeSayisi);
                } else {
                    System.out.println("Geçersiz harf girdiniz. Lütfen bir harf girin.");
                }
            }
            if (denemeSayisi == 0) {
                System.out.println("Oyunu kaybettiniz. Doğru harf: " + dogruHarf);
            } else {
                System.out.println("Oyunu kazandınız!");
            }

            if (denemeSayisi == 0) {
                devam = false || true;
            }
        }
        scanner.close();
    }

    public static boolean contains(char[] array, char item) {
        for (char n : array) {
            if (item == n) {
                return true;
            }
        }
        return false;
    }
}