/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mulyadi.mizanaccrest.route;

import com.mulyadi.mizanaccrest.helper.UtilHandler;
import com.mulyadi.mizanaccrest.modul.Accclassmodul;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 *
 * @author user
 */
public class Accclassroute {
    
    Accclassmodul modul=new Accclassmodul();

    public Accclassroute() {
        getdata();
        getdetaildata();
        insertdata();
        updatedata();
        deletedata();
        insertbatch();
        System.err.println("-----acc class----");
        System.out.println("/getaccclass");
        System.out.println("/getdetailaccclass");
        System.out.println("/insertaccclass");
        System.out.println("/updateaccclass");
        System.out.println("/deleteaccclass");
    }
    
    
    
    private void getdata(){
        Spark.get("/getaccclass",new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return modul.getdata().toString();
            }
        });
    }
    
    private void getdetaildata(){
        Spark.post("/getdetailaccclass",new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String key=rqst.queryParams("key");
                return modul.getdatadetail(key).toString();
            }
        });
    }
    
    
    private void insertdata(){
        Spark.post("/insertaccclass",new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String acc_class_id=rqst.queryParams("acc_class_id");
                String acc_class_name=rqst.queryParams("acc_class_name");
                return modul.insert(acc_class_id, acc_class_name).toString();
            }
        });
    }
    
    private void updatedata(){
        Spark.post("/updateaccclass",new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String acc_class_id=rqst.queryParams("acc_class_id");
                String acc_class_name=rqst.queryParams("acc_class_name");
                String id=rqst.queryParams("key");
                return modul.update(acc_class_id, acc_class_name, id).toString();
            }
        });
    }
    
    private void deletedata(){
        Spark.post("/deleteaccclass",new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String id =rqst.queryParams("key");
                return modul.delete(id).toString();
            }
        });
    }
    
    private void insertbatch(){
        Spark.post("/insertaccclassbatch",new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String data=rqst.queryParams("data");
                return modul.insertbatch(data).toString();
            }
        });
    }
    
    
    
}
