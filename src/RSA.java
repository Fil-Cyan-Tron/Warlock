public class RSA {
    public static int fastExp(int base, int esponente, int n) {
        int output = 1;
        while (esponente > 0) {
            output = (output * base) % n;
            esponente = esponente - 1;
        }
        return output;
    }

    public static int decriptaInt(int input, int[] chiavi) {
        if (chiavi.length != 4) {
            System.out.println("C'è qualcosa che non va con le chiavi :(");
            return 0;
        }
        int r = chiavi[0];
        int p = chiavi[2];
        int q = chiavi[3];
        int n = p * q;
        return fastExp(input, r, n);
    }

    public static int criptaInt(int input, int[] chiavi) {
        if (chiavi.length != 4) {
            System.out.println("C'è qualcosa che non va con le chiavi :(");
            return 0;
        }
        int s = chiavi[1];
        int p = chiavi[2];
        int q = chiavi[3];
        int n = p * q;
        return fastExp(input, s, n);
    }

    public static boolean checkCoprimi(int n, int s){
        int r;
        while(s > 0){
            r = n%s;
            n = s;
            s = r;
        }
        if(n < 0){
            n = -n;
        }
        return n == 1;
    }

    public static boolean isPrime(int n){
        boolean prime = true;
        if(n == 0){
            return false;
        }
        if(n < 0){
            n = -n;
        }
        if(n == 1){
            return false;
        }
        for(int i = 2 ; i < n && prime ; i++){
            prime = checkCoprimi(n,i);
        }
        return prime;
    }

    public static int EuclideEsteso(int s, int p, int q){
        int old_r = 0;
        int r = 1;
        int new_r;
        int old_t = 1;
        int t = 0;
        int new_t;
        int phi = (p-1)*(q-1);
        int old_gcd = phi;
        int gcd = s;
        int new_gcd = old_gcd%gcd;
        while(new_gcd != 1){
            int k = old_gcd/gcd;
            new_r = old_r - (k*r);
            old_r = r;
            r = new_r;
            new_t = old_t - (k*t);
            old_t = t;
            t = new_t;
            new_gcd = old_gcd%gcd;
            old_gcd = gcd;
            gcd = new_gcd;
        }
        while(r <= 0){
            r = r + phi;
        }
        return r;
    }
}