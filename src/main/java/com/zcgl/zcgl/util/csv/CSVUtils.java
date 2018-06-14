package com.zcgl.zcgl.util.csv;

import com.zcgl.zcgl.util.file.EncodingDetect;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class CSVUtils {

    public Map<Long, Map<String, String>> readCSV(String filePath) {
        Map<Long, Map<String, String>> map = new HashMap<>();
        try {
//            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            //获得文件编码
            String fileEncode = new EncodingDetect().getJavaEncode(filePath);
            InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), fileEncode);
            BufferedReader reader = new BufferedReader(isr);
//            reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            String line = null;
            String[] title = null;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                if (i == 0)
                    title = line.split(",");
                else {
                    Map<String, String> m = new HashMap<>();
                    String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                    for (int j = 0; j < title.length; j++) {
                        if (item.length > j)
                            m.put(title[j], item[j]);
                        else
                            m.put(title[j], "");
                    }
                    map.put(Long.parseLong(i + ""), m);
//                    String last = item[item.length - 1];//这就是你要的数据了
                    //int value = Integer.parseInt(last);//如果是数值，可以转化为数值
//                    System.out.println(last);
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        map.forEach((k,v)->{
//            System.out.println(k+":"+v);
//        });
        return map;
    }
}
