package AppModule.common;

import oracle.jbo.ApplicationModule;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Oct 05 14:35:17 IST 2017
// ---------------------------------------------------------------------
public interface contractAM extends ApplicationModule {
    void refreshSearchScreeh();

    void onClickVariation();

    void contractLookup();

    void totalContractSum(String headId);

    void usercount();

    String deletedbcall(String p_cid, String p_type, String P_username,
                        String p_ip);
}
