package com.huju.test01.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by huju on 2018/9/16.
 */
public class KpiIndexDomain implements Serializable{

/*    id                 bigint(20)     (NULL)           NO      PRI     (NULL)           select,insert,update,references  指标ID
    default_flag       char(1)        utf8_general_ci  YES             (NULL)           select,insert,update,references  是否存在默认值  Y/N
    default_val        varchar(200)   utf8_general_ci  YES             (NULL)           select,insert,update,references  默认值
    format_flag        char(1)        utf8_general_ci  YES             (NULL)           select,insert,update,references  是否自定义数据格式  Y/N
    format_val         varchar(50)    utf8_general_ci  YES             (NULL)           select,insert,update,references
    lookup_code        varchar(30)    utf8_general_ci  YES             (NULL)           select,insert,update,references  查找集CODE
    sql_desc           text           utf8_general_ci  YES             (NULL)           select,insert,update,references  sql
    script_desc        text           utf8_general_ci  YES             (NULL)           select,insert,update,references  script脚本
    expression         varchar(4000)  utf8_general_ci  YES             (NULL)           select,insert,update,references  公式
    remarks            varchar(1000)  utf8_general_ci  YES             (NULL)           select,insert,update,references  备注
    attribute1         varchar(150)   utf8_general_ci  YES             (NULL)           select,insert,update,references  扩展字段1
    attribute2         varchar(150)   utf8_general_ci  YES             (NULL)           select,insert,update,references  扩展字段2
    attribute3         varchar(150)   utf8_general_ci  YES             (NULL)           select,insert,update,references  扩展字段3
    attribute4         varchar(150)   utf8_general_ci  YES             (NULL)           select,insert,update,references  扩展字段4
    attribute5         varchar(150)   utf8_general_ci  YES             (NULL)           select,insert,update,references  扩展字段5
    created_by         varchar(45)    utf8_general_ci  YES             (NULL)           select,insert,update,references  创建人
    creation_date      datetime       (NULL)           YES             (NULL)           select,insert,update,references  创建时间
    last_updated_by    varchar(45)    utf8_general_ci  YES             (NULL)           select,insert,update,references  更新人
    last_update_date   datetime       (NULL)           YES             (NULL)           select,insert,update,references  更新时间
    calc_time          varchar(20)    utf8_general_ci  YES             (NULL)           select,insert,update,references  指标计算

    时间
    icon               varchar(50)    utf8_general_ci  YES             (NULL)           select,insert,update,references
    index_rule         varchar(20)    utf8_general_ci  YES             (NULL)           select,insert,update,references  运算规则*/


    private long id;
    private String statusCode;
    private String code;
    private String name;
    private String indexType;
    private String dataType;
    private String createdBy;
    private Date creationDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndexType() {
        return indexType;
    }

    public void setIndexType(String indexType) {
        this.indexType = indexType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "KpiIndexDomain{" +
                "id=" + id +
                ", statusCode='" + statusCode + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", indexType='" + indexType + '\'' +
                ", dataType='" + dataType + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
