package function.lamdba;


/**
 * @author TwoHour
 * @version 1.0
 * @描述: todo
 * @since 2025-11-28 10:57
 **/
public class lamdbaTest {
}

class Solution6 {
    public int uniquePaths(int m, int n) {

        // 计数器，用数组包装以允许 lambda 修改
        int[] count = {0};
        Dfs dfs = (self, x, y) -> {
            // 到达终点
            if (x == m && y == n) {
                count[0]++;
                return;
            }

            // 可以往下走
            if (x < m) {
                self.search(self, x + 1, y);
            }

            // 可以往右走
            if (y < n) {
                self.search(self, x, y + 1);
            }
        };

        dfs.search(dfs, 1, 1);

        return count[0];
    }
}

@FunctionalInterface
interface Dfs {
    void search(Dfs self, int x, int y);
}

//package function.lamdba;
//
//
//import java.util.ArrayList;
//
/// **
// * @author TwoHour
// * @version 1.0
// * @描述: todo
// * @since 2025-11-28 10:57
// **/
////public class lamdbaTest {
////}
////
////class Solution {
////    public int uniquePaths(int m, int n) {
////        if (m == 1 || n == 1) {
////            return 1;
////        }
////        ArrayList<Integer> list = new ArrayList<>(1);
////        list.set(0, 1);
////        dfs d;
////        d = (m1, n1) -> {
////            if (m1 == m && n1 == n) {
////                return;
////            }
////            if (m1 == m && n1 < n) {
////                Integer i = list.get(0);
////                list.set(0, ++i);
////                d.search(a, m, n + 1);
////            }
////            if (m1 < m && n1 == n) {
////                Integer i = list.get(0);
////                list.set(0, ++i);
////                a.search(a, m + 1, n);
////            }
////            Integer i = list.get(0);
////            list.set(0, ++i);
////            a.search(a, m + 1, n);
////        };
////    }
////}
////
////interface dfs {
////    void search(int n, int m);
////}