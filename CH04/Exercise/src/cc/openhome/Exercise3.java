package cc.openhome;

public class Exercise3 {
    public static void main(String[] args) {
        // 氣泡排序
        int[] number = {70, 80, 31, 37, 10, 1, 48, 60, 33, 80};
        boolean flag = true; 
        for(int i = 0; i < number.length-1 && flag; i++) { 
            flag = false; 
            for(int j = 0; j < number.length-i-1; j++) { 
                if(number[j+1] < number[j]) { 
                    int t = number[j+1]; 
                    number[j+1] = number[j]; 
                    number[j] = t;
                    flag = true; 
                } 
            } 
        }
        for(int n : number) {
            System.out.printf("%3d", n);
        }
    }
}
