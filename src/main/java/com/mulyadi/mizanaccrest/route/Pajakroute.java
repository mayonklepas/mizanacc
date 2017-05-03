/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mulyadi.mizanaccrest.route;

import com.mulyadi.mizanaccrest.modul.Pajakmodul;
import com.mulyadi.mizanaccrest.modul.Usersmodul;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 *
 * @author user
 */
public class Pajakroute {

    Pajakmodul modul = new Pajakmodul();

    public Pajakroute() {
        getdata();
        getdetaildata();
        insertdata();
        updatedata();
        deletedata();
        insertbatch();
        System.out.println("-----Pajak----");
        System.out.println("/getpajak");
        System.out.println("/getdetailpajak");
        System.out.println("/insertpajak");
        System.out.println("/updatepajak");
        System.out.println("/deletepajak");
    }

    private void getdata() {
        Spark.get("/getpajak", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return modul.getdata().toString();
            }
        });
    }

    private void getdetaildata() {
        Spark.post("/getdetailpajak", new Route() {
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
        Spark.post("/insertpajak", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String noindex=rqst.queryParams("noindex");
                String indextable=rqst.queryParams("indextable");
                String kodepajak=rqst.queryParams("kodepajak");
                String namapajak=rqst.queryParams("namapajak");
                String pajak_nilai=rqst.queryParams("pajaknilai");
                String akunjual=rqst.queryParams("akunjual");
                String akunbeli=rqst.queryParams("akunbeli");
                return modul.insert(noindex, indextable, kodepajak, namapajak, pajak_nilai,
                        akunjual, akunbeli).toString();
            }
        });
    }

    private void updatedata() {
        Spark.post("/updatepajak", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String noindex=rqst.queryParams("noindex");
                String indextable=rqst.queryParams("indextable");
                String kodepajak=rqst.queryParams("kodepajak");
                String namapajak=rqst.queryParams("namapajak");
                String pajak_nilai=rqst.queryParams("pajaknilai");
                String akunjual=rqst.queryParams("akunjual");
                String akunbeli=rqst.queryParams("akunbeli");
                String id=rqst.queryParams("id");
                return modul.update(noindex, indextable, kodepajak, namapajak, pajak_nilai,
                        akunjual, akunbeli, id).toString();
            }
        });
    }

    private void deletedata() {
        Spark.post("/deletepajak", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String id = rqst.queryParams("id");
                return modul.delete(id).toString();
            }
        });
    }

    private void insertbatch() {
        Spark.post("/insertpajakbatch", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String data = rqst.queryParams("data");
                return modul.insertbatch(data).toString();
            }
        });
    }

}
