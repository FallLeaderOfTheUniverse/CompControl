package Core;

import java.io.File;

/**
 * Created by spier on 4/10/14.
 */
public class Chooser {

    private void commandRecognise(String command) throws Exception {

        BusinessApi api = new BusinessApi();
        String name = command.substring(0, 4);
        String script = command.substring(5);

        if (name.equals("bash")) {
            //выполняем распознавание скрипка, возращается готовый скрипт, запускаем
            api.runScript(script);
        }
        if (name.equals("echo")) {
            //отправляем на на клиент эхо
            api.makeEcho(script);
        }
        if (name.equals("file")) {
            //получаем список файлов в данной директории, возвращаем на клиент
            api.getFiles(new File(script));
        }
        if (name.equals("audi")) {
            //получаем определенно построенный спиоск аудио файлов
            api.getAudio(Integer.parseInt(script));
        }
        if (name.equals("vide")) {
            //получаем определенно построенный список видео файлов
            api.getVideo();
        }
    }

}
