/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mulyadi.mizanaccrest.route;

import com.mulyadi.mizanaccrest.modul.Accconfigmodul;
import com.mulyadi.mizanaccrest.modul.Accmodul;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 *
 * @author user
 */
public class Accconfigroute {

    Accconfigmodul modul = new Accconfigmodul();

    public Accconfigroute() {
        getdata();
        getdetaildata();
        insertdata();
        updatedata();
        deletedata();
        insertbatch();
        System.out.println("-----acc config----");
        System.out.println("/getaccconfig");
        System.out.println("/getdetailaccconfig");
        System.out.println("/getfilteraccconfig");
        System.out.println("/insertaccconfig");
        System.out.println("/updateaccconfig");
        System.out.println("/deleteaccconfig");
    }

    private void getdata() {
        Spark.get("/getaccconfig", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return modul.getdata().toString();
            }
        });
    }

    private void getdetaildata() {
        Spark.post("/getdetailaccconfig", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String key = rqst.queryParams("key");
                return modul.getdatadetail(key).toString();
            }
        });
    }
    
    private void getfilterdata() {
        Spark.post("/getfilteraccconfig", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String field = rqst.queryParams("field");
                String key = rqst.queryParams("key");
                return modul.getdatafilter(field,key).toString();
            }
        });
    }

    private void insertdata() {
        Spark.post("/insertaccconfig", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String noindex=rqst.queryParams("noindex");
                String acc_code=rqst.queryParams("acc_code");
                String keterangan=rqst.queryParams("keterangan");
                String currencyid=rqst.queryParams("currencyid");
                String deptid=rqst.queryParams("deptid");
                return modul.insert(noindex, acc_code, keterangan, currencyid, deptid).toString();
            }
        });
    }

    private void updatedata() {
        Spark.post("/updateaccconfig", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                String noindex=rqst.queryParams("noindex");
                String acc_code=rqst.queryParams("acc_code");
                String keterangan=rqst.queryParams("keterangan");
                String currencyid=rqst.queryParams("currencyid");
                String deptid=rqst.queryParams("deptid");
                String id=rqst.queryParams("id");
                return modul.update(noindex, acc_code, keterangan, currencyid, deptid, id).toString();
            }
        });
    }

    private void deletedata() {
        Spark.post("/deleteaccconfig", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String id = rqst.queryParams("key");
                return modul.delete(id).toString();
            }
        });
    }

    private void insertbatch() {
        Spark.post("/insertaccconfigbatch", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String data = rqst.queryParams("data");
                return modul.insertbatch(data).toString();
            }
        });
    }

}
