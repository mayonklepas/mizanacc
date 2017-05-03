/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mulyadi.mizanaccrest.route;

import com.mulyadi.mizanaccrest.modul.Usersmodul;
import com.mulyadi.mizanaccrest.modul.Versimodul;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 *
 * @author user
 */
public class Versiroute {

    Versimodul modul = new Versimodul();

    public Versiroute() {
        getdata();
        getdetaildata();
        insertdata();
        updatedata();
        deletedata();
        insertbatch();
        System.out.println("-----Versi----");
        System.out.println("/getversi");
        System.out.println("/getdetailversi");
        System.out.println("/insertversi");
        System.out.println("/updateversi");
        System.out.println("/deleteversi");
    }

    private void getdata() {
        Spark.get("/getversi", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return modul.getdata().toString();
            }
        });
    }

    private void getdetaildata() {
        Spark.post("/getdetailversi", new Route() {
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
        Spark.post("/insertversi", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String nama=rqst.queryParams("nama");
                String versi_mayor=rqst.queryParams("versi_mayor");
                String versi_minor=rqst.queryParams("versi_minor");
                String versi_release=rqst.queryParams("versi_release");
                String versi_revisi=rqst.queryParams("versi_revisi");                        
                return modul.insert(nama, versi_mayor, versi_minor, versi_release, versi_revisi).toString();
            }
        });
    }

    private void updatedata() {
        Spark.post("/updateversi", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             String nama=rqst.queryParams("nama");
                String versi_mayor=rqst.queryParams("versi_mayor");
                String versi_minor=rqst.queryParams("versi_minor");
                String versi_release=rqst.queryParams("versi_release");
                String versi_revisi=rqst.queryParams("versi_revisi");               
                String id = rqst.queryParams("id");
                return modul.update(nama, versi_mayor, versi_minor, versi_release, versi_revisi, id).toString();
            }
        });
    }

    private void deletedata() {
        Spark.post("/deleteversi", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String id = rqst.queryParams("id");
                return modul.delete(id).toString();
            }
        });
    }

    private void insertbatch() {
        Spark.post("/insertversibatch", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String data = rqst.queryParams("data");
                return modul.insertbatch(data).toString();
            }
        });
    }

}
