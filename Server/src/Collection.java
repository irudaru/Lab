import java.io.File;
import java.util.Date;
import java.util.LinkedList;

/**
 * Класс для хранения и обработки LinkedList
 */
public class Collection {

    /**
     * Дата создания списка
     */
    private Date date = new Date();
    /**
     * Список, в котором хранятся элементы типа Route
     */
    public LinkedList<Route> list = new LinkedList<>();

    /**
     * Метод, возвращающий список, удобный для сохранения в формат CSV
     */
    public static Collection startFromSave(String[] args) {
        if (args.length > 0) {
            File saveFile = new File(args[0]);
            if (saveFile.exists()) {
                SaveManagement.setFile(saveFile);
                return SaveManagement.listFromSave();
            }
        }
        return new Collection();
    }

    /**
     * Метод, осуществляющий поиск элемента по id
     */
    public Route searchById(Integer id) {
        for (Route r : list) {
            if (r.getId().equals(id))
                return r;
        }
        return null;
    }

    public Date getDate() {
        return date;
    }

    /**
     * Метод, возвращающий уникальный id
     */
    public int getRandId() {
        int id;
        do {
            id = (int) (1 + Math.random() * (Integer.MAX_VALUE - 1));
        } while (this.searchById(id) != null);
        return id;
    }
}