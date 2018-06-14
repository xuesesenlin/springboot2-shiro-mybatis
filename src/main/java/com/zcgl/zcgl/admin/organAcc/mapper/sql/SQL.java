package com.zcgl.zcgl.admin.organAcc.mapper.sql;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class SQL {
//    public String insert1(Map<String, String> map) {
//        StringJoiner sq = new StringJoiner("");
//        String zqid = map.get("0");
//        map.forEach((k, v) -> {
//            if (!k.equals("0")) {
//                org.apache.ibatis.jdbc.SQL sql = new org.apache.ibatis.jdbc.SQL();
//                sql.INSERT_INTO("xxdbry_table");
//                sql.SET("uuid", "dbrq", "peoId", "zqId");
//                sql.VALUES("uuid", "'" + GetUuid.getUUID() + "'");
//                sql.VALUES("dbrq", "'" + k + "'");
//                sql.VALUES("peoId", "'" + v + "'");
//                sql.VALUES("zqId", "'" + zqid + "'");
//                sq.add(sql.toString() + ";");
//            }
//        });
//        return sq.toString();
//    }
//
//    public String insert2(Map<String, XxdbryModel> map) {
//        StringJoiner sq = new StringJoiner("");
//        map.forEach((k, v) -> {
//            org.apache.ibatis.jdbc.SQL sql = new org.apache.ibatis.jdbc.SQL();
//            sql.INSERT_INTO("xxdbry_table");
//            sql.SET("uuid", "dbrq", "peoId", "zqId");
//            sql.VALUES("uuid", "'" + GetUuid.getUUID() + "'");
//            sql.VALUES("dbrq", "'" + v.getDbrq() + "'");
//            sql.VALUES("peoId", "'" + v.getPeoId() + "'");
//            sql.VALUES("zqId", "'" + v.getZqId() + "'");
//            sq.add(sql.toString() + ";");
//        });
//        return sq.toString();
//    }
//
//    public String select1(Map<String, String> map) {
//        StringJoiner sq = new StringJoiner("");
//        sq.add("select x.peoId,x.dbrq from xxdbry_table x where x.dbrq in (" + map.get("0") + ") ORDER BY DATE_FORMAT(x.dbrq,'%Y-%c-%e')");
//        return sq.toString();
//    }
}
