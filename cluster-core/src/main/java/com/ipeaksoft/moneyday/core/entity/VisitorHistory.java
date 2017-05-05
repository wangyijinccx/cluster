package com.ipeaksoft.moneyday.core.entity;

import java.util.Date;

public class VisitorHistory {
    private String idfa;

    private Date ts;

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa == null ? null : idfa.trim();
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }
}