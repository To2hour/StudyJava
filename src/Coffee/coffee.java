package Coffee;


import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;

/**
 * @author TwoHour
 * @version 1.0
 * @描述:
 * @since 2025-10-26 20:28
 **/


interface coffee {
    public int getFee();
}
//基类咖啡
class simpleCoffee implements coffee {
    int fee;

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public int getFee() {
        return fee;
    }
}
//抽象的装饰者类，需要基类才能正常实例化
abstract class coffeeFix implements coffee {
    coffee c;

    coffeeFix(coffee newC) {
        this.c = newC;
    }
}

class AFix extends coffeeFix {

    AFix(coffee newC) {
        super(newC);
    }

    @Override
    public int getFee() {
        return super.c.getFee() + 5;
    }
}

class BFix extends coffeeFix {

    BFix(coffee newC) {
        super(newC);
    }

    @Override
    public int getFee() {
        return super.c.getFee() + 3;
    }

    public static void main(String[] args) {
        coffee simpleCoffee = new simpleCoffee();
        simpleCoffee = new AFix(simpleCoffee);
        System.out.println("simpleCoffee.getFee() = " + simpleCoffee.getFee());
        simpleCoffee = new AFix(simpleCoffee);
        System.out.println("simpleCoffee.getFee() = " + simpleCoffee.getFee());
        simpleCoffee = new AFix(simpleCoffee);
        System.out.println("simpleCoffee.getFee() = " + simpleCoffee.getFee());
        simpleCoffee = new BFix(simpleCoffee);
        System.out.println("simpleCoffee.getFee() = " + simpleCoffee.getFee());
    }
}


