package com.zcgl.zcgl.util.file;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class EncodingDetect {

    /**
     * 得到文件的编码
     *
     * @param filePath 文件路径
     * @return 文件的编码
     */
    public String getJavaEncode(String filePath) {
        try {
            BufferedInputStream bin = new BufferedInputStream(
                    new FileInputStream(filePath));
            int p = (bin.read() << 8) + bin.read();
            String code = null;
            switch (p) {
                case 0xefbb:
                    code = "UTF-8";
                    break;
                case 0xfffe:
                    code = "Unicode";
                    break;
                case 0xfeff:
                    code = "UTF-16BE";
                    break;
                default:
                    code = "GBK";
            }

            return code;
        } catch (Exception e) {
            return "UTF-8";
        }
    }
}
