package com.dp;

import java.util.Date;

public class AdReservationProxy implements AdReservation{
    private AdReservationImpl adReservationImpl;
    public AdReservationImpl getAdReservationImpl() {
        return adReservationImpl;
    }
    public void setAdReservationImpl(AdReservationImpl adReservationImpl) {
        this.adReservationImpl = adReservationImpl;
    }

    private int user_id;
    @Override
    public Boolean reserveAd(Integer annonce_id, int user_id, Date startDate, Date endDate) {
        if (user_id != -1) {
            adReservationImpl.reserveAd(annonce_id, user_id, startDate, endDate);
            return true;
        } else {
            return false;
        }
    }
}
