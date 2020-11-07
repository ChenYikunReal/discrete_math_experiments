public class Reasoning {
    
    //int转boolean
    public static boolean changeType(int var) {
        if (var == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    //合取
    public static boolean Conjunction(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5){
        if (var1 && var2 && var3 && var4 && var5){
            return true;
        }else{
            return false;
        }
    }

    //析取
    public static boolean Disjunctive(boolean var1, boolean var2){
        if ((var1 || var2) == true){
            return true;
        }else{
            return false;
        }
    }
    
    //逻辑推理最终表达式真伪
    public static boolean judge(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5){
        if (Conjunction(Disjunctive(var1, var2), Disjunctive(!var1, !var3), Disjunctive(!var4, !var5), Disjunctive(var4, var3), var5)) {
            return true;
        } else {
            return false;
        }
    }
    
    //输出结果
    public static void getResult(boolean var1, boolean var2, boolean var3) {
        if (var1 == true) {
            if (var2 == true) {
                if (var3 == false) {
                    System.out.println("结论是:A偷窃了x");
                    System.exit(0);
                }
            } else {
                if (var3 == true) {
                    System.out.println("结论是:B偷窃了x");
                    System.exit(0);
                }
            }
        }
    }
    
    //main方法
    public static void main(String[] args) {
        boolean A, B, C, D, E;
        for (int a = 0; a <= 1; a++) {
            for (int b = 0; b <= 1; b++) {
                for (int c = 0; c <= 1; c++) {
                    for (int d = 0; d <= 1; d++) {
                        for (int e = 0; e <= 1; e++) {
                            A = changeType(a);
                            B = changeType(b);
                            C = changeType(c);
                            D = changeType(d);
                            E = changeType(e);
                            getResult(judge(A, B, C, D, E), A, B);
                        }
                    }
                }
            }
        }
    }

}
