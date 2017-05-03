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
public class Pajakmodul {

    UtilHandler u = new UtilHandler();
    ConnectionHandler ch = new ConnectionHandler();
    StringBuilder sb;
    StringBuilder message;

    public Pajakmodul() {
    }

    public StringBuilder getdata() {
        message = new StringBuilder();
        try {
            String sql = "SELECT noindex, indextable, kodepajak, namapajak, pajak_nilai, "
                    + "akunjual,akunbeli, lastupdate FROM pajak;";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            sb = u.jsonencodedb(res);
            pre.close();
            ch.close();
            message = sb;
        } catch (Exception ex) {
            message.append(ex.getStackTrace().toString());
            Logger.getLogger(Pajakmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder getdatadetail(String field, String key) {
        message = new StringBuilder();
        try {
            String sql = "SELECT noindex, indextable, kodepajak, namapajak, pajak_nilai, "
                    + "akunjual,akunbeli, lastupdate FROM pajak "
                    + "WHERE " + field + "::character varying ILIKE ?";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, "%" + key + "%");
            ResultSet res = pre.executeQuery();
            sb = u.jsonencodedb(res);
            pre.close();
            ch.close();
            message = sb;
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Pajakmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder insert(String noindex, String indextable, String kodepajak, String namapajak,
            String pajak_nilai, String akunjual,String akunbeli) {
        message = new StringBuilder();
        try {
            String sql = "INSERT INTO pajak(noindex, indextable, kodepajak, namapajak,"
                    + " pajak_nilai, akunjual,akunbeli, lastupdate) VALUES (?, ?, ?, ?, ?, ?, ?, now())";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, noindex);
            pre.setInt(2, Integer.parseInt(indextable));
            pre.setString(3, kodepajak);
            pre.setString(4, namapajak);
            pre.setDouble(5, Double.parseDouble(pajak_nilai));
            pre.setString(6, akunjual);
            pre.setString(7, akunbeli);
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Pajakmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder update(String noindex, String indextable, String kodepajak, String namapajak,
            String pajak_nilai, String akunjual,String akunbeli,String id) {
        message = new StringBuilder();
        try {
            String sql = "UPDATE pajak SET noindex=?, indextable=?, kodepajak=?, namapajak=?, pajak_nilai=?,akunjual=?, "
                    + "akunbeli=?, lastupdate=now() WHERE noindex=?;";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, noindex);
            pre.setInt(2, Integer.parseInt(indextable));
            pre.setString(3, kodepajak);
            pre.setString(4, namapajak);
            pre.setDouble(5, Double.parseDouble(pajak_nilai));
            pre.setString(6, akunjual);
            pre.setString(7, akunbeli);
            pre.setString(8, id);
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Pajakmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder delete(String id) {
        message = new StringBuilder();
        try {
            String sql = "DELETE FROM pajak WHERE noindex=?";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, id);
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Pajakmodul.class.getName()).log(Level.SEVERE, null, ex);
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
                sbquery.append("INSERT INTO pajak (" + subentity[0] + ") VALUES(" + subentity[1] + ");");
            }
            PreparedStatement pre = ch.connect().prepareStatement(sbquery.toString());
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Pajakmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

}
