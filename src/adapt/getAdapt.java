package adapt;

/**
 * @author TwoHour
 * @version 1.0
 * @描述: 适配器工厂类，根据类型获取不同的适配器
 * @since 2025-10-23 17:09
 **/
public class getAdapt {
    
    // 定义支付类型枚举
    public enum PaymentType {
        S1, S2
    }
    
    /**
     * 根据支付类型获取对应的适配器
     * @param type 支付类型
     * @return 对应的适配器
     */
    public target getTarget(PaymentType type) {
        switch (type) {
            case S1:
                return new adapt(new s1());
            case S2:
                return new adapt(new s2());
            default:
                throw new IllegalArgumentException("不支持的支付类型: " + type);
        }
    }
    
    /**
     * 根据字符串类型获取适配器
     * @param typeStr 类型字符串
     * @return 对应的适配器
     */
    public target getTarget(String typeStr) {
        try {
            PaymentType type = PaymentType.valueOf(typeStr.toUpperCase());
            return getTarget(type);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("不支持的支付类型: " + typeStr);
        }
    }
}
