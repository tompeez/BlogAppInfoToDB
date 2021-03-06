package de.hahn.blog.depapplib.adfbc.facade;

import de.hahn.blog.baseclasses.model.adfbc.facade.BaseApplicationModuleImpl;
import de.hahn.blog.depapplib.adfbc.facade.common.DepLibAppModule;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jan 01 12:48:50 CET 2021
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DepLibAppModuleImpl extends BaseApplicationModuleImpl implements DepLibAppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public DepLibAppModuleImpl() {
    }

    /**
     * Container's getter for DepartmentsView1.
     * @return DepartmentsView1
     */
    public ViewObjectImpl getDepartmentsView1() {
        return (ViewObjectImpl) findViewObject("DepartmentsView1");
    }

    public String getApplicationName() {
        String name = super.getTransactionName();
        return name;
    }
}

