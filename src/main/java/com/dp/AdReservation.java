package com.dp;

import java.util.Date;

public interface AdReservation {
    Boolean reserveAd(Integer annonce_id, int user_id, Date startDate, Date endDate);
}
