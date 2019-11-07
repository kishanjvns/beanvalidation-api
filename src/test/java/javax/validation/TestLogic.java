/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kjaiswal
 */
public class TestLogic {
    public static void main(String[] args){
       int [] arr={10, 7, 1, 1, 1, 1,6};
       int length=arr.length;
       int mid=arr.length/2;
       int leftSum=0;
       int rightSum=0;
      
        for(int i=0;i<length/2;i++){
            int leftIndex=0;
            int rightIndex=length-1;
            leftSum=left(arr, leftSum, leftIndex, length);

            rightSum=right(arr, rightSum, rightIndex, length);

            
            boolean isTrue=check(arr,leftIndex,rightIndex, leftSum, rightSum);
            while(true){
                if(isTrue){
                System.out.print("Pass \n leftIndex "+leftIndex+" \n rightIndex "+rightIndex+"\n");
                break;
            }else{
                leftIndex=leftIndex+1;
                leftSum=left(arr, leftSum, leftIndex, length);
                rightIndex=rightIndex-1;
                rightSum=right(arr, rightSum, rightIndex, length);
            }
                isTrue=check(arr,leftIndex,rightIndex,leftSum, rightSum);
            }
            break;
        }
       System.out.print("out of for");

    }          
    public static boolean check(int[] arr,int leftIndex,int rightIndex, int leftSum,int rightSum){
        if(leftSum<rightSum){
           leftSum= left(arr, leftSum, ++leftIndex, arr.length);
           check(arr, leftIndex, rightIndex, leftSum, rightSum);
        }
        if(leftSum>rightSum){
           rightSum=right(arr, rightSum, --rightIndex, arr.length);
           check(arr, leftIndex, rightIndex, leftSum, rightSum);
        }
        return true;
    }




    public static int left(int[] arr,int leftSum,int leftIndex,int length){
         for(;leftIndex<length;leftIndex++){
                leftSum=leftSum+arr[leftIndex];
                break;
            }
         return leftSum;
    }

    public static int right(int[] arr,int rightSum,int rightIndex,int length){
        for(;rightIndex>=0;rightIndex--){
                rightSum=rightSum+arr[rightIndex];
                break;
            }
        return rightSum;
    }
}
