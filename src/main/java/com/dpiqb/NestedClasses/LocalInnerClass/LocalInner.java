package com.dpiqb.NestedClasses.LocalInnerClass;

public class LocalInner {
    public static void main(String[] args) {
        Math math = new Math();
        math.getResult();
    }
}
class Math{
    public void getResult(){
        class Division{
            private int div1;
            private int div2;

            public Division(int div1, int div2) {
                this.div1 = div1;
                this.div2 = div2;
            }

            public int getDiv1() {
                return div1;
            }

            public void setDiv1(int div1) {
                this.div1 = div1;
            }

            public int getDiv2() {
                return div2;
            }

            public void setDiv2(int div2) {
                this.div2 = div2;
            }
            public int action(){
                return div1 / div2;
            }
            public int mod(){
                return div1 % div2;
            }
        }
        Division division = new Division(17, 2);
        System.out.println("division.action() = " + division.action());
        System.out.println("division.mod() = " + division.mod());
    }
}
