package org.adi.springPA;

public class exampleBean {

    protected boolean invoked;


    public void invoke() {
        this.invoked = true;
        System.out.println(getClass().getName() + " is currently invoked.");
    }

    public boolean isInvoked() {
        System.out.println("\n\n -------->" + getClass().getName() + " is invoked. Id is: ");
        return invoked;
    }

    public void setInvoked(boolean invoked) {

        this.invoked = invoked;
        System.out.println(getClass().getName() + " set invoked=" + invoked);
        throw new Error("Unser Fehler");
    }

}
