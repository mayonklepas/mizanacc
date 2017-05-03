/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mulyadi.mizanaccrest.route;

import com.mulyadi.mizanaccrest.modul.Pajakmodul;
import com.mulyadi.mizanaccrest.modul.Prefikmodul;
import com.mulyadi.mizanaccrest.modul.Usersmodul;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 *
 * @author user
 */
public class Prefikroute {

    Prefikmodul modul = new Prefikmodul();

    public Prefikroute() {
        getdata();
        getdetaildata();
        insertdata();
        updatedata();
        deletedata();
        insertbatch();
        System.out.println("-----Prefik----");
        System.out.println("/getprefik");
        System.out.println("/getdetailprefik");
        System.out.println("/insertprefik");
        System.out.println("/updateprefik");
        System.out.println("/deleteprefik");
    }

    private void getdata() {
        Spark.get("/getprefik", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return modul.getdata().toString();
            }
        });
    }

    private void getdetaildata() {
        Spark.post("/getdetailprefik", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String field = rqst.queryParams("field");
                String key = rqst.queryParams("key");
                return modul.getdatadetail(field, key).toString();
            }
        });
    }

    private void insertdata() {
        Spark.post("/insertprefik", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String noindex = rqst.queryParams("noindex");
                String indextable = rqst.queryParams("indextable");
                String kode = rqst.queryParams("kode");
                String nama = rqst.queryParams("name");
                String prefik_kode = rqst.queryParams("prefik_kode");
                String keterangan_trans = rqst.queryParams("keterangan_trans");
                return modul.insert(noindex, indextable, kode, nama, prefik_kode, keterangan_trans).toString();
            }
        });
    }

    private void updatedata() {
        Spark.post("/updateprefik", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String noindex = rqst.queryParams("noindex");
                String indextable = rqst.queryParams("indextable");
                String kode = rqst.queryParams("kode");
                String nama = rqst.queryParams("name");
                String prefik_kode = rqst.queryParams("prefik_kode");
                String keterangan_trans = rqst.queryParams("keterangan_trans");
                String id = rqst.queryParams("id");
                return modul.update(noindex, indextable, kode, nama, prefik_kode, keterangan_trans, id).toString();
            }
        });
    }

    private void deletedata() {
        Spark.post("/deleteprefik", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String id = rqst.queryParams("id");
                return modul.delete(id).toString();
            }
        });
    }

    private void insertbatch() {
        Spark.post("/insertprefikbatch", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String data = rqst.queryParams("data");
                return modul.insertbatch(data).toString();
            }
        });
    }

}
