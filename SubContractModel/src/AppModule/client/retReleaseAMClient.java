package AppModule.client;

import AppModule.common.retReleaseAM;

import oracle.jbo.client.remote.ApplicationModuleImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Feb 01 11:53:11 IST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class retReleaseAMClient extends ApplicationModuleImpl implements retReleaseAM {
    /**
     * This is the default constructor (do not remove).
     */
    public retReleaseAMClient() {
    }

    public void refreshRetention() {
        Object _ret =
            this.riInvokeExportedMethod(this, "refreshRetention", null, null);
        return;
    }
}
