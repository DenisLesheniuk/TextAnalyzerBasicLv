package ml.ledv.textanalyzerbascilv.service;

import java.util.List;
import java.util.Map;

public class ProcessController {
    private boolean process = true;

    public boolean isProcess() {
        return process;
    }

    FileHandler fileHandler;

    public ProcessController() {
        this.fileHandler = new FileHandlerImpl();
    }

    public void doAnalize(String path){
        String s = fileHandler.textExtractor(path);
        TextAnalyzer textAnalyzer = new TextAnalizerImpl();
        List<Map.Entry<String, Integer>> list;
        list = textAnalyzer.topTenRepeatingWords(s);
        int count = 0;
        for(Map.Entry<String, Integer> map: list){
            if(count == 10)return;
            System.out.println(map.getKey() + " " + map.getValue());
            count++;
        }

    }
}
