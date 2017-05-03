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
public class Usersmodul {

    UtilHandler u = new UtilHandler();
    ConnectionHandler ch = new ConnectionHandler();
    StringBuilder sb;
    StringBuilder message;

    public Usersmodul() {
    }

    public StringBuilder getdata() {
        message = new StringBuilder();
        try {
            String sql = "SELECT noindex, indextable, user_name, user_pwd, parent, users_position_id FROM users";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            sb = u.jsonencodedb(res);
            pre.close();
            ch.close();
            message = sb;
        } catch (Exception ex) {
            message.append(ex.getStackTrace().toString());
            Logger.getLogger(Usersmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder getdatadetail(String field, String key) {
        message = new StringBuilder();
        try {
            String sql = "SELECT noindex, indextable, user_name, user_pwd, parent, users_position_id FROM users "
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
            Logger.getLogger(Usersmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder insert(String noindex,String user_name, String user_pwd,
            String parent, String users_position_id) {
        message = new StringBuilder();
        try {
            String sql = "INSERT INTO users(noindex,user_name, user_pwd, parent, users_position_id) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, noindex);
            pre.setString(2, user_name);
            pre.setString(3, user_pwd);
            pre.setString(4, parent);
            pre.setString(5, users_position_id);
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Usersmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder update(String noindex,String user_name, String user_pwd, String parent,
            String users_position_id,String id) {
        message = new StringBuilder();
        try {
            String sql = "UPDATE users SET noindex=?,user_name=?, user_pwd=?, parent=?,"
                    + " users_position_id=? WHERE noindex=?;";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setString(1, noindex);
            pre.setString(2, user_name);
            pre.setString(3, user_pwd);
            pre.setString(4, parent);
            pre.setString(5, users_position_id);
            pre.setString(6, id);
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Usersmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

    public StringBuilder delete(String id) {
        message = new StringBuilder();
        try {
            String sql = "DELETE FROM users WHERE noindex=?";
            PreparedStatement pre = ch.connect().prepareStatement(sql);
            pre.setInt(1, Integer.parseInt(id));
            pre.executeUpdate();
            pre.close();
            ch.close();
            message = getdata();
        } catch (Exception ex) {
            message.append(u.getexception(ex));
            Logger.getLogger(Usersmodul.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Usersmodul.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ch.close();
        }
        return message;
    }

}
