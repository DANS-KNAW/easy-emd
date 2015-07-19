package nl.knaw.dans.easy.ldap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nl.knaw.dans.common.lang.test.Tester;
import nl.knaw.dans.common.ldap.ds.DirContextSupplier;
import nl.knaw.dans.common.ldap.ds.LdapClient;
import nl.knaw.dans.common.ldap.ds.StandAloneDS;

public class AbstractOnlineTest {

    private static StandAloneDS SUPPLIER;

    private static LdapClient LDAP_CLIENT;

    private static final Logger logger = LoggerFactory.getLogger(AbstractOnlineTest.class);

    public static DirContextSupplier getDirContextSupplier() {
        if (SUPPLIER == null) {
            SUPPLIER = new StandAloneDS();
            String inUse = Tester.getString("ldap.in.use");
            logger.debug("Using " + inUse + " as ldap server");
            SUPPLIER.setProviderURL(Tester.getString("ldap." + inUse + ".providerURL"));
            SUPPLIER.setSecurityPrincipal(Tester.getString("ldap." + inUse + ".securityPrincipal"));
            SUPPLIER.setSecurityCredentials(Tester.getString("ldap." + inUse + ".securityCredentials"));
        }
        return SUPPLIER;
    }

    public static LdapClient getLdapClient() {
        if (LDAP_CLIENT == null) {
            LDAP_CLIENT = new LdapClient(getDirContextSupplier());
        }
        return LDAP_CLIENT;
    }

}