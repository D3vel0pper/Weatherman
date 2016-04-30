package d3vel0pper.com.weatherman.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.util.LongSparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import d3vel0pper.com.weatherman.R;

public class SettingFragment extends Fragment {
    //50こ
    private String[] prefecture = {"道北","道東","道央","道南","青森県","岩手県","宮城県",
            "秋田県","山形県","福島県","茨城県","栃木県","群馬県","埼玉県","千葉県",
            "東京都","神奈川県","新潟県","富山県","石川県","福井県","山梨県","長野県",
            "岐阜県","静岡県","愛知県","三重県","滋賀県","京都府","大阪府","兵庫県","奈良県",
            "和歌山県","鳥取県","島根県","岡山県","広島県","山口県","徳島県","香川県","愛媛県",
            "高知県","福岡県","佐賀県","長崎県","熊本県","大分県","宮崎県","鹿児島県","沖縄県"};
    private String[] cities;
    //private Map[] cityMap = new Map[50];
    //private List<Map<String,String>> citiMap = new ArrayList<>();
    private Map<String,String> map = new HashMap<>();
    private Map<Integer,Map<String,String>> cityMap = new HashMap<>();

    private static final String ARG_SECTION_NAME = "Setting";

    //private OnFragmentInteractionListener mListener;

    public static SettingFragment newInstance(String sectionName) {
        SettingFragment fragment = new SettingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_NAME,sectionName);
        fragment.setArguments(args);
        return fragment;
    }

    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setCities();
        for(int i = 0;i < 50;i++){
//            cityMap[i] = new Map<String,String>();


//            setValuesofMap();

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        public void onFragmentInteraction(Uri uri);
//    }

//    private void setCities(){
//        map.put("稚内","011000");
//        map.put("旭川","012010");
//        map.put("留萌","012020");
//        cityMap.put(0,map);
//
//        map.put("網走","013010");
//        map.put("北見","013020");
//        map.put("紋別","013030");
//        map.put("根室","014010");
//        map.put("釧路","014020");
//        map.put("帯広","014030");
//        cityMap.put(1,map);
//        map.clear();
//    }

/*
    private void setValuesofMap(){
        //douhoku
        cityMap[0].put("稚内","011000");
        cityMap[0].put("旭川","012010");
        cityMap[0].put("留萌","012020");
        //doutou
        cityMap[1].put("網走","013010");
        cityMap[1].put("北見","013020");
        cityMap[1].put("紋別","013030");
        cityMap[1].put("根室","014010");
        cityMap[1].put("釧路","014020");
        cityMap[1].put("帯広","014030");
        //douou
        cityMap[2].put("札幌","016010");
        cityMap[2].put("岩見沢","016020");
        cityMap[2].put("倶知安","016030");
        //dounan
        cityMap[3].put("室蘭","015010");
        cityMap[3].put("浦河", "015020");
        cityMap[3].put("函館", "017010");
        cityMap[3].put("江差", "017020");
        //aomori
        cityMap[4].put("青森", "020010");
        cityMap[4].put("むつ", "020020");
        cityMap[4].put("八戸", "020030");
        //iwate
        cityMap[5].put("盛岡","030010");
        cityMap[5].put("宮古","030020");
        cityMap[5].put("大船渡","030030");
        //miyagi
        cityMap[6].put("仙台", "040010");
        cityMap[6].put("白石", "040020");
        //akita
        cityMap[7].put("秋田", "050010");
        cityMap[7].put("横手", "050020");
        //yamagata
        cityMap[8].put("山形", "060010");
        cityMap[8].put("米沢", "060020");
        cityMap[8].put("酒田", "060030");
        cityMap[8].put("新庄", "060040");
        //fukusima
        cityMap[9].put("福島", "070010");
        cityMap[9].put("小名浜", "070020");
        cityMap[9].put("若松", "070030");
        //ibaraki
        cityMap[10].put("水戸", "080010");
        cityMap[10].put("土浦", "080020");
        //totigi
        cityMap[11].put("宇都宮", "090010");
        cityMap[11].put("大田原", "090020");
        //gunma
        cityMap[12].put("前橋","100010");
        cityMap[12].put("みなかみ", "100020");
        //saitama
        cityMap[13].put("さいたま","110010");
        cityMap[13].put("熊谷","110020");
        cityMap[13].put("秩父","110030");
        //chiba
        cityMap[14].put("千葉","120010");
        cityMap[14].put("銚子","120020");
        cityMap[14].put("館山","120030");
        //tokyo
        cityMap[15].put("東京","130010");
        cityMap[15].put("大島","130020");
        cityMap[15].put("八丈島","130030");
        cityMap[15].put("父島","130040");
        //kanagawa
        cityMap[16].put("横浜","140010");
        cityMap[16].put("小田原","140020");
        //nigata
        cityMap[17].put("新潟","150010");
        cityMap[17].put("長岡","150020");
        cityMap[17].put("高田","150030");
        cityMap[17].put("相川","150040");
        //toyama
        cityMap[18].put("富山","160010");
        cityMap[18].put("伏木","160020");
        //isikawa
        cityMap[19].put("金沢","170010");
        cityMap[19].put("輪島","170020");
        //fukui
        cityMap[20].put("福井", "180010");
        cityMap[20].put("敦賀", "180020");
        //yamanasi
        cityMap[21].put("甲府","190010");
        cityMap[21].put("河口湖","190020");
        //nagano
        cityMap[22].put("長野", "200010");
        cityMap[22].put("松本", "200020");
        cityMap[22].put("飯田", "200030");
        //gihu
        cityMap[23].put("岐阜","210010");
        cityMap[23].put("高山","210020");
        //sizuoka
        cityMap[24].put("静岡","220010");
        cityMap[24].put("網代","220020");
        cityMap[24].put("三島","220030");
        cityMap[24].put("浜松","220040");
        //aichi
        cityMap[25].put("名古屋","230010");
        cityMap[25].put("豊橋","230020");
        //mie
        cityMap[26].put("津","240010");
        cityMap[26].put("尾鷲","240020");
        //siga
        cityMap[27].put("大津","250010");
        cityMap[27].put("彦根","250020");
        //kyoto
        cityMap[28].put("京都","260010");
        cityMap[28].put("舞鶴","260020");
        //osaka
        cityMap[29].put("大阪","270000");
        //hyogo
        cityMap[30].put("神戸", "280010");
        cityMap[30].put("豊岡", "280020");
        //nara
        cityMap[31].put("奈良","290010");
        cityMap[31].put("風屋","290020");
        //wakayama
        cityMap[32].put("和歌山","300010");
        cityMap[32].put("潮岬","300020");
        //tottori
        cityMap[33].put("鳥取","310010");
        cityMap[33].put("米子","310020");
        //simane
        cityMap[34].put("松江","320010");
        cityMap[34].put("浜田","320020");
        cityMap[34].put("西郷","320030");
        //okayama
        cityMap[35].put("岡山","330010");
        cityMap[35].put("津山","330020");
        //hirosima
        cityMap[36].put("広島","340010");
        cityMap[36].put("庄原","340020");
        //yamaguchi
        cityMap[37].put("下関","350010");
        cityMap[37].put("山口","350020");
        cityMap[37].put("柳井","350030");
        cityMap[37].put("荻","350040");
        //tokusima
        cityMap[38].put("徳島","360010");
        cityMap[38].put("日和佐","360020");
        //kagawa
        cityMap[39].put("高松","370000");
        //ehime
        cityMap[40].put("松山", "380010");
        cityMap[40].put("新居浜","380020");
        cityMap[40].put("宇和島","380030");
        //kouchi
        cityMap[41].put("高知","390010");
        cityMap[41].put("室戸岬","390020");
        cityMap[41].put("清水","390030");
        //fukuoka
        cityMap[42].put("福岡","400010");
        cityMap[42].put("八幡","400020");
        cityMap[42].put("飯塚","400030");
        cityMap[42].put("久留米","400040");
        //saga
        cityMap[43].put("佐賀","410010");
        cityMap[43].put("伊万里","410020");
        //nagasaki
        cityMap[44].put("長崎","420010");
        cityMap[44].put("佐世保","420020");
        cityMap[44].put("厳原","420030");
        cityMap[44].put("福江","420040");
        //kumamoto
        cityMap[45].put("熊本","430010");
        cityMap[45].put("阿蘇乙姫","430020");
        cityMap[45].put("牛深","430030");
        cityMap[45].put("人吉","430040");
        //oita
        cityMap[46].put("大分","440010");
        cityMap[46].put("中津","440020");
        cityMap[46].put("日田","440030");
        cityMap[46].put("佐伯","440040");
        //miyazaki
        cityMap[47].put("宮崎","450010");
        cityMap[47].put("延岡","450020");
        cityMap[47].put("都城","450030");
        cityMap[47].put("高千穂","450040");
        //kagosima
        cityMap[48].put("鹿児島","460010");
        cityMap[48].put("鹿屋","460020");
        cityMap[48].put("種子島","460030");
        cityMap[48].put("名瀬","460040");
        //okinawa
        cityMap[49].put("那覇","471010");
        cityMap[49].put("名護","471020");
        cityMap[49].put("久米島","471030");
        cityMap[49].put("南大東","472000");
        cityMap[49].put("宮古島","473000");
        cityMap[49].put("石垣島","474010");
        cityMap[49].put("与那国島","474020");

    }
*/

}
