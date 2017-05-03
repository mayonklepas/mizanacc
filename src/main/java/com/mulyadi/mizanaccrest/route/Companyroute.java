/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mulyadi.mizanaccrest.route;

import com.mulyadi.mizanaccrest.modul.Companymodul;
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
public class Companyroute {

    Companymodul modul = new Companymodul();

    public Companyroute() {
        getdata();
        getdetaildata();
        insertdata();
        updatedata();
        deletedata();
        insertbatch();
        System.out.println("-----Company----");
        System.out.println("/getcompany");
        System.out.println("/getcompanydetail");
        System.out.println("/insertcompany");
        System.out.println("/updatecompany");
        System.out.println("/deletecompany");
    }

    private void getdata() {
        Spark.get("/getcompany", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return modul.getdata().toString();
            }
        });
    }

    private void getdetaildata() {
        Spark.post("/getdetailcompany", new Route() {
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
        Spark.post("/insertcompany", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String noindex = rqst.queryParams("noindex");
                String company_name = rqst.queryParams("company_name");
                String create_data_year = rqst.queryParams("create_data_year");
                String create_data_month = rqst.queryParams("create_data_month");
                String periode_year = rqst.queryParams("periode_year");
                String periode_month = rqst.queryParams("periode_month");
                String periode_end_of_month = rqst.queryParams("periode_end_of_month");
                String alamat1 = rqst.queryParams("alamat1");
                String alamat2 = rqst.queryParams("alamat2");
                String telp = rqst.queryParams("telp");
                String fax = rqst.queryParams("fax");
                String kota = rqst.queryParams("kota");
                String zipcode = rqst.queryParams("zipkode");
                String negara = rqst.queryParams("negara");
                String jenisusaha = rqst.queryParams("jenisusaha");
                String logo = rqst.queryParams("logo");
                String currencyid = rqst.queryParams("currencyid");
                String webpage = rqst.queryParams("webpage");
                String deptid = rqst.queryParams("deptid");
                return modul.insert(noindex, company_name, create_data_year, create_data_month, periode_year,
                        periode_month, periode_end_of_month, alamat1, alamat2, telp, fax,
                        kota, zipcode, negara, jenisusaha, logo, currencyid, webpage, deptid).toString();
            }
        });
    }

    private void updatedata() {
        Spark.post("/updatecompany", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String noindex = rqst.queryParams("noindex");
                String company_name = rqst.queryParams("company_name");
                String create_data_year = rqst.queryParams("create_data_year");
                String create_data_month = rqst.queryParams("create_data_month");
                String periode_year = rqst.queryParams("periode_year");
                String periode_month = rqst.queryParams("periode_month");
                String periode_end_of_month = rqst.queryParams("periode_end_of_month");
                String alamat1 = rqst.queryParams("alamat1");
                String alamat2 = rqst.queryParams("alamat2");
                String telp = rqst.queryParams("telp");
                String fax = rqst.queryParams("fax");
                String kota = rqst.queryParams("kota");
                String zipcode = rqst.queryParams("zipkode");
                String negara = rqst.queryParams("negara");
                String jenisusaha = rqst.queryParams("jenisusaha");
                String logo = rqst.queryParams("logo");
                String currencyid = rqst.queryParams("currencyid");
                String webpage = rqst.queryParams("webpage");
                String deptid = rqst.queryParams("deptid");
                String id = rqst.queryParams("id");
                return modul.update(noindex, company_name, create_data_year, create_data_month, periode_year, 
                        periode_month, periode_end_of_month, alamat1, alamat2, telp, fax, kota, 
                        zipcode, negara, jenisusaha, logo, currencyid, webpage, deptid, id).toString();
            }
        });
    }

    private void deletedata() {
        Spark.post("/deletecompany", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String id = rqst.queryParams("id");
                return modul.delete(id).toString();
            }
        });
    }

    private void insertbatch() {
        Spark.post("/insertcompanybatch", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String data = rqst.queryParams("data");
                return modul.insertbatch(data).toString();
            }
        });
    }

}
