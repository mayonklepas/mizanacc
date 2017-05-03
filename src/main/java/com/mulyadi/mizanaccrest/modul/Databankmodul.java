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
public class Databankmodul {

    UtilHandler u = new UtilHandler();
    ConnectionHandler ch = new ConnectionHandler();
    StringBuilder sb;
    StringBuilder message;

    public Databankmodul() {
    }

    public StringBuilder getdata() {
        message = new StringBuilder();
        try {
            String sql = "SELECT noindex, indextable, acc_code, nomor_rekening_bank,"
                    + " atas_nama_rekening,kantor_cabang, alamat, telp, fax, kodepos, "
                    + "contactperson, keterangan FROM databank;";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            sb = u.jsonencodedb(res);
            pre.close();
            ch.close();
            message = sb;
        } catch (Exception ex) {
            message.append(ex.getStackTrace().toString());
            Logger.getLogger(Databankmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder getdatadetail(String field, String key) {
        message = new StringBuilder();
        try {
            String sql = "SSELECT noindex, indextable, acc_code, nomor_rekening_bank, "
                    + "atas_nama_rekening,kantor_cabang, alamat, telp, fax, kodepos, "
                    + "contactperson, keterangan FROM databank; " + field + "::character varying ILIKE ?";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, "%" + key + "%");
            ResultSet res = pre.executeQuery();
            sb = u.jsonencodedb(res);
            pre.close();
            ch.close();
            message = sb;
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Databankmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder insert(String noindex, String acc_code, String nomor_rekening_bank,
                     String atas_nama_rekening,String kantor_cabang, String alamat, String telp,
                     String fax, String kodepos,String contactperson, String keterangan) {
        message = new StringBuilder();
        try {
            String sql = "INSERT INTO databank(noindex, acc_code, nomor_rekening_bank,"
                    + " atas_nama_rekening,kantor_cabang, alamat, telp, fax, kodepos, "
                    + "contactperson, keterangan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, noindex);
            pre.setString(2, acc_code);
            pre.setString(3, nomor_rekening_bank);
            pre.setString(4, atas_nama_rekening);
            pre.setString(5, kantor_cabang);
            pre.setString(6, alamat);
            pre.setString(7, telp);
            pre.setString(8, fax);
            pre.setString(9, kodepos);
            pre.setString(10, contactperson);
            pre.setString(11, keterangan);
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Databankmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder update(String noindex, String acc_code, String nomor_rekening_bank,
                     String atas_nama_rekening,String kantor_cabang, String alamat, String telp,
                     String fax, String kodepos,String contactperson, String keterangan,String id) {
        message = new StringBuilder();
        try {
            String sql = "UPDATE databank SET noindex=?, indextable=?, acc_code=?, nomor_rekening_bank=?, "
                    + "atas_nama_rekening=?,kantor_cabang=?, alamat=?, telp=?, fax=?, kodepos=?, contactperson=?, "
                    + "keterangan=? WHERE noindex=?;";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, noindex);
            pre.setString(2, acc_code);
            pre.setString(3, nomor_rekening_bank);
            pre.setString(4, atas_nama_rekening);
            pre.setString(5, kantor_cabang);
            pre.setString(6, alamat);
            pre.setString(7, telp);
            pre.setString(8, fax);
            pre.setString(9, kodepos);
            pre.setString(10, contactperson);
            pre.setString(11, keterangan);
            pre.setString(12, id);
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Databankmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder delete(String id) {
        message = new StringBuilder();
        try {
            String sql = "DELETE FROM databank WHERE noindex=?";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, id);
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Databankmodul.class.getName()).log(Level.SEVERE, null, ex);
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
                sbquery.append("INSERT INTO users (" + subentity[0] + ") VALUES(" + subentity[1] + ");");
            }
            PreparedStatement pre = ch.connect().prepareStatement(sbquery.toString());
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Databankmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

}
