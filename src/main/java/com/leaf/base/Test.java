package com.leaf.base;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {

    public static boolean test() {
        ProcessBuilder pb = new ProcessBuilder("tasklist");
        try {
            Process p = pb.start();
            BufferedReader rb = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = rb.readLine()) != null) {
                if (line.indexOf("chrome.exe") != -1){
                    return true;
                }
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] arg){
        while (true){
            //如果没有此进程，则说明执行完毕，可返回信息了
            if (!test()){
                System.out.println("程序执行完毕！");
                return;
            }
        }
    }
}
