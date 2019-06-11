package com.mauldev.astropedia.datas;

import com.mauldev.astropedia.models.ConstellationModel;
import com.mauldev.astropedia.models.StarModel;

import java.util.ArrayList;
import java.util.List;

public class ConstellationDataSeeder {

    /*Star Mock DB*/
    String[] starName = {"Deneb","Altair","Rigel","Spica"};
    String[] luminosity = {"196.000 L☉", "10.6 L☉","140.000 L☉","20.512 L☉"};
    String[] starShortDescription = {"Deneb /ˈdɛnɛb/ is a first-magnitude star in the constellation of Cygnus, the swan. Deneb is one of the vertices of the asterism known as the Summer Triangle and the \"head\" of the Northern Cross. It is the brightest star in Cygnus and the 19th brightest star in the night sky, with an average apparent magnitude of 1.25. A blue-white supergiant, Deneb rivals Rigel as the most luminous first magnitude star. However its distance, and hence luminosity, is poorly known; its luminosity is somewhere between 55,000 and 196,000 times that of the Sun. Its Bayer designation is α Cygni which is Latinised to Alpha Cygni, abbreviated to Alpha Cyg or α Cyg.",
        "Altair /ælˈtɛər/, designation α Aquilae (Latinised to Alpha Aquilae, abbreviated Alpha Aql, α Aql), is the brightest star in the constellation of Aquila and the twelfth brightest star in the night sky. It is currently in the G-cloud—a nearby interstellar cloud, an accumulation of gas and dust. Altair is an A-type main sequence star with an apparent visual magnitude of 0.77 and is one of the vertices of the Summer Triangle asterism (the other two vertices are marked by Deneb and Vega). It is 16.7 light-years (5.13 parsecs) from the Sun and is one of the closest stars visible to the naked eye.\n" +
                "\n" +
                "Altair rotates rapidly, with a velocity at the equator of approximately 286 km/s. This is a significant fraction of the star's estimated breakup speed of 400 km/s. A study with the Palomar Testbed Interferometer revealed that Altair is not spherical, but is flattened at the poles due to its high rate of rotation. Other interferometric studies with multiple telescopes, operating in the infrared, have imaged and confirmed this phenomenon.",
        "Rigel /ˈraɪdʒəl/, designated β Orionis (Latinized to Beta Orionis, abbreviated Beta Ori, β Ori), is generally the seventh-brightest star in the night sky and the brightest star in the constellation of Orion. Its brightness varies slightly, and it is occasionally outshone by Betelgeuse, itself a semi-regular variable star. Rigel looks blue-white to the naked eye, contrasting with orange-red Betelgeuse. Although appearing as a single star to the naked eye, Rigel is actually a multiple star system composed of at least four stars: Rigel A, Rigel Ba, Rigel Bb, and Rigel C.\n" +
                "\n" +
                "The name Rigel strictly refers to only the primary star (A), although it is commonly applied to the whole system. The primary has a companion star 9.5″ away with an apparent magnitude of 6.7, 400 times fainter than the primary. The companion is actually a triple star system, including the stars Rigel Ba, Rigel Bb, and Rigel C. Rigel Ba and Bb form a spectroscopic binary, while Rigel B and C, together called \"Rigel BC\" can only be resolved using very large telescopes. Historically, the whole triple system has been referred to as \"Rigel B\".\n" +
                "\n" +
                "Rigel is a massive blue supergiant calculated to be anywhere from 61,500 to 363,000 times as luminous as the Sun, depending on the method used to calculate its properties and assumptions about its distance, estimated to be about 860 light-years (260 pc). Rigel's radius is over 70 times that of the Sun and its surface temperature is 12,100 K. Pulsations cause Rigel's small intrinsic brightness variations, and it is classified as an Alpha Cygni variable. Rigel's physical parameters are poorly known, and its rapid complex evolution is not well understood, though the star's likely fate in the future is to end as a supernova.",
        "Spica /ˈspaɪkə/, designated α Virginis (Latinised to Alpha Virginis, abbreviated Alpha Vir, α Vir), is the brightest object in the constellation of Virgo and one of the 20 brightest stars in the night sky. Analysis of its parallax shows that it is located 250 ± 10 light years from the Sun. It is a spectroscopic binary star and rotating ellipsoidal variable; a system whose two stars are so close together they are egg-shaped rather than spherical, and can only be separated by their spectra. The primary is a blue giant and a variable star of the Beta Cephei type.\n" +
                "\n" +
                "Spica, along with Arcturus and Denebola or Regulus depending on the source, is part of the Spring Triangle asterism, and by extension, also of the Great Diamond together with the star Cor Caroli."
    };

    /*Constellation mock data*/
    private String[] constellationName = {"Cygnus","Aquila","Orion","Virgo"};
    private String[] bestViewMonthorSeason = {"September","August","January","May"};
    private String[] constellationShortDescription = {"Cygnus is a northern constellation lying on the plane of the Milky Way, deriving its name from the Latinized Greek word for swan. Cygnus is one of the most recognizable constellations of the northern summer and autumn, and it features a prominent asterism known as the Northern Cross (in contrast to the Southern Cross). Cygnus was among the 48 constellations listed by the 2nd century astronomer Ptolemy, and it remains one of the 88 modern constellations.",
        "Aquila is a constellation on the celestial equator. Its name is Latin for 'eagle' and it represents the bird that carried Zeus/Jupiter's thunderbolts in Greco-Roman mythology.\n" +
                "\n" +
                "Its brightest star, Altair, is one vertex of the Summer Triangle asterism. The constellation is best seen in the northern summer, as it is located along the Milky Way. Because of this location, many clusters and nebulae are found within its borders, but they are dim and galaxies are few.",
        "Orion is a prominent constellation located on the celestial equator and visible throughout the world. It is one of the most conspicuous and recognizable constellations in the night sky. It was named after Orion, a hunter in Greek mythology. Its brightest stars are the supergiants: blue-white Rigel (Beta Orionis) and red Betelgeuse (Alpha Orionis).",
        "Virgo is one of the constellations of the zodiac. Its name is Latin for virgin, and its symbol is ♍. Lying between Leo to the west and Libra to the east, it is the second-largest constellation in the sky (after Hydra) and the largest constellation in the zodiac. It can be easily found through its brightest star, Spica."
    };
    private String[] illustrationImageUrl = {"https://content.artofmanliness.com/uploads//2014/07/oldcygnus.jpg",
        "https://content.artofmanliness.com/uploads//2014/07/oldaquila.jpg",
        "https://content.artofmanliness.com/uploads//2014/07/oldorion.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/38/Sidney_Hall_-_Urania%27s_Mirror_-_Virgo.jpg/800px-Sidney_Hall_-_Urania%27s_Mirror_-_Virgo.jpg"
    };
    private String[] observationImageUrl = {
            "https://upload.wikimedia.org/wikipedia/commons/f/f5/CygnusCC.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/1/1e/AquilaCC.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/f/f5/OrionCC.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/3/37/VirgoCC.jpg"
    };
    private String[] wikipediaUrl = {
            "https://en.wikipedia.org/wiki/Cygnus_(constellation)",
            "https://en.wikipedia.org/wiki/Aquila_(constellation)",
            "https://en.wikipedia.org/wiki/Orion_(constellation)",
            "https://en.wikipedia.org/wiki/Virgo_(constellation)"
    };
    private Boolean[] isVisibleWithNakedEyes = {true,true,true,true};
    private int[] totalStar = {9,10,7,9};


    List<ConstellationModel> constellationModelList;
    List<StarModel> starModelList;

    public ConstellationDataSeeder() {
        this.starModelList = new ArrayList<>();
        this.constellationModelList = new ArrayList<>();
        generateStar();
    }

    private void generateStar() {
        for (int i = 0; i<4; i++){
            StarModel starModel = new StarModel();
            starModel.setName(starName[i]);
            starModel.setLuminosity(luminosity[i]);
            starModel.setShortDescription(starShortDescription[i]);
            starModelList.add(starModel);
        }
        generateConstellation();
    }

    private void generateConstellation() {
        for (int i =0; i<4;i++){
            ConstellationModel constellationModel = new ConstellationModel();
            constellationModel.setName(constellationName[i]);
            constellationModel.setBrightestStar(starModelList.get(i));
            constellationModel.setTotalStar(totalStar[i]);
            constellationModel.setBestViewMonthorSeason(bestViewMonthorSeason[i]);
            constellationModel.setShortDescription(constellationShortDescription[i]);
            constellationModel.setVisibleWithNakedEye(isVisibleWithNakedEyes[i]);
            constellationModel.setIllustrationImageUrl(illustrationImageUrl[i]);
            constellationModel.setObservationImageUrl(observationImageUrl[i]);
            constellationModel.setWikipediaUrl(wikipediaUrl[i]);

            constellationModelList.add(constellationModel);
        }
    }

    public List<ConstellationModel> generateData(){
        return constellationModelList;
    }

}
