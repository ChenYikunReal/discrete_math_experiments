import java.util.*;

public class Voter{
    
    //int转boolean
    public static boolean changeType(int var) {
        if (var == 1) {
            return true;
        } else {
            return false;
        }
    }

    //合取
    public static boolean Conjunction(boolean var1, boolean var2){
        if (var1 && var2){
            return true;
        }else{
            return false;
        }
    }

    //分析主析取范式(┓A∧B∧C) ∨(A∧┓B∧C)∨(A∧B∧┓C)∨(A∧B∧C)的真值
    //只要ABC中有至少两个同意（输入true）就可以
    public static boolean Disjunctive(boolean var1, boolean var2, boolean var3){
        return (var1 || var2 || var3);
    }
    
    //输出表决结果
    public static void getResult(boolean var) {
        if (var == true) {
            System.out.println("恭喜，表决通过");
        } else {
            System.out.println("很遗憾，表决没有通过");            
        }
    }

    public static void main(String[] args) {
        boolean a = false, b = false, c = false;
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入您的表决值！1代表同意，0代表反对，其余输入均无效");            
            int x = scan.nextInt();
            if (x == 0 || x == 1) {
                switch (i) {
                    case 0:
                        a = changeType(x);
                        break;
                    case 1:
                        b = changeType(x);
                        break;
                    case 2:
                        c = changeType(x);
                        break;
                }
            } else {
                System.out.println("您的输入错误，表决无效");
            }
        }
        
        getResult(Disjunctive(Conjunction(a, b), Conjunction(a, c), Conjunction(b, c)));
        scan.close();
    }

}