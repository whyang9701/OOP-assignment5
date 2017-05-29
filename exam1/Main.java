import java.util.*;


public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int testNum = 2 ; testNum<=a ; testNum++){
            Integer[] factors = getFactors(testNum);
            int sumOfFaactors = 0;
            for(int factor : factors){
                sumOfFaactors += factor;
            }
            
            if(sumOfFaactors == testNum){
                result.add(testNum);
                
            }
            
        }
        for(int i = 0 ; i < result.size(); i++){
                System.out.print(result.get(i));
                
                if(i+1!= result.size()){
                    System.out.print(" ");
                }
        }
    }
    public static Integer[] getFactors(int a){
        ArrayList<Integer> factors = new ArrayList<Integer>();
        factors.add(1);
        for(int i = 2 ; i<=Math.sqrt(a) ; i++){
            if(a % i == 0){
                int factor1 = i;
                int factor2 = a/i;
                factors.add(i);
                if(factor1 != factor2){
                    factors.add(factor2);
                }
            }
        }
        return factors.toArray(new Integer[factors.size()]);
    }
}
