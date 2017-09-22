/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.Date;

/**
 *
 * @author M.Chin
 */
class Relampagos {
    
    float latitude;
    float longitude;
    String destricao;
    Date data;

    public String getDestricao() {
        return destricao;
    }

    public void setDestricao(String destricao) {
        this.destricao = destricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Relampagos{"+ "latitude=" + latitude + ", longitude=" + longitude + ", destricao=" + destricao + ", data=" + data + '}';
    }
    
}