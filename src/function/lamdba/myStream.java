package function.lamdba;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

/**
 * @author TwoHour
 * @version 1.0
 * @描述: todo
 * @since 2025-12-01 15:17
 **/
public class myStream<T> {
    Collection<T> list;

    public myStream(Collection<T> list) {
        this.list = list;
    }

    public static void main(String[] args) {

        Stream<Stu> stuStream = Stream.of(
                new Stu(1, "tom"),
                new Stu(2, "lily"),
                new Stu(3, "jack"),
                new Stu(4, "anna"),
                new Stu(5, "mike"),
                new Stu(6, "sara"),
                new Stu(7, "james"),
                new Stu(8, "emma"),
                new Stu(9, "david"),
                new Stu(10, "olivia"),
                new Stu(11, "noah"),
                new Stu(12, "ava"),
                new Stu(13, "liam"),
                new Stu(13, "mia"),
                new Stu(15, "ethan"),
                new Stu(16, "chloe"),
                new Stu(11, "ethan"),
                new Stu(18, "zoey"),
                new Stu(19, "logan"),
                new Stu(20, "ella")
        );
        Map<Integer, Set<Stu>> collect = stuStream.parallel().collect(Collectors.groupingBy(a -> a.getName().length(), toSet()));
        stuStream.reduce(new Stu(), (a, b) -> (a));
        for (Map.Entry<Integer, Set<Stu>> integerListEntry : collect.entrySet()) {
            integerListEntry.getValue().stream().forEach(System.out::print);
            System.out.println();
        }
//        Stream<String> stream = Stream.of("1", "2", "3", "4");
////        HashMap<Object, Object> collect = stream.map(Integer::valueOf).collect(HashMap::new, (a, b) -> a.put(b, 1), (a, b) -> {
////        });
//        Map<Integer, Integer> collect = stream.collect(Collectors.toMap(Integer::valueOf, a -> 1));
//        for (Map.Entry<Integer, Integer> entry : collect.entrySet()) {
//            System.out.println("entry = " + entry);
//        }


//        stream.map(Integer::valueOf).collect(phoneA::new, (a, b) -> a.setFee(b), (a1, a2) -> {
//        });
    }

    public static <T> myStream<T> of(Collection<T> list) {
        return new myStream<>(list);
    }

    public myStream<T> filter(Predicate<T> pre) {
        Collection<T> newList = new ArrayList<>();
        for (T t : list) {
            if (pre.test(t)) {
                newList.add(t);
            }
        }
        this.list = newList;
        return this;
    }


    public <R> myStream<R> map(Function<T, R> func) {
        List<R> newList = new ArrayList<>();
        for (T t : list) {
            newList.add(func.apply(t));
        }
        return new myStream<>(newList);
    }

    public void foreach(Consumer<T> func) {
        for (T t : list) {
            func.accept(t);
        }
    }
}
