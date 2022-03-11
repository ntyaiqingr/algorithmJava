package algoJavaDay01;

public class Code01_PrintB {
    // 位运算

    public  static  void print(int num) {
        for (int i = 31; i >=0 ; i--) {
            // 左移不带符号 右移有带符号的 >> & >>>
            // 1往左移动i位
            // num << 1 == num * 2
            System.out.print((num & (1 << i))  == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 32位
        int a = 5;
        // ~取反 位运算 |, ^, &
        // -N = ~N + 1;
        //系统最小 取反+1 还是他自己
        int b = ~a;
        int c = 11;
        print(a);
        print(b);
        print(c);
        System.out.println("=================");
        print(a | c); // 有1 就可以
        print(a ^ c); // 完全不相同
        print(a & c); // 都是1 才是1
        System.out.println("-------------------------");
        int num = Integer.MIN_VALUE;
        print(num);
        System.out.println("!!!!!!!!!!");
        // 带符号（正负）右移 原本是负数 现在还是
        print(num >> 1);
        System.out.println("!!!!!!!!!!");
        // 不带符号（正负）右移 原本是负数现在不是了
        print(num >>> 1);
        System.out.println(num >>>1);
    }
}
