package com.terminator.zjxtwvf.guazi.util;

import com.terminator.zjxtwvf.guazi.model.entity.TrackingEntity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 2017/12/10.
 */

public class TrackingUtil {

    public static List<TrackingEntity.TrackingsBean> mTrackings = new ArrayList<TrackingEntity.TrackingsBean>();

    public static void initWifiTrackingData(TrackingEntity trackingEntity) {
        TrackingEntity.CommonBean comm = new TrackingEntity.CommonBean();
        comm.setAgency("meizu");
        comm.setApp_id(12);
        comm.setApp_version("3.9.1.0");
        comm.setBrand("m3 note");
        comm.setCarrier("其他");
        comm.setFriendlyname("魅蓝 note 3");
        comm.setImei("862007036501106");
        comm.setLine("c2c");

        TrackingEntity.TrackingsBean trackings = new TrackingEntity.TrackingsBean();
        trackings.setCity("cd");
        trackings.setLatlng("");
        trackings.setLocal_timestamp(Long.toString(Calendar.getInstance().getTimeInMillis()));
        trackings.setNetwork("wifi");
        trackings.setPage("");
        trackings.setPageid("");
        trackings.setPagetype("");
        trackings.setSessionid("0d82f7c9-68c7-439f-8118-c0b5c6102f7f");
        trackings.setWifissid("360免费WiFi-UB");
        trackings.setTracking_type("startup");

        mTrackings.add(trackings);

        trackingEntity.setCommon(comm);
        trackingEntity.setTrackings(mTrackings);
    }
}
