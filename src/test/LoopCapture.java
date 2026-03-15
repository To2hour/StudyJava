package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoopCapture {
    public static void main(String[] args) {
        List<person> list = Arrays.asList(new person("1", 1));
        List<Runnable> tasks = new ArrayList<>();
        // for (int i = 0; i < list.size(); i++) { // i 每次迭代都变化
        //     tasks.add(() -> System.out.println(i)); // 编译错误! i 不是 effectively final
        // }

        // Java 自然地避免了这个问题，因为它不允许捕获非 final 的循环变量
        // 正确的做法是在 lambda 内部创建一个副本，但这通常发生在其他场景下，比如处理集合元素
        for (var item : list) {
            tasks.add(() -> System.out.println(item));
        }
        tasks.forEach(Runnable::run); // 输出: A, B, C
    }
}