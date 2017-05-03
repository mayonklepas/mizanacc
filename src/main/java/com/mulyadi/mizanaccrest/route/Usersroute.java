/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mulyadi.mizanaccrest.route;

import com.mulyadi.mizanaccrest.modul.Usersmodul;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 *
 * @author user
 */
public class Usersroute {

    Usersmodul modul = new Usersmodul();

    public Usersroute() {
        getdata();
        getdetaildata();
        insertdata();
        updatedata();
        deletedata();
        insertbatch();
        System.out.println("-----Users----");
        System.out.println("/getusers");
        System.out.println("/getdetailusers");
        System.out.println("/insertusers");
        System.out.println("/updateusers");
        System.out.println("/deleteusers");
    }

    private void getdata() {
        Spark.get("/getusers", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return modul.getdata().toString();
            }
        });
    }

    private void getdetaildata() {
        Spark.post("/getdetailusers", new Route() {
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
        Spark.post("/insertusers", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String noindex = rqst.queryParams("noindex");
                String user_name = rqst.queryParams("user_name");
                String user_pwd = rqst.queryParams("user_pwd");
                String parent = rqst.queryParams("parent");
                String users_position_id = rqst.queryParams("users_position_id");
                return modul.insert(noindex, user_name, user_pwd, parent, users_position_id).toString();
            }
        });
    }

    private void updatedata() {
        Spark.post("/updateusers", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String noindex = rqst.queryParams("noindex");
                String user_name = rqst.queryParams("username");
                String user_pwd = rqst.queryParams("user_pwd");
                String parent = rqst.queryParams("parent");
                String users_position_id = rqst.queryParams("user_position_id");
                String id = rqst.queryParams("id");
                return modul.update(noindex, user_name, user_pwd, parent, users_position_id, id).toString();
            }
        });
    }

    private void deletedata() {
        Spark.post("/deleteusers", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String id = rqst.queryParams("id");
                return modul.delete(id).toString();
            }
        });
    }

    private void insertbatch() {
        Spark.post("/insertusersbatch", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String data = rqst.queryParams("data");
                return modul.insertbatch(data).toString();
            }
        });
    }

}
