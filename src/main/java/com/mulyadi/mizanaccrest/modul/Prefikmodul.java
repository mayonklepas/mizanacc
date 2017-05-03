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
public class Prefikmodul {

    UtilHandler u = new UtilHandler();
    ConnectionHandler ch = new ConnectionHandler();
    StringBuilder sb;
    StringBuilder message;

    public Prefikmodul() {
    }

    public StringBuilder getdata() {
        message = new StringBuilder();
        try {
            String sql = "SELECT noindex, indextable, kode, nama, prefik_kode, keterangan_trans FROM prefik";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            sb = u.jsonencodedb(res);
            pre.close();
            ch.close();
            message = sb;
        } catch (Exception ex) {
            message.append(ex.getStackTrace().toString());
            Logger.getLogger(Prefikmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder getdatadetail(String field, String key) {
        message = new StringBuilder();
        try {
            String sql = "SELECT noindex, indextable, kode, nama, prefik_kode, keterangan_trans FROM prefik "
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
            Logger.getLogger(Prefikmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder insert(String noindex, String indextable, String kode, String nama,
            String prefik_kode, String keterangan_trans) {
        message = new StringBuilder();
        try {
            String sql = "INSERT INTO prefik(noindex, indextable, kode, nama, prefik_kode, keterangan_trans) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, noindex);
            pre.setInt(2, Integer.parseInt(indextable));
            pre.setString(3, kode);
            pre.setString(4, nama);
            pre.setString(5, prefik_kode);
            pre.setString(6, keterangan_trans);
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Prefikmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder update(String noindex, String indextable, String kode, String nama,
            String prefik_kode, String keterangan_trans, String id) {
        message = new StringBuilder();
        try {
            String sql = "UPDATE prefik SET noindex=?, indextable=?, kode=?, nama=?, prefik_kode=?, "
                    + "keterangan_trans=? WHERE noindex=?;";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, noindex);
            pre.setInt(2, Integer.parseInt(indextable));
            pre.setString(3, kode);
            pre.setString(4, nama);
            pre.setString(5, prefik_kode);
            pre.setString(6, keterangan_trans);
            pre.setString(7, id);
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Prefikmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder delete(String id) {
        message = new StringBuilder();
        try {
            String sql = "DELETE FROM prefik WHERE noindex=?";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, id);
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Prefikmodul.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Prefikmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

}
