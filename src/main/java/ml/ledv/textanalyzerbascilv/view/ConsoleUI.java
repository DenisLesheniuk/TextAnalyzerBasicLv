package ml.ledv.textanalyzerbascilv.view;

import ml.ledv.textanalyzerbascilv.controller.ProcessController;

import java.util.Scanner;

public class ConsoleUI {
ProcessController processController;

    public ConsoleUI() {
        this.processController = new ProcessController();
    }

    public void start(){
      System.out.println("Привет мир!!!");
      System.out.println("Text Analizer v.1.0");

        while(!processController.isProcess()) {
            System.out.println("Для начала анализа текста введите путь к файлу :");
            Scanner scanner = new Scanner(System.in);
            String path = scanner.nextLine();
            processController.doAnalize(path);
        }
    }

}
