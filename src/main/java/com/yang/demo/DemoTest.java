package com.yang.demo;

public class DemoTest {

    public static String strReverseWithRecursive(String string){
        String[] a = string.split(" ");
        StringBuffer stringBuffer1 = new StringBuffer();
        for (int i=0;i<a.length;i++){
            StringBuffer stringBuffer = new StringBuffer();
            char[] s1 = a[i].toCharArray();
            for (int y=s1.length-1;y != -1;y--){
                stringBuffer.append(s1[y]);
            }
            stringBuffer1.append(stringBuffer.toString()+" ");
        }
        return stringBuffer1.toString();
    }

    public static void main(String[] args) {
        String aa = strReverseWithRecursive("Software and Services for Shipbrokers");
                System.out.println(aa);
    }

    public static String strstring(){
        int[] a1 = {1,2,34,5,6,7,12,5,9};
        int s1 = 1;
        int s2 = a1.length-1;
        int s3 = (s1+s2)/2;
        while (){

        }
        return null;
    }
}
