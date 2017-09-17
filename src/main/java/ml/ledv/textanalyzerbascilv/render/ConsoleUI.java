package ml.ledv.textanalyzerbascilv.render;

import ml.ledv.textanalyzerbascilv.service.FileHandler;
import ml.ledv.textanalyzerbascilv.service.FileHandlerImpl;
import ml.ledv.textanalyzerbascilv.service.ProcessController;

import java.io.File;
import java.util.Scanner;

public class ConsoleUI {
ProcessController processController = new ProcessController();

    public void start(){
      System.out.println("Привет мир!!!");
      System.out.println("Text Analizer v.1.0");
      System.out.println("Для начала анализа текста введите путь к файлу :");
        while(processController.isProcess()) {
            Scanner scanner = new Scanner(System.in);
            String path = scanner.nextLine();
            processController.doAnalize(path);
        }
    }

}
