import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String ss[] = s.split(",");
        int a = Integer.valueOf(ss[0]);
        int b = Integer.valueOf(ss[1]);

        int primes[] = new int[50000];
        int primes2[] = new int[b/2];
        int primesMax = 0;
        int primes2Max = 0;
        primes[0] = 2;
        //查出範圍內所有的質數
        for(int i = 3 ; i<=b; i+=2){
            for(int j = 0 ; j<= primesMax ; j++){
                if(i%primes[j] == 0){
                    break;
                }
                if(j == primesMax){
                    primesMax += 1;
                    primes[primesMax] = i;
                    break;
                }
            }
        }

        for(int i = 0 ; i < primesMax ; i++){
            if(primes[i]>=a && primes[i]<= b){
                primes2[primes2Max] = primes[i];
                primes2Max++;
            }
        }
        int maxSeriesNum = 0;
        for(int i = 0 ; i<=primes2Max ; i++){
            for(int j = i+1 ; j<=primes2Max ; j++){
                int difference = primes2[j] - primes2[i];
                int seriesNum = calcSeriesNum(i,b,difference,primes2);
                if(maxSeriesNum < seriesNum){
                    maxSeriesNum = seriesNum;
                }
                //System.out.println(seriesNum);
            }
        }
        System.out.println(maxSeriesNum);
    }

    public static int calcSeriesNum(int start ,int max, int difference , int[] primes){
        int seriesNum = 1 ;
        for(int i = start+difference ; i<max ; i+= difference){
            if(isPrime(i,primes)){
                seriesNum++;
            }
            else{
                break;
            }
        }
        return seriesNum;
    }

    public static boolean isPrime(int testNum ,int[] primes){
        for(int i = 0 ; i<primes.length ; i++){
            if(primes[i] == testNum){
                return true;
            }
        }
        return false;
    }
}