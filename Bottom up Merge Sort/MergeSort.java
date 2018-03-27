import java.util.Arrays;

public class BottomUp {
	
	 public static void mergeSort(float[] arr, float[] temp) {
		 int arrLength = arr.length;
		 int left,mid,right;
		 
		 for(int size = 1; size < arrLength; size = size*2) {
			 for(left = 0; left < arrLength-1; left = left + (2 * size)) {
				 mid = left + size - 1;
				 //right = Math.min(left+(2*size)-1, arrLength - 1);
				 if((arrLength - 1) > (left + (2*size) - 1)) {
					 right = left + (2*size) - 1; 
				 }
				 else {
					 right = arrLength-1;
				 }
				 merge(arr, temp, left, mid, right);
			 }
			 
			 
			 
		 }
		 
		 
		 
	 }
	 
	 public static void merge(float[] arr, float[] temp, int l, int m, int r) {
		 int i = l;
		 int j = m + 1;
		 int k = l;
		 while((i<=m)&&(j<=r)) {
			 if(arr[i] < arr[j]) {
				 temp[k] = arr[i];
				 i = i+1;
			 }
			 else {
				 temp[k] = arr[j];
				 j = j + 1;
			 }
			 k = k + 1;
		 }
		 for(;i<=m;i++) {
			 temp[k] = arr[i];
			 k = k + 1;
		 }
		 for(;j<=r;j++) {
			 temp[k] = arr[j];
			 k = k + 1;
		 }
		 
		 int subArrayCopySize = r-l+1;
		 for(int h = l; h < subArrayCopySize + l; h++) {
			 arr[h] = temp[h];
		 }
		 
	 }
	
     public static void main(String[] args) {
    	 float[] arr = {100, 80, 30, 110, 150, 10, 20, 15, 12};
    	 float[] temp = new float[arr.length];
    	 mergeSort(arr, temp);
    	 for(int i =0; i<temp.length; i++) {
    		 arr[i] = temp[i];		 
    	 }
    	 System.out.println(Arrays.toString(arr));
     }
     
}
