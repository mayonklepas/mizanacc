/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mulyadi.mizanaccrest.route;

import com.mulyadi.mizanaccrest.modul.Departmentmodul;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 *
 * @author user
 */
public class Departmentroute {

    Departmentmodul modul = new Departmentmodul();

    public Departmentroute() {
        getdata();
        getsubdatadata();
        getdetaildata();
        getfilterdata();
        insertdata();
        updatedata();
        deletedata();
        insertbatch();
        System.out.println("-----Department----");
        System.out.println("/getsubdepartment");
        System.out.println("/getdepartment");
        System.out.println("/getdetaildepartment");
        System.out.println("/getfilterdepartment");
        System.out.println("/insertdepartment");
        System.out.println("/updatedepartment");
        System.out.println("/deletedepartment");
    }

    private void getdata() {
        Spark.get("/getdepartment", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return modul.getdata().toString();
            }
        });
    }
    
    
    private void getsubdatadata() {
        Spark.get("/getsubdepartment", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return modul.getsubdata().toString();
            }
        });
    }

    private void getdetaildata() {
        Spark.post("/getdetaildepartment", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String key = rqst.queryParams("key");
                return modul.getdatadetail(key).toString();
            }
        });
    }
    
    private void getfilterdata() {
        Spark.post("/getfilterdepartment", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String field = rqst.queryParams("field");
                String key = rqst.queryParams("key");
                return modul.getdatafilter(field, key).toString();
            }
        });
    }

    private void insertdata() {
        Spark.post("/insertdepartment", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String deptid = rqst.queryParams("deptid");
                String dept_name = rqst.queryParams("dept_name");
                String isssubdept = rqst.queryParams("issubdept");
                String subdept = rqst.queryParams("subdept");
                return modul.insert(deptid, dept_name, isssubdept, subdept).toString();
            }
        });
    }

    private void updatedata() {
        Spark.post("/updatedepartment", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String deptid = rqst.queryParams("deptid");
                String dept_name = rqst.queryParams("dept_name");
                String isssubdept = rqst.queryParams("issubdept");
                String subdept = rqst.queryParams("subdept");
                String id = rqst.queryParams("id");
                return modul.update(deptid, dept_name, isssubdept, subdept, id).toString();
            }
        });
    }

    private void deletedata() {
        Spark.post("/deletedepartment", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String id = rqst.queryParams("id");
                return modul.delete(id).toString();
            }
        });
    }

    private void insertbatch() {
        Spark.post("/insertdepartmentbatch", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String data = rqst.queryParams("data");
                return modul.insertbatch(data).toString();
            }
        });
    }

}
