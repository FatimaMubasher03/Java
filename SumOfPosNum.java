import java.util.Scanner;

class SumOfPosNum{
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int a,b,summ=0;

        while (true){
            System.out.println("Enter Number 1: ");
            a=in.nextInt();
            if (a==-1) break;

            System.out.println("Enter Number 2: ");
            b=in.nextInt();

            System.out.println("Sum is " + (a+b));
            summ++;
            System.out.println("Operation performed " + summ + " number of times");
        }
    
        in.close();
    }
}