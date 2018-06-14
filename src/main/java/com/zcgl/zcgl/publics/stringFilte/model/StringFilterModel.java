package com.zcgl.zcgl.publics.stringFilte.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StringFilterModel implements Serializable {

    private String uuid;
    //    需要替换的词
    @NotBlank(message = "需要替换的词不能为空")
    @Size(max = 100, message = "需要替换的词最大长度为100位")
    private String yv;
    //    替换后的词
    @NotBlank(message = "替换后的词不能为空")
    @Size(max = 100, message = "替换后的词最大长度为100位")
    private String tv;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getYv() {
        return yv;
    }

    public void setYv(String yv) {
        this.yv = yv;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public StringFilterModel() {
        super();
    }

    public StringFilterModel(String uuid, String yv, String tv) {
        this.uuid = uuid;
        this.yv = yv;
        this.tv = tv;
    }

    @Override
    public String toString() {
        return "StringFilterModel{" +
                "uuid='" + uuid + '\'' +
                ", yv='" + yv + '\'' +
                ", tv='" + tv + '\'' +
                '}';
    }
}
