package com.zcgl.zcgl.util.bootPath;

import org.springframework.util.ResourceUtils;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class BootPathUtils {

    public String path() {
        try {
            String path = ResourceUtils.getURL("classpath:").getPath();
            System.out.println(path);
            return path;
        } catch (Exception e) {
            return "";
        }
    }
}
