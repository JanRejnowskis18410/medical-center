package com.pjatk.medicalcenter.util;

public class MessageTemplates {

    public static String confirmedAppointmentHTML = "<!DOCTYPE html>" +
            "<html>" +
            "<head>" +
            "<title>Nadchodząca wizyta</title>" +
            "    <style type=\"text/css\">" +
            "       h2 {font-size: 26px; line-height: 1.5; color: black;}" +
            "       h3 {font-size: 12px; color: black;}" +
            "       p {font-size: 12px; color: black;}" +
            "    table { border: 1px solid #e4e4e4;}" +
            "    </style>" +
            "</head>" +
            "<body>" +
            "<table width=\"100%%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"b0d6f9\">" +
            "    <tr>" +
            "        <td height=\"50\" align=\"center\"><h2>Nadchodząca wizyta</h2></td>" +
            "    </tr>" +
            "    <tr bgcolor=\"ffffff\">" +
            "        <td height=\"100\" align=\"center\">" +
            "           <h3>Masz zaplanowaną wizytę w dniu %s</h3>" +
            "           <h3>Szczegóły wizyty: </h3>" +
            "           <p>%s</p>" +
            "           <p>Lekarz: %s</p>" +
            "           <p>%s</p>" +
            "       </td>" +
            "    </tr>" +
            " </table>" +
            "</body>" +
            "</html>";

//    public static String reservedAppointmentHTML = "<!DOCTYPE html>" +
//            "<html>" +
//            "<head>" +
//            "<title>Nadchodząca wizyta</title>" +
//            "    <style type=\"text/css\">" +
//            "       h2 {font-size: 26px; line-height: 1.5; color: black;}" +
//            "       h3 {font-size: 12px; color: black;}" +
//            "       p {font-size: 12px; color: black;}" +
//            "    table { border: 1px solid #e4e4e4;}" +
//            "    </style>" +
//            "</head>" +
//            "<body>" +
//            "<table width=\"100%%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"b0d6f9\">" +
//            "    <tr>" +
//            "        <td height=\"50\" align=\"center\"><h2>Nadchodząca wizyta</h2></td>" +
//            "    </tr>" +
//            "    <tr bgcolor=\"ffffff\">" +
//            "        <td height=\"100\" align=\"center\">" +
//            "           <h3>Masz zaplanowaną wizytę w dniu %s</h3>" +
//            "           <h3>Szczegóły wizyty: </h3>" +
//            "           <p>%s</p>" +
//            "           <p>Lekarz: %s</p>" +
//            "           <p>W celu potwierdzenia lub odwołania wizyty zapraszamy do portalu pacjenta.</p>" +
//            "       </td>" +
//            "    </tr>" +
//            " </table>" +
//            "</body>" +
//            "</html>";
}
