package algoJavaDay01;

public class Code01_PrintB {
    // 位运算

    public  static  void print(int num) {
        for (int i = 31; i >=0 ; i--) {
            // 左移不带符号 右移有带符号的
            // 1往左移动i位
            // num << 1 == num * 2
            System.out.print((num & (1 << i))  == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 32位
        int num = 1123123;
        // ~取反 位运算 |, ^, &
        int b = ~num;

        print(num);
        print(b);
    }
}
