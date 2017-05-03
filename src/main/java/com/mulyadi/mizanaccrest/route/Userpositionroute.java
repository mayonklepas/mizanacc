/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mulyadi.mizanaccrest.route;

import com.mulyadi.mizanaccrest.modul.Userpositionmodul;
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
public class Userpositionroute {

    Userpositionmodul modul = new Userpositionmodul();

    public Userpositionroute() {
        getdata();
        getdetaildata();
        insertdata();
        updatedata();
        deletedata();
        insertbatch();
        System.out.println("-----User Position----");
        System.out.println("/getuserposition");
        System.out.println("/getdetailuserposition");
        System.out.println("/insertuserposition");
        System.out.println("/updateuserposition");
        System.out.println("/deleteuserposition");
    }

    private void getdata() {
        Spark.get("/getuserposition", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return modul.getdata().toString();
            }
        });
    }

    private void getdetaildata() {
        Spark.post("/getdetailuserposition", new Route() {
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
        Spark.post("/insertuserposition", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String noindex = rqst.queryParams("noindex");
                String nama = rqst.queryParams("nama");
                String keterangan = rqst.queryParams("keterangan");
                String hak_datamaster = rqst.queryParams("hak_datamaster");
                String hak_sistem = rqst.queryParams("hak_sistem");
                String hak_penjualan = rqst.queryParams("hak_penjualan");
                String hak_pembelian = rqst.queryParams("hak_pembelian");
                String hak_persediaan = rqst.queryParams("hak_persediaan");
                String hak_perbankan = rqst.queryParams("hak_perbankan");
                String hak_akuntansi = rqst.queryParams("hak_akuntansi");
                String hak_laporan = rqst.queryParams("hak_laporan");
                return modul.insert(noindex, nama, keterangan, hak_datamaster, hak_sistem,
                        hak_penjualan, hak_pembelian, hak_persediaan, hak_perbankan,
                        hak_akuntansi, hak_laporan).toString();
            }
        });
    }

    private void updatedata() {
        Spark.post("/updateuserposition", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String noindex = rqst.queryParams("noindex");
                String nama = rqst.queryParams("nama");
                String keterangan = rqst.queryParams("keterangan");
                String hak_datamaster = rqst.queryParams("hak_datamaster");
                String hak_sistem = rqst.queryParams("hak_sistem");
                String hak_penjualan = rqst.queryParams("hak_penjualan");
                String hak_pembelian = rqst.queryParams("hak_pembelian");
                String hak_persediaan = rqst.queryParams("hak_persediaan");
                String hak_perbankan = rqst.queryParams("hak_perbankan");
                String hak_akuntansi = rqst.queryParams("hak_akuntansi");
                String hak_laporan = rqst.queryParams("hak_laporan");
                String id = rqst.queryParams("id");
                return modul.update(noindex, nama, keterangan, hak_datamaster, hak_sistem, 
                        hak_penjualan, hak_pembelian, hak_persediaan, hak_perbankan, 
                        hak_akuntansi, hak_laporan, id).toString();
            }
        });
    }

    private void deletedata() {
        Spark.post("/deleteuserposition", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String id = rqst.queryParams("id");
                return modul.delete(id).toString();
            }
        });
    }

    private void insertbatch() {
        Spark.post("/insertuserpositionbatch", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String data = rqst.queryParams("data");
                return modul.insertbatch(data).toString();
            }
        });
    }

}
