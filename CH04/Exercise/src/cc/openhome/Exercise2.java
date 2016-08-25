package cc.openhome;

public class Exercise2 {
    public static void main(String args[]) { 
        final int N = 52; 
        int[] poker = new int[N + 1]; 

        for(int i = 1; i <= N; i++) {
            poker[i] = i; 
        }

        for(int i = 1; i <= N; i++) { 
            int j = (int) (Math.random() * N);

            if(j == 0) {
                j = 1;
            }

            int tmp = poker[i]; 
            poker[i] = poker[j]; 
            poker[j] = tmp; 
        } 

        for(int i = 1; i <= N; i++) { 
            switch((poker[i] - 1) / 13) { 
                case 0: System.out.print("桃"); break; 
                case 1: System.out.print("心"); break; 
                case 2: System.out.print("磚"); break; 
                case 3: System.out.print("梅"); 
            } 

            int remain = poker[i] % 13; 
            switch(remain) { 
                case 0: System.out.print(" K"); break; 
                case 12: System.out.print(" Q"); break; 
                case 11: System.out.print(" J"); break; 
                default: System.out.printf("%2d", remain); 
            } 
            System.out.printf("%c", i % 13 == 0 ? '\n' : ' '); 
        } 
    }     
}
