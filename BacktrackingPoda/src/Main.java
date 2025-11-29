import java.util.*;

public class Main {

    public static boolean canPartition(int[] nums) {
        int total = 0;
        for (int n : nums) total += n;
        if (total % 2 != 0) return false;

        Arrays.sort(nums);
        reverse(nums); // sort descendente → mejora la poda

        return backtrack(nums, 0, total / 2, total);
    }

    private static boolean backtrack(int[] nums, int i, int target, int remaining) {
        if (target == 0) return true;
        if (i >= nums.length || target < 0) return false;

        // Poda de límite superior: si el máximo posible no alcanza target, cortar
        if (remaining < target) return false;

        // tomar
        if (backtrack(nums, i + 1, target - nums[i], remaining - nums[i])) return true;

        // no tomar
        return backtrack(nums, i + 1, target, remaining - nums[i]);
    }

    private static void reverse(int[] a) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int t = a[l];
            a[l] = a[r];
            a[r] = t;
            l++; r--;
        }
    }

    public static void main(String[] args) {
        System.out.println("------------------------------------------------");
        System.out.println(" EXPERIMENTO SET PARTITION");
        System.out.println(" Enfoque: BacktrackingPoda");
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
