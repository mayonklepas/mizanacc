/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mulyadi.mizanaccrest;

import com.mulyadi.mizanaccrest.modul.Accclassmodul;
import com.mulyadi.mizanaccrest.route.Accclassroute;
import com.mulyadi.mizanaccrest.route.Accconfigroute;
import com.mulyadi.mizanaccrest.route.Accroute;
import com.mulyadi.mizanaccrest.route.Companyroute;
import com.mulyadi.mizanaccrest.route.Currencyrateroute;
import com.mulyadi.mizanaccrest.route.Currencyroute;
import com.mulyadi.mizanaccrest.route.Databankroute;
import com.mulyadi.mizanaccrest.route.Departmentroute;
import com.mulyadi.mizanaccrest.route.Pajakroute;
import com.mulyadi.mizanaccrest.route.Prefikroute;
import com.mulyadi.mizanaccrest.route.Setupprogramroute;
import com.mulyadi.mizanaccrest.route.Userpositionroute;
import com.mulyadi.mizanaccrest.route.Usersroute;
import com.mulyadi.mizanaccrest.route.Versiroute;
import spark.Spark;

/**
 *
 * @author user
 */
public class App {
    public static void main(String args[]){
        Spark.port(555);
        Spark.externalStaticFileLocation("resources");
        new Accclassroute();
        new Accroute();
        new Departmentroute();
        new Currencyroute();
        new Currencyrateroute();
        new Usersroute();
        new Accconfigroute();
        new Pajakroute();
        new Prefikroute();
        new Databankroute();
        new Versiroute();
        new Setupprogramroute();
        new Companyroute();
        new Userpositionroute();
    }
}
