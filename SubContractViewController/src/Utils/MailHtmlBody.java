package Utils;

public class MailHtmlBody {
    public MailHtmlBody() {
        super();
    }

    // Naresco

    public static String submit(String nameOfNofication,
                                String NoficationNumber, String LoginUser) {

        String htmlBody = "<html>\n" +
            "<head>\n" +
            "<title>Page Title</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:#444444\">\n" +
            "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" class=\"x_m_-6366644067162443722x_container\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; max-width:500px; margin:0 auto; text-align:inherit\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" bgcolor=\"transparent\" class=\"x_m_-6366644067162443722x_block-grid\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; width:100%; max-width:500px; color:#333; background-color:transparent\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; text-align:center; font-size:0\">\n" +
            "<div class=\"x_m_-6366644067162443722x_col x_m_-6366644067162443722x_num12\" style=\"display:inline-block; vertical-align:top; width:100%\">\n" +
            "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; padding-top:20px; padding-right:0px; padding-bottom:20px; padding-left:0px; border-top:0px solid transparent; border-right:0px solid transparent; border-bottom:0px solid transparent; border-left:0px solid transparent\">\n" +
            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
            "<tbody><tr style=\"vertical-align:top\">\n" +
            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:0px; padding-left:10px\">\n" +
            "<div style=\"color: rgb(85, 85, 85); line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" +
            "<div style=\"font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; font-size: 12px; line-height: 14px; color: rgb(85, 85, 85); text-align: left;\">\n" +
            "<p style=\"margin:0; font-size:18px; line-height:22px\"><span style=\"font-size:26px; line-height:31px; color:rgb(255,255,255)\"><strong><span style=\"line-height:31px; font-size:26px\">Naresco</span></strong></span></p>\n" +
            "</div>\n" +
            "</div>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:5px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
            "<div style=\"color: rgb(136, 136, 136); line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" +
            "<div style=\"font-size: 12px; line-height: 14px; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; color: rgb(136, 136, 136); text-align: left;\">\n" +
            "<p style=\"margin:0; font-size:12px; line-height:14px\"><span style=\"color:rgb(153,153,153); font-size:12px; line-height:14px\">Naresco <span class=\"x_m_-6366644067162443722highlight\" id=\"x_m_-63666440671624437220.9182669872898304\" name=\"x_searchHitInReadingPane\">Notifications</span></span></p>\n" +
            "</div>\n" +
            "</div>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "</div>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:#e5e5e5\">\n" +
            "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" class=\"x_m_-6366644067162443722x_container\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; max-width:500px; margin:0 auto; text-align:inherit\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" bgcolor=\"transparent\" class=\"x_m_-6366644067162443722x_block-grid\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; width:100%; max-width:500px; color:#333; background-color:transparent\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; text-align:center; font-size:0\">\n" +
            "<div class=\"x_m_-6366644067162443722x_col x_m_-6366644067162443722x_num12\" style=\"display:inline-block; vertical-align:top; width:100%\">\n" +
            "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; padding-top:30px; padding-right:0px; padding-bottom:30px; padding-left:0px; border-top:0px solid transparent; border-right:0px solid transparent; border-bottom:0px solid transparent; border-left:0px solid transparent\">\n" +
            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:0px; padding-left:10px\">\n" +
            "<div style=\"color: rgb(85, 85, 85); line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" +
            "<div style=\"font-size: 12px; line-height: 14px; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; color: rgb(85, 85, 85); text-align: left;\">\n" +
            "<p style=\"margin:0; font-size:14px; line-height:17px; text-align:justify\"><span style=\"font-size:24px; line-height:28px\"><strong><span style=\"line-height:28px; font-size:24px\"><span style=\"color:rgb(44,48,94); font-size:24px; line-height:28px\">Hey</span>,<span style=\"color:rgb(51,51,51); font-size:24px; line-height:28px\"> <span style=\"font-size:24px; line-height:28px\">" +
            nameOfNofication + "&nbsp" + NoficationNumber +
            "&nbspis Submitted for approval.</span></span></span></strong></span></p>\n" +
            "</div>\n" +
            "</div>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "<table align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
            "<div style=\"height:1px\">\n" +
            "<table align=\"center\" border=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; border-top:1px solid #bbbbbb; width:100%\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "</div>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:10px\">\n" +
            "<div style=\"color: rgb(119, 119, 119); line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" +
            "<div style=\"font-size: 12px; line-height: 14px; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; color: rgb(119, 119, 119); text-align: left;\">\n" +
            "<p style=\"margin:0; font-size:14px; line-height:17px; text-align:justify\"><span style=\"font-size:12px; line-height:14px; color:rgb(51,51,51)\"><span style=\"font-size:12px; line-height:14px\"><span style=\"font-size:12px; line-height:14px\"><strong style=\"color:rgb(255,102,0)\">" +
            LoginUser + "</strong> has placed an " + nameOfNofication +
            " with " + nameOfNofication + " number " + NoficationNumber +
            " is Submitted for approval.<br>\n" +
            "<br>\n" +
            "Thank you!<br>\n" +
            "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">Good day!</span></span></span></span></p>\n" +
            "</div>\n" +
            "</div>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "<table align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
            "<div style=\"height:1px\">\n" +
            "<table align=\"center\" border=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; border-top:1px solid #bbbbbb; width:100%\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "</div>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:15px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
            "<div style=\"line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" +
            "<div style=\"font-size: 12px; line-height: 14px; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; text-align: left;\">\n" +
            "<table style=\"border-collapse:collapse; border-spacing:0\">\n" +
            "<tbody>\n" +
            "<tr>\n" +
            "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#666; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
            "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">" +
            nameOfNofication + "</span></td>\n" +
            "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#ff6600; font-weight:bold; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
            "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">" +
            NoficationNumber + "</span></td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#666; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
            "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">Status</span></td>\n" +
            "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#ff6600; font-weight:bold; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
            "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">Submitted for Approval</span></td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#666; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
            "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#ff6600; font-weight:bold; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
            "</tr>\n" +
            "<tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "</div>\n" +
            "</div>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "<table align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
            "<div style=\"height:1px\">\n" +
            "<table align=\"center\" border=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; border-top:1px solid #bbbbbb; width:100%\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "</div>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td class=\"x_m_-6366644067162443722x_button-container\" align=\"left\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:15px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
            "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td width=\"100%\" class=\"x_m_-6366644067162443722x_button\" align=\"left\" valign=\"middle\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
            "<div align=\"left\" style=\"display:inline-block; border-radius:5px; max-width:25%; width:100%; border-top:0px solid transparent; border-right:0px solid transparent; border-bottom:0px solid transparent; border-left:0px solid transparent\">\n" +
            "</div>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "</div>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:#444444\">\n" +
            "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" class=\"x_m_-6366644067162443722x_container\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; max-width:500px; margin:0 auto; text-align:inherit\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" bgcolor=\"transparent\" class=\"x_m_-6366644067162443722x_block-grid\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; width:100%; max-width:500px; color:#333; background-color:transparent\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; text-align:center; font-size:0\">\n" +
            "<div class=\"x_m_-6366644067162443722x_col x_m_-6366644067162443722x_num12\" style=\"display:inline-block; vertical-align:top; width:100%\">\n" +
            "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; padding-top:25px; padding-right:0px; padding-bottom:25px; padding-left:0px; border-top:0px solid transparent; border-right:0px solid transparent; border-bottom:0px solid transparent; border-left:0px solid transparent\">\n" +
            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
            "<tbody>\n" +
            "<tr style=\"vertical-align:top\">\n" +
            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
            "<div style=\"color: rgb(187, 187, 187); line-height: 120%; font-family: Helvetica Neue, Helvetica, Arial, sans-serif, serif, EmojiFont;\">\n" +
            "<div style=\"font-size: 12px; line-height: 14px; color: rgb(187, 187, 187); font-family: Helvetica Neue, Helvetica, Arial, sans-serif, serif, EmojiFont; text-align: left;\">\n" +
            "<p style=\"margin:0; font-size:12px; line-height:14px; text-align:center\">Naresco <span class=\"x_m_-6366644067162443722highlight\" id=\"x_m_-63666440671624437220.6246102622735843\" name=\"x_searchHitInReadingPane\">Notifications</span></p>\n" +
            "<p style=\"margin:0; font-size:12px; line-height:14px; text-align:center\">mailto:Naresconotifications@Naresco-me.com <span class=\"x_m_-6366644067162443722highlight\" id=\"x_m_-63666440671624437220.6246102622735843\" name=\"x_searchHitInReadingPane\"></span></p>\n" +
            "<p style=\"margin:0; font-size:12px; line-height:14px; text-align:center\"><a href=\"mailto:Naresconotifications@Naresco-me.com?subject=Order+Notifications+Support+(12001)\" target=\"_blank\" rel=\"noopener noreferrer\" title=\"Naresconotification@gmail.com\" style=\"color:#ffffff; text-decoration:underline\"><wbr></a></p>\n" +
            "</div>\n" +
            "</div>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "</div>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "</body>\n" +
            "</html>";
        return htmlBody;
    }
}
