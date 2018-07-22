package com.pulsar.utils;

import java.io.*;

public class FileUtil {
    public static void main(String []args) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        try{
        BufferedReader br = new BufferedReader(new FileReader("c://Users//admin//cc.txt"));
        String s = null;
        int count=0;
        while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            if(count%5==0){
                if(count==0){

                result.append("insert into tt(en_name,fr,ap,ap3,code) values('"+s+"'");
                }else{ result.append(");\n");
                result.append("insert into tt(en_name,fr,ap,ap3,code) values('"+s+"'");
                }
            }
            else{

                    result.append(",'"+s+"'");

            }
            count++;
        }
        br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
            System.out.print(result.toString()+");");
        }
}
