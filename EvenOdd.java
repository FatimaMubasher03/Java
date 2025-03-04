public class EvenOdd{
     public static void main (String[] args){
        int evencount=0, oddcount=0;

        int[] numbers={1,2,3,4,5,6,7,8,9,10};
        for(int num:numbers){
            if (num % 2==0){
                evencount++;
            }
            else{
                oddcount++;
            }
        }
        //System.out.println("Original Array: " + numbers[0]);
        System.out.println("EvenCount: " + evencount);
        System.out.println("OddCount: " + oddcount);
    }
}