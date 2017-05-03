/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mulyadi.mizanaccrest.route;

import com.mulyadi.mizanaccrest.modul.Setupprogrammodul;
import com.mulyadi.mizanaccrest.modul.Usersmodul;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 *
 * @author user
 */
public class Setupprogramroute {

    Setupprogrammodul modul = new Setupprogrammodul();

    public Setupprogramroute() {
        getdata();
        getdetaildata();
        insertdata();
        updatedata();
        deletedata();
        insertbatch();
        System.out.println("-----Setupprogram----");
        System.out.println("/getsetuprogram");
        System.out.println("/getsetupprogram");
        System.out.println("/insertsetupprogram");
        System.out.println("/updatesetupprogram");
        System.out.println("/deletesetupprogram");
    }

    private void getdata() {
        Spark.get("/getsetupprogram", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return modul.getdata().toString();
            }
        });
    }

    private void getdetaildata() {
        Spark.post("/getsetupprogram", new Route() {
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
        Spark.post("/insertsetupprogram", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String noindex = rqst.queryParams("noindex");
                String indextable = rqst.queryParams("indextable");
                String keterangan = rqst.queryParams("keterangan");
                String boolvalue = rqst.queryParams("boolvalue");
                String strvalue = rqst.queryParams("strvalue");
                String intvalue = rqst.queryParams("intvalue");
                String currvalue = rqst.queryParams("currvalue");
                String datevalue = rqst.queryParams("datevalue");
                return modul.insert(noindex, indextable, keterangan, boolvalue, strvalue,
                        intvalue, currvalue, datevalue).toString();
            }
        });
    }

    private void updatedata() {
        Spark.post("/updatesetupprogram", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String noindex = rqst.queryParams("noindex");
                String indextable = rqst.queryParams("indextable");
                String keterangan = rqst.queryParams("keterangan");
                String boolvalue = rqst.queryParams("boolvalue");
                String strvalue = rqst.queryParams("strvalue");
                String intvalue = rqst.queryParams("intvalue");
                String currvalue = rqst.queryParams("currvalue");
                String datevalue = rqst.queryParams("datevalue");
                String id = rqst.queryParams("id");
                return modul.update(noindex, indextable, keterangan, boolvalue, strvalue,
                        intvalue, currvalue, datevalue, id).toString();
            }
        });
    }

    private void deletedata() {
        Spark.post("/deletesetupprogram", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String id = rqst.queryParams("id");
                return modul.delete(id).toString();
            }
        });
    }

    private void insertbatch() {
        Spark.post("/insertsetupprogrambatch", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String data = rqst.queryParams("data");
                return modul.insertbatch(data).toString();
            }
        });
    }

}
