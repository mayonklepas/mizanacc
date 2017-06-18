/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mulyadi.mizanaccrest.route;

import com.mulyadi.mizanaccrest.modul.Accmodul;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 *
 * @author user
 */
public class Accroute {

    Accmodul modul = new Accmodul();

    public Accroute() {
        getdata();
        getdetaildata();
        getfilterdata();
        insertdata();
        updatedata();
        deletedata();
        insertbatch();
        System.out.println("-----acc----");
        System.out.println("/getacc");
        System.out.println("/getdetailacc");
        System.out.println("/getfilteracc");
        System.out.println("/insertacc");
        System.out.println("/updateacc");
        System.out.println("/deleteacc");
    }

    private void getdata() {
        Spark.get("/getacc", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return modul.getdata().toString();
            }
        });
    }

    private void getdetaildata() {
        Spark.post("/getdetailacc", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String key = rqst.queryParams("key");
                return modul.getdatadetail(key).toString();
            }
        });
    }
    
     private void getfilterdata() {
        Spark.post("/getfilteracc", new Route() {
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
        Spark.post("/insertacc", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String acc_code = rqst.queryParams("acc_code");
                String acc_name = rqst.queryParams("acc_name");;
                String acc_class_id = rqst.queryParams("acc_class_id");;
                String isparent = rqst.queryParams("isparent");;
                String parentacc = rqst.queryParams("parentacc");;
                String firstparentacc = rqst.queryParams("firstparentacc");;
                String isactive = rqst.queryParams("isactive");;
                String acclevel = rqst.queryParams("acclevel");;
                String saldoawal = rqst.queryParams("saldoawal");;
                String currencyid = rqst.queryParams("currencyid");;
                String deptid = rqst.queryParams("deptid");;
                String iskasbank = rqst.queryParams("iskasbank");
                return modul.insert(acc_code, acc_name, acc_class_id, isparent, parentacc, firstparentacc,
                        isactive, acclevel, saldoawal, currencyid, deptid, iskasbank).toString();
            }
        });
    }

    private void updatedata() {
        Spark.post("/updateacc", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String acc_code = rqst.queryParams("acc_code");
                String acc_name = rqst.queryParams("acc_name");;
                String acc_class_id = rqst.queryParams("acc_class_id");;
                String isparent = rqst.queryParams("isparent");;
                String parentacc = rqst.queryParams("parentacc");;
                String firstparentacc = rqst.queryParams("firstparentacc");;
                String isactive = rqst.queryParams("isactive");;
                String acclevel = rqst.queryParams("acclevel");;
                String saldoawal = rqst.queryParams("saldoawal");;
                String currencyid = rqst.queryParams("currencyid");;
                String deptid = rqst.queryParams("deptid");;
                String iskasbank = rqst.queryParams("iskasbank");
                String id = rqst.queryParams("id");
                return modul.update(acc_code, acc_name, acc_class_id, isparent, parentacc, firstparentacc,
                        isactive, acclevel, saldoawal, currencyid, deptid,
                        iskasbank, id).toString();
            }
        });
    }

    private void deletedata() {
        Spark.post("/deleteacc", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String id = rqst.queryParams("key");
                return modul.delete(id).toString();
            }
        });
    }

    private void insertbatch() {
        Spark.post("/insertaccbatch", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String data = rqst.queryParams("data");
                return modul.insertbatch(data).toString();
            }
        });
    }

}
