/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mulyadi.mizanaccrest.route;

import com.mulyadi.mizanaccrest.modul.Databankmodul;
import com.mulyadi.mizanaccrest.modul.Usersmodul;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 *
 * @author user
 */
public class Databankroute {

    Databankmodul modul = new Databankmodul();

    public Databankroute() {
        getdata();
        getdetaildata();
        insertdata();
        updatedata();
        deletedata();
        insertbatch();
        System.out.println("-----Databank----");
        System.out.println("/getdatabank");
        System.out.println("/getdetaildatabank");
        System.out.println("/insertdatabank");
        System.out.println("/updatedatabank");
        System.out.println("/deletedatabank");
    }

    private void getdata() {
        Spark.get("/getdatabank", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return modul.getdata().toString();
            }
        });
    }

    private void getdetaildata() {
        Spark.post("/getdetaildatabank", new Route() {
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
        Spark.post("/insertdatabank", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String noindex=rqst.queryParams("noindex");
                String acc_code=rqst.queryParams("acc_code");
                String nomor_rekening_bank=rqst.queryParams("nomor_rekening_bank");
                String atas_nama_rekening=rqst.queryParams("atas_nama_rekening");
                String kantor_cabang=rqst.queryParams("kantor_cabang");
                String alamat=rqst.queryParams("alamat");
                String telp=rqst.queryParams("telp");
                String fax=rqst.queryParams("fax");
                String kodepos=rqst.queryParams("kodepos");
                String contactperson=rqst.queryParams("contactperson");
                String keterangan=rqst.queryParams("keterangan");
                return modul.insert(noindex, acc_code, nomor_rekening_bank, atas_nama_rekening, 
                        kantor_cabang, alamat, telp, fax, kodepos, contactperson, keterangan).toString();
            }
        });
    }

    private void updatedata() {
        Spark.post("/updatedatabank", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               String noindex=rqst.queryParams("noindex");
                String acc_code=rqst.queryParams("acc_code");
                String nomor_rekening_bank=rqst.queryParams("nomor_rekening_bank");
                String atas_nama_rekening=rqst.queryParams("atas_nama_rekening");
                String kantor_cabang=rqst.queryParams("kantor_cabang");
                String alamat=rqst.queryParams("alamat");
                String telp=rqst.queryParams("telp");
                String fax=rqst.queryParams("fax");
                String kodepos=rqst.queryParams("kodepos");
                String contactperson=rqst.queryParams("contactperson");
                String keterangan=rqst.queryParams("keterangan");
                String id = rqst.queryParams("id");
                return modul.update(noindex, acc_code, nomor_rekening_bank, atas_nama_rekening, 
                        kantor_cabang, alamat, telp, fax, kodepos, contactperson, keterangan, id).toString();
            }
        });
    }

    private void deletedata() {
        Spark.post("/deletedatabank", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String id = rqst.queryParams("id");
                return modul.delete(id).toString();
            }
        });
    }

    private void insertbatch() {
        Spark.post("/insertdatabankbatch", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String data = rqst.queryParams("data");
                return modul.insertbatch(data).toString();
            }
        });
    }

}
