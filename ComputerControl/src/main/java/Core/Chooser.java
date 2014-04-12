package Core;

import java.io.File;
import java.util.List;

/**
 * Created by spier on 4/10/14.
 */

//TODO: разобраться с интерфейсом ядра, чтобы было видно только один класс
public class Chooser {

    public String commandRecognise(String command) throws Exception {

        BusinessApi api = new BusinessApi();
        String name = command.substring(0, 4);
        String script = command.substring(5);

        if (name.equals("bash")) {
            //выполняем распознавание скрипта, возращается готовый скрипт, запускаем
            api.runScript(script);
            return "script is run";
        }
        if (name.equals("echo")) {
            //отправляем на на клиент эхо
            return api.makeEcho(script);
        }
        if (name.equals("file")) {
            //получаем список файлов в данной директории, возвращаем на клиент
            return fileToString(api.getFiles(new File(script)));
        }
        if (name.equals("audi")) {
            //получаем определенно построенный спиоск аудио файлов
            return fileToString(api.getAudio(Integer.parseInt(script)));
        }
        if (name.equals("vide")) {
            //получаем определенно построенный список видео файлов
            return fileToString(api.getVideo());
        }
        return "wrong";
    }

    private String fileToString(List<File> files) {
        String answer = "";
        for (File f : files) {
            answer += f.toString();
        }
        return answer;
    }

}
