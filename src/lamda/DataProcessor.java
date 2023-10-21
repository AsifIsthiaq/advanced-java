package lamda;

import java.util.*;

enum Operation {
    PRINT_TO_CONSOLE,
    PRINT_TO_FILE
}

@FunctionalInterface
interface ProcessData<T> {
    boolean apply(Map<String, T> data, Operation op);
}

public class DataProcessor {

    static <T> boolean processAndPrint(Map<String, T> data, Operation op, ProcessData<T> process) {
        return process.apply(data, op);
    }

    public static void main(String[] args) {

        ProcessData<List<Integer>> process = (data, op) -> {
            if (op == Operation.PRINT_TO_CONSOLE) {
                List<Integer> list = data.getOrDefault("TRADE", new ArrayList<Integer>());
                Collections.sort(list);
                System.out.println("Printing Data After Sorting");
                list.forEach(System.out::println);
                return true;
            }
            return false;
        };
        ProcessData<int[]> process2 = (data, op) -> {
            if (op == Operation.PRINT_TO_FILE) {
                int[] list = data.getOrDefault("TRADE", new int[1]);
                Arrays.sort(list);
                System.out.println("Printing Data After Sorting");
                System.out.println(Arrays.toString(list));
                return true;
            }
            return false;
        };
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>() {{
            put("TRADE", Arrays.asList(4, 2, 1, 555, 32, 2, 0));
        }};
        Map<String, int[]> map2 = new HashMap<String, int[]>() {{
            put("TRADE", new int[]{23, 44, 3, 2, 1, 0, 66});
        }};
        processAndPrint(map, Operation.PRINT_TO_CONSOLE, process);
        processAndPrint(map2, Operation.PRINT_TO_FILE, process2);
    }
}
