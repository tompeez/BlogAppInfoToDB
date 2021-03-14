package de.hahn.blog.baseclasses.model.adfbc.facade;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import oracle.adf.share.logging.ADFLogger;

import oracle.jbo.JboException;
import oracle.jbo.Session;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.DBTransaction;

public class BaseApplicationModuleImpl extends ApplicationModuleImpl {
    private static ADFLogger _logger = ADFLogger.createADFLogger(BaseApplicationModuleImpl.class);

    public BaseApplicationModuleImpl() {
        super();
    }

    @Override
    protected void prepareSession(Session session) {
        super.prepareSession(session);
        DBTransaction tx = getDBTransaction();
        // für Root AM setzen wir den angemeldeten USer in die DB session
        if (isRoot()) {
            String user = getUserPrincipalName();
            if (user == null) {
                // if no security given, we user annonymous as username
                user = "anonymous";
            }

            String module = this.getTransactionName();

            callStoredProcedure(tx, Types.NULL, "dbms_session.set_identifier(?)", new Object[] { user });
            callStoredProcedure(tx, Types.NULL, "dbms_application_info.set_client_info(?)", new Object[] { module });
        }
    }

    private Object callStoredProcedure(DBTransaction tx, int sqlReturnType, String stmt, Object[] bindVars) {

        CallableStatement st = null;

        try {
            int paramOffset;

            if (sqlReturnType != Types.NULL) {
                st = tx.createCallableStatement("begin ? := " + stmt + "; end;", 0);
                st.registerOutParameter(1, sqlReturnType);
                paramOffset = 2;
            } else {
                st = tx.createCallableStatement("begin " + stmt + "; end;", 0);
                paramOffset = 1;
            }

            if (bindVars != null) {
                for (int i = 0; i < bindVars.length; i++) {
                    // 4. Set the value of user-supplied bind vars in the stmt
                    st.setObject(i + paramOffset, bindVars[i]);
                }
            }

            st.executeUpdate();

            return sqlReturnType != Types.NULL ? st.getObject(1) : null;
        } catch (SQLException e) {
            JboException mbExc = new JboException("error executing procudure: " + stmt);
            _logger.severe(mbExc.getMessage(), e);
            throw mbExc;
        } finally {

            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    ;
                    // OK
                }
            }
        }
    }

    public String getTransactionName() {
        try {
            String name = this.getClass().getSimpleName() + " id: " + this.getDBTransaction()
                                                                          .toString()
                                                                          .split("@")[1];
            if (isRoot()) {
                name += " (ROOT)";
            }
            return name;
        } catch (Exception ex) {
            return "n/a";
        }
    }
}
