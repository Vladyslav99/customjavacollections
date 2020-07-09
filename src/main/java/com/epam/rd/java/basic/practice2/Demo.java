package com.epam.rd.java.basic.practice2;

public class Demo {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        System.out.println("==========ArrayImpl==========");
        ArrayImpl.main(new String[]{});
        System.out.println("==========ArrayImpl==========" + "\n");

        System.out.println("==========ListImpl==========");
        ListImpl.main(new String[]{});
        System.out.println("==========ListImpl==========" + "\n");

        System.out.println("==========QueueImpl==========");
        QueueImpl.main(new String[]{});
        System.out.println("==========QueueImpl==========" + "\n");

        System.out.println("==========StackImpl==========");
        StackImpl.main(new String[]{});
        System.out.println("==========StackImpl==========" + "\n");
    }
}
