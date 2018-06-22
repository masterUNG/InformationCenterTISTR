package com.example.kitaro.informationcentertistr.utility;

import com.example.kitaro.informationcentertistr.R;

public class MyConstant {

    private String[] id_ec_Strings = new String[]{"1", "4", "2", "3", "5", "6"};


    private String urlProduct = "http://203.150.10.52/mkm_connect/tb_bestpro.php";
    private String urlExpert = "http://203.150.10.52/mkm_connect/tb_per.php";
    private String urlPicture = "http://203.150.10.52/mkm_connect/imgs/";


    private int[] iconInts = new int[]{
            R.drawable.ic_product_24dp,
            R.drawable.ic_person__24dp,
            R.drawable.ic_ready_24dp,
            R.drawable.ic_service_research_24dp,
            R.drawable.ic_suport_24dp,
            R.drawable.ic_arrow_back_24dp};

    private String[] titleDrawerStrings = new String[]{
            "ผลงาน",
            "ความเชี่ยวชาญ",
            "ความพร้อมงานวิจัย",
            "บริการงานวิจัย",
            "การสนับสนุน",
            "กลับสู่หน้าหลัก"};

    private String[] titleStrings = new String[]{
            "InnoAg",
            "InnoEN",
            "InnoFood",
            "InnoHerb",
            "InnoMat",
            "InnoRobot"};

    private String[] subTitleStrings = new String[]{
            "เกษตร",
            "พลังงาน",
            "อาหาร",
            "สมุนไพร",
            "วัสดุ",
            "หุ่นยนต์"};

//    About Getter


    public String getUrlPicture() {
        return urlPicture;
    }

    public String getUrlExpert() {
        return urlExpert;
    }

    public String[] getId_ec_Strings() {
        return id_ec_Strings;
    }

    public String getUrlProduct() {
        return urlProduct;
    }

    public int[] getIconInts() {
        return iconInts;
    }

    public String[] getTitleDrawerStrings() {
        return titleDrawerStrings;
    }

    public String[] getTitleStrings() {
        return titleStrings;
    }

    public String[] getSubTitleStrings() {
        return subTitleStrings;
    }
}
