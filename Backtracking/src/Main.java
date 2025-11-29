import java.util.*;

public class Main {

    // Backtracking básico: explora todas las posibilidades
    public static boolean canPartition(int[] nums) {
        int total = 0;
        for (int n : nums) total += n;
        if (total % 2 != 0) return false;
        return backtrack(nums, 0, total / 2);
    }

    private static boolean backtrack(int[] nums, int i, int target) {
        if (target == 0) return true;
        if (i >= nums.length || target < 0) return false;

        // tomar
        if (backtrack(nums, i + 1, target - nums[i])) return true;

        // no tomar
        return backtrack(nums, i + 1, target);
    }

    public static void main(String[] args) {
        System.out.println("------------------------------------------------");
        System.out.println(" EXPERIMENTO SET PARTITION");
        System.out.println(" Enfoque: Backtracking");
        System.out.println("------------------------------------------------");

        int[] arr = {3, 1, 5, 9, 12};

        long t1 = System.nanoTime();
        boolean resp = canPartition(arr);
        long t2 = System.nanoTime();
        long exeTime = t2 - t1;

        System.out.println("Set fijo de tamaño = " + arr.length + "");
        System.out.println("Tiempo (ns): " + exeTime );
        System.out.println("Tiempo (s): " + exeTime / 1_000_000_000.0);
        System.out.println("Tiempo (min): " + exeTime / 60_000_000_000.0);
    }
}