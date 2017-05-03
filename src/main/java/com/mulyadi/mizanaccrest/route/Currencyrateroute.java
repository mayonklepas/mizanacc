/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mulyadi.mizanaccrest.route;

import com.mulyadi.mizanaccrest.modul.Currencymodul;
import com.mulyadi.mizanaccrest.modul.Currencyratemodul;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 *
 * @author user
 */
public class Currencyrateroute {

    Currencyratemodul modul = new Currencyratemodul();

    public Currencyrateroute() {
        getdata();
        getdetaildata();
        insertdata();
        updatedata();
        deletedata();
        insertbatch();
        System.out.println("-----Currencyrate----");
        System.out.println("/getcurrencyrate");
        System.out.println("/getdetailcurrencyrate");
        System.out.println("/insertcurrencyrate");
        System.out.println("/updatecurrencyrate");
        System.out.println("/deletecurrencyarate");
    }

    private void getdata() {
        Spark.get("/getcurrencyrate", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return modul.getdata().toString();
            }
        });
    }

    private void getdetaildata() {
        Spark.post("/getdetailcurrencyrate", new Route() {
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
        Spark.post("/insertcurrencyrate", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String noindex = rqst.queryParams("noindex");
                String indextable = rqst.queryParams("indextable");;
                String currencyid = rqst.queryParams("currencyid");
                String rate = rqst.queryParams("rate");
                String deptid = rqst.queryParams("deptid");
                return modul.insert(noindex, indextable, currencyid, rate, deptid).toString();
            }
        });
    }

    private void updatedata() {
        Spark.post("/updatecurrencyrate", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String noindex = rqst.queryParams("noindex");
                String indextable = rqst.queryParams("indextable");;
                String currencyid = rqst.queryParams("currencyid");
                String rate = rqst.queryParams("rate");
                String deptid = rqst.queryParams("deptid");
                String id = rqst.queryParams("id");
                return modul.update(noindex, indextable, currencyid, rate, deptid, id).toString();
            }
        });
    }

    private void deletedata() {
        Spark.post("/deletecurrencyrate", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String id = rqst.queryParams("id");
                return modul.delete(id).toString();
            }
        });
    }

    private void insertbatch() {
        Spark.post("/insertcurrencyratebatch", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String data = rqst.queryParams("data");
                return modul.insertbatch(data).toString();
            }
        });
    }

}
