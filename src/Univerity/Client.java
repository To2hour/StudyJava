package Univerity;

import java.util.ArrayList;
import java.util.List;
/**
 * @author TwoHour
 * @version 1.0
 * @描述: 组合模式
 * @since 2025-10-26 20:28
 **/
public class Client {
    public static void main(String[] args) {
        University university = new University("清华大学", "中国顶尖大学");

        College computerCollege = new College("计算机学院", "计算机学院");
        College infoCollege = new College("信息工程学院", "信息工程学院");

        Depart softwareDepart = new Depart("软件工程", "软件工程专业");
        Depart networkDepart = new Depart("网络工程", "网络工程专业");
        Depart communicationDepart = new Depart("通信工程", "通信工程专业");
        Depart infoDepart = new Depart("信息工程", "信息工程专业");

        computerCollege.add(softwareDepart);
        computerCollege.add(networkDepart);

        infoCollege.add(communicationDepart);
        infoCollege.add(infoDepart);

        university.add(computerCollege);
        university.add(infoCollege);

        university.print();
    }
}

// 抽象组件
abstract class Compoent {
    protected List<Compoent> childList = new ArrayList<>();
    protected String name;
    protected String desc;

    public Compoent(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public void add(Compoent compoent) {
        throw new UnsupportedOperationException();
    }

    public void delete(Compoent compoent) {
        throw new UnsupportedOperationException();
    }

    protected abstract void print();

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}

// 组合节点
class College extends Compoent {
    public College(String name, String desc) {
        super(name, desc);
    }

    @Override
    public void add(Compoent c) {
        childList.add(c);
    }

    @Override
    public void delete(Compoent c) {
        childList.remove(c);
    }

    @Override
    protected void print() {
        System.out.println("学院名称：" + this.getName());
        for (Compoent c : childList) {
            c.print();
        }
    }
}

// 叶子节点
class Depart extends Compoent {
    public Depart(String name, String desc) {
        super(name, desc);
    }

    @Override
    protected void print() {
        System.out.println("专业名称：" + this.getName());
    }
}

// 根节点（顶级组合）
class University extends Compoent {
    public University(String name, String desc) {
        super(name, desc);
    }

    @Override
    public void add(Compoent c) {
        childList.add(c);
    }

    @Override
    public void delete(Compoent c) {
        childList.remove(c);
    }

    @Override
    protected void print() {
        System.out.println("--------" + this.getName() + "--------");
        for (Compoent c : childList) {
            c.print();
        }
    }
}
