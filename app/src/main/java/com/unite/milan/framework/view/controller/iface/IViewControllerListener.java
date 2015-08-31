
package com.unite.milan.framework.view.controller.iface;

/**
 * Listener between view and controller to update views.
 *
 * @author tkmaea9
 */
public interface IViewControllerListener {
    public void notifyViewOnSuccess(Object object);

    public void notifyViewOnFailure(Object object);
}
