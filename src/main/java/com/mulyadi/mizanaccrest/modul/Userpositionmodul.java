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
public class Userpositionmodul {

    UtilHandler u = new UtilHandler();
    ConnectionHandler ch = new ConnectionHandler();
    StringBuilder sb;
    StringBuilder message;

    public Userpositionmodul() {
    }

    public StringBuilder getdata() {
        message = new StringBuilder();
        try {
            String sql = "SELECT noindex, indextable, nama, keterangan, hak_datamaster,"
                    + " hak_sistem, hak_penjualan, hak_pembelian, hak_persediaan, "
                    + "hak_perbankan, hak_akuntansi, hak_laporan FROM users_position;";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            sb = u.jsonencodedb(res);
            pre.close();
            ch.close();
            message = sb;
        } catch (Exception ex) {
            message.append(ex.getStackTrace().toString());
            Logger.getLogger(Userpositionmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder getdatadetail(String field, String key) {
        message = new StringBuilder();
        try {
            String sql = "SELECT noindex, nama, keterangan, hak_datamaster, "
                    + "hak_sistem, hak_penjualan, hak_pembelian, hak_persediaan, "
                    + "hak_perbankan, hak_akuntansi, hak_laporan FROM users_position "
                    + " WHERE " + field + "::character varying ILIKE ?";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, "%" + key + "%");
            ResultSet res = pre.executeQuery();
            sb = u.jsonencodedb(res);
            pre.close();
            ch.close();
            message = sb;
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Userpositionmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder insert(String noindex, String nama, String keterangan, String hak_datamaster,
            String hak_sistem, String hak_penjualan, String hak_pembelian, String hak_persediaan,
            String hak_perbankan, String hak_akuntansi, String hak_laporan) {
        message = new StringBuilder();
        try {
            String sql = "INSERT INTO users_position(noindex,nama, keterangan, "
                    + "hak_datamaster, hak_sistem, hak_penjualan, hak_pembelian, "
                    + "hak_persediaan, hak_perbankan, hak_akuntansi, hak_laporan) "
                    + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, noindex);
            pre.setString(2, nama);
            pre.setString(3, keterangan);
            pre.setInt(4, Integer.parseInt(hak_datamaster));
            pre.setInt(5, Integer.parseInt(hak_sistem));
            pre.setInt(6, Integer.parseInt(hak_penjualan));
            pre.setInt(7, Integer.parseInt(hak_pembelian));
            pre.setInt(8, Integer.parseInt(hak_persediaan));
            pre.setInt(9, Integer.parseInt(hak_perbankan));
            pre.setInt(10, Integer.parseInt(hak_akuntansi));
            pre.setInt(11, Integer.parseInt(hak_laporan));
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Userpositionmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder update(String noindex, String nama, String keterangan, String hak_datamaster,
            String hak_sistem, String hak_penjualan, String hak_pembelian, String hak_persediaan,
            String hak_perbankan, String hak_akuntansi, String hak_laporan, String id) {
        message = new StringBuilder();
        try {
            String sql = "UPDATE users_position SET noindex=?, nama=?, keterangan=?, "
                    + "hak_datamaster=?,hak_sistem=?, hak_penjualan=?, hak_pembelian=?, "
                    + "hak_persediaan=?,hak_perbankan=?, hak_akuntansi=?, hak_laporan=? WHERE noindex=?";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
             pre.setString(1, noindex);
            pre.setString(2, nama);
            pre.setString(3, keterangan);
            pre.setInt(4, Integer.parseInt(hak_datamaster));
            pre.setInt(5, Integer.parseInt(hak_sistem));
            pre.setInt(6, Integer.parseInt(hak_penjualan));
            pre.setInt(7, Integer.parseInt(hak_pembelian));
            pre.setInt(8, Integer.parseInt(hak_persediaan));
            pre.setInt(9, Integer.parseInt(hak_perbankan));
            pre.setInt(10, Integer.parseInt(hak_akuntansi));
            pre.setInt(11, Integer.parseInt(hak_laporan));
            pre.setInt(12, Integer.parseInt(id));
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Userpositionmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder delete(String id) {
        message = new StringBuilder();
        try {
            String sql = "DELETE FROM users_position WHERE noindex=?";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setInt(1, Integer.parseInt(id));
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Userpositionmodul.class.getName()).log(Level.SEVERE, null, ex);
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
                sbquery.append("INSERT INTO users_position (" + subentity[0] + ") VALUES(" + subentity[1] + ");");
            }
            PreparedStatement pre = ch.connect().prepareStatement(sbquery.toString());
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Userpositionmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

}
