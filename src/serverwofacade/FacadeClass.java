/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverwofacade;

/**
 *
 * @author thead
 */
public class FacadeClass {
    private static FacadeClass FacadeObj = null;
    private FacadeClass(){}
    private ScheduleServer obj = new ScheduleServer();

    public static FacadeClass getMyFacadeObject(){
        if(FacadeObj == null){
            FacadeObj = new FacadeClass();
        }
        return FacadeObj;
    }

    public void startServer(){
        obj.startBooting();
        obj.readSystemConfigFile();
        obj.init();
        obj.initializeContext();
        obj.initializeListeners();
        obj.createSystemObjects();
    }

    public void stopServer(){
        obj.releaseProcesses();
        obj.destory();
        obj.destroySystemObjects();
        obj.destoryListeners();
        obj.destoryContext();
        obj.shutdown();
    }
}
