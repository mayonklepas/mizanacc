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
public class Companymodul {

    UtilHandler u = new UtilHandler();
    ConnectionHandler ch = new ConnectionHandler();
    StringBuilder sb;
    StringBuilder message;

    public Companymodul() {
    }

    public StringBuilder getdata() {
        message = new StringBuilder();
        try {
            String sql = "SELECT noindex, company_name, create_data_year, create_data_month, "
                    + "periode_year, periode_month, periode_end_of_month, alamat1, alamat2, "
                    + "telp, fax, kota, zipcode, negara, jenisusaha, logo, currencyid, webpage, deptid FROM company";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            sb = u.jsonencodedb(res);
            pre.close();
            ch.close();
            message = sb;
        } catch (Exception ex) {
            message.append(ex.getStackTrace().toString());
            Logger.getLogger(Companymodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder getdatadetail(String field, String key) {
        message = new StringBuilder();
        try {
            String sql = "SELECT noindex, company_name, create_data_year, create_data_month,"
                    + " periode_year, periode_month, periode_end_of_month,"
                    + " alamat1, alamat2, telp, fax, kota, zipcode, negara,"
                    + " jenisusaha, logo, currencyid, webpage, deptid FROM company"
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
            Logger.getLogger(Companymodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder insert(String noindex,String company_name, String create_data_year, String create_data_month,
            String periode_year, String periode_month, String periode_end_of_month, String alamat1, String alamat2,
            String telp, String fax, String kota, String zipcode, String negara,
            String jenisusaha, String logo, String currencyid, String webpage,String deptid) {
        message = new StringBuilder();
        try {
            String sql = "INSERT INTO public.company(noindex, company_name, create_data_year, "
                    + "create_data_month, periode_year, periode_month, periode_end_of_month, "
                    + "alamat1, alamat2, telp, fax, kota, zipcode, negara, jenisusaha, logo, "
                    + "currencyid, webpage, deptid) VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setInt(1, Integer.parseInt(noindex));
            pre.setString(2, company_name);
            pre.setInt(3, Integer.parseInt(create_data_year));
            pre.setInt(4, Integer.parseInt(create_data_month));
            pre.setInt(5, Integer.parseInt(periode_year));
            pre.setInt(6, Integer.parseInt(periode_month));
            pre.setInt(7, Integer.parseInt(periode_end_of_month));
            pre.setString(8, alamat1);
            pre.setString(9, alamat2);
            pre.setString(10, telp);
            pre.setString(11, fax);
            pre.setString(12, kota);
            pre.setString(13, zipcode);
            pre.setString(14, negara);
            pre.setString(15, jenisusaha);
            pre.setString(16, logo);
            pre.setString(17, currencyid);
            pre.setString(18, webpage);
            pre.setInt(19, Integer.parseInt(deptid));
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Companymodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder update(String noindex,String company_name, String create_data_year, String create_data_month,
            String periode_year, String periode_month, String periode_end_of_month, String alamat1, String alamat2,
            String telp, String fax, String kota, String zipcode, String negara,
            String jenisusaha, String logo, String currencyid, String webpage,String deptid,String id) {
        message = new StringBuilder();
        try {
            String sql = "UPDATE company SET noindex=?, company_name=?, "
                    + "create_data_year=?, create_data_month=?,periode_year=?, "
                    + "periode_month=?, periode_end_of_month=?, alamat1=?, "
                    + "alamat2=?, telp=?, fax=?, kota=?, zipcode=?, negara=?, "
                    + "jenisusaha=?,logo=?, currencyid=?, webpage=?, deptid=? WHERE noindex=?";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
             pre.setInt(1, Integer.parseInt(noindex));
            pre.setString(2, company_name);
            pre.setInt(3, Integer.parseInt(create_data_year));
            pre.setInt(4, Integer.parseInt(create_data_month));
            pre.setInt(5, Integer.parseInt(periode_year));
            pre.setInt(6, Integer.parseInt(periode_month));
            pre.setInt(7, Integer.parseInt(periode_end_of_month));
            pre.setString(8, alamat1);
            pre.setString(9, alamat2);
            pre.setString(10, telp);
            pre.setString(11, fax);
            pre.setString(12, kota);
            pre.setString(13, zipcode);
            pre.setString(14, negara);
            pre.setString(15, jenisusaha);
            pre.setString(16, logo);
            pre.setString(17, currencyid);
            pre.setString(18, webpage);
            pre.setInt(19, Integer.parseInt(deptid));
            pre.setInt(10, Integer.parseInt(id));
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Companymodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder delete(String id) {
        message = new StringBuilder();
        try {
            String sql = "DELETE FROM company WHERE noindex=?";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setInt(1, Integer.parseInt(id));
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Companymodul.class.getName()).log(Level.SEVERE, null, ex);
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
                sbquery.append("INSERT INTO company (" + subentity[0] + ") VALUES(" + subentity[1] + ");");
            }
            PreparedStatement pre = ch.connect().prepareStatement(sbquery.toString());
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Companymodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

}
