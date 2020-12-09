package ru.geekbrains.spring.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Cart cart = context.getBean("cart", Cart.class);
        Scanner sc = new Scanner(System.in);
        String command = "";
        String message = "";
        while (true) {
            System.out.println("Для добавления товара в корзину введите 'add', для удаления товара - 'delete', для выхода из программы - 'exit'.");
            command = sc.nextLine();
            if (command.equals("add")) {
                System.out.println("Введите id товара");
                message = cart.addProduct(Integer.parseInt(sc.nextLine())) ? "Товар добавлен успешно" : "Товар не добавлен";
                System.out.println(message);
            } else if (command.equals("delete")) {
                System.out.println("Введите id товара");
                message = cart.deleteProduct(Integer.parseInt(sc.nextLine())) ? "Товар удален успешно" : "Товар не удален";
                System.out.println(message);
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Неизвестная команда");
            }
        }
    }
}
