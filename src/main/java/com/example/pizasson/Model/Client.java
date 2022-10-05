package com.example.pizasson.Model;

/**
 * This class contains the client information to be used on the invoice
 * The class has the attributes of the client name, nit and email
 *
 * @author Santiago Caballero
 */
public class Client {
    private String name;
    private String nit;
    private String email;

    /**
     * Constructor method of Client class
     */
    public Client(){
    }

    /**
     * Overloading the constructor method to receive the name, nit and email
     * @param name client name
     * @param nit client nit
     * @param email client email
     */
    public Client(String name, String nit, String email) {
        this.name = name;
        this.nit = nit;
        this.email = email;
    }

    /**
     * Method to get the client name
     * @return client name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set the client name
     * @param name to modify the attribute
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Method to get the client name
     * @return client nit
     */
    public String getNit() {
        return nit;
    }
    /**
     * Method to set the client nit
     * @param nit to modify the attribute
     */
    public void setNit(String nit) {
        this.nit = nit;
    }
    /**
     * Method to get the client email
     * @return client email
     */
    public String getEmail() {
        return email;
    }
    /**
     * Method to set the client email
     * @param email to modify the attribute
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
