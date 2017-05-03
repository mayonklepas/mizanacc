/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mulyadi.mizanaccrest.modul;

import com.mulyadi.mizanaccrest.helper.ConnectionHandler;
import com.mulyadi.mizanaccrest.helper.UtilHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Setupprogrammodul {

    UtilHandler u = new UtilHandler();
    ConnectionHandler ch = new ConnectionHandler();
    StringBuilder sb;
    StringBuilder message;

    public Setupprogrammodul() {
    }

    public StringBuilder getdata() {
        message = new StringBuilder();
        try {
            String sql = "SELECT noindex, indextable, keterangan, boolvalue, strvalue, intvalue,currvalue,"
                    + " datevalue, lastupdate FROM setupprogram";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            sb = u.jsonencodedb(res);
            pre.close();
            ch.close();
            message = sb;
        } catch (Exception ex) {
            message.append(ex.getStackTrace().toString());
            Logger.getLogger(Setupprogrammodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder getdatadetail(String field, String key) {
        message = new StringBuilder();
        try {
            String sql = "SELECT noindex, indextable, keterangan, boolvalue, strvalue, intvalue,currvalue,"
                    + " datevalue, lastupdate FROM setupprogram WHERE " + field + "::character varying ILIKE ?";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, "%" + key + "%");
            ResultSet res = pre.executeQuery();
            sb = u.jsonencodedb(res);
            pre.close();
            ch.close();
            message = sb;
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Setupprogrammodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder insert(String noindex, String indextable, String keterangan, String boolvalue, String strvalue,
            String intvalue, String currvalue, String datevalue) {
        message = new StringBuilder();
        try {
            String sql = "INSERT INTO setupprogram(noindex, indextable, keterangan, boolvalue,"
                    + " strvalue, intvalue, currvalue, datevalue, lastupdate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, now())";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            boolean tf = true;
            if (boolvalue == "t") {
                tf = true;
            } else {
                tf = false;
            }
            java.util.Date dt = new SimpleDateFormat("MM/dd/yyyy").parse(datevalue);
            java.sql.Date sqldate = new java.sql.Date(dt.getTime());
            pre.setString(1, noindex);
            pre.setInt(2, Integer.parseInt(indextable));
            pre.setString(3, keterangan);
            pre.setBoolean(4, tf);
            pre.setString(5, strvalue);
            pre.setInt(6, Integer.parseInt(intvalue));
            pre.setDouble(7, Double.parseDouble(currvalue));
            pre.setDate(8, sqldate);
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Setupprogrammodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder update(String noindex, String indextable, String keterangan, String boolvalue, String strvalue,
            String intvalue, String currvalue, String datevalue, String id) {
        message = new StringBuilder();
        try {
            String sql = "UPDATE setupprogram SET noindex=?, indextable=?, keterangan=?, boolvalue=?, strvalue=?,intvalue=?,"
                    + " currvalue=?, datevalue=?, lastupdate=? WHERE noindex=?";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            boolean tf = true;
            if (boolvalue == "t") {
                tf = true;
            } else {
                tf = false;
            }
            java.util.Date dt = new SimpleDateFormat("MM/dd/yyyy").parse(datevalue);
            java.sql.Date sqldate = new java.sql.Date(dt.getTime());
            pre.setString(1, noindex);
            pre.setInt(2, Integer.parseInt(indextable));
            pre.setString(3, keterangan);
            pre.setBoolean(4, tf);
            pre.setString(5, strvalue);
            pre.setInt(6, Integer.parseInt(intvalue));
            pre.setDouble(7, Double.parseDouble(currvalue));
            pre.setDate(8, sqldate);
            pre.setString(9, id);
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Setupprogrammodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder delete(String id) {
        message = new StringBuilder();
        try {
            String sql = "DELETE FROM setupprogram WHERE noindex=?";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, id);
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Setupprogrammodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder insertbatch(String data) {
        message = new StringBuilder();
        try {
            String[] entity = data.split("$$$");
            StringBuilder sbquery = new StringBuilder();
            for (int i = 0; i < entity.length; i++) {
                String[] subentity = entity[i].split("$___");
                sbquery.append("INSERT INTO setupprogram (" + subentity[0] + ") VALUES(" + subentity[1] + ");");
            }
            PreparedStatement pre = ch.connect().prepareStatement(sbquery.toString());
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Setupprogrammodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

}
