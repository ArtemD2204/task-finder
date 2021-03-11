import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class TaskServiceTest {

    @Parameterized.Parameter(0)
    public String requiredTasks;

    @Parameterized.Parameter(1)
    public String[] taskCollections;

    @Parameterized.Parameter(2)
    public List<String> expectedResult;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {
                        ",T1001,",
                        new String[]{"T1005", ",T1001,", "   T1001 ,, , T1005 ,,  ",
                                ",T1005,, ,T1001,", "T1004, ,T1001, T1007, ", "T1009, ,T1005, "},
                        Arrays.asList("T1001", "T1001, T1005", "T1001, T1005", "T1001, T1004, T1007")
                },
                {
                        "T1004, , T1005, ",
                        new String[]{"T1004", "T1005, ,T1004,", " T1008, ,T1004, T1009, , ,T1005,", "T1009, ,T1005,"},
                        Arrays.asList("T1004, T1005", "T1004, T1005, T1008, T1009")
                },
                {
                        "T1004, , T1005, ,T1006,",
                        new String[]{"T1004", "T1005, ,T1004,", " T1006, ,T1004,  , ,T1005,",
                                " T1006, ,T1004, T1009 , ,T1005,", "T1009, ,T1005,,,T1004"},
                        Arrays.asList("T1004, T1005, T1006", "T1004, T1005, T1006, T1009")
                }
        };
        return Arrays.asList(data);
    }

    @Test
    public void findCollectionsWithRequiredTasks() {
        List<String> actualRes = TaskService.findCollectionsWithRequiredTasks(requiredTasks, taskCollections);
        Assert.assertEquals(expectedResult, actualRes);
    }
}
