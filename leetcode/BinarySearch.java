import java.util.Arrays;
import java.util.Scanner;

/**
 * 查找一条直线上距离 0 点最近的点
 *
 * 采用二分查找法，时间复杂度是 log(n)
 */
public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int[] arr = Arrays.stream(str.split(",")).mapToInt(Integer::valueOf).toArray();
//        int[] arr = new int[]{-9,-8,-7,-5,-4,-3,2,3,5,8};
        int v = search(arr, 0, arr.length-1);
        System.out.println(v);
    }

    private static int search(int[] arr, int start, int end){
        if(start == end || start+1 == end){
            if(Math.abs(arr[start]) > Math.abs(arr[end])){
                return arr[end];
            }else {
                return arr[start];
            }
        }
        int mid = (start+end)/2;
        System.out.printf("%d=%d %d=%d %d=%d \n", start, arr[start], end, arr[end], mid, arr[mid]);
        if(arr[mid]>0){
            return search(arr, start, mid);
        }else if(arr[mid] < 0){
            return search(arr, mid, end);
        }else {
            return 0;
        }
    }
}
