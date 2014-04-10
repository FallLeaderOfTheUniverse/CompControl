package Core.Busines.Cash;

import Core.Busines.Interfaces.Cash;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by spier on 4/10/14.
 */

//TODO: переделать указание папок (полностью) оно ужасно
public class CashRealTime implements Cash {
    private static Map<File, Object> cash;

    public static void main(String[] args) {
        CashRealTime cashRealTime = new CashRealTime();
        Map<File, Object> map = cashRealTime.getOneLevelMap(new File("/"));
        //cashRealTime.mapSout(map);
        String file = "home/spier/prog/";
        String folder = "/";
        System.out.println(folder + file);
        cash = cashRealTime.getRecursMap(file, map, folder);

        cash = cashRealTime.getRecursMap(file, cash, folder);

        cashRealTime.recursMapOutput(cash);
    }

    @Override
    public List<File> getFiles() {
        return null;
    }

    //возвращает список файлов в папке
    private List<File> getListOfFiles(File file) {
        List<File> list = new ArrayList<File>();
        for (File f : file.listFiles()) {
            list.add(f);
        }
        return list;
    }

    //разбивает файл.тустринг на уровни в листе стринг
    private List<String> getFileByList(File file) {
        String sFile = file.toString() + "/";
        List<String> lFile = new ArrayList<String>();
        while (!sFile.equals("")) {
            int i = sFile.indexOf("/");
            lFile.add(sFile.substring(0,i+1));
            sFile = sFile.substring(i+1);
        }
        return lFile;
    }

    // возвращает в мапу все файлы в папке
    private Map<File, Object> getOneLevelMap(File file) {
        Map<File, Object> map = new HashMap<File, Object>();
        for (File f : file.listFiles()) {
            map.put(f, new HashMap<File, Object>());
        }
        return map;
    }

    private Map<File, Object> getRecursMap(String file, Map<File, Object> map, String folder) {
        if (map.containsKey(new File(folder + getFirstFolder(file)))) {
            if ( ((Map<File, Object>)  map.get(new File(folder + getFirstFolder(file)))).size() == 0) {
                Map<File, Object> rMap = getOneLevelMap(new File(folder + getFirstFolder(file)));
                map.put(new File(folder + getFirstFolder(file)), rMap);
                getRecursMap(getNextFolder(file), rMap, folder + getFirstFolder(file));
                System.out.println(folder + getFirstFolder(file));
                System.out.println("-------------------------------------------------------");
            } else {
                getRecursMap(getNextFolder(file), ((Map<File, Object>)  map.get(new File(folder + getFirstFolder(file)))), folder + getFirstFolder(file));
                System.out.println("===============" + folder + getFirstFolder(file));
            }

        }
        return map;
    }

    private String getFirstFolder(String file) {
        int i = file.indexOf("/");
        return file.substring(0, i+1);
    }

    private String getNextFolder(String file) {
        int i = file.indexOf("/");
        return file.substring(i+1);
    }

    private void recursMapOutput(Map<File, Object> map) {
        for (Map.Entry<File, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "/" /*+ "map"*/);


            recursMapOutput((Map<File, Object>) entry.getValue());
        }
    }

    private void mapSout(Map<File, Object> map) {
        if (map == null) {
            System.out.println("null");
        }
        for (Map.Entry<File, Object> entry : map.entrySet()) {
            System.out.print(entry.getKey() + "|" + entry.getValue() + " ");
        }
        System.out.println();
    }
}
