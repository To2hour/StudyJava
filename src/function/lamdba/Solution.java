package function.lamdba;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<String> res = new ArrayList<>();

    public List<String> allSubstrings(String s) {
        dfs(s, 0);
        return res;
    }

    // DFS 枚举从 startIndex 开始的所有子串
    private void dfs(String s, int startIndex) {
        if (startIndex == s.length()) {
            return; // 到末尾就返回
        }

        // 枚举以 startIndex 开头的所有长度子串
        for (int i = startIndex; i < s.length(); i++) {
            String temp = s.substring(startIndex, i + 1);
            res.add(temp); // 收集当前子串
            System.out.println("DFS: startIndex=" + startIndex + ", i=" + i + ", temp=" + temp); // 打印调试
            dfs(s, startIndex + 1); // 递归从下一个起点开始
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "abc";
        List<String> ans = sol.allSubstrings(s);

        System.out.println("所有子串:");
        for (String sub : ans) {
            System.out.println(sub);
        }
    }
}
