package com.zhu.facts;

/**
 * @author heykb
 */
public class HelloFact implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    private String message;

    public HelloFact() {
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HelloFact(String message) {
        this.message = message;
    }

}
