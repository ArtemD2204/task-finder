import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> res = TaskService.findCollectionsWithRequiredTasks("T1004, , T1005, ",
                new String[]{"T1005, ,T1004,", " T1008, ,T1004, ,T1005,", "T1009, ,T1005,", "T1009,T1004,,T1008 , ,T1005,"});
        TaskService.saveToFile("D:/task-finder-res.csv", res);
    }
}
