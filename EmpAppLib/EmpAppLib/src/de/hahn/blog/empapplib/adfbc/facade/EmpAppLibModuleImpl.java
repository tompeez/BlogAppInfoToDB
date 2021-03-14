package de.hahn.blog.empapplib.adfbc.facade;

import de.hahn.blog.baseclasses.model.adfbc.facade.BaseApplicationModuleImpl;
import de.hahn.blog.empapplib.adfbc.facade.common.EmpAppLibModule;

import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jan 01 12:29:20 CET 2021
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class EmpAppLibModuleImpl extends BaseApplicationModuleImpl implements EmpAppLibModule {
    /**
     * This is the default constructor (do not remove).
     */
    public EmpAppLibModuleImpl() {
    }

    /**
     * Container's getter for EmployeesView1.
     * @return EmployeesView1
     */
    public ViewObjectImpl getEmployeesView1() {
        return (ViewObjectImpl) findViewObject("EmployeesView1");
    }

    /**
     * Container's getter for JobHistoryView1.
     * @return JobHistoryView1
     */
    public ViewObjectImpl getJobHistoryView1() {
        return (ViewObjectImpl) findViewObject("JobHistoryView1");
    }

    /**
     * Container's getter for JobsView1.
     * @return JobsView1
     */
    public ViewObjectImpl getJobsView1() {
        return (ViewObjectImpl) findViewObject("JobsView1");
    }

    /**
     * Container's getter for EmployeesView2.
     * @return EmployeesView2
     */
    public ViewObjectImpl getEmployeesView2() {
        return (ViewObjectImpl) findViewObject("EmployeesView2");
    }

    /**
     * Container's getter for EmployeesView3.
     * @return EmployeesView3
     */
    public ViewObjectImpl getEmployeesView3() {
        return (ViewObjectImpl) findViewObject("EmployeesView3");
    }

    /**
     * Container's getter for JobHistoryView2.
     * @return JobHistoryView2
     */
    public ViewObjectImpl getJobHistoryView2() {
        return (ViewObjectImpl) findViewObject("JobHistoryView2");
    }

    /**
     * Container's getter for JobHistoryView3.
     * @return JobHistoryView3
     */
    public ViewObjectImpl getJobHistoryView3() {
        return (ViewObjectImpl) findViewObject("JobHistoryView3");
    }

    /**
     * Container's getter for EmpManagerFkLink1.
     * @return EmpManagerFkLink1
     */
    public ViewLinkImpl getEmpManagerFkLink1() {
        return (ViewLinkImpl) findViewLink("EmpManagerFkLink1");
    }

    /**
     * Container's getter for EmpJobFkLink1.
     * @return EmpJobFkLink1
     */
    public ViewLinkImpl getEmpJobFkLink1() {
        return (ViewLinkImpl) findViewLink("EmpJobFkLink1");
    }

    /**
     * Container's getter for JhistEmpFkLink1.
     * @return JhistEmpFkLink1
     */
    public ViewLinkImpl getJhistEmpFkLink1() {
        return (ViewLinkImpl) findViewLink("JhistEmpFkLink1");
    }

    /**
     * Container's getter for JhistJobFkLink1.
     * @return JhistJobFkLink1
     */
    public ViewLinkImpl getJhistJobFkLink1() {
        return (ViewLinkImpl) findViewLink("JhistJobFkLink1");
    }

    public String getApplicationName() {
        String name = super.getTransactionName();
        return name;
    }
}

