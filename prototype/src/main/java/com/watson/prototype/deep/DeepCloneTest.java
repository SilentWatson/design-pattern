package com.watson.prototype.deep;

public class DeepCloneTest {
    public static void main(String[] args) {
        QiTianDaSheng prototype = new QiTianDaSheng();
        QiTianDaSheng copy = null;
        try {
            copy = (QiTianDaSheng)prototype.clone();
            System.out.println(copy.jinGuBang==prototype.jinGuBang);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
