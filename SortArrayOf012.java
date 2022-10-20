import java.util.Arrays;
import java.util.Scanner;
class SortArrayOf012{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the Size of Array");
        int n = scn.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the Value between 0,1,2");
        for(int a=0;a<n;a++){
            arr[a]=scn.nextInt();
        }
        
        sort(arr);

        System.out.println(Arrays.toString(arr));

    }
    public static void sort(int[]arr){
        int low =0,mid =0;
        int high = arr.length-1;

        while(mid<high){

            if(arr[mid] == 0){
                swap(low,mid, arr);
                low++;
                mid++;

            }else if(arr[mid] == 1){
                mid++;
            }else{
                swap(mid,high,arr);
                high--;
            }
        }
    }

    public static void swap(int a,int b, int[]arr){
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}