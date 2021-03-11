import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class TaskService {
    private static final String REGEX = "(\\s*,\\s*)+";
    public static List<String> findCollectionsWithRequiredTasks(String requiredTasks, String[] taskCollections) {
        List<String> result = new ArrayList<>();
        Set<String> requiredTaskSet = getTaskSetFromString(requiredTasks);
        for(String taskCollection : taskCollections) {
            Set<String> taskSet = getTaskSetFromString(taskCollection);
            if (taskSet.containsAll(requiredTaskSet)) {
                String taskSetString = taskSet.toString();
                result.add(taskSetString.substring(1, taskSetString.length()-1));
            }
        }
        return result;
    }

    private static Set<String> getTaskSetFromString(String string) {
        Set<String> set = new TreeSet<>();
        String[] arr = string.trim().split(REGEX);
        if (!"".equals(arr[0]))
            set.add(arr[0]);
        set.addAll(Arrays.asList(arr).subList(1, arr.length));
        return set;
    }

    public static void saveToFile(String path, Collection<String> stringCollection) {
        try(PrintWriter printWriter = new PrintWriter(new FileOutputStream(path))) {
            int index = 0;
            for (String str : stringCollection) {
                printWriter.printf("%d, %s\n", index++, str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
