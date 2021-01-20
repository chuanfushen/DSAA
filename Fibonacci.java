public class Fibonacci {

    public static int fib(int n)
    {
        // Base Case
        if (n <= 1)
            return n;

        // Recursive call
        return fib(n - 1)
                + fib(n - 2);
    }

    public static int nonfib(int n)
    {
        int f[] = new int[n + 2];
        int i;
        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static void main(String[]args){
        int N = 10;

        for (int i = 0; i < N; i++)
            System.out.print(nonfib(i) + " ");
    }
}
