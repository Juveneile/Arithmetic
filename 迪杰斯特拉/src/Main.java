import java.util.Scanner;

/**
 * @author hxxhk
 */
public class Main {
    public static int MaxValue = 100000;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //顶点数
        int vertex = input.nextInt();
        //边数
        int edge = input.nextInt();

        int[][] matrix = new int[vertex][vertex];
        //初始化邻接矩阵
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                matrix[i][j] = MaxValue;
            }
        }
        for (int i = 0; i < edge; i++) {
            int source = input.nextInt()-1;
            int target = input.nextInt()-1;
            int weight = input.nextInt();
            matrix[source][target] = weight;
        }

        //单源最短路径，源点
        int source = input.nextInt()-1;
        int target = input.nextInt()-1;
        String time = input.next();
        input.close();
        String[] mdh = time.split("/");
        int hour = Integer.parseInt(mdh[1]);
        String[] md = mdh[0].split("\\.");
        int month = Integer.parseInt(md[0]);
        int day = Integer.parseInt(md[1]);
        //调用dijstra算法计算最短路径
        int[] shortest = dijstra(matrix, source);
        //打印最短路径
        for (int i = 0; i < matrix.length; i++) {
            if (i == target) {
                if(shortest[i] != MaxValue){
                    int hourNew = shortest[i];
                    month = month + (day + (hour + hourNew) / 24) / 30;
                    day = (day + (hour + hourNew) / 24) % 31;
                    hour = (hour + hourNew) % 24;
                }
                System.out.println(month + "." + day + "/" + hour);
            }
        }
    }


    public static int[] dijstra(int[][] matrix, int source) {
        //最短路径长度
        int[] shortest = new int[matrix.length];
        //判断该点的最短路径是否求出
        int[] visited = new int[matrix.length];
        //存储输出路径
        String[] path = new String[matrix.length];

        //初始化输出路径
        for (int i = 0; i < matrix.length; i++) {
            path[i] = new String(source + "->" + i);
        }

        //初始化源节点
        shortest[source] = 0;
        visited[source] = 1;

        for (int i = 1; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;

            for (int j = 0; j < matrix.length; j++) {
                //已经求出最短路径的节点不需要再加入计算并判断加入节点后是否存在更短路径
                if (visited[j] == 0 && matrix[source][j] < min) {
                    min = matrix[source][j];
                    index = j;
                }
            }

            //更新最短路径
            shortest[index] = min;
            visited[index] = 1;

            //更新从index跳到其它节点的较短路径
            for (int m = 0; m < matrix.length; m++) {
                if (visited[m] == 0 && matrix[source][index] + matrix[index][m] < matrix[source][m]) {
                    matrix[source][m] = matrix[source][index] + matrix[index][m];
                    path[m] = path[index] + "->" + m;
                }
            }

        }
        return shortest;
    }

}
