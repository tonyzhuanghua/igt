package com.igt.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by zhuanghua on 2017/2/24.
 */
    public class Avvenimento {

    private int codPrograma;
    private String siglaSport;
    private String desManif;
    private String desAvvenimento;
    private String dateTime;
    private List<String> desTipoSco;

    public List<String> getDesTipoSco() {
        return desTipoSco;
    }

    public void setDesTipoSco(List<String> desTipoSco) {
        this.desTipoSco = desTipoSco;
    }

    public int getCodPrograma() {
        return codPrograma;
    }

    public void setCodPrograma(int codPrograma) {
        this.codPrograma = codPrograma;
    }

    public String getSiglaSport() {
        return siglaSport;
    }

    public void setSiglaSport(String siglaSport) {
        this.siglaSport = siglaSport;
    }

    public String getDesManif() {
        return desManif;
    }

    public void setDesManif(String desManif) {
        this.desManif = desManif;
    }

    public String getDesAvvenimento() {
        return desAvvenimento;
    }

    public void setDesAvvenimento(String desAvvenimento) {
        this.desAvvenimento = desAvvenimento;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
