import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String ss[] = s.split(",");
        int a = Integer.valueOf(ss[0]);
        int b = Integer.valueOf(ss[1]);
        int c = Integer.valueOf(ss[2]);
        int max = c/a ;
        for(int i = 0 ; i<=max ; i++){
            int remainNum = c-a*i;
            if(remainNum % b == 0){
                System.out.print(i);
                System.out.print(",");
                System.out.println(remainNum/b);
                
            }
        }
    }
}