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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Accmodul {

    UtilHandler u = new UtilHandler();
    ConnectionHandler ch = new ConnectionHandler();
    StringBuilder sb;
    StringBuilder message;

    public Accmodul() {
    }

    public StringBuilder getdata() {
        message = new StringBuilder();
        try {
            String sql = "SELECT acc_code,acc_name,acc_class_id,isparent,parentacc,"
                    + "firstparentacc,isactive,acclevel,saldoawal,currencyid,deptid,iskasbank,lastupdate"
                    + " FROM acc ORDER BY acc_code";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            sb = u.jsonencodedb(res);
            pre.close();
            ch.close();
            message = sb;
        } catch (Exception ex) {
            message.append(ex.getStackTrace().toString());
            Logger.getLogger(Accmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder getdatadetail(String field, String key) {
        message = new StringBuilder();
        try {
            String sql = "SELECT acc_code,acc_name,acc_class_id,isparent,parentacc,"
                    + "firstparentacc,isactive,acclevel,saldoawal,currencyid,deptid,iskasbank,lastupdate "
                    + "FROM acc WHERE " + field + " ILIKE ? ";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, "%" + key + "%");
            ResultSet res = pre.executeQuery();
            sb = u.jsonencodedb(res);
            pre.close();
            ch.close();
            message = sb;
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Accmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder insert(String acc_code, String acc_name, String acc_class_id,
            String isparent, String parentacc, String firstparentacc, String isactive, String acclevel,
            String saldoawal, String currencyid, String deptid, String iskasbank) {
        message = new StringBuilder();
        try {
            String sql = "INSERT INTO acc(acc_code, acc_name, acc_class_id, isparent, parentacc, firstparentacc,"
                    + "isactive, acclevel, saldoawal, currencyid, deptid, iskasbank) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, acc_code);
            pre.setString(2, acc_name);
            pre.setInt(3, Integer.parseInt(acc_class_id));
            pre.setInt(4, Integer.parseInt(isparent));
            pre.setString(5, parentacc);
            pre.setInt(6, Integer.parseInt(firstparentacc));
            pre.setInt(7, Integer.parseInt(isactive));
            pre.setInt(8, Integer.parseInt(acclevel));
            pre.setDouble(9, Double.parseDouble(saldoawal));
            pre.setString(10, currencyid);
            pre.setInt(11, Integer.parseInt(deptid));
            pre.setInt(12, Integer.parseInt(iskasbank));
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Accmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder update(String acc_code, String acc_name, String acc_class_id,
            String isparent, String parentacc, String firstparentacc, String isactive, String acclevel,
            String saldoawal, String currencyid, String deptid, String iskasbank, String id) {
        message = new StringBuilder();
        try {
            String sql = "UPDATE acc"
                    + "SET acc_code=?, acc_name=?, acc_class_id=?, isparent=?, parentacc=?,"
                    + "firstparentacc=?, isactive=?, acclevel=?, saldoawal=?, currencyid=?,"
                    + "deptid=?, iskasbank=?, lastupdate=? "
                    + " WHERE acc_code=?;";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, acc_code);
            pre.setString(2, acc_name);
            pre.setInt(3, Integer.parseInt(acc_class_id));
            pre.setInt(4, Integer.parseInt(isparent));
            pre.setString(5, parentacc);
            pre.setInt(6, Integer.parseInt(firstparentacc));
            pre.setInt(7, Integer.parseInt(isactive));
            pre.setInt(8, Integer.parseInt(acclevel));
            pre.setDouble(9, Double.parseDouble(saldoawal));
            pre.setString(10, currencyid);
            pre.setInt(11, Integer.parseInt(deptid));
            pre.setInt(12, Integer.parseInt(iskasbank));
            pre.setString(13, id);
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Accmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder delete(String id) {
        message = new StringBuilder();
        try {
            String sql = "DELETE FROM acc WHERE acc_code=?";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, id);
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Accmodul.class.getName()).log(Level.SEVERE, null, ex);
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
                sbquery.append("INSERT INTO acc (" + subentity[0] + ") VALUES(" + subentity[1] + ");");
            }
            PreparedStatement pre = ch.connect().prepareStatement(sbquery.toString());
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Accmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

}
