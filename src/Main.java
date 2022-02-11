public class Main {

    private static final int N = 4;
    private static int cols[] = new int[N+1];

    public static boolean promise(int level){
        for(int i=1; i<level; i++){
            if(cols[i] == cols[level]){
                return false;
            }
            else if(level - i == Math.abs(cols[level]-cols[i])){
                return false;
            }
        }
        return true;
    }

    public static boolean queen(int level){
        if(!promise(level))
            return false;
        else if(level == N) {
            return true;
        }
        for(int i=1; i<=N; i++){
            cols[level+1] = i;
            if(queen(level+1))
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        queen(0);

        for(int i=1; i<=N; i++){
            System.out.println(i + "행 queen 위치: " + cols[i] + "열");
        }
    }
}
