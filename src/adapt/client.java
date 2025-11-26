package adapt;

/**
 * @author TwoHour
 * @version 1.0
 * @描述: 客户端测试类，演示根据类型获取不同适配器
 * @since 2025-10-23 17:05
 **/
public class client {
    public static void main(String[] args) {
        getAdapt factory = new getAdapt();
        
        System.out.println("=== 使用枚举类型获取适配器 ===");
        
        // 使用枚举类型获取S1适配器
        target s1Adapter = factory.getTarget(getAdapt.PaymentType.S1);
        System.out.println("S1适配器测试:");
        s1Adapter.pay(100);
        
        System.out.println();
        
        // 使用枚举类型获取S2适配器
        target s2Adapter = factory.getTarget(getAdapt.PaymentType.S2);
        System.out.println("S2适配器测试:");
        s2Adapter.pay(200);
        
        System.out.println("\n=== 使用字符串类型获取适配器 ===");
        
        // 使用字符串类型获取适配器
        target s1Adapter2 = factory.getTarget("s1");
        System.out.println("通过字符串's1'获取适配器:");
        s1Adapter2.pay(300);
        
        target s2Adapter2 = factory.getTarget("S2");
        System.out.println("通过字符串'S2'获取适配器:");
        s2Adapter2.pay(400);
        
        System.out.println("\n=== 异常处理测试 ===");
        try {
            factory.getTarget("INVALID");
        } catch (IllegalArgumentException e) {
            System.out.println("捕获异常: " + e.getMessage());
        }
    }
}
