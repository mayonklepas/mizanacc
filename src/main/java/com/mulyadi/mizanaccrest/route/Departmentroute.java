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
        getdetaildata();
        insertdata();
        updatedata();
        deletedata();
        insertbatch();
        System.out.println("-----Department----");
        System.out.println("/getdepartment");
        System.out.println("/getdetaildepartment");
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

    private void getdetaildata() {
        Spark.post("/getdetaildepartment", new Route() {
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
        Spark.post("/insertdepartment", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String deptid = rqst.queryParams("deptid");
                String dept_name = rqst.queryParams("deptid");
                String isssubdept = rqst.queryParams("deptid");
                String subdept = rqst.queryParams("deptid");
                String parentdept = rqst.queryParams("deptid");
                return modul.insert(deptid, dept_name, isssubdept, subdept, parentdept).toString();
            }
        });
    }

    private void updatedata() {
        Spark.post("/updatedepartment", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String deptid = rqst.queryParams("deptid");
                String dept_name = rqst.queryParams("deptid");
                String isssubdept = rqst.queryParams("deptid");
                String subdept = rqst.queryParams("deptid");
                String parentdept = rqst.queryParams("deptid");
                String id = rqst.queryParams("id");
                return modul.update(deptid, dept_name, isssubdept, subdept, parentdept, id).toString();
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
