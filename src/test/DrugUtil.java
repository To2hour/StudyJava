package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class DrugUtil {
    // ====== 并发控制：序号计数器（解决同一毫秒内生成重复单号的问题） ======
    private static final AtomicInteger sequence = new AtomicInteger(0);
    private static volatile long lastTimestamp = 0L;

    private DrugUtil() {
        // 私有构造函数，防止实例化
    }

    /**
     * 生成带序号的单号（线程安全，解决并发问题）
     * 格式：前缀 + yyMMddHHmmssSSS + 序号(01-99)
     * 同一毫秒内最多生成100个不重复单号
     *
     * @param prefix 单号前缀（如：RK、OUT、PC等）
     * @return 单号
     */
    private static synchronized String generateBillCodeWithSequence(String prefix) {
        long currentTime = System.currentTimeMillis();
        int seq;

        if (currentTime == lastTimestamp) {
            // 同一毫秒内，序列号递增（1-99）
            seq = sequence.incrementAndGet();
            if (seq >= 100) {
                // 超过100个，等待下一毫秒
                while (currentTime <= lastTimestamp) {
                    currentTime = System.currentTimeMillis();
                }
                lastTimestamp = currentTime;
                sequence.set(1);
                seq = 1;
            }
        } else {
            // 新的毫秒，序列号重置为1
            lastTimestamp = currentTime;
            sequence.set(1);
            seq = 1;
        }

        // 使用同一个 currentTime 来格式化，不要重新获取时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
        String timestamp = sdf.format(new Date(currentTime));

        // 返回：前缀 + 时间戳 + 2位序号
        return String.format("%s%s%02d", prefix, timestamp, seq);
    }

    /**
     * 生成入库单号
     * 格式：RK + yyMMddHHmmssSSS + 序号(01-99)
     *
     * @return 入库单号
     */
    public static String generateBillcode() {
        return generateBillCodeWithSequence("RK");
    }

    /**
     * 生成出库单号
     * 格式：OUT + yyMMddHHmmssSSS + 序号(01-99)
     *
     * @return 出库单号
     */
    public static String generateOutBillcode() {
        return generateBillCodeWithSequence("OUT");
    }

    /**
     * 生成盘存单号
     * 格式：PC + yyMMddHHmmssSSS + 序号(01-99)
     *
     * @return 盘存单号
     */
    public static String generateInventoryBatchId() {
        return generateBillCodeWithSequence("PC");
    }

    /**
     * 生成报损单号
     * 格式：Lost + yyMMddHHmmssSSS + 序号(01-99)
     *
     * @return 报损单号
     */
    public static String generateLostBillcode() {
        return generateBillCodeWithSequence("Lost");
    }

    /**
     * 生成调价单号
     * 格式：Price + yyMMddHHmmssSSS + 序号(01-99)
     *
     * @return 调价单号
     */
    public static String generatePriceBillcode() {
        return generateBillCodeWithSequence("Price");
    }

    /**
     * 生成退回单号
     * 格式：Back + yyMMddHHmmssSSS + 序号(01-99)
     *
     * @return 退回单号
     */
    public static String generateBackBillcode() {
        return generateBillCodeWithSequence("Back");
    }

    /**
     * 生成协定处方单单号
     * 格式：PreAdvice + yyMMddHHmmssSSS + 序号(01-99)
     *
     * @return 协定处方单单号
     */
    public static String generateAgreementNo() {
        return generateBillCodeWithSequence("PreAdvice");
    }
    public static String test() {
        long currentTime = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String format = sdf.format(currentTime);
        return "test"+format;
    }

    /**
     * 判断字符串是否包含中文字符
     *
     * @param str 待检测的字符串
     * @return 如果包含中文字符返回true，否则返回false
     */
    public static boolean isChinese(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        // 使用与项目中其他地方一致的正则表达式
        return str.matches(".*[\\u4e00-\\u9fa5].*");
    }

}
