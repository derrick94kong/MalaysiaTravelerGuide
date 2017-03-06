package com.example.d3rrick.malaysiatravelerguide;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by D3rricK on 4/3/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "MyTG.db";

    //table name
    public static final String STATE_TABLE = "states";
    public static final String PLACES_TABLE = "places";

    //common column
    public static final String ID = "id";

    //states table column
    public static final String STATES_NAME = "states_name";

    //places table column
    public static final String STATE_ID = "states_id";
    public static final String PLACES_NAME = "places_name";
    public static final String INFORMATION = "info";

    //States table data
    public static final String[] states_data = {"Penang","Kuala Lumpur","Malacca","Sarawak","Sabah"};

    //places table data
    public static final String[][] places_data = {{"1","Batu Ferringhi", "Batu Ferringhi is a suburb of George Town in Penang, Malaysia. Located along the northern coast of Penang Island, it is the prime beach destination in Penang among locals and tourists. To cater to the influx of tourists, several major high-rise hotels have been established along the 4km stretch of beaches, including the Hard Rock Hotel. The beach resorts along Batu Ferringhi also offer various water sport activities, such as parasailing. On a clear day, one could get a picturesque view of the Andaman Sea and Mount Jerai, which is located within the neighbouring state of Kedah. In addition, Batu Ferringhi is famous for its night market that offers a wide variety of merchandise and street food."}
                                                                                ,{"1","Escape Theme Park","Escape Theme Park was an outdoor theme park located inside NTUC Downtown East, Pasir Ris in Singapore. It was opened in May 2000 and a water park named Wild Wild Wet located adjacent to it was opened in June 2004. Its slogan is \"360 degrees of fun\". The theme park operates on Saturdays, Sundays, gazetted school and public holidays. It had been a non-smoking park from 2005 until it ceased operations in November 2011 for redevelopment. In 2012, reports confirmed that the park would make way for an expansion of Wild Wild Wet."}
                                                                                ,{"1","Penang Hill","Penang Hill is a hill resort comprising a group of peaks in Penang, Malaysia. It is located in Air Itam, which is 6 kilometres (3.7 mi) from the city centre of George Town. Penang Hill is also known by the Malay name Bukit Bendera, which refers to Flagstaff Hill, the most developed peak. The name Penang Hill covers a number of hills, with the highest point at Western Hill which is 833 metres (2,733 ft) above sea level. The hill stands out prominently from the lowlands as a hilly and forested area. It was used as a retreat during the British colonial period, and is now a popular tourist destination in Penang. The top of the hill is accessible via the Penang Hill Railway from its base station at Air Itam."}
                                                                                ,{"1","Kek Lok Si Temple","The Kek Lok Si Temple  is a Buddhist temple situated in Air Itam in Penang facing the sea and commanding an impressive view, and is one of the best known temples on the island. It is said to be the largest Buddhist temple in Malaysia. It is also an important pilgrimage centre for Buddhists from Hong Kong, the Philippines, Singapore and other countries in Southeast Asia. This entire complex of temples was built over a period from 1890 to 1930, an inspirational initiative of Beow Lean, the Abbot. The main draw in the complex is the striking seven-storey Pagoda of Rama VI (Pagoda of Ten Thousand Buddhas) with 10,000 alabaster and bronze statues of Buddha, and the 30.2 metres (99 ft) tall bronze statue of Kuan Yin, the Goddess of Mercy. Mahayana Buddhism, Theravada Buddhism and traditional Chinese rituals blend into a harmonious whole, both in the temple architecture and artwork as well as in the daily activities of worshippers. The temple is heavily commercialised with shops at every level and inside the main temple complexes selling all religious paraphernalia."}
                                                                                ,{"2","Petronas Towers","The Petronas Towers, also known as the Petronas Twin Towers (Malay: Menara Petronas, or Menara Berkembar Petronas), are twin skyscrapers in Kuala Lumpur, Malaysia. According to the Council on Tall Buildings and Urban Habitat (CTBUH)''s official definition and ranking, they were the tallest buildings in the world from 1998 to 2004 and remain the tallest twin towers in the world. The buildings are a landmark of Kuala Lumpur, along with nearby Kuala Lumpur Tower."}
                                                                                ,{"2","Kuala Lumpur Tower","The Kuala Lumpur Tower is a tall tower located in Kuala Lumpur, Malaysia. Its construction was completed on 1 March 1995. It is used for communication purposes and features an antenna that reaches 421 metres (1,381 feet) and is the 7th tallest freestanding tower in the world. The roof of the pod is at 335 metres (1,099 feet). The rest of the tower below has a stairwell and an elevator to reach the upper area, which also contains a revolving restaurant, providing diners with a panoramic view of the city. Races are held annually, where participants race up the stairs to the top. The tower also acts as the Islamic falak observatory to observe the crescent moon which marks the beginning of Muslim month of Ramadhan, Syawal, and Zulhijjah, to celebrate fasting month of Ramadhan, Hari Raya Aidilfitri and Aidiladha. The tower is the highest viewpoint in Kuala Lumpur that is open to the public."}
                                                                                ,{"2","Merdeka Square","Merdeka Square (Malay: Dataran Merdeka) is a square located in Kuala Lumpur, Malaysia. It is situated in front of the Sultan Abdul Samad Building. Literally Independence Square, it was formerly known as the Selangor Club Padang or simply the \"Padang\" and was used as the cricket green of the Selangor Club (now Royal Selangor Club). It was here the Union Flag was lowered and the Malayan flag hoisted for the first time at midnight (time: 12:00 AM) on 31 August 1957. Since then, Merdeka Square has been the usual venue for the annual Merdeka Parade (National Day Parade)."}
                                                                                ,{"2","Petaling Street","Petaling Street  is a Chinatown located in Kuala Lumpur, Malaysia. Haggling is a common sight here and the place is usually crowded with locals as well as tourists. The area has dozens of restaurants and food stalls, serving local favourites such as Hokkien mee, ikan bakar (barbecued fish), asam laksa and curry noodles. Traders here are mainly Chinese but there are also Indian, Malay, and Bangladeshi traders."}
                                                                                ,{"3", "A Famosa", "A Famosa was a Portuguese fortress located in Malacca, Malaysia. It is among the oldest surviving European architectural remains in south east Asia. The Porta de Santiago, a small gate house, is the only part of the fortress which still remains today. The name is often mispronounced /eɪ/ Famosa, even among Malaysians, as though the Portuguese definite article a were the English letter A. A more authentic pronunciation would be /ɑː/ Famosa."}
                                                                                ,{"3", "Baba Nyonya Heritage Museum", "The Baba and Nyonya House Museum, also known as the Baba Nyonya Heritage Museum, is a museum in Malacca, Malaysia. It showcases the local history of ethnic Chinese-Malays called Baba-Nyonya or Peranakan in Malacca. The museum was established in 1986 by Chan Kim Lay, the fourth generation of his family to reside in the large house built by his great-grandfather in 1896 in Jalan Tun Tan Cheng Lock, a street also known as Millionaire''s Row for its luxurious houses."}
                                                                                ,{"3", "Jonker Walk", "The Jonker Walk is the Chinatown street of Malacca, Malaysia located along Jonker Street. During the Dutch Malacca, servants and subordinates of Dutch masters used to live at the nearby Heeren Street. However, as the Dutch left, it became noblemen''s street. Rich Peranakans started to live and did business within the street area, giving the street a deep-rooted ethnic and cultural flavor. The road starts from across Malacca River near the Stadthuys. The road is filled with historical houses along its left and right sides dating back to 17th century. It also has shops selling antiques, textiles, foods, handicrafts and souvenirs."}
                                                                                ,{"3", "Christ Church", "Christ Church is an 18th-century Anglican church in the city of Malacca, Malaysia. It is the oldest functioning Protestant church in Malaysia and is within the jurisdiction of the Lower Central Archdeaconry of the Anglican Diocese of West Malaysia. The church is built in Dutch Colonial architecture style and is laid out in a simple rectangle of 82 feet (25 m) by 42 feet (13 m). The ceiling rises to 40 feet (12 m) and is spanned by wooden beams, each carved from a single tree. The roof is covered with Dutch tiles and the walls were raised using Dutch bricks built on local laterite blocks then coated with Chinese plaster. The floors of the church are paved with granite blocks originally used as ballast for merchant ships."}
                                                                                ,{"4", "Gunung Mulu National Park", "The Gunung Mulu National Park is a national park in Miri Division, Sarawak, Malaysia, is a UNESCO World Heritage Site that encompasses caves and karst formations in a mountainous equatorial rainforest setting. The park is famous for its caves and the expeditions that have been mounted to explore them and their surrounding rainforest, most notably the Royal Geographical Society Expedition of 1977–1978, which saw over 100 scientists in the field for 15 months. This initiated a series of over 20 expeditions now drawn together as the Mulu Caves Project. The national park is named after Mount Mulu, the second highest mountain in Sarawak."}
                                                                                ,{"4", "Kuching", "Kuching is the capital and the most populous city in the state of Sarawak in Malaysia. Kuching is a major food destination for tourists and the main gateway for travellers visiting Sarawak and Borneo. Kuching Wetlands National Park is located about 30 kilometres (19 mi) from the city and there are many other tourist attractions in and around Kuching such as Bako National Park, Semenggoh Wildlife Centre, Rainforest World Music Festival (RWMF), state assembly building, The Astana, Fort Margherita, Kuching Cat Museum, and Sarawak State Museum. The city has become one of the major industrial and commercial centres in East Malaysia."}
                                                                                ,{"4", "Bario", "Bario (or as Google maps calls it - ''Bareo'') is a village located in the centre of the Kelabit Highlands in Miri Division, Sarawak, Malaysia and 1000 m (3280 ft) above sea level. It is the main settlement for the indigenous Kelabit tribe in what is known locally as the Kelabit Highlands. There are regular flights between Bario Airport and Ba''kelalan, Marudi and Miri. Over a century ago, the Kelabits were somewhat involved in headhunting raids, not so much for ritual purposes but as a means to prove one’s courage, bravery or valour, and to get even with their enemy. However, things have changed. Today among other things, the Kelabits are well known for their friendliness and hospitality. They embraced Christianity during the 1940s through the influence of Guru Paul, also known as Nimang Tepun."}
                                                                                ,{"4", "Marudi", "Marudi is a town on the Baram River in Miri Division, Sarawak, Malaysia. Marudi is a quiet town situated inland from Miri, similar in size to Kapit though nowhere near as busy. Its main attraction is another of the Brooke outposts, the beige wooden Fort House. It is the cultural heart of Sarawak''s highland tribesfolk, collectively called Orang Ulu. Before Miri was founded, Marudi was the administrative centre of the northern region of Sarawak. Marudi, a riverine town about 100 km upriver from Kuala Baram, is the largest town in the sparsely populated Baram district. It is the district administrative headquarters and has been since the days of the White Rajahs. Marudi used to be a stepping stone to the well-known tourist destination, Gunung Mulu National Park. Pioneer tourists would travel from Miri to Marudi first, and then from the river, tourists would have to use long boats cutting through few adventurous rapids upstream before reaching Mulu. With the completion of a small airport at Mulu, most tourists prefer to take Twin Otters operated by MASwings of Malaysia Airlines direct from Miri Airport."}
                                                                                ,{"5", "Kinabalu Park","Kinabalu Park (Malay: Taman Kinabalu), established as one of the first national parks of Malaysia in 1964, is Malaysia''s first World Heritage Site designated by UNESCO in December 2000 for its \"outstanding universal values\" and the role as one of the most important biological sites in the world with more than 4,500 species of flora and fauna, including 326 bird and around 100 mammal species, and over 110 land snail species. Located on the west coast of Sabah, Malaysian Borneo, it covers an area of 754 square kilometres surrounding Mount Kinabalu, which at 4,095.2 metres, is the highest mountain on the island of Borneo. The park is one of the most popular tourist spots in Sabah and Malaysia in general. In 1967, more than 987,653 visitors and 43,430 climbers visited the Park."}
                                                                                ,{"5", "Turtle Islands National Park", "Turtle Islands Park (Taman Pulau Penyu) is located within the Turtle Islands, which lie in the Sulu Sea some 3 kilometres (1.9 miles) north of Sandakan in Sabah, Malaysia. It consists of 3 islands - Selingaan, Bakkungan Kechil and Gulisaan (often spelt with -an instead of the traditional -aan), including the surrounding coral reefs and ocean. The Park is noted for its green turtles and hawksbill turtles which lay their eggs on the beaches of the islands. The Park covers an area of 17.4 km². The name Turtle Islands, however, refers to 10 islands, 3 of which are part of Turtle Islands Park of Malaysia, and 7 which belong to the Municipality of Turtle Islands, Tawi-Tawi, Philippines. On 1 August 1966, the first turtle hatchery in Malaysia was established on Selingan, funded entirely by the Sabah state government. Turtle hatcheries on the remaining two islands followed shortly after. In 1972, Selingan, Bakkungan Kechil and Gulisan were designated as a Game and Bird Sanctuary. In 1977, this status was upgraded to that of a Marine Park. Permanent park staff monitor the turtles, protect the hatcheries and tag the turtles for research purposes. Libaran Island is also designated within the park boundaries, however it is not a major turtle hatching spot."}
                                                                                ,{"5", "Danum Valley Conservation Area", "Danum Valley Conservation Area is a 438 square kilometres tract of relatively undisturbed lowland dipterocarp forest in Sabah, Malaysia. It has an extensive diversity of tropical flora and fauna, including such species as the rare East Sumatran rhinoceros, Bornean orangutans, gibbons, mousedeer, clouded leopards and over 270 bird species. Activities offered are jungle treks, river swimming, bird watching, night jungle tours and excursions to nearby logging sites and timber mills. The area holds unique status in the sense that before it became a conservation area there were no human settlements within the area, meaning that hunting, logging and other human interference was non existent making the area almost unique. It is managed by Yayasan Sabah for conservation, research, education, and habitat restoration training purposes."}
                                                                                ,{"5", "Kota Kinabalu", "Kota Kinabalu, formerly known as Jesselton, is the capital of the state of Sabah, Malaysia. It is also the capital of the West Coast Division of Sabah. The city is located on the northwest coast of Borneo facing the South China Sea. The Tunku Abdul Rahman National Park[6] lies to its west and Mount Kinabalu, which gave the city its name, is located to its east. Kota Kinabalu has a population of 452,058 according to the 2010 census; when the adjacent Penampang and Putatan districts are included, the metro area has a combined population of 628,725. Kota Kinabalu is often known as KK both in Malaysia and internationally. It is a major tourist destination and a popular gateway for travellers visiting Sabah and Borneo. Kinabalu Park is located about 90 kilometres from the city and there are many other tourist attractions in and around the city. Kota Kinabalu is also one of the major industrial and commercial centres of East Malaysia. These two factors combine to make Kota Kinabalu one of the fastest growing cities in Malaysia."}};

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+STATE_TABLE+" ("+ID+" integer primary key autoincrement, "+STATES_NAME+" text);");
        for (int i = 0; i < states_data.length; i++) {
            db.execSQL("insert into "+STATE_TABLE+" ("+STATES_NAME+") values ('"+states_data[i]+"')");
        }

        db.execSQL("create table "+PLACES_TABLE+" ("+ID+" integer primary key autoincrement, "+STATE_ID+" integer,"+PLACES_NAME+" text, "+INFORMATION+" text, foreign key("+STATE_ID+") references "+ STATE_TABLE +"("+ID+"));");
        for (int i = 0; i < places_data.length; i++) {
            db.execSQL("insert into "+PLACES_TABLE+" ("+STATE_ID+", "+PLACES_NAME+","+INFORMATION+") values ('"+places_data[i][0]+"','"+places_data[i][1]+"','"+places_data[i][2]+"')");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exist "+ STATE_TABLE);
        db.execSQL("drop table if exist "+ PLACES_TABLE);
        onCreate(db);
    }

    public String[] getStates(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select "+STATES_NAME+ " from " + STATE_TABLE, null);
        String[] arrState = new String[res.getCount()];
        int i = 0;
        if(res.getCount() > 0) {
            while (res.moveToNext())
            {
                String state = res.getString(res.getColumnIndex(STATES_NAME));
                arrState[i] = state;
                i++;
            }
        }
        return arrState;
    }

    public String[] getPlaces(String index){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery( "select "+PLACES_NAME+" from " + PLACES_TABLE + " where " + STATE_ID + " = ( select "+ ID +" from "+ STATE_TABLE +" where "+ STATES_NAME+" = '"+ index +"');", null);
        String[] arrPlace = new String[res.getCount()];
        int i = 0;
        if(res.getCount() > 0) {
            while (res.moveToNext())
            {
                String place = res.getString(res.getColumnIndex(PLACES_NAME));
                arrPlace[i] = place;
                i++;
            }
        }
        return arrPlace;
    }

    public String getInfo(String index){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery( "select "+INFORMATION+" from " +PLACES_TABLE+" where " +PLACES_NAME+" = '" +index+"';", null);

        /*String Info;
        Info = res.getString(res.getColumnIndex(INFORMATION));
        return Info;*/

        String arrInfo = new String();
        int i = 0;
        if(res.getCount() > 0) {
            while (res.moveToNext())
            {
                String info = res.getString(res.getColumnIndex(INFORMATION));
                arrInfo = info;
            }
        }
        return arrInfo;
    }
}
