import java.util.*;

public class HukommelsesTest {

    static class MyObject {
        int a = 42;
        int b = 7;
        byte[] data = new byte[32];
    }

    public static long getUsedMemoryKB() {
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / 1024;
    }

    public static void benchmark(int count) {
        System.out.println("\n🔢 Antal objekter: " + count);
        List<Long> memoryLog = new ArrayList<>();
        memoryLog.add(getUsedMemoryKB());

        List<MyObject> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(new MyObject());
            memoryLog.add(getUsedMemoryKB());
        }

        memoryLog.add(getUsedMemoryKB());

        long min = Collections.min(memoryLog);
        long max = Collections.max(memoryLog);
        long avg = (long) memoryLog.stream().mapToLong(Long::longValue).average().orElse(0);

        System.out.println("🔻 Min:  " + min + " KB");
        System.out.println("📈 Gennemsnit: " + avg + " KB");
        System.out.println("🔺 Peak: " + max + " KB");
    }

    public static void main(String[] args) {
        for (int count : new int[]{10, 1_000, 10_000, 100_000, 10_000_000}) {
            benchmark(count);
        }
    }
}
