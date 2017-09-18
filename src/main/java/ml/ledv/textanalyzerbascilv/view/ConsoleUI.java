package ml.ledv.textanalyzerbascilv.view;

import ml.ledv.textanalyzerbascilv.controller.ProcessController;

import java.util.Scanner;

/**
 * The class provides method star() for starting app in the console.
 *
 * @author Denis Lesheniuk
 * @version 1.0
 * **/

public class ConsoleUI {
ProcessController processController;

    public ConsoleUI() {
        this.processController = new ProcessController();
    }

    public void start(){
      System.out.println("Привет мир!!!");
      System.out.println("Text Analizer v.1.0");

        while(!processController.isProcess()) {
            System.out.println("Для начала анализа текста введите путь к файлу :\n" +
                    "Пример : F://file_name.txt");
            Scanner scanner = new Scanner(System.in);
            String path = scanner.nextLine();
            processController.doAnalize(path);
        }
    }

}
