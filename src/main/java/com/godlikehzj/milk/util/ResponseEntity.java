package com.godlikehzj.milk.util;

import java.io.Serializable;/**
 * Created by godlikehzj on 15/9/9.
 */


public class ResponseEntity  implements Serializable{

    private String message;
    private Integer status;
    private Object data;

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public ResponseEntity( Integer status,String message, Object data) {
        super();
        this.message = message;
        this.status = status;
        this.data = data;
    }
    public ResponseEntity() {
        super();
    }

}
