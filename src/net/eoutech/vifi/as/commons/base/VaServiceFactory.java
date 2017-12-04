package net.eoutech.vifi.as.commons.base;

import net.eoutech.vifi.as.service.VaAccountingService;
import net.eoutech.vifi.as.service.VaAuthenticationService;
import net.eoutech.vifi.as.service.VaAuthorizationService;
import net.eoutech.vifi.as.service.VaStatisticService;
import net.eoutech.vifi.as.vsw.service.accounting.VswAccVUPDATEService;
import net.eoutech.vifi.as.vsw.service.authentiction.VswAuthenGSREGService;
import net.eoutech.vifi.as.vsw.service.authentiction.VswAuthenVSWHBService;
import net.eoutech.vifi.as.vsw.service.authorization.*;

/**
 * Created by SUU on 2016/5/25.
 */
public class VaServiceFactory {

    private static VaServiceFactory instance = null;

    private VaServiceFactory () {
    }

    public static VaServiceFactory getInstance () {
        if ( instance == null ) {
            instance = new VaServiceFactory();
        }
        return instance;
    }
        //认证
    public VaAuthenticationService createAuthenService ( VaMsgReq req, VaMsgResp resp ) {
        VaAuthenticationService service = null;
        switch ( req.getMsgType() ) {

            // VSW
            case GSREG:
                service = new VswAuthenGSREGService( req, resp );
                break;
//            case VSWHB :
//                service = new VswAuthenVSWHBService( req, resp );
//                break;

            default:
        }
        return service;
    }
        //授权计费
    public VaAuthorizationService createAuthorService ( VaMsgReq req, VaMsgResp resp ) {
        VaAuthorizationService service = null;
        switch ( req.getMsgType() ) {
            // VSW
//            case VOPEN:
//                service = new VswAuthorVOPENService( req, resp );
//                break;
            case VUPDATE:
                service = new VswAuthorVUPDATEService( req, resp );
                break;
//            case VCLOSE:
//                service = new VswAuthorVCLOSEService( req, resp );
//                break;
            case SPUBLISH:
                service = new VswAuthorSPUBLISHService( req, resp );
                break;
            case GSREG:
                service = new VswAuthorGSREGService( req, resp );
                break;
//            case VSWHB:
//                service = new VswAuthorVSWHBService( req, resp );
//                break;
            default:
        }
        return service;
    }
        //记账
    public VaAccountingService createAccService ( VaMsgReq req, VaMsgResp resp ) {
        VaAccountingService service = null;
        switch ( req.getMsgType() ) {

            // VSW
            case VUPDATE:
                service = new VswAccVUPDATEService( req, resp );
                break;

            default:
        }
        return service;
    }

    public VaStatisticService createStatisticService ( VaMsgReq req, VaMsgResp resp ) {
        VaStatisticService service = new VaStatisticService( req, resp );
        return service;
    }

}
