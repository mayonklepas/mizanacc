/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mulyadi.mizanaccrest.route;

import com.mulyadi.mizanaccrest.modul.Currencymodul;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 *
 * @author user
 */
public class Currencyroute {

    Currencymodul modul = new Currencymodul();

    public Currencyroute() {
        getdata();
        getdetaildata();
        insertdata();
        updatedata();
        deletedata();
        insertbatch();
        System.out.println("-----Currency----");
        System.out.println("/getcurrency");
        System.out.println("/getdetailcurrency");
        System.out.println("/insertcurrency");
        System.out.println("/updatecurrency");
        System.out.println("/deletecurrency");
    }

    private void getdata() {
        Spark.get("/getcurrency", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return modul.getdata().toString();
            }
        });
    }

    private void getdetaildata() {
        Spark.post("/getdetailcurrency", new Route() {
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
        Spark.post("/insertcurrency", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String noindex = rqst.queryParams("noindex");
                String currency_code = rqst.queryParams("currency_code");
                String currency_name = rqst.queryParams("currency_name");
                String currency_rate = rqst.queryParams("currency_rate");
                String currency_symbol = rqst.queryParams("currency_symbol");
                String country_name = rqst.queryParams("country_name");
                String deptid = rqst.queryParams("deptid");
                return modul.insert(noindex, currency_code, currency_name, currency_rate,
                        currency_symbol, country_name, deptid).toString();
            }
        });
    }

    private void updatedata() {
        Spark.post("/updatecurrency", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String noindex = rqst.queryParams("noindex");
                String currency_code = rqst.queryParams("currency_code");
                String currency_name = rqst.queryParams("currency_name");
                String currency_rate = rqst.queryParams("currency_rate");
                String currency_symbol = rqst.queryParams("currency_symbol");
                String country_name = rqst.queryParams("country_name");
                String deptid = rqst.queryParams("deptid");
                String id = rqst.queryParams("id");
                return modul.update(noindex, currency_code, currency_name, currency_rate,
                        currency_symbol, country_name, deptid, id).toString();
            }
        });
    }

    private void deletedata() {
        Spark.post("/deletecurrency", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String id = rqst.queryParams("id");
                return modul.delete(id).toString();
            }
        });
    }

    private void insertbatch() {
        Spark.post("/insertcurrencybatch", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String data = rqst.queryParams("data");
                return modul.insertbatch(data).toString();
            }
        });
    }

}
