package com.adviteya.remote;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.adviteya.meta.MA_CompanyMeta;
import com.adviteya.meta.MA_WeeklyEffortReportMeta;
import com.adviteya.model.MA_Company;
import com.adviteya.model.MA_WeeklyEffortReport;
import com.adviteya.persistence.AbstractEntityDAO;
import com.adviteya.service.EntityService;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.tools.remoteapi.RemoteApiInstaller;
import com.google.appengine.tools.remoteapi.RemoteApiOptions;

public class UpdateRemoteEntityTest {

    public static void main(String[] args) throws IOException {
//        RemoteApiOptions options =
//            new RemoteApiOptions()
//                .server("omcqa1.appspot.com", 443)
//                .credentials("hrmastercontrol@gmail.com", "xxxxx");
        //
         RemoteApiOptions options =
         new RemoteApiOptions().server("localhost", 80).credentials("", "");

        RemoteApiInstaller installer = new RemoteApiInstaller();
        installer.install(options);
        UpdateRemoteEntityTest _upd = new UpdateRemoteEntityTest();
        try {

            _upd.updateWeeklyReport();
            // GlobalTransaction gtx = Datastore.beginGlobalTransaction();
            // AbstractEntityDAO.setGtx(gtx);

//            MA_Company _company = new MA_Company();
//            MA_CompanyMeta _cmeta = new MA_CompanyMeta();

            // Key _k = Datastore.createKey(MA_Company.class, 102051);
            // _company.setKey(_k);
            //
            // _company = Datastore.query(_cmeta).filter(_cmeta.key.equal(_k))
            // .asSingle();
            // _company.setActive("Y");

//            EntityService es = EntityService.getInstance();
//            List<MA_Company> _clist = es.getAllCompanyList();
//            ArrayList _updatedClist = new ArrayList();
//
//            for (Iterator iterator = _clist.iterator(); iterator.hasNext();) {
//                GlobalTransaction gtx = Datastore.beginGlobalTransaction();
//                AbstractEntityDAO.setGtx(gtx);
//                MA_Company ma_Company = (MA_Company) iterator.next();
//                ma_Company.setActive("N");
//                AbstractEntityDAO.addModel(ma_Company);
//                gtx.commit();
//
//                // _updatedClist.add(ma_Company);
//            }

            // AbstractEntityDAO.addModels(_updatedClist);

            // AbstractEntityDAO.addModel(_company);
            // gtx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            installer.uninstall();
        }
    }

    private void updateWeeklyReport() {
        GlobalTransaction gtx = Datastore.beginGlobalTransaction();
        AbstractEntityDAO.setGtx(gtx);

        MA_WeeklyEffortReport _weeklyreport = new MA_WeeklyEffortReport();
        MA_WeeklyEffortReportMeta _wmeta = new MA_WeeklyEffortReportMeta();

        Key _k = Datastore.createKey(MA_WeeklyEffortReport.class, 534201);
        _weeklyreport.setKey(_k);

        _weeklyreport =
            Datastore.query(_wmeta).filter(_wmeta.key.equal(_k)).asSingle();
        _weeklyreport.setWeekNo(41);
        AbstractEntityDAO.addModel(_weeklyreport);
        gtx.commit();
    }
}
