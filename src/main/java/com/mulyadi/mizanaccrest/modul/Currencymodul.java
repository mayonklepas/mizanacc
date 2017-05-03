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
public class Currencymodul {

    UtilHandler u = new UtilHandler();
    ConnectionHandler ch = new ConnectionHandler();
    StringBuilder sb;
    StringBuilder message;

    public Currencymodul() {
    }

    public StringBuilder getdata() {
        message = new StringBuilder();
        try {
            String sql = "SELECT noindex, currency_code, currency_name, currency_rate, currency_symbol,country_name, deptid,"
                    + " lastupdate, indextable FROM currency";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            sb = u.jsonencodedb(res);
            pre.close();
            ch.close();
            message = sb;
        } catch (Exception ex) {
            message.append(ex.getStackTrace().toString());
            Logger.getLogger(Currencymodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder getdatadetail(String field, String key) {
        message = new StringBuilder();
        try {
            String sql = "SELECT noindex, currency_code, currency_name, currency_rate, currency_symbol,country_name, deptid,"
                    + " lastupdate, indextable FROM currency WHERE " + field + "::character varying ILIKE ?";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, "%" + key + "%");
            ResultSet res = pre.executeQuery();
            sb = u.jsonencodedb(res);
            pre.close();
            ch.close();
            message = sb;
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Currencymodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder insert(String noindex, String currency_code, String currency_name,
            String currency_rate, String currency_symbol, String country_name, String deptid) {
        message = new StringBuilder();
        try {
            String sql = "INSERT INTO public.currency(noindex, currency_code, currency_name, currency_rate, currency_symbol, "
                    + "country_name, deptid, lastupdate)VALUES (?, ?, ?, ?, ?, ?, ?,now());";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, noindex);
            pre.setString(2, currency_code);
            pre.setString(3, currency_name);
            pre.setDouble(4, Double.parseDouble(currency_rate));
            pre.setString(5, currency_symbol);
            pre.setString(6, currency_name);
            pre.setInt(7, Integer.parseInt(deptid));
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Currencymodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder update(String noindex, String currency_code, String currency_name,
            String currency_rate, String currency_symbol, String country_name, String deptid, String id) {
        message = new StringBuilder();
        try {
            String sql = "UPDATE currency SET noindex=?, currency_code=?, currency_name=?, "
                    + "currency_rate=?,currency_symbol=?, country_name=?, deptid=?,"
                    + " lastupdate=now() WHERE noindex=?";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, noindex);
            pre.setString(2, currency_code);
            pre.setString(3, currency_name);
            pre.setDouble(4, Double.parseDouble(currency_rate));
            pre.setString(5, currency_symbol);
            pre.setString(6, currency_name);
            pre.setInt(7, Integer.parseInt(deptid));
            pre.setString(8, id);
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Currencymodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder delete(String id) {
        message = new StringBuilder();
        try {
            String sql = "DELETE FROM currency WHERE noindex=?";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, id);
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Currencymodul.class.getName()).log(Level.SEVERE, null, ex);
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
                sbquery.append("INSERT INTO currency (" + subentity[0] + ") VALUES(" + subentity[1] + ");");
            }
            PreparedStatement pre = ch.connect().prepareStatement(sbquery.toString());
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Currencymodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

}
