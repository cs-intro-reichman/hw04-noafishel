public class Primes {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[] arr = new boolean[n+1];
        for (int i = 2; i < arr.length; i++){
            arr[i] = true;
        }

        int p = 2;
        while (p <= Math.sqrt(n)) {
            arr = crossOut(arr, p);
            p = nextIndex(arr, p);
        }
        printlnArr(arr, n);
    }

    public static boolean[] crossOut (boolean[] arr, int p){
        for (int i = (p + 1); i < arr.length; i++){
            if (i % p == 0) {
                arr[i] = false;
            }
        }

        return arr;
    }

    public static int nextIndex (boolean[] arr, int p){
        for(int i = (p + 1); i < arr.length; i++){
            if (arr[i]) {
                return i;
            }
        }
        return arr.length;
    }

    public static void printlnArr (boolean[] arr, int n){
        System.out.println("Prime numbers up to " + n + ":");
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i]) {
                System.out.println(i);
                count++;
             }
        }
        double percent = ((double)count / n) * 100;
        System.out.println("There are " + count + " primes between 2 and " +
                            n + " (" + (int)percent + "% are primes)");
    }
}