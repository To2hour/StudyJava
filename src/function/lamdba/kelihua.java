package function.lamdba;


import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author TwoHour
 * @version 1.0
 * @描述: todo
 * @since 2025-12-01 14:18
 **/
public class kelihua {
    public static void main(String[] args) {
        Fa a = a1 -> b -> a1 + b;
        Fb method = a.method(1);
        int method1 = method.method(2);
        int method2 = method.method(3);
        System.out.println("method1 = " + method1);
        System.out.println("method2 = " + method2);
        System.out.println("method = " + method);
    }
}

interface Fa {
    Fb method(int a);
}

interface Fb {
    int method(int b);

}

class TreeNode<T> {
    T value;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode() {
    }

    public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}

class Tree<T> {
    TreeNode<T> root;

    public void List(TreeNode<T> node, Consumer<TreeNode<T>> func,String type) {
        if (node == null) {
            return;
        }
        //前
        if(Objects.equals(type, "1")){
            func.accept(node);
            List(node.left, func,type);
            List(node.right, func,type);
        }
        //中
        if(Objects.equals(type, "2")){
            List(node.left, func,type);
            func.accept(node);
            List(node.right, func,type);
        }
        //后
        if(Objects.equals(type, "3")){
            List(node.left, func,type);
            List(node.right, func,type);
            func.accept(node);
        }

    }
}