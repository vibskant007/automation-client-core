package com.walmartlabs.report;

public class ElasticStore implements ReportStore{

    private static final String elasticUrl = "";

    @Override
    public void sendReportStats(ReportObject reportObject) {
        //send to elastic search
    }

}
