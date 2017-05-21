/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mulyadi.mizanaccrest.helper;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import spark.ResponseTransformer;

/**
 *
 * @author user
 */
public class UtilHandler {

    public UtilHandler() {
    }

    public StringBuilder jsonencodedb(ResultSet res) {
        StringBuilder sbres = new StringBuilder();
        try {
            ResultSetMetaData rm = res.getMetaData();
            int colcount = rm.getColumnCount();
            StringBuilder sbcolum = new StringBuilder();
            while (res.next()) {
                sbcolum.append("{");
                StringBuilder sbrow = new StringBuilder();
                for (int i = 1; i <= colcount; i++) {
                    int coltipe = rm.getColumnType(i);
                    if (coltipe == Types.DATE || coltipe == Types.VARCHAR || coltipe == Types.TIMESTAMP) {
                        sbrow.append("\"" + rm.getColumnName(i) + "\"" + ":" + "\"" + res.getString(i) + "\"" + ",");
                    } else {
                        sbrow.append("\"" + rm.getColumnName(i) + "\"" + ":" + res.getString(i) + ",");
                    }
                }

                if (sbrow.toString().length() == 0) {
                    sbcolum.append("");
                } else {
                    sbcolum.append(sbrow.toString().substring(0, sbrow.length() - 1));
                    sbcolum.append("},");
                }

            }

            if (sbcolum.toString().length() == 0) {
                sbres.append("[]");
            } else {
                sbres.append("[" + sbcolum.substring(0, sbcolum.length() - 1) + "]");
            }
            res.close();
        } catch (Exception ex) {
            Logger.getLogger(UtilHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sbres;
    }

    public String getexception(Exception ex) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        ex.printStackTrace(pw);
        return sw.toString();
    }

}
